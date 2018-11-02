package com.arpico.groupid.infosysws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arpico.groupid.infosysws.dto.EmailDto;
import com.arpico.groupid.infosysws.dto.ResponseDto;
import com.arpico.groupid.infosysws.service.EmailService;

@RestController()
@CrossOrigin(origins = "*")
public class EmailController {

	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<Object> sendMail(@RequestBody EmailDto emailDto) throws Exception{
		
		ResponseDto msg = null;
		
		try{
			msg = emailService.send(emailDto);
		} catch (Exception e) {
			msg = new ResponseDto();
			msg.setCode("500");
			msg.setMessage("Internal Server Error");;
			msg.setCode("Error");
			
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
		
	}
}
