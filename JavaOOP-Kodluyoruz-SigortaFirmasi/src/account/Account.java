package account;

import java.time.LocalDate;
import java.util.ArrayList;

import Enum.AuthenticationStatus;
import address.IAddress;
import exception.InvalidAuthenticationException;
import insurance.Insurance;
import managers.AddressManager;
import user.User;

public abstract class Account implements Comparable<Account> {
	protected User user;
	protected ArrayList<Insurance> insuranceList = new ArrayList<Insurance>();
	protected AuthenticationStatus authenticationStatus;
	
	public Account(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	public ArrayList<Insurance> getInsuranceList() {
		return insuranceList;
	}
	public AuthenticationStatus getAuthenticationStatus() {
		return authenticationStatus;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public void setInsuranceList(ArrayList<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}
	public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
		this.authenticationStatus = authenticationStatus;
	}
	
	public void addAddress(IAddress addressType) {
		AddressManager.addAddress(user, addressType);
	}
	public void removeAddress(IAddress addressType,int index) {
		AddressManager.removeAddress(user, index);
	}

	public abstract void addPolicy(ArrayList<Insurance> insuranceList,Insurance insurance,LocalDate beginDate,LocalDate finishDate);
	
	public boolean logIn(Account account,String email , String password) throws InvalidAuthenticationException {
		if(account.getUser() != null) {
			if(account.getUser().getEmail().equals(email) && account.getUser().getPassword().equals(password)) {
				authenticationStatus = AuthenticationStatus.SUCCESS;
				System.out.println(authenticationStatus.getStatus());
			}else {
				authenticationStatus = AuthenticationStatus.FAIL;
			}
		}else {
			authenticationStatus = AuthenticationStatus.FAIL;
			throw new InvalidAuthenticationException("User Null!");
		}
		return authenticationStatus.getCode();
	}

	
	public void showUserInfo() {
		StringBuilder builder = new StringBuilder();

		builder.append(user.getName());
		builder.append(" ");
		builder.append(user.getSurname());
		builder.append("\n\nEmail: ");
		builder.append(user.getEmail());
		builder.append("\nPassword: ");
		builder.append(user.getPassword());
		builder.append("\nJob: ");
		builder.append(user.getJob());
		builder.append("\nYas: ");
		builder.append(user.getAge());
		for(IAddress address : user.getAddressList()) {
			builder.append("\n");
			builder.append(address);
		}
		builder.append(getInsuranceList().toString());
		
		System.out.println(builder);
	}
	
	
	@Override
	public String toString() {
		return "Account [ User=" + user.getName() + ", insuranceList=" + insuranceList + ", authenticationStatus="
				+ authenticationStatus + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authenticationStatus == null) ? 0 : authenticationStatus.hashCode());
		result = prime * result + ((insuranceList == null) ? 0 : insuranceList.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (authenticationStatus != other.authenticationStatus)
			return false;
		if (insuranceList == null) {
			if (other.insuranceList != null)
				return false;
		} else if (!insuranceList.equals(other.insuranceList))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
