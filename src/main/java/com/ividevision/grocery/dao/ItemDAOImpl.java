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
	        String queryString = "SELECT item FROM Item item WHERE item.id = ?1";
	        TypedQuery<Item> query = entityManager.createQuery(queryString,
	            Item.class);
	        query.setParameter(1, id);

	        return query.getSingleResult();
	        
	      } catch (NoResultException e) {
	        return null;
	      }		
	}
	  
	  public Long createItem(Long id)
	  {
		  return 1L;
	  }
	  
	  public void updateItem(Long id)
	  {
		  return;
	  }
	  
	  public void deleteItem(Long id)
	  {
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
