package co.unicauca.cliente.restaurantathand.access;

import co.unicauca.cliente.RestaurantJerseyClient;
import co.unicauca.cliente.restaurantathand.domain.entity.Restaurant;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Interfaz donde se declara un CRUD para Restaurante
 *
 * @author Beca98
 */
public class RestaurantAccessREST implements IRestaurantAccess {

    RestaurantJerseyClient jersey;
    Response rta;

    public RestaurantAccessREST() {
        this.jersey = new RestaurantJerseyClient();
    }

    /**
     * Buscar un restaurante consumiendo un API REST mediante un cliente jersey
     *
     * @param userAdmin nombre de usuario del administrador del restaurante
     * @return objeto restaurante
     * @throws Exception error al buscar un restaurante
     *
     */
    @Override
    public List<Restaurant> findRestaurantByUserAdmin(String userAdmin) throws Exception {
        GenericType<List<Restaurant>> listResponseTypeM = new GenericType<List<Restaurant>>() {
        };
        List<Restaurant> restaurant = jersey.findByAdmin_JSON(listResponseTypeM, userAdmin);
        return restaurant;
    }

    /**
     * Buscar un restaurante consumiendo un API REST mediante un cliente jersey
     *
     * @param name nombre del restaurante
     * @return objeto restaurante
     * @throws Exception error al buscar un restaurante
     */
    @Override
    public Restaurant findRestaurantByName(String name) throws Exception {
        Restaurant restaurant = jersey.findByName_JSON(Restaurant.class, name);
        return restaurant;
    }

    /**
     * Buscar un restaurante consumiendo un API REST mediante un cliente jersey
     *
     * @param nit nit del restaurante
     * @return objeto restaurante
     * @throws Exception error al buscar un restaurante
     */
    @Override
    public Restaurant findRestaurantByNit(String nit) throws Exception {
        Restaurant restaurant = jersey.findByNit_JSON(Restaurant.class, nit);
        return restaurant;
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
     * @throws Exception error al actualizar el usuario
     */
    @Override
    public boolean updateRestaurant(String nit, String name, String address, String mobile, String email, String city, String userAdmin) throws Exception {
        Restaurant restaurant = findRestaurantByNit(nit);
        if (restaurant == null) {
            return false;
        }
        restaurant.setAtrNameRest(name);
        restaurant.setAtrAddressRest(address);
        restaurant.setAtrMobileRest(mobile);
        restaurant.setAtrEmailRest(email);
        restaurant.setAtrCityRest(city);
        restaurant.setAtrAdmiRest(userAdmin);
        rta = jersey.edit_JSON(restaurant, nit);
        return true;
    }

    /**
     * Elimina un restaurante consumiendo un API REST mediante un cliente jersey
     *
     * @param nit nit del restaurante
     * @return true si se elimino correctamente el restaurante o false en caso
     * contrario
     * @throws Exception error al actualizar el usuario
     */
    @Override
    public boolean deleteRestaurant(String nit) throws Exception {
        Restaurant restaurante = findRestaurantByNit(nit);
        if (restaurante == null) {
            return false;
        }
        rta = jersey.delete(nit);
        return true;
    }

    /**
     * Crea un Restaurante consumiendo un API REST mediante un cliente jersey
     *
     * @param restaurant restaurante
     * @return true si se creo correctamente el restaurante o false en caso
     * contrario
     * @throws Exception error crear el usuario
     */
    @Override
    public boolean createRestaurant(Restaurant restaurant) throws Exception {
        Restaurant restaurants = findRestaurantByNit(restaurant.getAtrNitRest());
        if (restaurants != null) {
            return false;
        }
        rta = jersey.create_JSON(restaurant);
        return true;
    }

    /**
     * Lista todos los restaurantes consumiendo un API REST mediante un cliente
     * jersey
     *
     * @return Lista de restaurantes
     * @throws java.lang.Exception
     */
    @Override
    public List<Restaurant> list() throws Exception {
        GenericType<List<Restaurant>> listResponseTypeM = new GenericType<List<Restaurant>>() {
        };
        List<Restaurant> restaurant = jersey.findAll(listResponseTypeM);
        return restaurant;
    }

}
