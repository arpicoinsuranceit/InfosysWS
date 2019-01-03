package com.arpico.groupid.infosysws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insmspara")
public class SMSParaEntity {

	private Integer smsParaId;
	private String sbucod;
	private String smsType;
	private String msg;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="smsparaid")
	public Integer getSmsParaId() {
		return smsParaId;
	}
	public void setSmsParaId(Integer smsParaId) {
		this.smsParaId = smsParaId;
	}
	
	@Column(name="sbucod")
	public String getSbucod() {
		return sbucod;
	}
	public void setSbucod(String sbucod) {
		this.sbucod = sbucod;
	}
	
	@Column(name="smstype")
	public String getSmsType() {
		return smsType;
	}
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
	
	@Column(name="msg")
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String toString() {
		return "SMSPara [smsParaId=" + smsParaId + ", sbucod=" + sbucod + ", smsType=" + smsType + ", msg=" + msg + "]";
	}
	
	
	
}
