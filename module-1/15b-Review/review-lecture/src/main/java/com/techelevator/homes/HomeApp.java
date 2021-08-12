package com.techelevator.homes;

import java.util.List;

public class HomeApp {
	private Menu menu;
	private Inventory inventory;
	private final String LIST_HOMES="1";
	private final String SEARCH_HOME_BY_MLS="2";

	public HomeApp(){
		menu=new Menu();
		inventory=new Inventory();
	}

	public static void main(String[] args) {
         HomeApp app = new HomeApp();
         app.run();
	}
	private void run(){
		String response=menu.printMainMenu();
		if (response.equals(LIST_HOMES)){
			List<Home> foundHomes= inventory.retrieveListOfHomes();
			menu.printListOfHomes(foundHomes);
		} else if (response.equals(SEARCH_HOME_BY_MLS)) {
			String mlsNUmber=menu.askUserForMLSNumber();
			Home home= inventory.findHomeByMLSNumber(mlsNUmber);
			menu.printHome(home);
			if(home!=null){
				menu.printHome(home);
			}else{
				menu.printError("Home Not Found");
			}
		}
	}
}
