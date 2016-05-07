package com.labs;

public class CustomerDO {

	private String longitude;
	private String latitude;
	private String name;
	private long mobileNo;
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public CustomerDO(String longitude, String latitude, String name,
			long mobileNo) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.mobileNo = mobileNo;
	}
	
	
}
