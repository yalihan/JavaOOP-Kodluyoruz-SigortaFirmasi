package user;

import java.time.LocalDate;
import java.util.ArrayList;
import address.IAddress;

public class User {
	String name;
	String surname;
	String email;
	String password;
	String job;
	short age;
	ArrayList<IAddress> addressList;
	LocalDate lastLogInDate;
	
	public User(String name,String surname,String email,String password,String job,short age,ArrayList<IAddress> addressList) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.job = job;
		this.age = age;
		this.addressList = addressList;
	}
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getJob() {
		return job;
	}
	public short getAge() {
		return age;
	}
	public ArrayList<IAddress> getAddressList() {
		return addressList;
	}
	public LocalDate getLastLogInDate() {
		return lastLogInDate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setAge(short age) {
		this.age = age;
	}
	public void setAddressList(ArrayList<IAddress> addressList) {
		this.addressList = addressList;
	}
	public void setLastLogInDate(LocalDate lastLogInDate) {
		this.lastLogInDate = lastLogInDate;
	}
}
