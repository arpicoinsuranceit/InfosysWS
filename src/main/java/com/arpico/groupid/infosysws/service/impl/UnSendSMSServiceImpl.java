package com.arpico.groupid.infosysws.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.arpico.groupid.infosysws.dao.SchedulerCustomDao;
import com.arpico.groupid.infosysws.entity.InRcptSmsLog;
import com.arpico.groupid.infosysws.service.SendSMSService;
import com.arpico.groupid.infosysws.service.UnSendSMSService;

@Service
@Transactional
public class UnSendSMSServiceImpl implements UnSendSMSService{
	
	@Autowired
	private SchedulerCustomDao schedulerCustomDao;
	
	@Autowired
	private SendSMSService sendSmsService;

	@Override
	public void unsendReceiptSMS() throws Exception {
		List<InRcptSmsLog> inRcptSmsLogs=schedulerCustomDao.unsendReceiptSms();
		
		System.out.println(inRcptSmsLogs.size());
		
		if(inRcptSmsLogs != null) {
			inRcptSmsLogs.forEach(i ->{
				ArrayList<InRcptSmsLog> list=new ArrayList<>();
				list.add(i);
				
				try {
					sendSmsService.sendSMS(i.getMesage(),list,"system");
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}

	

}
