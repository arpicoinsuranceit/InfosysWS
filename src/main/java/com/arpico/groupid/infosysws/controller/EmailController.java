package com.arpico.groupid.infosysws.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arpico.groupid.infosysws.dto.EmailDto;

@RestController()
@CrossOrigin(origins = "*")
public class EmailController {

	public ResponseEntity<Object> sendMail(@RequestBody EmailDto emailDto) throws Exception{
		
		return null;
	}
}
