package com.ividevision.grocery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ividevision.grocery.dao.ItemDAOInterface;
import com.ividevision.grocery.model.Item;

public class GroceryServiceImpl implements GroceryServiceInterface {
	
	@Autowired
	ItemDAOInterface itemDAO;
	
	@Transactional
	public Item getItemById(Long id)
	{
		return itemDAO.getItemById(id);
	}
	
	

}
