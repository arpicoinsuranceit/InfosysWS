package com.arpico.groupid.infosysws.service;

import com.arpico.groupid.infosysws.dto.ResponseDto;
import com.arpico.groupid.infosysws.dto.SMSDto;

public interface QuotationSMSService {
	
	public ResponseDto getQuotationSMSMessage(SMSDto smsDto)throws Exception;

}
