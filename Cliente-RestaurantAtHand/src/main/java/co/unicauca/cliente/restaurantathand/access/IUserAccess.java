package co.unicauca.cliente.restaurantathand.access;

import co.unicauca.cliente.restaurantathand.domain.entity.User;

/**
 * Interface que define los servicios de persistencia de Clientes del
 * restaurante
 *
 * @author Andres Rios
 */
public interface IUserAccess {

    /**
     * Buscar un usuario consumiendo un API REST
     *
     * @param userName nombre del usuario
     * @return objeto usuario
     * @throws Exception error al buscar un usuario
     */
    public User findUser(String userName) throws Exception;

    /**
     * Actualiza un usuario consumiendo un API REST
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
    public boolean updateUser(String userName, String identificacion, String name, String lastName, String password, String city, String address, String phone, String type) throws Exception;

    /**
     * Elimina un usuario consumiendo un API REST
     *
     * @param userName nombre de usuario del usuario
     * @return true si se elimino correctamente el usuario o false en caso
     * contrario
     * @throws Exception error al actualizar el usuario
     */
    public boolean deleteUser(String userName) throws Exception;

    /**
     * Crea un usuario consumiendo un API REST
     *
     * @param user Usuario del restaurante
     * @return Devuelve true si se pudo crear el usuario
     * @throws Exception error crear el usuario
     */
    public boolean createUser(User user) throws Exception;

    /**
     * Lista todos los usuarios consumiendo un API REST
     *
     * @return Lista de usuarios
     * @throws java.lang.Exception
     */
    public java.util.List<User> list() throws Exception;
}
