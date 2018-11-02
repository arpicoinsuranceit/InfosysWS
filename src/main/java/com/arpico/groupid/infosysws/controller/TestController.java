package com.arpico.groupid.infosysws.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

	@RequestMapping("/test")
	public String test (){
		
		System.out.println("called");
		return "works";
	}
}
