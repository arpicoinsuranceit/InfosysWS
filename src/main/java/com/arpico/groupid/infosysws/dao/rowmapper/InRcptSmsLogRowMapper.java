package com.arpico.groupid.infosysws.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arpico.groupid.infosysws.entity.InRcptSmsLog;
import com.arpico.groupid.infosysws.entity.pk.InRcptSmsLogPk;

public class InRcptSmsLogRowMapper implements RowMapper<InRcptSmsLog>{
	
	@Override
	public InRcptSmsLog mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		InRcptSmsLogPk pk = new InRcptSmsLogPk();
		
		pk.setDocNum(rs.getString("docnum"));
		pk.setSbuCode(rs.getString("sbucod"));
		
		
		InRcptSmsLog inRcptSmsLog=new InRcptSmsLog();
		inRcptSmsLog.setInRcptSmsLogPk(pk);
		
		inRcptSmsLog.setCreaby(rs.getString("creaby"));
		inRcptSmsLog.setCreadt(rs.getDate("creadt"));
		inRcptSmsLog.setDoccod(rs.getString("doccod"));
		inRcptSmsLog.setErrmsg(rs.getString("errmsg"));
		inRcptSmsLog.setLoccod(rs.getString("loccod"));
		inRcptSmsLog.setLockin(rs.getDate("lockin"));
		inRcptSmsLog.setMesage(rs.getString("mesage"));
		inRcptSmsLog.setPolnum(rs.getString("polnum"));
		inRcptSmsLog.setPpdmob(rs.getString("ppdmob"));
		inRcptSmsLog.setPprnum(rs.getString("pprnum"));
		inRcptSmsLog.setQuonum(rs.getString("quonum"));
		inRcptSmsLog.setSendby(rs.getString("sendby"));
		inRcptSmsLog.setSmssts(rs.getString("smssts"));
		inRcptSmsLog.setSnddat(rs.getDate("snddat"));
		inRcptSmsLog.setSndsts(rs.getString("sndsts"));
		
		return inRcptSmsLog;
		
		
	}

}
