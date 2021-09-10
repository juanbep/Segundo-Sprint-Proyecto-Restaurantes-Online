package co.unicauca.menu.access;

import co.unicauca.menu.domain.entity.Menu;
import java.util.List;

/**
 *
 * @author Beca98
 */
public interface IMenuRepository {

    List<Menu> findAll();

    Menu findByMenuId(String prmIdMenu);

    List<Menu> findByIdRest(String prmIdRest);

    /**
     * Crea el Menú
     *
     * @param prmNewMenu
     * @return
     */
    boolean create(Menu prmNewMenu);

    /**
     * Actualiza el Menú
     *
     * @param prmNewMenu
     * @return
     */
    boolean update(Menu prmNewMenu);

    /**
     * Elimina un Menú
     *
     * @param prmIdMenu
     * @return
     */
    boolean delete(String prmIdMenu);

    /**
     * Crea una visualizacion del menu ofrecio por dia
     *
     * @param prmIdMenu
     * @param prmDia
     * @return
     */
    boolean createVisualizacion(String prmIdMenu, String prmDia);

    /**
     * Muestra los platos ofrecidos en un Menú
     *
     * @param prmIdMenu
     * @param prmIdPlato
     * @return
     */
    boolean createOfrece(String prmIdMenu, String prmIdPlato);

    /**
     * Lista el Menú del dia
     *
     * @param prmIdMenu
     * @return
     */
    List<String> listarDia(String prmIdMenu);

    /**
     * Lista los platos ofrecidos en el Menú
     *
     * @param prmIdMenu
     * @return
     */
    List<String> listarPlato(String prmIdMenu);

    boolean deleteVisualizacion(String prmIdMenu, String prmDia);

    boolean deleteOfrece(String prmIdMenu, String prmIDPlato);
}
