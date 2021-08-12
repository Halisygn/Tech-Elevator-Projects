package com.techelevator.homes;

import java.util.List;
import java.util.Scanner;

/**
 * The Menu class is responsible for printing a simple menu for our application
 * and capturing user input. This acts as the User Interface for our app.
 * 
 * @author Java Green Rock Stars
 *
 */

public class Menu {

	private Scanner scanner;

	public Menu() {
		scanner = new Scanner(System.in);
	}

	public String printMainMenu() {

		System.out.println("***************************");
		System.out.println("Java Green Realtor App 3000");
		System.out.println("***************************\n");

		System.out.println("1. List all homes");
		System.out.println("2. Search for a home by MLS Number");
		System.out.println("3. Add a new listing");
		System.out.println("4. Exit\n");

		System.out.println("Please select your choice (number only)");

        String response = scanner.nextLine();
        return response;
	}


	public void printListOfHomes(List<Home> homeList) {

		for (Home home : homeList) {
			printHome(home);
		}

	}


	public String askUserForMLSNumber() {
		System.out.println("PLease enter the MLS Number your are looking for: ");
		return scanner.nextLine();
	}


	
	/**
	 * This method prints out a single home.  We 'could' have put this up in the for each loop above, but breaking
	 * it out on it's own keeps the code above cleaner AND we can also reuse when printing out the home from menu option 2
	 *  
	 * @param home
	 */
	public void printHome(Home home) {
		
		System.out.println("MLS Number: " + home.getMlsNumber());

		if (home.getAddress() != null) {
			System.out.println("Street Address: " + home.getAddress().getStreetNumber() + " "
					+ home.getAddress().getStreetName() + " " + home.getAddress().getCity() + " "
					+ home.getAddress().getState() + " " + home.getAddress().getZipCode() + "\n");
		}
		
		System.out.println(String.format("%-25s %s", "Bedrooms: ", home.getNumberOfBedrooms()));
		System.out.println(String.format("%-25s %s", "Bathrooms: ", home.getNumberOfBathrooms()));
		System.out.println(String.format("%-25s %s", "Description: ", home.getShortDescription()));
		System.out.println(String.format("%-25s $%s", "Price: ", String.format("%.2f", home.getPrice())));
		
		System.out.println("\n*********** *** *** ***  ************\n");		
		
	}
	
	
	public Home getHomeInfo() {
		
		Home home = null;
		
		System.out.println("Enter the MLS Number this house is listed under");
		String mls = scanner.nextLine();
		
		
		//call private method below to get the address from user
		Address address = getAddressInfo();
		
		System.out.println("Is this a (S)ingle Family Home or (R)ental Home?");
		String type = scanner.nextLine();
		
		if (type.equalsIgnoreCase("R")) {
			//ask for a rental term
			System.out.println("What is the rental term for this property in months?");
			String termAsString = scanner.nextLine();
			
			home = new RentalHome(address, mls, Integer.parseInt(termAsString));
		}
		else {
			home = new SingleFamilyHome(address, mls, "VAC");  //defaulting neighborhood to VAC
		}
		
		
		System.out.println("Enter the number of Bedrooms: ");
		String numberOfBedrooms = scanner.nextLine();
		home.setNumberOfBedrooms(Double.parseDouble(numberOfBedrooms));
		
		System.out.println("Enter the number ofBathrooms: ");
		String numberOfBathrooms = scanner.nextLine();
		home.setNumberOfBathrooms(Double.parseDouble(numberOfBathrooms));
		
		
		System.out.println("Enter a short description of the property: ");
		home.setShortDescription(scanner.nextLine());
		
		System.out.println("What is the listing price of this property?");
		String priceAsString = scanner.nextLine();
		home.setPrice(Double.parseDouble(priceAsString));
		
		
		
		return home;
		
	}
	
	
	
	public void printError (String message) {
		System.out.println("Error: " + message);
	}
	
	
	
	
	
	private Address getAddressInfo() {
		Address address = new Address();
		
		System.out.println("\nEnter the street number of the residence: ");
		int streetNumber = Integer.parseInt(scanner.nextLine());
		address.setStreetNumber(streetNumber);
		
		System.out.println("\nEnter the street name of the residence: ");
		address.setStreetName(scanner.nextLine());
		
		System.out.println("\nEnter the city name: ");
		address.setCity(scanner.nextLine());
		
		System.out.println("\nEnter the state: ");
		address.setState(scanner.nextLine());
		
		System.out.println("\nEnter the zip code: ");
		String zip = scanner.nextLine();
		address.setZipCode(Integer.parseInt(zip));
		
		return address;
	}	

}
