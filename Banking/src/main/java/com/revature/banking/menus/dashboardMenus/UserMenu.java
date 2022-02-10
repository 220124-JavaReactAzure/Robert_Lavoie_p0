package com.revature.banking.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.banking.menus.Menu;
import com.revature.banking.util.MenuRouter;

public class UserMenu extends Menu{
	
	public UserMenu(BufferedReader consoleReader, MenuRouter router) {
		super("User", "/user", consoleReader, router);
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
