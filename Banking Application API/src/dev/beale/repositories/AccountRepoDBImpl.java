package dev.beale.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dev.beale.models.Account;
import dev.beale.util.JDBCCon;

public class AccountRepoDBImpl implements AccountDao {

	// gets logs
	static final Logger log = Logger.getLogger(AccountRepoDBImpl.class);

	// connects to database
	public static Connection conn = JDBCCon.getConnection();

	@Override
	public Account createAccount(Account a) {
		// Instructions for database
		String sql = "INSERT INTO accounts VALUES (default, ?,?,?,?,?) RETURNING *";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			log.info("Setting New Information");
			// set values for the placeholders: ?
			ps.setInt(1, a.getCid());
			ps.setInt(2, a.getBalance());
			ps.setInt(3, a.getAmount());
			ps.setBoolean(4, a.isCheckingAccount());
			ps.setBoolean(5, a.isSavingsAccount());

			if (a.isCheckingAccount() == false && a.isSavingsAccount() == false) {
				log.info("Defaulting a Savings Account");
				ps.setBoolean(5, true);
			}
			// Stores the information
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				log.info("Building an Account with given Information");
				return buildAccount(rs);
			}
		} catch (SQLException e) {
			log.error("Database Connection Information Error" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with setting information");
		return null;
	}

	@Override
	public Account getAccount(int id) {
		// Instructions for database
		String sql = "SELECT * FROM accounts WHERE a_id = ?";

		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// Set values for Placeholders
			log.info("Setting New Information");
			ps.setInt(1, id);

			// ExecuteQuery, store the results
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Building New Account");
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			log.error("Database Connection Information Error" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with setting information");
		return null;
	}

	public Account getAccount(int id, int id2) {

		// Instructions for database
		String sql = "SELECT * FROM accounts WHERE a_id = ? and c_id = ?";

		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// Set values for Placeholders
			log.info("Setting New Information");
			ps.setInt(1, id);
			ps.setInt(2, id2);

			// ExecuteQuery, store the results
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Building New Account");
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			log.error("Database Connection Information Error" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with Setting Information");
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {

		// Instructions for database
		String sql = "SELECT * FROM accounts";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			// stores the information
			ResultSet rs = ps.executeQuery();

			// creates an account list with the stored information
			List<Account> accounts = new ArrayList<Account>();
			while (rs.next()) {

				accounts.add(buildAccount(rs));
			}
			log.info("Returning List of Accounts");
			return accounts;

		} catch (SQLException e) {
			log.error("Database Connection Information Error" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with List Information");
		return null;
	}

	public List<Account> getAllAccounts(int id) {
		String sql = "SELECT * FROM accounts where c_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			log.info("Setting New Information");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			List<Account> accounts = new ArrayList<Account>();
			while (rs.next()) {

				accounts.add(buildAccount(rs));
			}
			log.info("Sending Created List");
			return accounts;

		} catch (SQLException e) {
			log.error("Database Connection Information Error" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with List Info");
		return null;
	}

	public List<Account> getAllAccountsByParam(int id, int param1, int param2) {
		String sql = "SELECT * FROM accounts where c_id = ? and (balance < ? and balance > ?)";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			log.info("Setting New Information");
			ps.setInt(1, id);
			ps.setInt(2, param1);
			ps.setInt(3, param2);

			ResultSet rs = ps.executeQuery();

			List<Account> accounts = new ArrayList<Account>();
			while (rs.next()) {
				accounts.add(buildAccount(rs));
			}
			log.info("Sending Created List");
			return accounts;

		} catch (SQLException e) {
			log.error("Database Connection Problems" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with Listing Accounts Info");
		return null;
	}

	@Override
	public Account updateAccount(Account change) {
		String sql = ("UPDATE accounts SET balance = ?, amount = ?, checking_account = ?, savings_account = ? WHERE a_id = ? and c_id = ? RETURNING *");
		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);

			// Set values for Placeholders
			log.info("Setting New Information");
			ps.setInt(1, change.getBalance());
			ps.setInt(2, change.getAmount());
			ps.setBoolean(3, change.isCheckingAccount());
			ps.setBoolean(4, change.isSavingsAccount());
			ps.setInt(5, change.getId());
			ps.setInt(6, change.getCid());

			// ExecuteQuery, store the results
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Creating New Account");
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			log.error("Database Connection Problems" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with Setting Info");
		return null;
	}

	@Override
	public Account deleteAccount(int id) {
		String sql = "DELETE FROM accounts WHERE a_id = ? RETURNING *";

		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);

			// Set values for Placeholders
			log.info("Setting New Information");
			ps.setInt(1, id);

			// ExecuteQuery, store the results
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Creating New Account");
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			log.error("Database Connecting Problems" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Missing Info");
		return null;
	}

	@Override
	public Account withdraw(Account a, Account c) {
		String sql = ("UPDATE accounts SET balance=balance-?, amount = -? WHERE a_id = ? and c_id = ? RETURNING *");

		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);

			// Set values for Placeholders
			log.info("Setting New Information");
			ps.setDouble(1, Math.abs(c.getAmount()));
			ps.setDouble(2, Math.abs(c.getAmount()));
			ps.setInt(3, a.getId());
			ps.setInt(4, a.getCid());

			// ExecuteQuery, store the result
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Creating New Account");
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			log.error("Database Issues" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with Setting Info");
		return null;
	}

	@Override
	public Account deposit(Account a, Account c) {

		// Instructions for database
		String sql = ("UPDATE accounts SET balance=balance+?, amount = ? WHERE a_id = ? and c_id = ? RETURNING *");

		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// Set values for Placeholders
			log.info("Setting New Information");
			ps.setDouble(1, Math.abs(c.getAmount()));
			ps.setDouble(2, Math.abs(c.getAmount()));
			ps.setInt(3, a.getId());
			ps.setInt(4, a.getCid());

			// ExecuteQuery, store the result
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Building New Account");
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			log.error("Database Connective Issues" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with Setting Info");
		return null;
	}

	@Override
	public Account deleteAccount(int id, int id2) {

		// Instructions for database
		String sql = "DELETE FROM accounts WHERE a_id = ? and c_id = ? RETURNING *";

		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);

			// Set values for Placeholders
			log.info("Setting New Information");
			ps.setInt(1, id);
			ps.setInt(2, id2);

			// ExecuteQuery, store the results
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Creating New Account");
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			log.error("Database Connective Problems" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with Setting Info");
		return null;
	}

	@Override
	public Account updateAccount(Account change, Account b) {
		String sql = ("UPDATE accounts SET balance = ?, amount = ?, checking_account = ?, savings_account = ? WHERE a_id = ? and c_id = ? RETURNING *");
		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);

			// Set values for Placeholders
			log.info("Setting New Information");
			ps.setInt(1, change.getBalance());
			ps.setInt(2, b.getAmount());
			ps.setBoolean(3, change.isCheckingAccount());
			ps.setBoolean(4, change.isSavingsAccount());
			ps.setInt(5, change.getId());
			ps.setInt(6, change.getCid());

			// ExecuteQuery, store the results
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Building New Account");
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			log.error("Database Connection Problems" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with Setting Info");
		return null;
	}

	private Account buildAccount(ResultSet rs) throws SQLException {

		log.info("Setting Up New Account");

		Account aa = new Account();
		aa.setId(rs.getInt("a_id"));
		aa.setCid(rs.getInt("c_id"));
		aa.setBalance(rs.getInt("balance"));
		aa.setAmount(rs.getInt("amount"));
		aa.setCheckingAccount(rs.getBoolean("checking_account"));
		aa.setSavingsAccount(rs.getBoolean("savings_account"));
		return aa;
	}
}
