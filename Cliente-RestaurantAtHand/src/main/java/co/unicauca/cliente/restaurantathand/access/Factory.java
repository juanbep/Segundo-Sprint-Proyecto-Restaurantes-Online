package co.unicauca.cliente.restaurantathand.access;

/**
 * Fabrica que se encarga de instanciar TypeServiceREST o cualquier otro que se
 * cree en el futuro.
 *
 * @author Beca98
 */
public class Factory {

    private static Factory instance;

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IUserService
     *
     * @return una clase hija
     */
    public IUserAccess getUserService() {
        return new UserAccessREST();
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IRestaurantService
     *
     * @return una clase hija de la abstracción
     */
    public IRestaurantAccess getRestaurantService() {
        return new RestaurantAccessREST();

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IMenuService
     *
     * @return una clase hija de la abstracción IRepositorioMenu
     */
    public IMenuAccess getMenuService() {
        return new MenuAccessREST();
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IPlatoService
     *
     * @return una clase hija de la abstracción IRepositorioEntry
     */
    public IPlatoAccess getPlatoService() {
        return new PlatoAccessREST();
    }
}
