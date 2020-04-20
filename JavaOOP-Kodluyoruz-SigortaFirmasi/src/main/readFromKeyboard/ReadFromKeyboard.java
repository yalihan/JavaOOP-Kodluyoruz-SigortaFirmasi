package main.readFromKeyboard;

import java.util.Scanner;

import account.Account;
import exception.InvalidAuthenticationException;
import managers.AccountManager;

public class ReadFromKeyboard {
	
	public Account logIn() throws InvalidAuthenticationException {
		AccountManager accountManager = new AccountManager();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Email : ");
		String email = scanner.nextLine();
		System.out.print("Password : ");
		String password = scanner.nextLine();
		
		return accountManager.logIn(email, password);
		
	}
}
