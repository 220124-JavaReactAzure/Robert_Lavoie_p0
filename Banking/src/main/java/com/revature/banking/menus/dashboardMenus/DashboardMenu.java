package com.revature.banking.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.banking.menus.Menu;
import com.revature.banking.models.User;
import com.revature.banking.services.UserService;
import com.revature.banking.util.MenuRouter;

public class DashboardMenu extends Menu {

	private final UserService userService;

	public DashboardMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("Dashboard", "/dashboard", consoleReader, router);
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {

		User sessionScientist = userService.getSessionUser();

		if (sessionScientist == null) {
			System.out.println("You are not currently logged in! Rerouting to the login screen.....");
			router.transfer("/login");
			return;
		}

		while (userService.isSessionActive()) {
			System.out.println("Welcome " + userService.getSessionUser());
			String menu = "1) View/edit my profile information\n" + 
					"2) Edit/create Accounts\n" +
					"3) View my Accounts\n" + 
					"4) Logout\n" + 
					 "> ";

			System.out.print(menu);

			String userSelection = consoleReader.readLine();

			switch (userSelection) {
			case "1":
				System.out.println("View/edit profile selected");
				router.transfer("/user-profile-edit");
				break;
			case "2":
				System.out.println("View/edit/create accounts selected");
				router.transfer("/create-account");
				break;
			case "3":
				System.out.println("View My accounts selected:");
				router.transfer("/my-accounts");
				break;
			case "4":
				userService.logout();
				break;
			default:
				System.out.println("The user made an invalid selection");
			}
		}
	}

}
