package com.arpico.groupid.infosysws.security;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtDecoder {
	public String generate(String token) throws JsonParseException, JsonMappingException, IOException {

		Jwt jwtToken = JwtHelper.decode(token);
		String claims = jwtToken.getClaims();
		HashMap claimsMap = new ObjectMapper().readValue(claims, HashMap.class);
		return claimsMap.get("userId").toString();

	}
}
