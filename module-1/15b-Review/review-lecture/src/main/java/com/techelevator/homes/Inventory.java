package com.techelevator.homes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Inventory {
	
	
	// This hashmap contains our inventory of homes. We must protect it so it is private.
	// Only way to modify data is to go through the public methods below.
	private Map<String, Home> homeInventory = new HashMap<String, Home>();
	
	/**
	 * This constructor is called when the program loads (see HomeApp class). When inventory class is created
	 * it will load 'sample data'. Later in module 2, we will load data from a database. 
	 */
	public Inventory() {
		loadData();
	}



	/**
	 * This method returns a list of all homes in the map
	 * @return
	 */
	public List<Home> retrieveListOfHomes() {
		
		List<Home> homeList = new ArrayList<Home>();
		
		Set<String> keys = homeInventory.keySet();
		
		for (String key : keys) {
			
			homeList.add(homeInventory.get(key));
			
		}

		
		return homeList;
	}
	
	/**
	 * This method takes a mls number and uses it to search the map.
	 * @param mlsNumber
	 * @returns found home, or null if not found
	 */
	public Home findHomeByMLSNumber(String mlsNumber) {
		return homeInventory.get(mlsNumber);
	}
	
	/**
	 * This method takes a home object and adds it to the map
	 * @param home
	 */
	public void addNewListing(Home home) { 
		homeInventory.put(home.getMlsNumber(), home);
	}
	
	
	//This is temporary. This loads some sample data when the program loads. 
	// TODO: In Module 2, we will store homes in the database.
	
	private void loadData() {
		
		//create a home to populate map
		Address address = new Address(123, "Spooky Lane", "Columbus", "OH", 43225);
		
		Home home1 = new SingleFamilyHome(address, "123");  //calling constructor, passing in above address and setting mlsNumber to 123
		home1.setNumberOfBathrooms(4.5);
		home1.setNumberOfBedrooms(4);
		home1.setPrice(10000.00);
		home1.setShortDescription("This house sits on top of an old graveyard near the city mortuary.");
		
		homeInventory.put("123", home1);
		
		
		//create another home to populate map
		Address address1 = new Address(456, "Simpson Lane", "Columbus", "OH", 43225);
		
		Home home2 = new RentalHome(address1, "456", 12);
		home2.setNumberOfBathrooms(4.5);
		home2.setNumberOfBedrooms(4);
		home2.setPrice(100.00);
		home2.setShortDescription("This house belonged to Homer Simpson and sits only a mile from the nuclear plant.");
		
		homeInventory.put(home2.getMlsNumber(), home2);		
		
		
		
		
	}

	

}
