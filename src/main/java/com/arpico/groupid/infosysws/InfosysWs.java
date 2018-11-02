package com.arpico.groupid.infosysws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class InfosysWs extends SpringBootServletInitializer {
	
	public static void main (String args[]) {
		SpringApplication.run(InfosysWs.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(InfosysWs.class);
	}
}
