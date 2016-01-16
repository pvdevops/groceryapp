package com.ividevision.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ividevision.grocery.dao.ItemDAOImpl;
import com.ividevision.grocery.model.Item;

@Component
public class GroceryServiceImpl implements GroceryServiceInterface {
	
	@Autowired
	ItemDAOImpl itemDAO;
	
	@Transactional
	public Item getItemById(Long id)
	{
		return itemDAO.getItemById(id);
	}
	
	@Transactional
	public List<Item> getItems()
	{
		return itemDAO.getItems();
	}
	
	@Transactional
	public Item putItem(Item item)
	{
		return itemDAO.createItem(item);
	}
	
	@Transactional
	public Item updateItem(Item oldItem, Item newItem)
	{	
		Item updatedItem = itemDAO.updateItem(oldItem, newItem);
		return updatedItem;
	}
	
	@Transactional
	public void deleteItem(Item item)
	{	
		itemDAO.deleteItem(item);
	}
		
}
