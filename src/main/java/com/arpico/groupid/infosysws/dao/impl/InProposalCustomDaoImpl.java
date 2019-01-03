package com.arpico.groupid.infosysws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arpico.groupid.infosysws.dao.InProposalCustomDao;

@Repository
public class InProposalCustomDaoImpl implements InProposalCustomDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String getCustomerMobile(String propNum) throws Exception {
		
		return jdbcTemplate.queryForObject("select ppdmob from inproposals "
				+ "where sbucod = '450' and pprnum = '" + propNum + "' and pprsta <> 'INAC' ",
				String.class);
		
	}

}
