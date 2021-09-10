package co.unicauca.menu.access;

import co.unicauca.menu.domain.entity.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Se utiliza postgres, importante: para que funcione la aplicación, se debe
 * copiar manualmente la librería de maven de netbeans postgresql-42.2.8.jar, y
 * pegarla en el directorio donde se haya instalado Payara
 *
 * @author Luis Tabares
 */
public class MenuRepository implements IMenuRepository {

    private Connection conn;

    public MenuRepository() {
        initDatabase();
    }

    /**
     * Inicializa la tabla Menu e insertar un registro
     */
    private void initDatabase() {
        //SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS menu ("
                + "IdMenu varchar(60) PRIMARY KEY,"
                + "NameMenu varchar(60) NOT NULL,"
                + "IdRest varchar(60) not null"
                + "); "
                + "CREATE TABLE IF NOT EXISTS visualizacion ("
                + "IdMenu varchar(60) not null,"
                + "Dia varchar(60) not null,"
                + "primary key(IDMENU, DIA)"
                + "); "
                + "CREATE TABLE IF NOT EXISTS ofrece("
                + "IdMenu varchar(60) not null,"
                + "Id varchar(60) not null,"
                + "primary key(IDMENU, ID)"
                + "); ";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            // Datos de inicialización
            if (this.findByMenuId("100") == null) {
                stmt.execute("INSERT INTO menu(IdMenu, NameMenu, IdRest) "
                        + "values('100','Menu Oriental','500');");
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Conectar a la bd
     */
    public void connect() {
        try {

            String url = "jdbc:postgresql://localhost:5432/menuBD";
            String usuario = "postgres";
            String contrasenia = "system";
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usuario, contrasenia);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Desconecta de la base de datos
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }

    }

    @Override
    public List<Menu> findAll() {
        List<Menu> menu = new ArrayList<>();
        try {

            String sql = "SELECT * FROM menu";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Menu newMenu = new Menu();
                newMenu.setAtrIdMenu(rs.getString("IdMenu"));
                newMenu.setAtrNomMenu(rs.getString("NameMenu"));
                newMenu.setAtrIdRest(rs.getString("IdRest"));
                newMenu.setAtrDiasVisualizacion(listarDia(newMenu.getAtrIdMenu()));
                newMenu.setAtrIdPlatos(newMenu.getAtrIdPlatos());
                menu.add(newMenu);
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menu;
    }

    @Override
    public List<Menu> findByIdRest(String IdRest) {
        List<Menu> menu = new ArrayList<>();
        try {

            String sql = "SELECT * FROM menu where IdRest='" + IdRest + "'";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Menu newMenu = new Menu();
                newMenu.setAtrIdMenu(rs.getString("IdMenu"));
                newMenu.setAtrNomMenu(rs.getString("NameMenu"));
                newMenu.setAtrIdRest(rs.getString("IdRest"));
                menu.add(newMenu);
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menu;
    }

    /*
    * Verifica si existe el menu en la base de datos
    * buscando por su primary key idmenu
     */
    @Override
    public Menu findByMenuId(String prmIdMenu) {
        Menu menu = null;
        try {

            String sql = "SELECT * FROM menu Where IdMenu='" + prmIdMenu + "'";
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                menu = new Menu();
                menu.setAtrIdMenu(rs.getString("idmenu"));
                menu.setAtrNomMenu(rs.getString("namemenu"));
                menu.setAtrIdRest(rs.getString("idrest"));
            }

            this.disconnect();
            if (menu != null) {
                menu.setAtrDiasVisualizacion(listarDia(prmIdMenu));
                menu.setAtrIdPlatos(listarPlato(prmIdMenu));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error al buscar en la base de datos", ex);
        }
        return menu;
    }

    @Override
    public boolean create(Menu prmNewMenu) {
        String sql = "";
        try {
            this.connect();

            sql = "INSERT INTO menu ( IdMenu, NameMenu, IdRest) "
                    + "VALUES ( ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prmNewMenu.getAtrIdMenu());
            pstmt.setString(2, prmNewMenu.getAtrNomMenu());
            pstmt.setString(3, prmNewMenu.getAtrIdRest());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }

    @Override
    public boolean update(Menu prmNewMenu) {
        try {
            this.connect();

            String sql = "UPDATE menu "
                    + "SET  "
                    + "NameMenu ='" + prmNewMenu.getAtrNomMenu() + "', "
                    + "IdRest = '" + prmNewMenu.getAtrIdRest() + "' "
                    + "WHERE IdMenu = '" + prmNewMenu.getAtrIdMenu() + "'";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error al actualizar el menu", ex);
        }
        return false;
    }

    @Override
    public boolean delete(String prmIdMenu) {
        try {

            String sql = "DELETE FROM menu "
                    + "WHERE IdMenu = ?";
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prmIdMenu);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error al eliminar el menu", ex);
        }
        return false;
    }

    @Override
    public boolean createVisualizacion(String prmIdMenu, String prmDia) {
        String sql = "";
        try {
            this.connect();

            sql = "INSERT INTO visualizacion ( IdMenu, Dia) "
                    + "VALUES ( '" + prmIdMenu + "','" + prmDia + "')";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error en el insert into del menu" + sql, ex);
        }
        return false;
    }

    @Override
    public boolean deleteVisualizacion(String prmIdMenu, String prmDia) {
        String sql = "";
        try {
            this.connect();

            sql = "DELETE  FROM visualizacion WHERE IdMenu='" + prmIdMenu + "' and Dia='" + prmDia + "'";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error en el insert into del menu" + sql, ex);
        }
        return false;
    }

    @Override
    public boolean createOfrece(String prmIdMenu, String prmIdPlato) {
        try {
            this.connect();

            String sql = "INSERT INTO ofrece (IdMenu,Id) VALUES ('" + prmIdMenu + "','" + prmIdPlato + "')";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error al actualizar", ex);
        }
        return false;

    }

    @Override
    public boolean deleteOfrece(String prmIdMenu, String prmIDPlato) {
        String sql = "";
        try {
            this.connect();

            sql = "DELETE  FROM ofrece WHERE IdMenu='" + prmIdMenu + "' and Id='" + prmIDPlato + "'";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, "Error en el insert into del menu" + sql, ex);
        }
        return false;
    }

    @Override
    public List<String> listarDia(String prmIdMenu) {
        List<String> listaDia = null;
        try {

            String sql = "SELECT DIA FROM visualizacion WHERE IdMenu = '" + prmIdMenu + "'";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listaDia = new ArrayList<>();

                listaDia.add(rs.getString("Dia"));

            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDia;
    }

    @Override
    public List<String> listarPlato(String prmIdMenu) {
        List<String> listaPlato = null;
        try {

            String sql = "SELECT ID FROM ofrece WHERE IdMenu = '" + prmIdMenu + "'";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listaPlato = new ArrayList<>();

                listaPlato.add(rs.getString("Id"));

            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MenuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPlato;
    }

}
