package com.labs;

public class NotificationDO implements Comparable<NotificationDO>{

	private String nPackage;
	private String nTicker;
	private String nTitle;
	private String nText;
	private long nTime;
	
	public String getnPackage() {
		return nPackage;
	}
	public void setnPackage(String nPackage) {
		this.nPackage = nPackage;
	}
	public String getnTicker() {
		return nTicker;
	}
	public void setnTicker(String nTicker) {
		this.nTicker = nTicker;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnText() {
		return nText;
	}
	public void setnText(String nText) {
		this.nText = nText;
	}
	public long getnTime() {
		return nTime;
	}
	public void setnTime(long nTime) {
		this.nTime = nTime;
	}
	public NotificationDO(String nPackage, String nTicker, String nTitle,
			String nText, long nTime) {
		super();
		this.nPackage = nPackage;
		this.nTicker = nTicker;
		this.nTitle = nTitle;
		this.nText = nText;
		this.nTime = nTime;
	}
	@Override
	public int compareTo(NotificationDO notification) {
		
		return Long.compare(notification.nTime, this.nTime);
	}
	
}
