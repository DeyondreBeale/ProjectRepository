package dev.beale.services;

import java.util.List;

import dev.beale.models.Account;

public interface AccountService {

	public Account createAccount(Account a);

	public Account getAccount(int id);

	public List<Account> getAllAccounts();

	public Account updateAccount(Account change);

	public Account deleteAccount(int id);

	public List<Account> getAccountsOfChecking(boolean checkingAccounts);

	public List<Account> getAccountsOfSavings(boolean savingsAccounts);

	public List<Account> getAllAccounts(int id);

	public List<Account> getAllAccountsByParam(int id, int param1, int param2);

	public Account getAccount(int id, int id2);

	public Account deleteAccount(int id, int id2);

	public Account deposit(Account a, Account b);

	public Account updateAccount(Account a, Account b);

	public Account withdraw(Account a, Account c);
}
