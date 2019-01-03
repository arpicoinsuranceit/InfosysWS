package com.arpico.groupid.infosysws.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arpico.groupid.infosysws.dto.ReceiptDetails;

public class ReceiptDetailsRowMapper implements RowMapper<ReceiptDetails>{

	@Override
	public ReceiptDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReceiptDetails receiptDetails=new ReceiptDetails();
		
		receiptDetails.setCreadt(rs.getDate("creadt"));
		receiptDetails.setPolnum(rs.getInt("polnum"));
		receiptDetails.setPprnum(rs.getString("pprnum"));
		receiptDetails.setQuonum(rs.getInt("quonum"));
		receiptDetails.setTotprm(rs.getDouble("totprm"));
		receiptDetails.setLoccod(rs.getString("loccod"));
		
		
		return receiptDetails;
	}

}
