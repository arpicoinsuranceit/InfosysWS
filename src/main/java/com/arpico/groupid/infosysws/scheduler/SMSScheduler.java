package com.arpico.groupid.infosysws.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.arpico.groupid.infosysws.dao.SchedulerCustomDao;
import com.arpico.groupid.infosysws.entity.InRcptSmsLog;
import com.arpico.groupid.infosysws.service.SendSMSService;

@Component
public class SMSScheduler {
	
	@Autowired
	private SchedulerCustomDao schedulerCustomDao;
	
	@Autowired
	private SendSMSService sendSmsService;
	
	
	//run 8 pm every day unsend receipt SMS	(0 0 20 * * *) 
	@Scheduled(cron="0 0 20 * * *")
	public void smsSchedule() {
		
		try {
			
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Method executed at everyday 8 pm. Current time is :: "+ new Date());
	}

}