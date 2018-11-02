package com.arpico.groupid.infosysws.service;

import com.arpico.groupid.infosysws.dto.EmailDto;
import com.arpico.groupid.infosysws.entity.EmailLogEntity;

public interface EmailSendService {
	
	public void sendEmail(EmailDto dto, EmailLogEntity entity) throws Exception;

}
