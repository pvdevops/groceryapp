package com.ividevision.grocery.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ividevision.grocery.model.Item;
import com.ividevision.grocery.service.GroceryServiceImpl;

/**
 * Rest Layer resource for grocery Items
 *
 */

@Component
//@PreAuthorize("hasRole('ROLE_REST')")
@Path("/getitems")
public class ItemResource {
	
	@Autowired
	private GroceryServiceImpl groceryService;
	
	@GET
	//@Path("listnodes")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getItems() {
		
		return Response.status(200).entity("{List of items will be fetched soon}")
	              .header("Access-Control-Allow-Headers", "X-extra-header")
	              .allow("OPTIONS").build();
	    /* List<Item> items;
	    
	    try {
	      items = groceryService.getItems();
	      if (null != ec2ConfigsById) {
	        return Response.status(200).entity(ec2ConfigsById)
	            .header("Access-Control-Allow-Headers", "X-extra-header")
	            .allow("OPTIONS").build();
	      } else {
	        return Response.status(Response.Status.NO_CONTENT)
	            .entity("Error in finding Nodes.").build();
	      }
	    } catch (Exception genericException) {
	      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	          .entity("Error in finding Nodes.").build();
	    } */
	} 
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getItemById(@PathParam("id") Long itemId) {
		
	    try {
	        Item item = groceryService.getItemById(itemId);;
	        if (null != item) {
	          return Response.status(200).entity(item)
	              .header("Access-Control-Allow-Headers", "X-extra-header")
	              .allow("OPTIONS").build();
	        } else {
	          return Response.status(Response.Status.NO_CONTENT)
	              .entity("Error in finding Item.").build();
	        }
	      } catch (Exception genericException) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity("Error in finding Item.").build();
	      }
	}
}
