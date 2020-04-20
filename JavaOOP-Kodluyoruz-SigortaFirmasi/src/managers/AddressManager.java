package managers;

import java.util.ArrayList;
import address.IAddress;
import user.User;

public class AddressManager {
	
	public static void addAddress(User user,IAddress addressType) {
		if(user.getAddressList()==null) {
			ArrayList<IAddress> addressList = new ArrayList<IAddress>();
			addressList.add(addressType);
			user.setAddressList(addressList);
		}else {
			if(isAddressExist(user,addressType)) {
				System.out.println("This address already exist!");
			}
			else {
				user.getAddressList().add(addressType);
			}
		}
	}
	
	public static void removeAddress(User user,int index) {
		user.getAddressList().remove(index);
	}
	
	
	private static boolean isAddressExist(User user,IAddress addressType) {
		ArrayList<IAddress> addressList  = user.getAddressList();
		for(IAddress address : addressList) {
			if(address.getProvince().equals(addressType.getProvince()) && address.getDistrict().equals(addressType.getDistrict())
				&& address.getRoad().equals(addressType.getRoad()) && address.getStreet().equals(addressType.getStreet())
				&& address.getBuiltNo() == addressType.getBuiltNo()) {
				return true;
			}
		}
		return false;
	}
	

}
