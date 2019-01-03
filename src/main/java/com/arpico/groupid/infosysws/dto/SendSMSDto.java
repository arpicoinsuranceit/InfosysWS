package com.arpico.groupid.infosysws.dto;

import java.util.ArrayList;

public class SendSMSDto {
	
	private String message;
	private ArrayList<String> mobileList;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<String> getMobileList() {
		return mobileList;
	}
	public void setMobileList(ArrayList<String> mobileList) {
		this.mobileList = mobileList;
	}
	@Override
	public String toString() {
		return "SendSMSDto [message=" + message + ", mobileList=" + mobileList + "]";
	}
	
	

}
