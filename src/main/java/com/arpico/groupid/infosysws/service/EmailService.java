package com.arpico.groupid.infosysws.service;

import com.arpico.groupid.infosysws.dto.EmailDto;

public interface EmailService {

	String send(EmailDto emailDto) throws Exception;

}
