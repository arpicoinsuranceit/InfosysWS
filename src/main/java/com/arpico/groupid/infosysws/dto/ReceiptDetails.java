package com.arpico.groupid.infosysws.dto;

import java.util.Date;

public class ReceiptDetails {
	
	private Integer quonum;
	private String pprnum;
	private Integer polnum;
	private Double totprm;
	private Date creadt;
	private String loccod;
	public Integer getQuonum() {
		return quonum;
	}
	public void setQuonum(Integer quonum) {
		this.quonum = quonum;
	}
	public String getPprnum() {
		return pprnum;
	}
	public void setPprnum(String pprnum) {
		this.pprnum = pprnum;
	}
	public Integer getPolnum() {
		return polnum;
	}
	public void setPolnum(Integer polnum) {
		this.polnum = polnum;
	}
	public Double getTotprm() {
		return totprm;
	}
	public void setTotprm(Double totprm) {
		this.totprm = totprm;
	}
	public Date getCreadt() {
		return creadt;
	}
	public void setCreadt(Date creadt) {
		this.creadt = creadt;
	}
	
	public String getLoccod() {
		return loccod;
	}
	public void setLoccod(String loccod) {
		this.loccod = loccod;
	}
	@Override
	public String toString() {
		return "ReceiptDetails [quonum=" + quonum + ", pprnum=" + pprnum + ", polnum=" + polnum + ", totprm=" + totprm
				+ ", creadt=" + creadt + ", loccod=" + loccod + "]";
	}
	
	
	

}
