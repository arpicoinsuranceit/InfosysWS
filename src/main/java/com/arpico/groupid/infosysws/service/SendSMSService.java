package com.arpico.groupid.infosysws.service;

import java.util.ArrayList;
import com.arpico.groupid.infosysws.entity.InRcptSmsLog;

public interface SendSMSService {
	
	void sendSMS(String message, ArrayList<InRcptSmsLog> log, String userCode) throws Exception;

}
