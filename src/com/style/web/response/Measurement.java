package com.style.web.response;

public class Measurement {

	private int profileid;
	private String neck;
	private String sleeve;
	private String chest;
	private String waist;
	private String shoe;
	private String inseam;
	private String jacket;
	private String shirt;
	private String weight;
	private String height;
	
	public int getProfileid() {
		return profileid;
	}

	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	public String getNeck() {
		return neck;
	}

	public void setNeck(String neck) {
		this.neck = neck;
	}

	public String getSleeve() {
		return sleeve;
	}

	public void setSleeve(String sleeve) {
		this.sleeve = sleeve;
	}

	public String getChest() {
		return chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}

	public String getWaist() {
		return waist;
	}

	public void setWaist(String waist) {
		this.waist = waist;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getShoe() {
		return shoe;
	}

	public void setShoe(String shoe) {
		this.shoe = shoe;
	}

	public String getInseam() {
		return inseam;
	}

	public void setInseam(String inseam) {
		this.inseam = inseam;
	}

	public String getJacket() {
		return jacket;
	}

	public void setJacket(String jacket) {
		this.jacket = jacket;
	}

	public String getShirt() {
		return shirt;
	}

	public void setShirt(String shirt) {
		this.shirt = shirt;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Measurement(int profileid, String neck, String sleeve, String chest, String waist, String shoe,
			String inseam, String jacket, String shirt, String weight, String height) {
		super();
		this.profileid = profileid;
		this.neck = neck;
		this.sleeve = sleeve;
		this.chest = chest;
		this.waist = waist;
		this.shoe = shoe;
		this.inseam = inseam;
		this.jacket = jacket;
		this.shirt = shirt;
		this.weight = weight;
		this.height = height;
	}

	public Measurement() {
	}

}
