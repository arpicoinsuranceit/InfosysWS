package com.arpico.groupid.infosysws.service;

import com.arpico.groupid.infosysws.dto.ResponseDto;
import com.arpico.groupid.infosysws.dto.SMSDto;

public interface PolicySMSService {
	
	public ResponseDto getPolicySMSMessage(SMSDto smsDto)throws Exception;

}
