package com.techelevator.jghomes;

import java.util.Scanner;

import com.techelevator.jghomes.exceptions.HomeServiceException;
import com.techelevator.jghomes.models.AuthenticatedUser;
import com.techelevator.jghomes.models.Home;
import com.techelevator.jghomes.models.UserCredentials;
import com.techelevator.jghomes.services.AuthenticationService;
import com.techelevator.jghomes.exceptions.AuthenticationServiceException;
import com.techelevator.jghomes.services.HomeService;
import com.techelevator.view.ConsoleService;

public class App {

	private static final String API_BASE_URL = "http://localhost:8080/";

	private static final String MENU_OPTION_EXIT = "Exit";
	private static final String LOGIN_MENU_OPTION_REGISTER = "Register";
	private static final String LOGIN_MENU_OPTION_LOGIN = "Login";
	private static final String[] LOGIN_MENU_OPTIONS = { LOGIN_MENU_OPTION_REGISTER, LOGIN_MENU_OPTION_LOGIN,
			MENU_OPTION_EXIT };

	private static final String MAIN_MENU_OPTION_LIST_ALL_HOMES = "List all homes";
	private static final String MAIN_MENU_OPTION_GET_HOME_BY_ID = "Retrieve home by MLS identifier";
	private static final String MAIN_MENU_OPTION_ADD_HOME = "Add a home";
	private static final String MAIN_MENU_OPTION_DELETE_HOME = "Delete a home";

	private static final String MAIN_MENU_OPTION_LOGIN = "Login as different user";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_LIST_ALL_HOMES,
			MAIN_MENU_OPTION_GET_HOME_BY_ID, MAIN_MENU_OPTION_ADD_HOME, MAIN_MENU_OPTION_DELETE_HOME,
			MAIN_MENU_OPTION_LOGIN, MENU_OPTION_EXIT };

	// I have all the user info you may need after you login .. ;-)
	private AuthenticatedUser currentUser;

	// user interface - console service
	private ConsoleService console;

	// client services
	private AuthenticationService authenticationService;
	private HomeService homeService;

	private Scanner scanner;

	public static void main(String[] args) throws HomeServiceException {
		App app = new App(new ConsoleService(System.in, System.out), new AuthenticationService(API_BASE_URL),
				new HomeService(API_BASE_URL));
		app.run();
	}

	public App(ConsoleService console, AuthenticationService authenticationService, HomeService homeService) {
		this.console = console;
		this.authenticationService = authenticationService;
		this.homeService = homeService;
		scanner = new Scanner(System.in);
	}

	public void run() throws HomeServiceException {
		System.out.println("*********************");
		System.out.println("* Welcome to JG Homes! *");
		System.out.println("*********************");

		registerAndLogin();
		mainMenu();
	}

	private void mainMenu() throws HomeServiceException {
		while (true) {
			String choice = (String) console.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (MAIN_MENU_OPTION_LIST_ALL_HOMES.equals(choice)) {
				listAllHomes();
			} else if (MAIN_MENU_OPTION_GET_HOME_BY_ID.equals(choice)) {
				getHomeByMLSID();
			} else if (MAIN_MENU_OPTION_ADD_HOME.equals(choice)) {
				addHome();
			} else if (MAIN_MENU_OPTION_DELETE_HOME.equals(choice)) {
				deleteHome();
			} else if (MAIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else {
				// the only other option on the main menu is to exit
				exitProgram();
			}
		}
	}

	private void listAllHomes() throws HomeServiceException {
		Home[] homes = homeService.retrieveListOfHomes();
		console.printListOfHomes(homes);

	}

	private void getHomeByMLSID() throws HomeServiceException {
		Home home = homeService.retrieveHomesByMLSID(console.getMLSNumberFromUser());
		console.printHome(home);
	}

	private void addHome() throws HomeServiceException {
		homeService.addHome(console.getHomeInfo());
	}

	private void deleteHome() throws HomeServiceException {
		homeService.deleteHome(console.promptUserForMLSNumberToDelete());
	}

	private void exitProgram() {
		System.exit(0);
	}

	private void registerAndLogin() {
		while (!isAuthenticated()) {
			String choice = (String) console.getChoiceFromOptions(LOGIN_MENU_OPTIONS);
			if (LOGIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else if (LOGIN_MENU_OPTION_REGISTER.equals(choice)) {
				register();
			} else {
				// the only other option on the login menu is to exit
				exitProgram();
			}
		}
	}

	/*
	 * Current user is not null IF they have been authenticated.
	 */
	private boolean isAuthenticated() {
		return currentUser != null;
	}

	private void register() {
		System.out.println("Please register a new user account");
		boolean isRegistered = false;
		while (!isRegistered) // will keep looping until user is registered
		{
			UserCredentials credentials = console.collectUserCredentials();
			try {
				authenticationService.register(credentials);
				isRegistered = true;
				System.out.println("Registration successful. You can now login.");
			} catch (AuthenticationServiceException e) {
				System.out.println("REGISTRATION ERROR: " + e.getMessage());
				System.out.println("Please attempt to register again.");
			}
		}
	}

	private void login() {
		System.out.println("Please log in");
		currentUser = null;
		while (currentUser == null) // will keep looping until user is logged in
		{
			UserCredentials credentials = console.collectUserCredentials();
			try {
				currentUser = authenticationService.login(credentials);

				// WE NEED THIS NEXTLINE FOR THE CAPSTONE
				//we need to grab the AUTH TOKEN from current user and set it on the home service
				//so the home service has the token for it's requests.
				homeService.setAUTH_TOKEN(currentUser.getToken());



			} catch (AuthenticationServiceException e) {
				System.out.println("LOGIN ERROR: " + e.getMessage());
				System.out.println("Please attempt to login again.");
			}
		}
	}




}
