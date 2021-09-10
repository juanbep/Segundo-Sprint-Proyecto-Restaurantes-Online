package co.unicauca.user.domain.service;

import co.unicauca.user.access.IUserRepository;
import co.unicauca.user.domain.entity.User;
import co.unicauca.user.domain.validators.ValidationError;
import co.unicauca.user.infra.DomainErrors;
import co.unicauca.user.infra.Error;
import co.unicauca.user.infra.Utilities;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Servicio de Usuario. Es una fachada de acceso al negocio. Lo usa la capa de
 * presentación.
 * 
 * @author Luis Tabares
 */

@RequestScoped
public class UserService {
    /**
     * Dependencia de una abstracción No es algo concreto. No se sabe como será
     * implementado
     */
    @Inject
    private IUserRepository repository;
    
    
    /**
     * Busca un usuario por su userName
     *
     * @param prmUserName nombre de usuario del usuario
     * @return usuario, o null, si no lo encuentra
     */
    public User findByUserName(String prmUserName) {
        return repository.findByUserName(prmUserName);
    }
    
    public void setUserRepository(IUserRepository repository){
        this.repository = repository;
    }
    
    /**
     * Busca todos los usuarios
     *
     * @return lista de usuarios
     */
    public List<User> findAll() {
        List<User> users = repository.findAll();
        return users;
    }
    
    /**
     * Crea un nuevo usuario
     *
     * @param newUser usuario a guardar en la base de datos
     * @return true si lo crea, false si no
     */
    public boolean create(User newUser) {
        List<Error> errors = validateCreate(newUser);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        //Si pasa las validaciones se graba en la bd
        return repository.create(newUser);
    }
    
    
    /**
     * Edita o actualiza un Usuario
     *
     * @param userName nombre de usuario de un usuario 
     * @param newUser usuario a editar en el sistema
     * @return true si lo actualiza, false si no
     */
    public boolean update(String userName, User newUser) {
        List<Error> errors = validateUpdate(userName, newUser);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        User userAux = this.findByUserName(userName);
        userAux.setAtrName(newUser.getAtrName());
        userAux.setAtrLastName(newUser.getAtrLastName());
        userAux.setAtrPassword(newUser.getAtrPassword());
        userAux.setAtrCity(newUser.getAtrCity());   
        userAux.setAtrAddress(newUser.getAtrAddress());  
        userAux.setAtrPhone(newUser.getAtrPhone());   
        userAux.setAtrType(newUser.getAtrType()); 
        userAux.setAtrIdentification(newUser.getAtrIdentification()); 
         
        repository.update(userAux);
        return true;
    }
    
    /**
     * Elimina un usuario de la base de datos
     *
     * @param UserName nombre de usuario del usuario
     * @return true si lo elimina, false si no
     */
    public boolean delete(String UserName) {
        //Validate usuario
        List<Error> errors = validateDelete(UserName);
        if (!errors.isEmpty()) {
            DomainErrors.setErrors(errors);
            return false;
        }
        // Pasada la validación, se puede borrar de la bd
        return repository.delete(UserName);
    }
    
    /**
     * Valida que el usuario esté correcto antes de grabarlo
     *
     * @param newUser Usuario
     * @return lista de errores de negocio
     */
    private List<Error> validateCreate(User newUser) {
        List<Error> errors; 
        
        //Validar User
        errors = validarCampos(newUser);
        /*if (newUser.getAtrUserName()== null || newUser.getAtrUserName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "UserName", "El userName del usuario es obligatorio");
            errors.add(error);
        }
        */
        //Validar que no exista el usuario
        if(newUser.getAtrUserName() != null){
            if (!newUser.getAtrUserName().isEmpty()) {

                User userAux = repository.findByUserName(newUser.getAtrUserName());

                if (userAux != null) {
                    // El usuario ya existe
                    Error error = new Error(ValidationError.INVALID_FIELD, "UserName", "El username del usuario ya existe");
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    /**
     * Valida que el usuario esté correcto antes de editarlo en la bd
     * @param userName nombre de usuario
     * @param newUser usuario
     * @return lista de errores de negocio
     */
    private List<Error> validateUpdate(String userName, User newUser) {
         List<Error> errors = new ArrayList<>();
        //Validar usuario
        errors = validarCampos(newUser);
        
         // Validar que exista el usuario
        User userAux = repository.findByUserName(userName);
        if (userAux == null) {
            // El usuario no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "userName", "El nombre de usuario del usuario no existe");
            errors.add(error);
        }

        return errors;
    }

    /**
     * Valida que los datos del usuario no esten vacios o nulos 
     *
     * @param newUser usuario
     * @return lista de errores de negocio
     */
    private List<Error> validarCampos (User newUser){
        
        List<Error> errors = new ArrayList<>();
        
        //Validate user
        if (newUser.getAtrIdentification()== null || newUser.getAtrIdentification().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Identificacion", "La identificacion del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAtrIdentification()!= null && Utilities.isNumeric(newUser.getAtrIdentification())==false) {
            Error error = new Error(ValidationError.INVALID_FIELD, "Identificacion", "La identificacion del usuario solo debe contener numeros");
            errors.add(error);
        }
        if (newUser.getAtrName() == null || newUser.getAtrName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Name", "El nombre delusuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAtrLastName()== null || newUser.getAtrLastName().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "LastName", "El apellido del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAtrPassword()== null || newUser.getAtrPassword().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Password", "La contraseña del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAtrCity() == null || newUser.getAtrCity().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "City", "La ciudad del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAtrAddress()== null || newUser.getAtrAddress().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Address", "La direccion del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAtrPhone()== null || newUser.getAtrPhone().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Phone", "El telefono del usuario es obligatorio");
            errors.add(error);
        }
        if (newUser.getAtrPhone()!= null && Utilities.isNumeric(newUser.getAtrPhone())==false) {
            Error error = new Error(ValidationError.INVALID_FIELD, "Phone", "El telefono del usuario solo debe contener numeros");
            errors.add(error);
        }
        if (newUser.getAtrType()== null || newUser.getAtrType().isEmpty()) {
            Error error = new Error(ValidationError.EMPTY_FIELD, "Type", "El tipo de usuario es obligatorio");
            errors.add(error);
        }
        
        return errors;
    }

    /**
     * Valida el usuario exista para poder eliminarlo de la BD
     *
     * @param UserName nombre de usuario 
     * @return lista de errores de negocio
     */
    private List<Error> validateDelete(String UserName) {
        
        List<Error> errors = new ArrayList<>();
        // Validar que exista el usuario
        User userAux = repository.findByUserName(UserName);

        if (userAux == null) {
            // El usuario no existe
            Error error = new Error(ValidationError.INVALID_FIELD, "id", "El id del producto no existe");
            errors.add(error);
        }

        return errors;
    }
    
}