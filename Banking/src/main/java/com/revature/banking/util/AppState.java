package com.revature.banking.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.banking.daos.AccountDAO;
import com.revature.banking.daos.UserDAO;
import com.revature.banking.menus.dashboardMenus.AccountCreationMenu;
import com.revature.banking.menus.dashboardMenus.DashboardMenu;
import com.revature.banking.menus.dashboardMenus.UserMenu;
import com.revature.banking.menus.startPages.LoginMenu;
import com.revature.banking.menus.startPages.RegisterMenu;
import com.revature.banking.menus.startPages.WelcomeMenu;
import com.revature.banking.services.AccountService;
import com.revature.banking.services.UserService;
import com.revature.banking.util.logging.Logger;

public class AppState {

	private final Logger logger;
	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		
		logger = Logger.getLogger(true);
		logger.log("Application is initiliazing.....");
		
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		UserDAO scientistDAO = new UserDAO();
		AccountDAO monsterDAO = new AccountDAO();
		UserService scientistService = new UserService(scientistDAO);
		AccountService monsterService = new AccountService(monsterDAO, scientistService);
		
		router.addMenu(new WelcomeMenu(consoleReader, router));
		router.addMenu(new RegisterMenu(consoleReader, router, scientistService));
		router.addMenu(new LoginMenu(consoleReader, router, scientistService));
		router.addMenu(new DashboardMenu(consoleReader, router, scientistService));
		router.addMenu(new UserMenu(consoleReader, router));
		router.addMenu(new AccountCreationMenu(consoleReader, router, monsterService));
		
		logger.log("Application initiliazed!!! We do did it!~WOOO~");
	}
	
	public void startup() {
		try {
			while(isRunning) {
				router.transfer("/welcome");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void shutdown() {
		isRunning = false;
	}
	
}
