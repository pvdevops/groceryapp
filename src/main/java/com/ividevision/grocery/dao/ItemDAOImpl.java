package com.ividevision.grocery.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.ividevision.grocery.model.Item;

@Component
public class ItemDAOImpl implements ItemDAOInterface {
	
	@PersistenceContext(unitName = "groceryAppDBPersistence")
	private EntityManager entityManager;
	
	public Item getItemById(Long id)
	{
	    try {
	        /* String queryString = "SELECT item FROM Item item WHERE item.id = ?1";
	        TypedQuery<Item> query = entityManager.createQuery(queryString,
	            Item.class);
	        query.setParameter(1, id); 

	        return query.getSingleResult(); */
	    	
	    	return entityManager.find(Item.class, id);
	        
	      } catch (NoResultException e) {
	        return null;
	      }		
	}
	
	public Item getItemByName(String itemName)
	{
	    try {
	        String queryString = "SELECT item FROM Item item WHERE item.itemName = ?1";
	        TypedQuery<Item> query = entityManager.createQuery(queryString,
	            Item.class);
	        query.setParameter(1, itemName);

	        return query.getSingleResult();
	        
	      } catch (NoResultException e) {
	        return null;
	      }		
	}
	
	public List<Item> getItems()
	{
	    try {
	    	
	        return entityManager.createQuery("SELECT item FROM Item item").getResultList();
	        
	      } catch (NoResultException e) {
	        return null;
	      }		
	}
	  
	  public Item createItem(Item item)
	  {
		  try {
		      entityManager.persist(item);
		      entityManager.refresh(item);
		     
		      return item; 
		      
		  } catch (Exception e) {
			  
			  //throw e;
			  return null;
		  }	  
	  }
	  
	  public Item updateItem(Item oldItem, Item newItem)
	  {
	   	  Item existingItem = getItemByName(oldItem.getItemName());
	   	  existingItem.setItemName(newItem.getItemName());
	   	  existingItem.setPrice(newItem.getPrice());
	      entityManager.merge(existingItem);
	      entityManager.flush();
	      return existingItem;
	  }
	  
	  public void deleteItem(Item item)
	  {
	   	  Item existingItem = getItemByName(item.getItemName());
	      entityManager.remove(existingItem);
		  return;
	  }
	  
	  public Boolean checkItem(Long id) 
	  {
		  return true;
	  }
	  
	  public List<Item> getItemsList()
	  {
		  List<Item> itemsList = new ArrayList<Item>();
		  return itemsList;
	  }

}
