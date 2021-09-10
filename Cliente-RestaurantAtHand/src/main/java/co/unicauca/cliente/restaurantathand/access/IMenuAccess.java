package co.unicauca.cliente.restaurantathand.access;

import co.unicauca.cliente.restaurantathand.domain.entity.Dish;
import co.unicauca.cliente.restaurantathand.domain.entity.Menu;
import java.util.List;

/**
 * Interface que define los servicios de persistencia del Menu
 *
 * @author Beca98
 */
public interface IMenuAccess {

    /**
     * Metodo encargado de Buscar un menu
     *
     * @param id identificador del menu
     * @return objeto de tipo Menu
     * @throws Exception error al buscar un Menu
     */
    public Menu findMenu(String id) throws Exception;

    /**
     * Metodo encargado de Buscar un menu y restaurante
     *
     * @param name nombre
     * @return objeto de tipo Menu
     * @throws Exception error al buscar un Menu y restaurante
     */
    public List<Menu> findMenubyRN(String name) throws Exception;

    /**
     * Metodo encargado de actualizar un Menu
     *
     * @param id identificador del menu
     * @param newMenu Objeto de tipo menu
     * @return true si se actualizo correctamente y false en caso contrario
     * @throws Exception error al actualizar Menu
     */
    public boolean updateMenu(String id, Menu newMenu) throws Exception;

    /**
     * Metodo de Eliminar Un Menu
     *
     * @param id identificador del menu
     * @return true si realizo correctamente y false en caso contrario
     * @throws Exception error al Eliminar Menu
     */
    public boolean deleteMenu(String id) throws Exception;

    /**
     * Metodo de Crear menu
     *
     * @param newMenu Objeto de tipo menu
     * @return true creado correctamente y false en caso contrario
     * @throws Exception error al crear el Menu
     */
    public boolean createMenu(Menu newMenu) throws Exception;

    /**
     * Lista todos los menus consumiendo un API REST
     *
     * @return Lista de menus
     * @throws java.lang.Exception
     */
    public java.util.List<Menu> list() throws Exception;

    public boolean addDish(Menu menu, Dish dish) throws Exception;

}
