package com.arpico.groupid.infosysws.dao;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupid.infosysws.entity.SMSParaEntity;

public interface SMSParaDao extends CrudRepository<SMSParaEntity, Integer>{
	
	public SMSParaEntity findBySmsType(String smsType)throws Exception;

}
