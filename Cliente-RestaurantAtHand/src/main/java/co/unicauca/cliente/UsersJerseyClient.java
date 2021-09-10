package co.unicauca.cliente;

import co.unicauca.cliente.restaurantathand.domain.entity.User;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 * Jersey REST client generated for REST resource:UserController [user]<br>
 * USAGE:
 * <pre>
 *        UsersJerseyClient client = new UsersJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Beca98
 */
public class UsersJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8084/API-Usuario/user-service";

    public UsersJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("user");
    }

    public <T> T findByUserName_XML(Class<T> responseType, String userName) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{userName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findByUserName_JSON(Class<T> responseType, String userName) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{userName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public javax.ws.rs.core.Response edit_XML(Object requestEntity, String userName) throws javax.ws.rs.ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{userName})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), javax.ws.rs.core.Response.class);
    }

    public javax.ws.rs.core.Response edit_JSON(Object requestEntity, String userName) throws javax.ws.rs.ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{userName})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), javax.ws.rs.core.Response.class);
    }

    public javax.ws.rs.core.Response create_XML(Object requestEntity) throws javax.ws.rs.ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), javax.ws.rs.core.Response.class);
    }

    public javax.ws.rs.core.Response create_JSON(Object requestEntity) throws javax.ws.rs.ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), javax.ws.rs.core.Response.class);
    }

    public <T> T findAll(Class<T> responseType) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public javax.ws.rs.core.Response delete(String userName) throws javax.ws.rs.ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{userName})).request().delete(javax.ws.rs.core.Response.class);
    }

    public void close() {
        client.close();
    }

    public <T> List<User> findAll(GenericType<List<User>> responseType) throws javax.ws.rs.ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

}
