package co.unicauca.menu.domain.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Menu de un Restaurante
 *
 * @author Beca98
 *
 */
public class Menu {

    private String atrIdMenu;
    private String atrNomMenu;
    private String atrIdRest;
    private List<String> atrDiasVisualizacion;
    private List<String> atrIdPlatos;

    /**
     * Constructor parametrizado
     *
     * @param atrIdMenu
     * @param atrNomMenu
     * @param atrIdRest
     */
    public Menu(String atrIdMenu, String atrNomMenu, String atrIdRest) {
        this.atrIdMenu = atrIdMenu;
        this.atrNomMenu = atrNomMenu;
        this.atrIdRest = atrIdRest;
        atrDiasVisualizacion = new ArrayList<String>();
        atrIdPlatos = new ArrayList<String>();
    }

    /**
     * Constructor por defecto
     */
    public Menu() {
        atrDiasVisualizacion = new ArrayList<String>();
        atrIdPlatos = new ArrayList<String>();
    }

    public String getAtrIdMenu() {
        return atrIdMenu;
    }

    public void setAtrIdMenu(String atrIdMenu) {
        this.atrIdMenu = atrIdMenu;
    }

    public String getAtrNomMenu() {
        return atrNomMenu;
    }

    public void setAtrNomMenu(String atrNomMenu) {
        this.atrNomMenu = atrNomMenu;
    }

    public String getAtrIdRest() {
        return atrIdRest;
    }

    public void setAtrIdRest(String atrIdRest) {
        this.atrIdRest = atrIdRest;
    }

    public List<String> getAtrDiasVisualizacion() {
        return atrDiasVisualizacion;
    }

    public void setAtrDiasVisualizacion(List<String> atrDiasVisualizacion) {
        this.atrDiasVisualizacion = atrDiasVisualizacion;
    }

    public List<String> getAtrIdPlatos() {
        return atrIdPlatos;
    }

    public void setAtrIdPlatos(List<String> atrIdPlatos) {
        this.atrIdPlatos = atrIdPlatos;
    }

}
