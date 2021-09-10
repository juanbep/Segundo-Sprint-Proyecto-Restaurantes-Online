package co.unicauca.user.presentation.rest;

import co.unicauca.user.domain.entity.User;
import co.unicauca.user.domain.service.UserService;
import co.unicauca.user.infra.DomainErrors;
import co.unicauca.user.infra.JsonResponse;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * API REST de los servicios web.
 *
 * @author Luis Tabares
 */
@Stateless
@Path("/user")
public class UserController {

    /**
     * Se inyecta la única implementación que hay de ProductService
     */
    @Inject
    private UserService service;

    public UserController() {
        service = new UserService();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8084/API-Usuario/user-service/user/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8084/API-Usuario/user-service/user/mfgranoble 

     */
    @GET
    @Path("{userName}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User findByUserName(@PathParam("userName") String userName) {
        return service.findByUserName(userName);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
          http://localhost:8084/API-Usuario/user-service/user/ 
         
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(User user) {
        JsonResponse resp;
        if (service.create(user)) {
            resp = new JsonResponse(true, "Usuario creado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear el Usuario", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8084/API-Usuario/user-service/user/magutierrez 
         
     */
    @PUT
    @Path("{userName}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("userName") String userName, User user) {
        JsonResponse resp;
        if (service.update(userName, user)) {
            resp = new JsonResponse(true, "Usuario modificado con éxito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar el Usuario", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8084/API-Usuario/user-service/user/mfgranoble 

     */
    @DELETE
    @Path("{userName}")
    public Response delete(@PathParam("userName") String userName) {
        JsonResponse resp;

        if (service.delete(userName)) {
            resp = new JsonResponse(true, "Usuario eliminado con éxito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar el usuario", DomainErrors.getErrors());
        }

        return Response.ok().entity(resp).build();

    }

}
