package com.arpico.groupid.infosysws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arpico.groupid.infosysws.dao.SchedulerCustomDao;
import com.arpico.groupid.infosysws.dto.ResponseDto;
import com.arpico.groupid.infosysws.dto.SMSDto;
import com.arpico.groupid.infosysws.entity.InRcptSmsLog;
import com.arpico.groupid.infosysws.service.PolicySMSService;
import com.arpico.groupid.infosysws.service.ProposalSMSService;
import com.arpico.groupid.infosysws.service.QuotationSMSService;
import com.arpico.groupid.infosysws.service.UnSendSMSService;

@RestController
@CrossOrigin(origins = "*")
public class SMSController {
	
	@Autowired
	private ProposalSMSService proposalSMSService;
	
	@Autowired
	private PolicySMSService policySMSService;
	
	@Autowired
	private QuotationSMSService quotationSMSService;
	
	@Autowired
	private SchedulerCustomDao schedulerCustomDao;
	
	@Autowired
	private UnSendSMSService unSendSMSService;
	
	@PostMapping("/sendSMS")
	public ResponseEntity<Object> sendSMS(@RequestBody SMSDto smsDto){
		System.out.println(smsDto);
		
		ResponseDto msg = null;
		
		switch (smsDto.getSmsType()) {
			case "proposal":
				try {
					msg= proposalSMSService.getProposalSMSMessage(smsDto);
				} catch (Exception e) {
					msg = new ResponseDto();
					msg.setCode("500");
					msg.setMessage("Internal Server Error");;
					msg.setCode("Error");
					
					e.printStackTrace();
				}
				
				break;
			case "quotation":
				try {
					msg= quotationSMSService.getQuotationSMSMessage(smsDto);
				} catch (Exception e) {
					msg = new ResponseDto();
					msg.setCode("500");
					msg.setMessage("Internal Server Error");;
					msg.setCode("Error");
					
					e.printStackTrace();
				}
				
				break;
			case "policy":
				try {
					msg= policySMSService.getPolicySMSMessage(smsDto);
				} catch (Exception e) {
					msg = new ResponseDto();
					msg.setCode("500");
					msg.setMessage("Internal Server Error");;
					msg.setCode("Error");
					
					e.printStackTrace();
				}
				
				break;
	
			default:
				break;
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/unSendReceiptSMS", method = RequestMethod.GET)
	public void unsendReceiptSMSSend(){
		System.out.println(" called unsend");
		try {
			unSendSMSService.unsendReceiptSMS();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
