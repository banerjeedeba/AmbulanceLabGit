package com.labs;

public class NotificationDO implements Comparable<NotificationDO>{

	private String nPackage;
	private String nTicker;
	private String nTitle;
	private String nText;
	private long nTime;
	private String nId;
	private String nKey;
	
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
	
	public String getnId() {
		return nId;
	}
	public void setnId(String nId) {
		this.nId = nId;
	}
	public String getnKey() {
		return nKey;
	}
	public void setnKey(String nKey) {
		this.nKey = nKey;
	}
	
	public NotificationDO(String nPackage, String nTicker, String nTitle,
			String nText, long nTime, String nId, String nKey) {
		super();
		this.nPackage = nPackage;
		this.nTicker = nTicker;
		this.nTitle = nTitle;
		this.nText = nText;
		this.nTime = nTime;
		this.nId = nId;
		this.nKey = nKey;
	}
	@Override
	public int compareTo(NotificationDO notification) {
		
		return Long.compare(notification.nTime, this.nTime);
	}
	
}
