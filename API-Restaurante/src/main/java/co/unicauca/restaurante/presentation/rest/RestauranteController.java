package co.unicauca.restaurante.presentation.rest;

import co.unicauca.restaurante.domain.entity.Restaurant;
import co.unicauca.restaurante.domain.service.RestaurantService;
import co.unicauca.restaurante.infra.DomainErrors;
import co.unicauca.restaurante.infra.JsonResponse;
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
 * @author Andres Rios
 */
@Stateless
@Path("/restaurante")
public class RestauranteController {

    /**
     * Se inyecta la única implementación que hay de RestaurantService
     */
    @Inject
    private RestaurantService service;

    public RestauranteController() {
        service = new RestaurantService();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8084/API-Restaurante/restaurante-service/restaurante/ 

     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Restaurant> findAll() {
        return service.findAll();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8084/API-Restaurante/restaurante-service/restaurante/findByName/Maxi Pan 

     */
    @GET
    @Path("/findByName/{name}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Restaurant findByName(@PathParam("name") String name) {
        return service.findByName(name);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8084/API-Restaurante/restaurante-service/restaurante/findByNit/111 

     */
    @GET
    @Path("/findByNit/{nit}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Restaurant findByNit(@PathParam("nit") String nit) {
        return service.findByNit(nit);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X GET http://localhost:8084/API-Restaurante/restaurante-service/restaurante/findByAdmin/111 

     */
    @GET
    @Path("/findByAdmin/{userNameAdmin}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Restaurant> findByAdmin(@PathParam("userNameAdmin") String nameAdmin) {
        return service.findByAdmin(nameAdmin);
    }

    /*
        Su uso desde consola mediante client url:
        curl -X POST \
          http://localhost:8084/API-Restaurante/restaurante-service/restaurante/  
          
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Restaurant restaurant) {
        JsonResponse resp;
        if (service.create(restaurant)) {
            resp = new JsonResponse(true, "restaurane creado con exito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo crear el restaurante", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();
    }

    /*
        Su uso desde consola mediante client url:
        curl -X PUT \
          http://localhost:8084/API-Restaurante/restaurante-service/restaurante/222
         
     */
    @PUT
    @Path("{nit}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("nit") String nit, Restaurant restaurant) {
        JsonResponse resp;
        if (service.update(nit, restaurant)) {
            resp = new JsonResponse(true, "Restaurant modificado con exito", null);
        } else {
            resp = new JsonResponse(false, "No se pudo modificar el Restaurante", DomainErrors.getErrors());
        }
        return Response.ok().entity(resp).build();

    }

    /*
        Su uso desde consola mediante client url:
        curl -X DELETE http://localhost:8084/API-Restaurante/restaurante-service/restaurante/222 

     */
    @DELETE
    @Path("{nit}")
    public Response delete(@PathParam("nit") String nit) {
        JsonResponse resp;

        if (service.delete(nit)) {
            resp = new JsonResponse(true, "Restaurante eliminado con exito", null);

        } else {
            resp = new JsonResponse(false, "No se pudo eliminar el Restaurante", DomainErrors.getErrors());
        }
        service.delete(nit);

        return Response.ok().entity(resp).build();

    }

}
