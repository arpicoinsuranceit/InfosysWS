package com.arpico.groupid.infosysws.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupid.infosysws.entity.InRcptSmsLog;
import com.arpico.groupid.infosysws.entity.pk.InRcptSmsLogPk;

public interface InRcptSmsLogDao extends CrudRepository<InRcptSmsLog, InRcptSmsLogPk>{
	
	public List<InRcptSmsLog> findBySndstsAndCreadtGreaterThan(String sndsts,Date creadt)throws Exception;

}
