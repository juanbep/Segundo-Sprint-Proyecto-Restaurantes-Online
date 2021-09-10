package co.unicauca.cliente.restaurantathand.access;

import co.unicauca.cliente.restaurantathand.domain.entity.Restaurant;

/**
 * Interface que define los servicios de persistencia del Restaurante
 *
 * @author Beca98
 */
public interface IRestaurantAccess {

    /**
     * Buscar un restaurante
     *
     * @param userAdmin nombre de usuario del administrador del restaurante
     * @return objeto restaurante
     * @throws Exception error al buscar un restaurante
     */
    public java.util.List<Restaurant> findRestaurantByUserAdmin(String userAdmin) throws Exception;

    /**
     * Buscar un restaurante
     *
     * @param name nombre del restaurante
     * @return objeto restaurante
     * @throws Exception error al buscar un restaurante
     */
    public Restaurant findRestaurantByName(String name) throws Exception;

    /**
     * Buscar un restaurante
     *
     * @param nit nit del restaurante
     * @return objeto restaurante
     * @throws Exception error al buscar un restaurante
     */
    public Restaurant findRestaurantByNit(String nit) throws Exception;

    /**
     * Actualiza un restaurante consumiendo un API REST
     *
     * @param nit nit del restaurante
     * @param name nombre del restaurante
     * @param address direccion del restaurante
     * @param mobile telefono del restaurante
     * @param email email del restaurante
     * @param city ciudad del restaurante
     * @param userAdmin nombre de usuario del administrador del restaurante
     * @return objeto restaurante
     * @throws Exception error al actualizar el usuario
     */
    public boolean updateRestaurant(String nit, String name, String address, String mobile, String email, String city, String userAdmin) throws Exception;

    /**
     * Elimina un restaurante consumiendo un API REST
     *
     * @param nit nit del restaurante
     * @return true si se elimino correctamente el restaurante o false en caso
     * contrario
     * @throws Exception error al actualizar el usuario
     */
    public boolean deleteRestaurant(String nit) throws Exception;

    /**
     * Crea un Restaurante consumiendo un API REST
     *
     * @param restaurant restaurante
     * @return true si se creo correctamente el restaurante o false en caso
     * contrario
     * @throws Exception error crear el usuario
     */
    public boolean createRestaurant(Restaurant restaurant) throws Exception;

    /**
     * Lista todos los restaurantes
     *
     * @return Lista de restaurantes
     * @throws java.lang.Exception
     */
    public java.util.List<Restaurant> list() throws Exception;
}
