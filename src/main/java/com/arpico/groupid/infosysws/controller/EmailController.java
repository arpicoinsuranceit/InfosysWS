package com.arpico.groupid.infosysws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arpico.groupid.infosysws.dto.EmailDto;
import com.arpico.groupid.infosysws.service.EmailService;

@RestController()
@CrossOrigin(origins = "*")
public class EmailController {

	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<Object> sendMail(@RequestBody EmailDto emailDto) throws Exception{
		
		String msg = emailService.send(emailDto);
		
		return null;
		
	}
}
