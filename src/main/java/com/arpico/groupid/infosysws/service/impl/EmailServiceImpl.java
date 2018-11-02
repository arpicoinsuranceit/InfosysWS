package com.arpico.groupid.infosysws.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpico.groupid.infosysws.dao.EmailAttachmentDao;
import com.arpico.groupid.infosysws.dao.EmailCCDao;
import com.arpico.groupid.infosysws.dao.EmailLogDao;
import com.arpico.groupid.infosysws.dto.EmailDto;
import com.arpico.groupid.infosysws.dto.ResponseDto;
import com.arpico.groupid.infosysws.entity.EmailAttachmentEntity;
import com.arpico.groupid.infosysws.entity.EmailCCEntity;
import com.arpico.groupid.infosysws.entity.EmailLogEntity;
import com.arpico.groupid.infosysws.security.JwtDecoder;
import com.arpico.groupid.infosysws.service.EmailService;
import com.arpico.groupid.infosysws.util.AppConstant;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailLogDao emailLogDao;
	
	@Autowired
	private EmailAttachmentDao emailAttachmentDao;
	
	@Autowired
	private EmailCCDao emailCCDao;
	
	@Autowired
	private JwtDecoder decoder;

	@Override
	public ResponseDto send(EmailDto emailDto) throws Exception {
		
		String userName = decoder.generate(emailDto.getToken());

		EmailLogEntity emailLogEntity = getEmailLogEntity(emailDto, userName);
		
		EmailLogEntity savedEmailLogEntity = emailLogDao.save(emailLogEntity);

		if (emailDto.getCcMails() != null && !emailDto.getCcMails().isEmpty()) {
			List<EmailCCEntity> entities = new ArrayList<>();

			emailDto.getCcMails().forEach(e -> {
				EmailCCEntity entity = new EmailCCEntity();

				entity.setCcMail(e);
				entity.setEmailLogEntity(savedEmailLogEntity);

				entities.add(entity);
			});
			
			emailCCDao.save(entities);

		}

		if (emailDto.getFilePaths() != null && !emailDto.getFilePaths().isEmpty()) {
			List<EmailAttachmentEntity> entities = new ArrayList<>();

			emailDto.getFilePaths().forEach(e -> {
				EmailAttachmentEntity entity = new EmailAttachmentEntity();

				entity.setFilePath(e);
				entity.setEmailLogEntity(savedEmailLogEntity);

				entities.add(entity);
			});

			emailAttachmentDao.save(entities);
		}

		ResponseDto responseDto = new ResponseDto();
		
		responseDto.setCode("200");
		responseDto.setMessage("Success");;
		responseDto.setStatus("OK");;
		return responseDto;
	}

	protected EmailLogEntity getEmailLogEntity(EmailDto dto, String user) {
		EmailLogEntity entity = new EmailLogEntity();
		entity.setSubject(dto.getSubject());
		entity.setBody(dto.getBody());
		entity.setTo(dto.getToMail());
		entity.setFrom(dto.getFromMail());
		entity.setStatus(AppConstant.NOT_SENT);
		entity.setCreateBy(user);
		entity.setDepartment(dto.getDepartment());
		entity.setCreateDate(new Date());
		return entity;
	}

}
