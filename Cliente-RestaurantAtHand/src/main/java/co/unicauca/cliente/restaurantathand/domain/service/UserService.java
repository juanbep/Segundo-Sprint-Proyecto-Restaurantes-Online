package co.unicauca.cliente.restaurantathand.domain.service;

import co.unicauca.cliente.restaurantathand.access.IUserAccess;
import co.unicauca.cliente.restaurantathand.domain.entity.User;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Luis Tabares
 */
public class UserService {

    private final IUserAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IUserService
     */
    public UserService(IUserAccess service) {
        this.service = service;
    }

    /**
     * Busca un cliente en el servidor remoto
     *
     * @param userName nombre de usuario del usuario
     * @return Objeto tipo Cliente, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public User findUser(String userName) throws Exception {
        return service.findUser(userName);

    }

    /**
     * Busca un cliente en el servidor remoto
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
     * @return
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public User findUser(String userName, String identificacion, String name, String lastName, String password, String city, String address, String phone, String type) throws Exception {
        return service.findUser(userName);

    }

    /**
     * Creacion de un user
     *
     * @param user
     * @return
     * @throws Exception
     */
    public boolean createUser(User user) throws Exception {
        return service.createUser(user);

    }

}
