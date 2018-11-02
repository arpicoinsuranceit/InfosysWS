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

@Table(name = "EMAIL_ATTACHMENT")
@Entity
public class EmailAttachmentEntity {

	private Integer id;
	private String filePath;
	private EmailLogEntity emailLogEntity;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ATT_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ATTPAT")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
		return "EmailAttachmentEntity [id=" + id + ", filePath=" + filePath + ", emailLogEntity=" + emailLogEntity
				+ "]";
	}
}
