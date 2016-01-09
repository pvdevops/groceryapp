package com.ividevision.grocery.maincontroller;

import org.jboss.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ividevision.grocery.model.Item;
import com.ividevision.grocery.service.GroceryServiceImpl;

public class MainController {
	
	private static Logger logger = Logger.getLogger(ApplicationContext.class);
	private static ApplicationContext applicationContext;
	
	static ApplicationContext context = 
	    	  new ClassPathXmlApplicationContext("spring/applicationContext.xml");

	public static void main(String[] args) {
		// Auto-generated method stub
		logger.info("Main function Start for Grocery App.");
		
		GroceryServiceImpl groceryService = (GroceryServiceImpl)applicationContext.getBean("groceryService");
		
		Item item = groceryService.getItemById(1000L);
		
		System.out.println(item);

		logger.info("Main function End for Grocery App.");
	}

}
