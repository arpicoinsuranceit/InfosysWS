package com.arpico.groupid.infosysws.dto;

public class SMSMessageHelperDto {
	
	private Double amount;
	private String polnum;
	private String propnum;
	private String quonum;
	private String date;
	private String premiumshort;
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPolnum() {
		return polnum;
	}
	public void setPolnum(String polnum) {
		this.polnum = polnum;
	}
	public String getPropnum() {
		return propnum;
	}
	public void setPropnum(String propnum) {
		this.propnum = propnum;
	}
	public String getQuonum() {
		return quonum;
	}
	public void setQuonum(String quonum) {
		this.quonum = quonum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPremiumshort() {
		return premiumshort;
	}
	public void setPremiumshort(String premiumshort) {
		this.premiumshort = premiumshort;
	}
	@Override
	public String toString() {
		return "SMSMessageHelperDto [amount=" + amount + ", polnum=" + polnum + ", propnum=" + propnum + ", quonum="
				+ quonum + ", date=" + date + ", premiumshort=" + premiumshort + "]";
	}
	
	

}
