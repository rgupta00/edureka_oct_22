package com.bankapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
//it is used to convert data from rs to object..
public class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account=new Account();
		account.setId(rs.getInt(1));
		account.setName(rs.getNString(2));
		account.setBalance(rs.getDouble(3));
		
		return account;
	}

}
