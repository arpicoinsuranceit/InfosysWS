package com.arpico.groupid.infosysws.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arpico.groupid.infosysws.dao.SchedulerCustomDao;
import com.arpico.groupid.infosysws.dao.rowmapper.InProposalsRowMapper;
import com.arpico.groupid.infosysws.dao.rowmapper.InRcptSmsLogRowMapper;
import com.arpico.groupid.infosysws.entity.InProposalsEntity;
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

	@Override
	public List<InProposalsEntity> sixMonthOldProposals(String sbuCode) throws Exception {
		
		String sql = "select * from inproposals "
                + "where sbucod='" + sbuCode + "' and pprsta<>'INAC' and (polnum='' or polnum is null) "
                + "and creadt between DATE_SUB(date_format(now(),'%Y-%m-%d 00:00:00'), INTERVAL 6 MONTH) and DATE_SUB(date_format(now(),'%Y-%m-%d 23:59:59'), INTERVAL 6 MONTH)";
		
		return jdbcTemplate.query(sql, new InProposalsRowMapper());
	}

}
