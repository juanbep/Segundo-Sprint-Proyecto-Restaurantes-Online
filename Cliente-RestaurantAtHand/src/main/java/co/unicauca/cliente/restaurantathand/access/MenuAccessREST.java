package co.unicauca.cliente.restaurantathand.access;

import co.unicauca.cliente.MenuJerseyClient;
import co.unicauca.cliente.restaurantathand.domain.entity.Dish;
import co.unicauca.cliente.restaurantathand.domain.entity.Menu;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Andres Rios
 */
public class MenuAccessREST implements IMenuAccess {

    MenuJerseyClient jersey;
    Response rta;

    public MenuAccessREST() {
        this.jersey = new MenuJerseyClient();
    }

    @Override
    public Menu findMenu(String id) throws Exception {
        return jersey.findByMenuId_JSON(Menu.class, id);
    }

    @Override
    public List<Menu> findMenubyRN(String name) throws Exception {
        GenericType<List<Menu>> listResponseTypeM = new GenericType<List<Menu>>() {
        };
        List<Menu> menus = jersey.findMbyRN_JSON(listResponseTypeM, name);
        return menus;
    }

    @Override
    public boolean updateMenu(String id, Menu newMenu) throws Exception {
        Menu menu = findMenu(id);
        if (menu == null) {
            return false;
        }
        menu = newMenu;
        rta = jersey.edit_JSON(menu, id);

        if (newMenu.getAtrIdPlatos() != null) {
            for (int i = 0; i < newMenu.getAtrIdPlatos().size(); i++) {
                jersey.createOfrece_JSON(menu, menu.getAtrIdMenu(), newMenu.getAtrIdPlatos().get(i));
            }
        }
        if (newMenu.getAtrDiasVisualizacion() != null) {
            for (int i = 0; i < newMenu.getAtrDiasVisualizacion().size(); i++) {
                jersey.createVisualizacion_JSON(menu, menu.getAtrIdMenu(), newMenu.getAtrDiasVisualizacion().get(i));
            }
        }
        return true;
    }

    @Override
    public boolean deleteMenu(String id) throws Exception {
        Menu menu = findMenu(id);
        if (menu == null) {
            return false;
        }
        rta = jersey.deleteMenu(id);
        return true;
    }

    @Override
    public boolean createMenu(Menu newMenu) throws Exception {
        Menu menu = findMenu(newMenu.getAtrIdMenu());
        if (menu != null) {
            return false;
        }
        rta = jersey.create_JSON(newMenu);

        if (newMenu.getAtrDiasVisualizacion() != null) {
            for (int i = 0; i < newMenu.getAtrDiasVisualizacion().size(); i++) {
                jersey.createVisualizacion_JSON(menu, newMenu.getAtrIdMenu(), newMenu.getAtrDiasVisualizacion().get(i));
            }
        }
        return true;
    }

    public boolean addDish(Menu menu, Dish dish) {
        GenericType<List<String>> listResponseTypeM = new GenericType<List<String>>() {
        };
        List<String> platos = jersey.findPlato_JSON(listResponseTypeM, dish.getAtrNameDish());

        //buscar si ya existe el plato en ese menu 
        if (!platos.isEmpty()) {
            for (int i = 0; i < platos.size(); i++) {
                if (platos.get(i).equals(dish.getAtrIdDish())) {
                    return false;
                }
            }
        }

        jersey.createOfrece_JSON(menu, menu.getAtrIdMenu(), dish.getAtrIdDish());
        return true;
    }

    /**
     * Lista todos los menus consumiendo un API REST mediante un cliente jersey
     *
     * @return Lista de menus
     * @throws java.lang.Exception
     */
    @Override
    public List<Menu> list() throws Exception {
        GenericType<List<Menu>> listResponseTypeM = new GenericType<List<Menu>>() {
        };
        List<Menu> menus = jersey.findAll(listResponseTypeM);
        return menus;
    }

}
