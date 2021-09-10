package co.unicauca.cliente.restaurantathand.access;

import co.unicauca.cliente.UsersJerseyClient;
import co.unicauca.cliente.restaurantathand.domain.entity.User;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Interfaz donde se declara un CRUD para User
 *
 * @author Beca98
 */
public class UserAccessREST implements IUserAccess {

    UsersJerseyClient jersey;
    Response rta;

    public UserAccessREST() {
        this.jersey = new UsersJerseyClient();
    }

    /**
     * Buscar un usuario consumiendo un API REST mediante un cliente jersey
     *
     * @param userName nombre de usuario del usuario
     * @return objeto usuario
     * @throws Exception error al buscar un usuario
     */
    @Override
    public User findUser(String userName) throws Exception {
        User user = jersey.findByUserName_JSON(User.class, userName);
        return user;
    }

    /**
     *
     * @param userName nombre de usuario del usuario
     * @param identificacion identificacion del usuario
     * @param name nombre del usuario
     * @param lastName apellido del usuario
     * @param password contraseña del usuario
     * @param city ciudad del usuario
     * @param address dirreccion del usuario
     * @param phone telefono del usuario
     * @param type tipo de usuario (Administrador o cliente)
     * @return objeto usuario
     * @throws Exception error al actualizar el usuario
     */
    @Override
    public boolean updateUser(String userName, String identificacion, String name, String lastName, String password, String city, String address, String phone, String type) throws Exception {
        User user = findUser(userName);
        if (user == null) {
            return false;
        }
        user.setAtrIdentification(identificacion);
        user.setAtrName(name);
        user.setAtrLastName(lastName);
        user.setAtrPassword(password);
        user.setAtrCity(city);
        user.setAtrAddress(address);
        user.setAtrPhone(phone);
        user.setAtrType(type);
        rta = jersey.edit_JSON(user, userName);
        return true;
    }

    /**
     * Elimina un usuario consumiendo un API REST mediante un cliente jersey
     *
     * @param userName nombre del usuario
     * @return true si se elimino correctamente el usuario o false en caso
     * contrario
     * @throws Exception error al actualizar el usuario
     */
    @Override
    public boolean deleteUser(String userName) throws Exception {
        User user = findUser(userName);
        if (user == null) {
            return false;
        }
        rta = jersey.delete(userName);
        return true;
    }

    /**
     * Crea un usuario consumiendo un API REST mediante un cliente jersey
     *
     * @param user usuario del restaurante
     * @return Devuelve true si se pudo crear
     * @throws Exception error crear el usuario
     */
    @Override
    public boolean createUser(User user) throws Exception {
        User users = findUser(user.getAtrUserName());
        if (users != null) {
            return false;
        }
        rta = jersey.create_JSON(user);
        return true;
    }

    /**
     * Lista todos los usuarios consumiendo un API REST mediante un cliente
     * jersey
     *
     * @return Lista de usuarios
     * @throws java.lang.Exception
     */
    @Override
    public List<User> list() throws Exception {
        GenericType<List<User>> listResponseTypeM = new GenericType<List<User>>() {
        };
        List<User> user = jersey.findAll(listResponseTypeM);
        return user;
    }

}
