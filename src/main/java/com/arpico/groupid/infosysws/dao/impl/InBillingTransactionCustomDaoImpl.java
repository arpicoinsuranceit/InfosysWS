package com.arpico.groupid.infosysws.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.arpico.groupid.infosysws.dao.InBillingTransactionCustomDao;


@Repository
public class InBillingTransactionCustomDaoImpl implements InBillingTransactionCustomDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Double paybleAmountThisMonth(Integer pprNo) throws Exception {
		Double amount = 0.0;

		try {
			List<Object> args = new ArrayList<>();
			args.add(pprNo);

			amount = jdbcTemplate.query("SELECT sum(amount) `sum` FROM inbillingtransactions "
					+ " where sbucod = '450' and pprnum=? and  txnyer <= year(curdate()) and txnmth <= month(curdate())",
					args.toArray(), new ResultSetExtractor<Double>() {

						@Override
						public Double extractData(ResultSet rs) throws SQLException, DataAccessException {
							Double amountTemp = 0.0;
							if (rs.next()) {
								amountTemp = rs.getDouble("sum");
							}
							return amountTemp;
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return amount;
	}

}
