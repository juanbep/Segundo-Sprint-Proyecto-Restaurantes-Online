package co.unicauca.cliente.restaurantathand.domain.service;

import co.unicauca.cliente.restaurantathand.access.IMenuAccess;
import co.unicauca.cliente.restaurantathand.domain.entity.Dish;
import co.unicauca.cliente.restaurantathand.domain.entity.Menu;
import java.util.List;

/**
 *
 * @author Luis Tabares
 */
public class MenuService {

    private final IMenuAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IMenuService
     */
    public MenuService(IMenuAccess service) {
        this.service = service;
    }

    /**
     * Busca un Menu en el servidor remoto
     *
     * @param id identificador del Menu
     * @return Objeto tipo menu, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Menu findMenu(String id) throws Exception {
        return service.findMenu(id);

    }

    /**
     * Busca un menu en el servidor remoto
     *
     * @param name nombre
     * @return objeto de tipo menu
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public List<Menu> findbyMenubyRN(String name) throws Exception {
        return service.findMenubyRN(name);
    }

    /**
     * Actualiza un menu en el servidor remoto
     *
     * @param id identificador del menu
     * @param newMenu Objeto de tipo menu
     * @return true si se realizo la actualizacion correctamente o false en caso
     * contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean updateMenu(String id, Menu newMenu) throws Exception {
        return service.updateMenu(id, newMenu);
    }

    /**
     * Elimina un menu en el servidor Remoto
     *
     * @param id identificador del menu
     * @return true si se realizo corectamente o false en caso contrario
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean deleteMenu(String id) throws Exception {
        return service.deleteMenu(id);
    }

    /**
     * Crea un menuen el servidor remoto
     *
     * @param menu Objeto de tipo menu
     * @return true o false
     * @throws Exception la excepcio se lanza cuando no logra conexión con el
     * servidor
     */
    public boolean createMenu(Menu menu) throws Exception {
        return service.createMenu(menu);
    }

    /**
     * Lista objetos de tipo Menu
     *
     * @return lista de objetos menu
     * @throws Exception se lanza cuando no logra conexión con el servidor
     */
    public List<Menu> listMenus() throws Exception {
        return service.list();
    }

    public boolean addDish(Menu menu, Dish dish) throws Exception {
        return service.addDish(menu, dish);
    }
}
