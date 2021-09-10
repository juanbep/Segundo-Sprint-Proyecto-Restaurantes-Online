package co.unicauca.user.access;

import co.unicauca.user.domain.entity.User;
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
import javax.enterprise.inject.Default;

/**
 * Se utiliza postgres, importante: para que funcione la aplicación, se debe
 * copiar manualmente la librería de maven de netbeans postgresql-42.2.8.jar, y
 * pegarla en el directorio donde se haya instalado Payara.
 *
 * @author Luis Tabares
 */
@Default
public class UserRepository implements IUserRepository {

    private Connection conn;

    public UserRepository() {
        initDatabase();
        System.out.println("User- constructor");
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {

            String sql = "SELECT * FROM users";
            this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User newUser = new User();
                newUser.setAtrUserName(rs.getString("Username"));
                newUser.setAtrIdentification(rs.getString("Id"));
                newUser.setAtrName(rs.getString("Name"));
                newUser.setAtrLastName(rs.getString("Lastname"));
                newUser.setAtrPassword(rs.getString("Password"));
                newUser.setAtrCity(rs.getString("City"));
                newUser.setAtrAddress(rs.getString("Address"));
                newUser.setAtrPhone(rs.getString("Phone"));
                newUser.setAtrType(rs.getString("Type"));

                users.add(newUser);
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public User findByUserName(String prmUserName) {
        User user = null;
        try {

            String sql = "SELECT * FROM users Where USERNAME='" + prmUserName + "'";
            this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                user = new User();
                user.setAtrUserName(rs.getString("username"));
                user.setAtrIdentification(rs.getString("id"));
                user.setAtrName(rs.getString("name"));
                user.setAtrLastName(rs.getString("lastname"));
                user.setAtrPassword(rs.getString("password"));
                user.setAtrCity(rs.getString("city"));
                user.setAtrAddress(rs.getString("address"));
                user.setAtrPhone(rs.getString("phone"));
                user.setAtrType(rs.getString("type"));
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error al buscar el producto en la base de datos", ex);
        }
        System.out.println("co.unicauca.user.access.UserRepository.findByUserName()");

        return user;
    }

    @Override
    public boolean create(User prmNewUser) {
        String sql = "";
        try {
            this.connect();

            sql = "INSERT INTO users ( USERNAME, ID, NAME, LASTNAME,PASSWORD,CITY,ADDRESS,PHONE,TYPE) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prmNewUser.getAtrUserName());
            pstmt.setString(2, prmNewUser.getAtrIdentification());
            pstmt.setString(3, prmNewUser.getAtrName());
            pstmt.setString(4, prmNewUser.getAtrLastName());
            pstmt.setString(5, prmNewUser.getAtrPassword());
            pstmt.setString(6, prmNewUser.getAtrCity());
            pstmt.setString(7, prmNewUser.getAtrAddress());
            pstmt.setString(8, prmNewUser.getAtrPhone());
            pstmt.setString(9, prmNewUser.getAtrType());
            pstmt.executeUpdate();
            this.disconnect();
            System.out.println("co.unicauca.user.access.UserRepository.create()");

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error en el insert into: " + sql, ex);
        }
        return false;
    }

    @Override
    public boolean update(User prmNewUser) {
        try {
            this.connect();

            String sql = "UPDATE users "
                    + "Set id = ?, "
                    + "name = ? ,"
                    + "Lastname = ? ,"
                    + "Password = ? ,"
                    + "City = ? ,"
                    + "Address = ? ,"
                    + "Phone = ? ,"
                    + "Type = ? "
                    + "Where Username = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, prmNewUser.getAtrIdentification());
            pstmt.setString(2, prmNewUser.getAtrName());
            pstmt.setString(3, prmNewUser.getAtrLastName());
            pstmt.setString(4, prmNewUser.getAtrPassword());
            pstmt.setString(5, prmNewUser.getAtrCity());
            pstmt.setString(6, prmNewUser.getAtrAddress());
            pstmt.setString(7, prmNewUser.getAtrPhone());
            pstmt.setString(8, prmNewUser.getAtrType());
            pstmt.setString(9, prmNewUser.getAtrUserName());
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error al actualizar el producto", ex);
        }
        return false;
    }

    @Override
    public boolean delete(String prmUserName) {
        try {

            String sql = "DELETE FROM users "
                    + "WHERE USERNAME = ?";
            this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prmUserName);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error al eliminar producto", ex);
        }
        return false;
    }

    /**
     * Inicializa la tabla User
     */
    private void initDatabase() {
        //SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "Username varchar(60) PRIMARY KEY,"
                + "Id        varchar(60) NOT NULL,"
                + "Name      varchar(60) not null,"
                + "Lastname  varchar(60) not null,"
                + "Password  varchar(60) not null,"
                + "City      varchar(60) not null,"
                + "Address   varchar(60) not null,"
                + "Phone     varchar(60) not null,"
                + "Type      varchar(60) not null"
                + "); ";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);// Datos de inicialización

            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Conectar a la bd
     */
    public void connect() {
        try {

            String url = "jdbc:postgresql://localhost:5432/userBD";
            String usuario = "postgres";
            String contrasenia = "system";
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usuario, contrasenia);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error al cerrar conexión de la base de datos", ex);
        }

    }

}
