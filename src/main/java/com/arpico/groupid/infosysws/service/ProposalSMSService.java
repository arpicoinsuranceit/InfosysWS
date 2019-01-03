package com.arpico.groupid.infosysws.service;

import org.springframework.http.ResponseEntity;

import com.arpico.groupid.infosysws.dto.ResponseDto;
import com.arpico.groupid.infosysws.dto.SMSDto;

public interface ProposalSMSService {
	
	public ResponseDto getProposalSMSMessage(SMSDto smsDto)throws Exception;

}
