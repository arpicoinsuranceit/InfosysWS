package com.arpico.groupid.infosysws.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.arpico.groupid.infosysws.entity.pk.InRcptSmsLogPk;

@Entity
@Table(name="inrcptsms_log")
public class InRcptSmsLog {
	
	private InRcptSmsLogPk inRcptSmsLogPk;
	private String polnum;
	private String pprnum;
	private String quonum;
	private String mesage;
	private String sndsts;
	private String errmsg;
	private String creaby;
	private Date creadt;
	private Date lockin;
	private String ppdmob;
	private String loccod;
	private String doccod;
	private Date snddat;
	private String sendby;
	private String smssts;
	
	@EmbeddedId
	public InRcptSmsLogPk getInRcptSmsLogPk() {
		return inRcptSmsLogPk;
	}
	public void setInRcptSmsLogPk(InRcptSmsLogPk inRcptSmsLogPk) {
		this.inRcptSmsLogPk = inRcptSmsLogPk;
	}
	
	public String getPolnum() {
		return polnum;
	}
	public void setPolnum(String polnum) {
		this.polnum = polnum;
	}
	public String getPprnum() {
		return pprnum;
	}
	public void setPprnum(String pprnum) {
		this.pprnum = pprnum;
	}
	public String getQuonum() {
		return quonum;
	}
	public void setQuonum(String quonum) {
		this.quonum = quonum;
	}
	public String getMesage() {
		return mesage;
	}
	public void setMesage(String message) {
		this.mesage = message;
	}
	public String getSndsts() {
		return sndsts;
	}
	public void setSndsts(String sndsts) {
		this.sndsts = sndsts;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getCreaby() {
		return creaby;
	}
	public void setCreaby(String creaby) {
		this.creaby = creaby;
	}
	public Date getCreadt() {
		return creadt;
	}
	public void setCreadt(Date creadt) {
		this.creadt = creadt;
	}
	public Date getLockin() {
		return lockin;
	}
	public void setLockin(Date lockin) {
		this.lockin = lockin;
	}
	public String getPpdmob() {
		return ppdmob;
	}
	public void setPpdmob(String ppdmob) {
		this.ppdmob = ppdmob;
	}
	public String getLoccod() {
		return loccod;
	}
	public void setLoccod(String loccod) {
		this.loccod = loccod;
	}
	public String getDoccod() {
		return doccod;
	}
	public void setDoccod(String doccod) {
		this.doccod = doccod;
	}
	public Date getSnddat() {
		return snddat;
	}
	public void setSnddat(Date snddat) {
		this.snddat = snddat;
	}
	public String getSendby() {
		return sendby;
	}
	public void setSendby(String sendby) {
		this.sendby = sendby;
	}
	public String getSmssts() {
		return smssts;
	}
	public void setSmssts(String smssts) {
		this.smssts = smssts;
	}
	@Override
	public String toString() {
		return "InRcptSmsLog [inRcptSmsLogPk=" + inRcptSmsLogPk + ", polnum=" + polnum + ", pprnum=" + pprnum
				+ ", quonum=" + quonum + ", message=" + mesage + ", sndsts=" + sndsts + ", errmsg=" + errmsg
				+ ", creaby=" + creaby + ", creadt=" + creadt + ", lockin=" + lockin + ", ppdmob=" + ppdmob
				+ ", loccod=" + loccod + ", doccod=" + doccod + ", snddat=" + snddat + ", sendby=" + sendby
				+ ", smssts=" + smssts + "]";
	}
	
	
	

}
