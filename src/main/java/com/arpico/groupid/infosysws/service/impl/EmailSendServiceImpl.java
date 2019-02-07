package com.arpico.groupid.infosysws.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.arpico.groupid.infosysws.dao.EmailLogDao;
import com.arpico.groupid.infosysws.dto.EmailDto;
import com.arpico.groupid.infosysws.entity.EmailLogEntity;
import com.arpico.groupid.infosysws.service.EmailSendService;
import com.arpico.groupid.infosysws.util.AppConstant;
import com.arpico.groupid.infosysws.util.Email;

@Service
@Transactional
public class EmailSendServiceImpl implements EmailSendService {

	@Autowired
	private EmailLogDao emailLogDao;

	@Override
	public void sendEmail(EmailDto dto, EmailLogEntity entity) throws Exception {
		try {
			sendEmail(dto);
			entity.setStatus(AppConstant.SENT);
			emailLogDao.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendEmail(EmailDto dto) throws AddressException, MessagingException, IllegalStateException, IOException {
		
		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", Email.HOST);
		props.put("mail.smtp.port", Email.PORT);

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Email.getMail(dto.getDepartment()),
								Email.getPassword(dto.getDepartment()));
					}

				});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(dto.getFromMail()));

		message.setRecipients(Message.RecipientType.TO,

				InternetAddress.parse(dto.getToMail()));
		
		String cc = "";
		
		for(String s : dto.getCcMails()) {
			cc += s+",";
		}
		
		cc= cc.substring(0, cc.length()-1);

		message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));

		message.setSubject(dto.getSubject());
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(dto.getBody());

//		if(dto.getBodyContentType() !=  null) {
//			 messageBodyPart.setContent(dto.getBody(), "text/html");
//		}else {
//			messageBodyPart.setText(dto.getBody());
//		}

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		for (MultipartFile i : dto.getAttachments()) {

			File convFile = new File( i.getOriginalFilename());
		    i.transferTo(convFile);
			
			DataSource source = new FileDataSource(new File(convFile.getName()));

			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(i.getName());

			multipart.addBodyPart(messageBodyPart);
		}

		message.setContent(multipart);

		Transport.send(message);
	}

}
