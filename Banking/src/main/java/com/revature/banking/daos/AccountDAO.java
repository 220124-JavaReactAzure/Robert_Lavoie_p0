package com.revature.banking.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import com.revature.banking.models.Account;
import com.revature.banking.util.collections.List;
import com.revature.banking.util.datasource.ConnectionFactory;

public class AccountDAO implements CrudDAO<Account> {
	
	// TODO: Implement search by creatorID
	public List<Account> findAccountByOwner(String owner){
		return null;
	}

	@Override
	public Account create(Account newAccount) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			newAccount.setAccountId(UUID.randomUUID().toString());

			String sql = "insert into account (accountId, accountType, accountName, accountOwner, balance, userId)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newAccount.getAccountId());
			ps.setString(2, newAccount.getAccountType());
			ps.setString(3, newAccount.getAccountName());
			ps.setString(4, newAccount.getAccountOwner());
			ps.setDouble(5, newAccount.getBalance());
			ps.setString(6, newAccount.getUserId());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newAccount;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Account updatedAccount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
