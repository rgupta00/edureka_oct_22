package com.bankapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AccountDaoJdbcImpl implements AccountDao {

	private static final String UPDATE_ACCOUNT = "update accounts set balance =? where id=?";
	private static final String INSERT_QUERY = "insert into accounts(name, balance) values (?,?)";
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AccountDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> getAll() {
		return jdbcTemplate.query("select * from accounts", new AccountRowMapper());
	}

	@Override
	public Account getById(int id) {
		return jdbcTemplate.queryForObject("select * from accounts where id=?", new AccountRowMapper(), id);
	}

	@Override
	public void updateAccount(Account account) {
		jdbcTemplate.update(UPDATE_ACCOUNT,
				new Object[] { account.getBalance(), account.getId() });
	}

	@Override
	public void addAccount(Account account) {

		jdbcTemplate.update(INSERT_QUERY,new Object[] { account.getName(), account.getBalance() });
	}

	@Override
	public void deleteAccount(int id) {
		jdbcTemplate.update("delete from accounts where id=?", id);
	}

}





/*
 * List<Account> accounts = new ArrayList<Account>();
 * 
 * Connection connection = null; try { connection = dataSource.getConnection();
 * // now i want to print all records Statement stmt =
 * connection.createStatement(); ResultSet rs =
 * stmt.executeQuery("select * from accounts");
 * 
 * while (rs.next()) { accounts.add(new Account(rs.getInt(1), rs.getString(2),
 * rs.getDouble(3))); } } catch (SQLException e) { e.printStackTrace(); }
 * finally { if (connection != null) { try { connection.close(); } catch
 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * } }
 * 
 * return accounts;
 */
