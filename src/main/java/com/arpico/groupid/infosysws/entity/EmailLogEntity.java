package com.arpico.groupid.infosysws.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMAIL_LOG")
public class EmailLogEntity {

	private Integer id;
	private String from;
	private String to;
	private String body;
	private String subject;
	private String status;
	private String department;
	private String createBy;
	private Date createDate;
	private String modifyBy;
	private Date modifyDate;

	private List<EmailCCEntity> ccEntities;
	private List<EmailAttachmentEntity> attachmentEntities;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EML_ID", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "EMLFRM", nullable = false)
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Column(name = "EML_TO", nullable = false)
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Column(name = "EMLBDY")
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Column(name = "EMLSUB")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "EMLSTA")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "EMLDEP", nullable = false)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "CRETBY", nullable = false)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "CREDAT", nullable = false)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "MOD_BY")
	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	@Column(name = "MODDAT")
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@OneToMany(mappedBy = "emailLogEntity", targetEntity = EmailCCEntity.class)
	public List<EmailCCEntity> getCcEntities() {
		return ccEntities;
	}

	public void setCcEntities(List<EmailCCEntity> ccEntities) {
		this.ccEntities = ccEntities;
	}

	@OneToMany(mappedBy = "emailLogEntity", targetEntity = EmailAttachmentEntity.class)
	public List<EmailAttachmentEntity> getAttachmentEntities() {
		return attachmentEntities;
	}

	public void setAttachmentEntities(List<EmailAttachmentEntity> attachmentEntities) {
		this.attachmentEntities = attachmentEntities;
	}

	@Override
	public String toString() {
		return "EmailLogEntity [id=" + id + ", from=" + from + ", to=" + to + ", body=" + body + ", subject=" + subject
				+ ", status=" + status + ", createBy=" + createBy + ", createDate=" + createDate + ", modifyBy="
				+ modifyBy + ", modifyDate=" + modifyDate + ", ccEntities=" + ccEntities + ", attachmentEntities="
				+ attachmentEntities + "]";
	}

}
