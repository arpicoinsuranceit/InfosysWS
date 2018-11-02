package com.arpico.groupid.infosysws.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpico.groupid.infosysws.dao.EmailLogDao;
import com.arpico.groupid.infosysws.dto.EmailDto;
import com.arpico.groupid.infosysws.entity.EmailLogEntity;
import com.arpico.groupid.infosysws.service.EmailSendService;
import com.arpico.groupid.infosysws.util.AppConstant;

@Service
@Transactional
public class EmailSendServiceImpl implements EmailSendService{
	
	@Autowired
	private EmailLogDao emailLogDao;

	@Override
	public void sendEmail(EmailDto dto, EmailLogEntity entity) throws Exception {
		try {
			sendEmail(dto);
			entity.setStatus(AppConstant.SENT);
			emailLogDao.save(entity);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendEmail(EmailDto dto) {
		// TODO Auto-generated method stub
		
	}

}
