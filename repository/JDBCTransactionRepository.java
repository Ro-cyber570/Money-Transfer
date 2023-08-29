package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

import com.example.db.DataSourceConnectionFactory;
import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.entity.TransactionType;

public class JDBCTransactionRepository implements TransactionRepository {
	static int id;

	public void insert(Transaction transaction,Account account) {
		// TODO Auto-generated method stub

		Connection connection = null;
		try {
			connection = DataSourceConnectionFactory.getConnection();
			
			String sql = "insert into transactions(amount,transactiontype,localt,accountnumber) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, transaction.getAmount());
			ps.setString(2,String.valueOf(transaction.getType()));
			ps.setString(3,String.valueOf(transaction.getLocalDateTime()));
			ps.setString(4, account.getNumber());
			ps.executeUpdate();

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


		
		
	}



}
