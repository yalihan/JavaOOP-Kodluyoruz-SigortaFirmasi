package address.impl;

import address.IAddress;

public class HomeAddress implements IAddress {
	
	String province;
	String district;
	String road;
	String street;
	int builtNo;
	
	public HomeAddress(String province, String district, String road, String street, int builtNo) {
		this.province = province;
		this.district = district;
		this.road = road;
		this.street = street;
		this.builtNo = builtNo;
	}

	public String getProvince() {
		return province;
	}
	public String getDistrict() {
		return district;
	}
	public String getRoad() {
		return road;
	}
	public String getStreet() {
		return street;
	}
	public int getBuiltNo() {
		return builtNo;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setBuiltNo(int builtNo) {
		this.builtNo = builtNo;
	}
	
	@Override
	public String toString() {
		return "HomeAddress :\n[province=" + province + ", district=" + district + ", road=" + road + ", street=" + street
				+ ", builtNo=" + builtNo + "]";
	}
}
