package com.arpico.groupid.infosysws.dao;

import org.springframework.data.repository.CrudRepository;

import com.arpico.groupid.infosysws.entity.InRcptSmsLog;
import com.arpico.groupid.infosysws.entity.pk.InRcptSmsLogPk;

public interface InRcptSmsLogDao extends CrudRepository<InRcptSmsLog, InRcptSmsLogPk>{

}
