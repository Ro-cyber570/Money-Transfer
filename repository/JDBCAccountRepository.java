package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.db.DataSourceConnectionFactory;
import com.example.entity.Account;

public class JDBCAccountRepository implements AccountRepository {

	@Override
	public Account loadAccount(String number) {
		// TODO Auto-generated method stub
		Account account = null;
		Connection connection = null;
		try {
			connection = DataSourceConnectionFactory.getConnection();
			String sql = "select * from accounts where number=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, number);
			ResultSet rs = ps.executeQuery();
			rs.next();
			account = new Account();
			account.setBalance(rs.getDouble(2));
			account.setNumber(number);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = DataSourceConnectionFactory.getConnection();
			String sql = "update accounts set balance=? where number=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setString(2, account.getNumber());
			int rs = ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
