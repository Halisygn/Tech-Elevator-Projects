package com.techelevator.homes;

import java.util.List;

public class HomeApp {

	private Menu menu;
	private Inventory inventory;

	private final String LIST_HOMES = "1";
	private final String SEARCH_HOME_BY_MLS = "2";

	public HomeApp() {
		menu = new Menu();
		inventory = new Inventory();
	}


	public static void main(String[] args) {
         HomeApp app = new HomeApp();
         app.run();
	}


	private void run() {

		String response = menu.printMainMenu();

		if (response.equals(LIST_HOMES)) {
			//go fetch a list of homes from inventory class
			List<Home> foundHomes = inventory.retrieveListOfHomes();
			menu.printListOfHomes(foundHomes);
		}
		else if (response.equals(SEARCH_HOME_BY_MLS)) {
			// call menu class and have it ask user for mlsnumber
			String mlsNUmber = menu.askUserForMLSNumber();

			// pass this mlsnumber to inventory to go find
			Home home = inventory.findHomeByMLSNumber(mlsNUmber);

			// pass home it found to menu class to display data to user
			if (home != null) {
				menu.printHome(home);
			}
			else {
				//home not found
				menu.printError("Home Not Found!");
			}
		}
		else {

		}

	}
	

}
