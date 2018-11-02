package com.arpico.groupid.infosysws.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class EmailDto {

	private String token;
	private String toMail;
	private String fromMail;
	private String subject;
	private String body;
	private List<String> ccMails;
	private List<String> filePaths;
	private List<MultipartFile> attachments;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getFromMail() {
		return fromMail;
	}

	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getFilePaths() {
		return filePaths;
	}

	public void setFilePaths(List<String> filePaths) {
		this.filePaths = filePaths;
	}

	public List<String> getCcMails() {
		return ccMails;
	}

	public void setCcMails(List<String> ccMails) {
		this.ccMails = ccMails;
	}

	public List<MultipartFile> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<MultipartFile> attachments) {
		this.attachments = attachments;
	}

	@Override
	public String toString() {
		return "EmailDto [token=" + token + ", toMail=" + toMail + ", fromMail=" + fromMail + ", subject=" + subject
				+ ", body=" + body + ", ccMails=" + ccMails + ", attachments=" + attachments + "]";
	}

}
