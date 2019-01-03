package com.arpico.groupid.infosysws.dao;

import com.arpico.groupid.infosysws.dto.ReceiptDetails;

public interface ReceiptDetailsCustomDao {
	
	public ReceiptDetails getReceiptDetailsFromInTransaction(String doccode,String docnum)throws Exception;

}
