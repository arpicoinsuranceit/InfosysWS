package com.arpico.groupid.infosysws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arpico.groupid.infosysws.dao.ReceiptDetailsCustomDao;
import com.arpico.groupid.infosysws.dao.rowmapper.ReceiptDetailsRowMapper;
import com.arpico.groupid.infosysws.dto.ReceiptDetails;

@Repository
public class ReceiptDetailsCustomDaoImpl implements ReceiptDetailsCustomDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ReceiptDetails getReceiptDetailsFromInTransaction(String doccode, String docnum) throws Exception {
		
		return jdbcTemplate
				.queryForObject("select creadt, pprnum, polnum,quonum, totprm,loccod from intransactions "
						+ "where sbucod='450' and  doccod = '" + doccode + "' and docnum  = '" + docnum + "' order by creadt desc limit 1", new ReceiptDetailsRowMapper());
		
	}

}
