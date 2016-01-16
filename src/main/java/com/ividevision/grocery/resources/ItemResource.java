package com.ividevision.grocery.resources;

import java.util.List;

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
@Path("/itemservice")
public class ItemResource {
	
	@Autowired
	private GroceryServiceImpl groceryService;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getItems() {
		
		/* return Response.status(200).entity("{\"List of items\": \"will be fetched soon\"}")
	              .header("Access-Control-Allow-Headers", "X-extra-header")
	              .allow("OPTIONS").build(); */
	    List<Item> items;
	    
	    try {
	      items = groceryService.getItems();
	      if (null != items) {
	        return Response.status(200).entity(items)
	            .header("Access-Control-Allow-Headers", "X-extra-header")
	            .allow("OPTIONS").build();
	      } else {
	        return Response.status(Response.Status.NO_CONTENT)
	            .entity("Error in fetching all items.").build();
	      }
	    } catch (Exception genericException) {
	      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	          .entity(genericException.getMessage()).build();
	    }
	} 
	
	@GET
	@Path("/getitem/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getItemById(@PathParam("id") Long itemId) {
		
	    try {
	        Item item = groceryService.getItemById(itemId);
	        if (null != item) {
	          return Response.status(Response.Status.ACCEPTED).entity(item)
	              .header("Access-Control-Allow-Headers", "X-extra-header")
	              .allow("OPTIONS").build();
	        } else {	                    
	          return Response.status(Response.Status.BAD_REQUEST)
		  	            .entity("{\"Error\":\"" + 
		  	    	             Response.Status.BAD_REQUEST + 
		  	    	             " - Item does NOT exist\" }").build();
	        }
	      } catch (Exception genericException) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity(genericException.getMessage()).build();
	      }
	}
	
	@POST
	@Path("/putitem")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response putItem(Item item) {
		
	    try {
	         item = groceryService.putItem(item);
	        if (null != item) {
	        	//return Response.status(Response.Status.CREATED).entity(id).build();
	          return Response.status(Response.Status.CREATED).entity(item)
	              .header("Access-Control-Allow-Headers", "X-extra-header")
	              .allow("OPTIONS").build();
	        } else {	          
	    	  return Response.status(Response.Status.BAD_REQUEST)
	  	            .entity("{\"Error\":\"" + 
	  	    	             Response.Status.BAD_REQUEST + 
	  	    	             " - Item already exists\" }").build();
	        }
	      } catch (Exception genericException) {
	    	  
	    	  genericException.printStackTrace();
	        
	    	  return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity("{\"Error\":\"" + 
	    	             Response.Status.INTERNAL_SERVER_ERROR + 
	    	             " - Item already exists\" }").build();
	      }
	}
	
	@PUT
	@Path("/updateitem/{id}")
	//@Consumes({MediaType.MULTIPART_FORM_DATA})
	//@Produces({MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response updateItem(@PathParam("id") String existingItemName, Item newItem) {
		
	    try {	
	    	 Item oldItem = new Item();
	    	 oldItem.setItemName(existingItemName);
	         Item item = groceryService.updateItem(oldItem, newItem);
	         
	         return Response.status(Response.Status.ACCEPTED).entity(item)
	              .header("Access-Control-Allow-Headers", "X-extra-header")
	              .allow("OPTIONS").build();
	        }
	    catch (Exception genericException) {
	    	  
	    	  genericException.printStackTrace();
	        
	    	  return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity(genericException.getMessage()).build();
	      }
	}
	
	@DELETE
	@Path("/deleteitem/{id}")
	//@Consumes({MediaType.MULTIPART_FORM_DATA})
	//@Produces({MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteItem(@PathParam("id") String existingItemName) {
		
	    try {
	    	 Item item = new Item();
	    	 item.setItemName(existingItemName);
	         groceryService.deleteItem(item);
	         
	         return Response.status(Response.Status.ACCEPTED).
	        		 entity("{\"Success\":\"" + 
    	             Response.Status.ACCEPTED + 
    	             " - Item successfully deleted\" }").build();
	        }
	    catch (Exception genericException) {
	    	  
	    	  genericException.printStackTrace();
	        
	    	  return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity(genericException.getMessage()).build();
	      }
	}
}
