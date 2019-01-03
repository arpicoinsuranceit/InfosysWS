package com.arpico.groupid.infosysws.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INEMAIL_LOG_CC")
public class EmailCCEntity {

	private Integer id;
	private String ccMail;
	private EmailLogEntity emailLogEntity;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMLCID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "EML_CC")
	public String getCcMail() {
		return ccMail;
	}
	
	public void setCcMail(String ccMail) {
		this.ccMail = ccMail;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EML_ID", nullable = false)
	public EmailLogEntity getEmailLogEntity() {
		return emailLogEntity;
	}

	public void setEmailLogEntity(EmailLogEntity emailLogEntity) {
		this.emailLogEntity = emailLogEntity;
	}

	@Override
	public String toString() {
		return "EmailCCEntity [id=" + id + ", ccMail=" + ccMail + ", emailLogEntity=" + emailLogEntity + "]";
	}

}
