package com.arpico.groupid.infosysws.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arpico.groupid.infosysws.dao.SchedulerCustomDao;
import com.arpico.groupid.infosysws.dao.rowmapper.InRcptSmsLogRowMapper;
import com.arpico.groupid.infosysws.entity.InRcptSmsLog;

@Repository
public class SchedulerCustomDaoImpl implements SchedulerCustomDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<InRcptSmsLog> unsendReceiptSms() throws Exception {
		
		return jdbcTemplate.query("SELECT a.* FROM inrcptsms_log a inner join inproposals b ON a.sbucod = b.sbucod and a.pprnum = b.pprnum WHERE " + 
				"a.sbucod = '450' AND a.ppdmob IS NOT NULL AND a.smssts = 'VAL' AND (a.sndsts != 'Y' or a.sndsts is null) " + 
				"AND a.creadt >= current_date() AND (a.errmsg NOT IN('Invalid destination group','Parameter Missing','Cannot find Phone Number','no_routes')  or a.errmsg is null) " + 
				"AND b.pprsta <> 'INAC';", new InRcptSmsLogRowMapper());
		
	}

}
