package com.ividevision.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ividevision.grocery.service.GroceryServiceImpl;

@Controller
@RequestMapping("/")
public class MainController {	
		
	@Autowired
	private GroceryServiceImpl groceryService;
	
	    @RequestMapping(method = RequestMethod.GET)		
		public @ResponseBody String printItem(ModelMap model) 
		{
		      //model.addAttribute("message", getItemById(1000L).toString());		      
	    	 
	    	return groceryService.getItemById(1000L).toString();
		}	
		
	/* private static Logger logger = Logger.getLogger(ApplicationContext.class);
	
	static ApplicationContext appContext = 
	    	  new ClassPathXmlApplicationContext("spring/applicationContext.xml");

	public static void main(String[] args) {
		// Auto-generated method stub
		logger.info("Main function Start for Grocery App.");
		System.out.println("MAIN function Start for Grocery App.");
		
		GroceryServiceImpl groceryService = (GroceryServiceImpl)appContext.getBean("groceryService");
		
		Item item = groceryService.getItemById(1000L);
		
		System.out.println(item);

		logger.info("Main function End for Grocery App.");
	} */

}
