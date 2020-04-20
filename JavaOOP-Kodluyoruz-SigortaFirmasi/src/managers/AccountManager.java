package managers;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import account.Account;
import account.ext.*;
import address.IAddress;
import address.impl.*;
import exception.InvalidAuthenticationException;
import user.User;

public class AccountManager {
	
	Set<Account> accounts = new TreeSet<Account>();
	
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	
	public Account logIn(String email,String password) throws InvalidAuthenticationException {
		addAccount(getEnterpriseAccount(sampleEnterpriseUsers()));
		addAccount(getIndividualAccounts(sampleIndividualUsers()));
		for(Account account : accounts) {
			try {
				if(account.logIn(account,email, password)) {
					return account;
				}
			}catch(InvalidAuthenticationException invalidAuthenticationException) {
				System.out.println(invalidAuthenticationException.getMessage());
				return null;
			}
		}
		return null;
	}
	
	public User sampleIndividualUsers() {
		ArrayList<IAddress> addressList = new ArrayList<IAddress>();
		HomeAddress homeAddress = new HomeAddress("aHSehir","aHIlce","aHCadde","aHCadde",1);
		BusinessAddress businessAddress = new BusinessAddress("aBSehir","aBIlce","aBCadde","aBSokak",2);
		addressList.add(homeAddress);
		addressList.add(businessAddress);
		User user = new User("Alihan","Yilmaz","alihan@email.com","alihan123","Developer",(short)25,addressList);
		return user;
	}
	public User sampleEnterpriseUsers() {
		ArrayList<IAddress> addressList = new ArrayList<IAddress>();
		HomeAddress homeAddress = new HomeAddress("mHSehir","mHIlce","mHCadde","mHCadde",1);
		BusinessAddress businessAddress = new BusinessAddress("mBSehir","mBIlce","mBCadde","mBSokak",2);
		addressList.add(homeAddress);
		addressList.add(businessAddress);
		User user = new User("Meric","Aytuglu","meric@email.com","meric123","Developer",(short)25,addressList);
		return user;
	}
	
	public Account getIndividualAccounts(User user) {
		Account account = new Individual(user);
		return account;
	}
	public Account getEnterpriseAccount(User user) {
		Account account = new Enterprise(user);
		return account;
	}
	
}
