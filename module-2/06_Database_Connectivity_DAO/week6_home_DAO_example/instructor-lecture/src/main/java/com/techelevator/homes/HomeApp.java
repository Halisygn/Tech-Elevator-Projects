package com.techelevator.homes;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.homes.domain.Home;
import com.techelevator.homes.model.HomeDAO;
import com.techelevator.homes.model.HomeSqlDAO;
import com.techelevator.homes.view.Menu;

public class HomeApp {
	
	private static final String LIST_ALL_HOMES = "1";
	private static final String SEARCH_HOMES_BY_MLS = "2";
	private static final String ADD_HOME = "3";
	private static final String DELETE_HOME = "4";
	private static final String LIST_AGENT_SUBMENU_OPTIONS = "5";
	private static final String EXIT_PROGRAM = "6";
	
	//the datasource will be an object we pass to the DAO imple class.
 	private BasicDataSource homeDataSource;
	
	
 	private Menu menu;
 	private HomeDAO homeDAO;
 	
 	public HomeApp() {
 		this.menu = new Menu();
 		this.homeDAO = new HomeSqlDAO(getDataSource());
 	}


	
	// The main() should just create an instance of the class, and delegate to another method. In this case the run()
	public static void main(String[] args) {
		
         HomeApp app = new HomeApp();
         app.run();
	}
	
	
	// The run method is private. It provides the highest level of orchestration/control. 
	// In this case, It uses the Menu class to do UI stuff like print menu and user prompts and 
	// it uses the homeInventory class to handle the data side of things. 
	
	// The main method acts as a controller to 'control' the overall flow of the program.
    private void run() {	
    	
    	
    	//this is a boolean value to keep the program running unless user enters exit.
    	boolean running = true;
    	
        while (running) {
        	
        	String choice = menu.printMainMenu();   

    		if (choice.equals(LIST_ALL_HOMES)) {
    			
    	         //TODO: implement me using DAO
    			List<Home> homeList = homeDAO.retrieveHomesForSale();
    			menu.printListOfHomes(homeList);
    			
    		}
    		else if (choice.equals(SEARCH_HOMES_BY_MLS)) {
    			
    			//call the menu to ask the user for a MLS Number..
    			String mls = menu.getMLSNumberFromUser();
    			
                //TODO: Implement me using DAO
    			Home home = homeDAO.retrieveHomeByMLSId(mls);
    			
    			menu.printHome(home);
    			
    		}
    		else if (choice.equals(ADD_HOME)) {

    			//call the menu class to prompt user to enter home information
    			Home homeToAdd = menu.getHomeInfo();
    			
                homeDAO.addHome(homeToAdd);
    			
    		}
    		else if (choice.equals(DELETE_HOME)) {
    			
    			String mls = menu.promptUserForMLSNumberToDelete();
  
    			boolean isDeleted = homeDAO.deleteHome(mls);
    			
    			if (isDeleted) {
    				menu.printMessage("Home: " + mls + " was deleted");
    			}
    			else {
    				menu.printMessage("Home: " + mls + " not found");
    			}
    			
    		}
    		else if (choice.equals(LIST_AGENT_SUBMENU_OPTIONS)){
    			
    			handleSubMenu();
    			
    		}
    		else if(choice.equals(EXIT_PROGRAM)) {
    			
    			running = false;  // this allows us to exit the loop
    			
    		}
    		else {
    			
    			menu.printMessage(choice + " is not a valid option!");
    			
    		}  
    		

        }  // end of main while loop
		
       
		//exit the program
		System.out.println("Exiting the program.... Goodbye!");
    	
    	
    }
    
    private void handleSubMenu() {
    	
    	
			boolean isLooping = true;
			
	    	while (isLooping) {
	    				
	    		String subMenuChoice = menu.printAgentManagementMenu();
	    				
	    		if (subMenuChoice.equalsIgnoreCase("1")) {
	    			//TODO: remove sysout and implement
	    			System.out.println("You chose #1");	
	    		}
	    		else if (subMenuChoice.equalsIgnoreCase("2")) {
	    			//TODO: remove sysout and implement
	    			System.out.println("You chose #2");	
	    		}
	    		else if (subMenuChoice.equalsIgnoreCase("3")) {
	    			//TODO: remove sysout and implement
	    			System.out.println("You chose #3");	
	    		}	    		
	    		else if (subMenuChoice.equalsIgnoreCase("4")) {
	    			//TODO: remove sysout and implement
	    			System.out.println("You chose #4");	
	    		}	    	    		
	    		else if (subMenuChoice.equalsIgnoreCase("5")){
	    			//TODO: remove sysout and implement
	    			System.out.println("Returning to previous menu");
	    			isLooping = false;
	    			
	    		}
	    		else {
	    			menu.printMessage("Invalid Choice.");
	    		}
	    				
	    } 	
	    	
	    	//sends us back to main menu
    	
    }
    
    
    private BasicDataSource getDataSource() {
	   BasicDataSource homeDataSource = new BasicDataSource();
	   homeDataSource.setUrl("jdbc:postgresql://localhost:5432/jghomes");
	   homeDataSource.setUsername("postgres");
	   homeDataSource.setPassword("postgres1");
	   return homeDataSource;
    }
    
    

}
