package co.unicauca.cliente;

import co.unicauca.cliente.restaurantathand.domain.entity.Menu;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:MenuController [/menu]<br>
 * USAGE:
 * <pre>
 *        MenuJerseyClient client = new MenuJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Luis Tabares 
 */
public class MenuJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8084/API-Menu/menu-service";

    public MenuJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("menu");
    }

    public Response deleteMenu(String idMenu) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{idMenu})).request().delete(Response.class);
    }

    public Response edit_XML(Object requestEntity, String idMenu) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{idMenu})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
    }

    public Response edit_JSON(Object requestEntity, String idMenu) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{idMenu})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T findDia(Class<T> responseType, String idMenu) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("lisDia/{0}", new Object[]{idMenu}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response createVisualizacion_XML(Object requestEntity, String idMenu, String Dia) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("createMenuVisualizacion/{0}/{1}", new Object[]{idMenu, Dia})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
    }

    public Response createVisualizacion_JSON(Object requestEntity, String idMenu, String Dia) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("createMenuVisualizacion/{0}/{1}", new Object[]{idMenu, Dia})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response deleteVisualizacion(String idMenu, String Dia) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteVisualizacion/{0}/{1}", new Object[]{idMenu, Dia})).request().delete(Response.class);
    }

    public Response create_XML(Object requestEntity) throws ClientErrorException {
        return webTarget.path("createMenu").request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
    }

    public Response create_JSON(Object requestEntity) throws ClientErrorException {
        return webTarget.path("createMenu").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response createOfrece_XML(Object requestEntity, String idMenu, String idPlato) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("createOfrece/{0}/{1}", new Object[]{idMenu, idPlato})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
    }

    public Response createOfrece_JSON(Object requestEntity, String idMenu, String idPlato) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("createOfrece/{0}/{1}", new Object[]{idMenu, idPlato})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T findByMenuId_XML(Class<T> responseType, String idMenu) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{idMenu}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findByMenuId_JSON(Class<T> responseType, String idMenu) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{idMenu}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findPlato(Class<T> responseType, String idMenu) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("lisPlatos/{0}", new Object[]{idMenu}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> List<Menu> findAll(GenericType<List<Menu>> responseType) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public Response deleteOfrece(String idMenu, String idPlato) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteOfrece/{0}/{1}", new Object[]{idMenu, idPlato})).request().delete(Response.class);
    }

    public void close() {
        client.close();
    }

     public <T> List<Menu> findMbyRN_JSON(GenericType<List<Menu>> responseType, String rn) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> List<String> findPlato_JSON(GenericType<List<String>> responseType, String atrNameDish) throws ClientErrorException{
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
}
