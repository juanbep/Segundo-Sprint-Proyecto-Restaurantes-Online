package co.unicauca.cliente.restaurantathand.domain.entity;

/**
 * User que puede ser Administrador de un restaurante o un cliente de la
 * aplicacion
 *
 * @author Beca98
 */
public class User {

    /**
     * Nombre de usuario
     */
    private String atrUserName;
    /**
     * Cedula
     */
    private String atrIdentification;
    /**
     * Nombres
     */
    private String atrName;
    /**
     * Apellidos
     */
    private String atrLastName;
    /**
     * Contraseña
     */
    private String atrPassword;
    /**
     * Nombre de ciudad
     */
    private String atrCity;
    /**
     * Dirección de residencia
     */
    private String atrAddress;
    /**
     * Teléfono Móvil
     */
    private String atrPhone;
    /**
     * Tipo de User (Administrador o Usuario)
     */
    private String atrType;

    public User() {
    }

    public User(String atrUserName, String atrIdentification, String atrName, String atrLastName, String atrContrasena, String atrCiudad, String atrDireccion, String atrCelular, String atrTipo) {
        this.atrUserName = atrUserName;
        this.atrIdentification = atrIdentification;
        this.atrName = atrName;
        this.atrLastName = atrLastName;
        this.atrPassword = atrContrasena;
        this.atrCity = atrCiudad;
        this.atrAddress = atrDireccion;
        this.atrPhone = atrCelular;
        this.atrType = atrTipo;
    }

    public String getAtrUserName() {
        return atrUserName;
    }

    public void setAtrUserName(String atrUserName) {
        this.atrUserName = atrUserName;
    }

    public String getAtrIdentification() {
        return atrIdentification;
    }

    public void setAtrIdentification(String atrIdentification) {
        this.atrIdentification = atrIdentification;
    }

    public String getAtrName() {
        return atrName;
    }

    public void setAtrName(String atrName) {
        this.atrName = atrName;
    }

    public String getAtrLastName() {
        return atrLastName;
    }

    public void setAtrLastName(String atrLastName) {
        this.atrLastName = atrLastName;
    }

    public String getAtrPassword() {
        return atrPassword;
    }

    public void setAtrPassword(String atrPassword) {
        this.atrPassword = atrPassword;
    }

    public String getAtrCity() {
        return atrCity;
    }

    public void setAtrCity(String atrCity) {
        this.atrCity = atrCity;
    }

    public String getAtrAddress() {
        return atrAddress;
    }

    public void setAtrAddress(String atrAddress) {
        this.atrAddress = atrAddress;
    }

    public String getAtrPhone() {
        return atrPhone;
    }

    public void setAtrPhone(String atrPhone) {
        this.atrPhone = atrPhone;
    }

    public String getAtrType() {
        return atrType;
    }

    public void setAtrType(String atrType) {
        this.atrType = atrType;
    }

}
