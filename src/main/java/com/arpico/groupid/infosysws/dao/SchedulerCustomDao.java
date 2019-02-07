package com.arpico.groupid.infosysws.dao;

import java.util.List;

import com.arpico.groupid.infosysws.entity.InProposalsEntity;
import com.arpico.groupid.infosysws.entity.InRcptSmsLog;

public interface SchedulerCustomDao {
	
	public List<InRcptSmsLog> unsendReceiptSms()throws Exception;
	
	public List<InProposalsEntity> sixMonthOldProposals(String sbuCode)throws Exception;

}
