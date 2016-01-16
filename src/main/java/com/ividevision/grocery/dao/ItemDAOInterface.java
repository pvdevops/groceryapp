package com.ividevision.grocery.dao;

import java.util.List;
import com.ividevision.grocery.model.Item;


public interface ItemDAOInterface {
	
  public Item getItemById(Long id);
  
  public Item getItemByName(String itemName);
  
  public Item createItem(Item item);
  
  public Item updateItem(Item oldItem, Item newItem);
  
  public void deleteItem(Item item);
  
  public Boolean checkItem(Long id);
  
  public List<Item> getItemsList();

}
