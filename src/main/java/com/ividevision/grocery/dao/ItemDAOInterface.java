package com.ividevision.grocery.dao;

import java.util.List;
import com.ividevision.grocery.model.Item;


public interface ItemDAOInterface {
	
  public Item getItemById(Long id);
  
  public Long createItem(Long id);
  
  public void updateItem(Long id);
  
  public void deleteItem(Long id);
  
  public Boolean checkItem(Long id);
  
  public List<Item> getItemsList();

}
