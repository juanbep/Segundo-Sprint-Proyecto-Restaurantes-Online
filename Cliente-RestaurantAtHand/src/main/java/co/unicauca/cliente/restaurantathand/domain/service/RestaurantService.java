package co.unicauca.cliente.restaurantathand.domain.service;

import co.unicauca.cliente.restaurantathand.access.IRestaurantAccess;
import co.unicauca.cliente.restaurantathand.domain.entity.Restaurant;
import java.util.List;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Beca98
 */
public class RestaurantService {

    private final IRestaurantAccess service;

    /**
     *
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo ICustomerService
     */
    public RestaurantService(IRestaurantAccess service) {
        this.service = service;
    }

    /**
     *
     * Busca un restaurante en el servidor remoto
     *
     * @param userAdmin nombre de usuario del administrador del restaurante
     * @return Objeto tipo restaurante, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public List<Restaurant> findRestaurantByUserAdmin(String userAdmin) throws Exception {
        return service.findRestaurantByUserAdmin(userAdmin);
    }

    /**
     * Buscar un restaurante en el servidor remoto
     *
     * @param name nombre del restaurante
     * @return Objeto tipo restaurante, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Restaurant findRestaurantByName(String name) throws Exception {
        return service.findRestaurantByName(name);
    }

    /**
     * Buscar un restaurante en el servidor remoto
     *
     * @param nit nit del restaurante
     * @return Objeto tipo restaurante, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Restaurant findRestaurantByNit(String nit) throws Exception {
        return service.findRestaurantByNit(nit);
    }

    /**
     *
     *
     * @param nit nit del restaurante
     * @param name nombre del restaurante
     * @param address direccion del restaurante
     * @param mobile telefono del restaurante
     * @param email email del restaurante
     * @param city ciudad del restaurante
     * @param userAdmin nombre de usuario del administrador del restaurante
     * @return objeto restaurante
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean updateRestaurant(String nit, String name, String address, String mobile, String email, String city, String userAdmin) throws Exception {
        return service.updateRestaurant(nit, name, address, mobile, email, city, userAdmin);
    }

    /**
     * Crea un Restaurante en el servidor remoto
     *
     * @param restaurant restaurante
     * @return true si se creo correctamente el restaurante o false en caso
     * contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean createRestaurant(Restaurant restaurant) throws Exception {
        return service.createRestaurant(restaurant);
    }

    /**
     * Elimina un restaurante en el servidor remoto
     *
     * @param nit nit del restaurante
     * @return true si se realizo conrrectamente false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean delete(String nit) throws Exception {
        return service.deleteRestaurant(nit);
    }

    /**
     * Lista todos los restaurantes
     *
     * @return Lista de restaurantes encontrados
     * @throws Exception Si no encuentra lista de restaurantes
     */
    public List<Restaurant> listRestaurants() throws Exception {
        return service.list();
    }
}
