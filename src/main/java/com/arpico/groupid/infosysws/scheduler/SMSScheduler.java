package com.arpico.groupid.infosysws.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.arpico.groupid.infosysws.dao.InRcptSmsLogDao;
import com.arpico.groupid.infosysws.entity.InRcptSmsLog;
import com.arpico.groupid.infosysws.service.SendSMSService;

@Component
public class SMSScheduler {
	
	@Autowired
	private InRcptSmsLogDao inRcptSmsLogDao;
	
	@Autowired
	private SendSMSService sendSmsService;
	
	
	//run 8 pm every day unsend receipt SMS	
	@Scheduled(cron="0 0 20 * * *")
	public void smsSchedule() {
		
		try {
			
			List<InRcptSmsLog> inRcptSmsLogs=inRcptSmsLogDao.findBySndsts("N");
			
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Method executed at every 10 seconds. Current time is :: "+ new Date());
	}

}
