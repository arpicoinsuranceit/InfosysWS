package com.arpico.groupid.infosysws.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.arpico.groupid.infosysws.dto.EmailDto;
import com.arpico.groupid.infosysws.service.EmailService;

@Service
@Transactional
public class EmailServiceImpl implements EmailService{

	@Override
	public String send(EmailDto emailDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
