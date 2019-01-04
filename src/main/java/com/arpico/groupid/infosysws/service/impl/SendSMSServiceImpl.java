package com.arpico.groupid.infosysws.service.impl;


import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.arpico.groupid.infosysws.dao.InRcptSmsLogDao;
import com.arpico.groupid.infosysws.entity.InRcptSmsLog;
import com.arpico.groupid.infosysws.service.SendSMSService;
import com.arpico.groupid.infosysws.util.AppConstant;

@Service
@Transactional
@PropertySource("classpath:insurance.properties")
public class SendSMSServiceImpl implements SendSMSService{
	
	@Value( "${dialog_sms_gateway_password}" )
	private String password;
	
	@Autowired
	private InRcptSmsLogDao inRcptSmsLogDao;

	@Override
	public void sendSMS(String message,ArrayList<InRcptSmsLog> log,String userCode) throws Exception {
	
		new Thread() {
			public void run() {
				for (InRcptSmsLog inRcptSmsLog : log) {
					
					MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
					map.add("destination", inRcptSmsLog.getPpdmob());
					map.add("q", password);
					map.add("message", message);
	
					try {
						RestTemplate restTemplate = new RestTemplate();
						String result = restTemplate.postForObject(AppConstant.SEND_SMS, map,
								String.class);
						System.out.println(result);
						
						if(result == "0") {
							inRcptSmsLog.setSendby(userCode);
							inRcptSmsLog.setSnddat(new Date());
							inRcptSmsLog.setSmssts("Y");
							inRcptSmsLog.setErrmsg(result);
							
							inRcptSmsLogDao.save(inRcptSmsLog);
							
						}else {
							inRcptSmsLog.setSmssts("N");
							inRcptSmsLog.setErrmsg(result);
							
							inRcptSmsLogDao.save(inRcptSmsLog);
						}
						
						Thread.sleep(10000);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}.start();
		
	}

}
