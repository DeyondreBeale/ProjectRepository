package dev.beale.models;

import org.apache.log4j.Logger;

public class Account {

	static final Logger log = Logger.getLogger(Account.class);

	int id;
	int c_id;
	int balance;
	int amount;
	boolean checkingAccount;
	boolean savingsAccount;

	public Account() {
		super();
	}

	public Account(int id, int c_id, int balance, int amount, boolean checkingAccount, boolean savingsAccount) {
		super();
		log.info("Setting Account Values");
		this.balance = balance;
		this.id = id;
		this.c_id = c_id;
		this.amount = amount;
		this.checkingAccount = checkingAccount;
		this.savingsAccount = savingsAccount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return c_id;
	}

	public void setCid(int cid) {
		c_id = cid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(boolean checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	public boolean isSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(boolean savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", c_id= " + c_id + ", balance=" + balance + ", amount=" + amount
				+ ", checkingAccount=" + checkingAccount + ", savingsAccount=" + savingsAccount + "]";
	}

}
