package com.arpico.groupid.infosysws.entity.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InRcptSmsLogPk implements Serializable{
	
	private String sbuCode;
	private String docNum;
	
	@Column(name="sbucod")
	public String getSbuCode() {
		return sbuCode;
	}
	public void setSbuCode(String sbuCode) {
		this.sbuCode = sbuCode;
	}
	
	@Column(name="docnum")
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	
	@Override
	public String toString() {
		return "InRcptSmsLogPk [sbuCode=" + sbuCode + ", docNum=" + docNum + "]";
	}
	
	

}
