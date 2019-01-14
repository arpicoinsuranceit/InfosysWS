package com.arpico.groupid.infosysws.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arpico.groupid.infosysws.dao.InBillingTransactionCustomDao;
import com.arpico.groupid.infosysws.dao.InProposalCustomDao;
import com.arpico.groupid.infosysws.dao.InRcptSmsLogDao;
import com.arpico.groupid.infosysws.dao.ReceiptDetailsCustomDao;
import com.arpico.groupid.infosysws.dao.SMSParaDao;
import com.arpico.groupid.infosysws.dto.ReceiptDetails;
import com.arpico.groupid.infosysws.dto.ResponseDto;
import com.arpico.groupid.infosysws.dto.SMSDto;
import com.arpico.groupid.infosysws.dto.SendSMSDto;
import com.arpico.groupid.infosysws.entity.InRcptSmsLog;
import com.arpico.groupid.infosysws.entity.SMSParaEntity;
import com.arpico.groupid.infosysws.entity.pk.InRcptSmsLogPk;
import com.arpico.groupid.infosysws.service.ProposalSMSService;
import com.arpico.groupid.infosysws.service.QuotationSMSService;
import com.arpico.groupid.infosysws.service.SendSMSService;

@Service
@Transactional
public class QuotationSMSServiceImpl implements QuotationSMSService{
	
	@Autowired
	private SMSParaDao smsParaDao;
	
	@Autowired
	private ReceiptDetailsCustomDao receiptDetailsCustomDao;
	
	@Autowired
	private InProposalCustomDao inProposalCustomDao;
	
	@Autowired
	private SendSMSService sendSmsService;
	
	@Autowired
	private InRcptSmsLogDao inRcptSmsLogDao;
	
	@Autowired
	private InBillingTransactionCustomDao inBillingTransactionCustomDao;

	@Override
	public ResponseDto getQuotationSMSMessage(SMSDto smsDto) throws Exception {
		ResponseDto resp = new ResponseDto();
		
		ReceiptDetails receiptDetails=receiptDetailsCustomDao.getReceiptDetailsFromInTransaction(smsDto.getDocCode(),smsDto.getRcptNo());
		
		if(receiptDetails != null) {
			SMSParaEntity smsParaEntity=smsParaDao.findBySmsType(smsDto.getSmsType());
			
			String message=smsParaEntity.getMsg();
			
			String replaceString=message.replaceAll("#amount#", Double.toString(receiptDetails.getTotprm().intValue()));
			replaceString=replaceString.replaceAll("#quonum#", Integer.toString(receiptDetails.getQuonum()));
			replaceString=replaceString.replaceAll("#propnum#", receiptDetails.getPprnum());
			replaceString=replaceString.replaceAll("#date#", new SimpleDateFormat("dd-MM-yyyy").format(receiptDetails.getCreadt()));
			
			Double payableAmount=inBillingTransactionCustomDao.paybleAmountThisMonth(Integer.parseInt(receiptDetails.getPprnum()));
			
			if(payableAmount > 0) {
				replaceString=replaceString.replaceAll("#premiumshort#", "Rs."+payableAmount+" Premium Short");
			}else {
				replaceString=replaceString.replaceAll("#premiumshort#", "");
			}
			
			String customerMob=inProposalCustomDao.getCustomerMobile(receiptDetails.getPprnum());
			
			InRcptSmsLog inRcptSmsLog=new InRcptSmsLog();
			
			InRcptSmsLogPk inRcptSmsLogPk=new InRcptSmsLogPk();
			inRcptSmsLogPk.setDocNum(smsDto.getRcptNo());
			inRcptSmsLogPk.setSbuCode("450");
			
			inRcptSmsLog.setInRcptSmsLogPk(inRcptSmsLogPk);
			inRcptSmsLog.setCreadt(new Date());
			inRcptSmsLog.setCreaby(smsDto.getUserCode());
			inRcptSmsLog.setDoccod(smsDto.getDocCode());
			inRcptSmsLog.setLoccod(receiptDetails.getLoccod());
			inRcptSmsLog.setLockin(new Date());
			inRcptSmsLog.setMesage(replaceString);
			inRcptSmsLog.setSndsts("N");
			
			String polnum=Integer.toString(receiptDetails.getPolnum());
			
			inRcptSmsLog.setPolnum(polnum.equals("0")? null:polnum);
			inRcptSmsLog.setPprnum(receiptDetails.getPprnum());
			inRcptSmsLog.setQuonum(Integer.toString(receiptDetails.getQuonum()));
			inRcptSmsLog.setSmssts("VAL");
			inRcptSmsLog.setPpdmob(customerMob);
			
			InRcptSmsLog inRcptSmsLog2=inRcptSmsLogDao.save(inRcptSmsLog);
			ArrayList<InRcptSmsLog> rcptSmsLogs=new ArrayList<>();
			rcptSmsLogs.add(inRcptSmsLog2);

			sendSmsService.sendSMS(replaceString,rcptSmsLogs,smsDto.getUserCode());
			
			resp.setCode("200");
			resp.setMessage("Success");
			resp.setStatus("OK");
			
			return resp;
			
			
		}
		
		resp.setCode("204");
		resp.setMessage("Receipt Not Found");
		resp.setStatus("OK");
		
		return resp;
	}

}
