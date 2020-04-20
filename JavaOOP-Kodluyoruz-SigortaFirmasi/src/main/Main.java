package main;

import java.time.LocalDate;
import java.util.Scanner;

import account.Account;
import address.impl.BusinessAddress;
import address.impl.HomeAddress;
import exception.InvalidAuthenticationException;
import insurance.ext.CarInsurance;
import insurance.ext.HealthInsurance;
import insurance.ext.ResidanceInsurance;
import insurance.ext.TravelInsurance;
import main.readFromKeyboard.ReadFromKeyboard;
import managers.AddressManager;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	private static ReadFromKeyboard readFromKeyboard = new ReadFromKeyboard();
	
	public static void main(String[] args) throws InvalidAuthenticationException {
		
		
		Account account = readFromKeyboard.logIn();
		
		while(account != null) {
			showMainMenu();
			System.out.print("\nNe yapmak istersiniz ?");
			int choice = scanner.nextInt();
			if(choice == 11) {
				break;
			}else if(choice == 1) {
				account.showUserInfo();
				System.out.println(account.getInsuranceList().toString());
			}else if(choice == 2) {
				addHomeAddress(account);
			}else if(choice == 3) {
				addBusinessAddress(account);
			}else if(choice == 4) {
				removeAddress(account, 0);
			}else if(choice == 5) {
				removeAddress(account, 1);
			}else if(choice == 6) {
				showAccountPolicy(account);
			}else if(choice == 7) {
				addHealthPolicy(account);
			}else if(choice == 8) {
				addResidancePolicy(account);
			}else if(choice == 9) {
				addCarPolicy(account);
			}else if(choice == 10) {
				addTravelPolicy(account);
			}
		}
	}
	
	

	
	public static void showMainMenu() {
		StringBuilder builder = new StringBuilder();
		builder.append("1 - Bilgilerimi Goster");
		builder.append("\n2 - Ev Adresi Ekle");
		builder.append("\n3 - Is Adresi Ekle");
		builder.append("\n4 - Ev Adresi Cikar");
		builder.append("\n5 - Is Adresi Cikar");
		builder.append("\n6 - Sigorta Policelerim");
		builder.append("\n7 - Hayat Sigortası Ekle");
		builder.append("\n8 - Ev Sigortası Ekle");
		builder.append("\n9 - Araba Sigortası Ekle");
		builder.append("\n10 - Seyahat Sigortası Ekle");
		builder.append("\n11 - Cikis");
		System.out.println(builder.toString());
	}
	

	public static void addHomeAddress(Account account) {
		System.out.print("Province: ");
		String province = scanner.nextLine();

		System.out.print("District: ");
		String district = scanner.nextLine();

		System.out.print("Road: ");
		String road = scanner.nextLine();

		System.out.print("Street: ");
		String street = scanner.nextLine();

		System.out.println("Built No: ");
		int builtNo = scanner.nextInt();

		AddressManager.addAddress(account.getUser(), new HomeAddress(province, district, road, street, builtNo));
		
	}
	public static void addBusinessAddress(Account account) {
		System.out.print("Province: ");
		String province = scanner.nextLine();

		System.out.print("District: ");
		String district = scanner.nextLine();

		System.out.print("Road: ");
		String road = scanner.nextLine();

		System.out.print("Street: ");
		String street = scanner.nextLine();

		System.out.println("Built No: ");
		int builtNo = scanner.nextInt();

		AddressManager.addAddress(account.getUser(), new BusinessAddress(province, district, road, street, builtNo));
		
	}
	public static void removeAddress(Account account,int index) {
		AddressManager.removeAddress(account.getUser(), index);
	}
	
	public static void showAccountPolicy(Account account) {
		System.out.println(account.getInsuranceList().toString());
	}
	public static void addHealthPolicy(Account account) {
		account.addPolicy(account.getInsuranceList(), new HealthInsurance(), LocalDate.now(),LocalDate.now().minusDays(6));
	}
	public static void addResidancePolicy(Account account) {
		account.addPolicy(account.getInsuranceList(), new ResidanceInsurance(), LocalDate.now(),LocalDate.now().minusDays(6));
	}
	public static void addCarPolicy(Account account) {
		account.addPolicy(account.getInsuranceList(), new CarInsurance(), LocalDate.now(),LocalDate.now().minusDays(6));
	}
	public static void addTravelPolicy(Account account) {
		account.addPolicy(account.getInsuranceList(), new TravelInsurance(), LocalDate.now(),LocalDate.now().minusDays(6));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
