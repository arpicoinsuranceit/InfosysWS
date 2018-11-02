package com.arpico.groupid.infosysws.service;

import com.arpico.groupid.infosysws.dto.EmailDto;
import com.arpico.groupid.infosysws.dto.ResponseDto;

public interface EmailService {

	ResponseDto send(EmailDto emailDto) throws Exception;

}
