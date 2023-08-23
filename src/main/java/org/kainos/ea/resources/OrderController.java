package org.kainos.ea.resources;


import io.swagger.annotations.Api;
import org.kainos.ea.api.OrderService;
import org.kainos.ea.cli.Order;
import org.kainos.ea.client.FailedToGetOrderException;
import org.kainos.ea.client.OrderDoesNotExistException;
import org.kainos.ea.client.ProductDoesNotExistException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api("Engineering Academy Dropwizard Order APL")
@Path("/api")
public class OrderController {
    OrderService orderService = new OrderService();

    @GET
    @Path("/orders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders() {
        try {
            return Response.ok(orderService.getAllOrders()).build();

        } catch (FailedToGetOrderException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();

        }

    }

    @GET
    @Path("/orders/{id}")
    @Produces(MediaType.APPLICATION_JSON)
  public Response getOrdersById(@PathParam("id")int id) {

        try {
            return Response.ok(orderService.getOrderById(id)).build();
        } catch (FailedToGetOrderException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }catch(OrderDoesNotExistException e){

            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

}






