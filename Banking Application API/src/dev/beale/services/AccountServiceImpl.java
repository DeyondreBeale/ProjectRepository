package dev.beale.services;

import java.util.ArrayList;
import java.util.List;

import dev.beale.models.Account;
import dev.beale.repositories.AccountDao;

public class AccountServiceImpl implements AccountService {

	public AccountDao ad;

	public AccountServiceImpl(AccountDao ad) {
		this.ad = ad;
	}

	public Account createAccount(Account c) {
		return ad.createAccount(c);
	}

	public Account getAccount(int id) {
		return ad.getAccount(id);
	}

	public Account getAccount(int id, int id2) {
		return ad.getAccount(id, id2);
	}

	public List<Account> getAllAccounts() {
		return ad.getAllAccounts();
	}

	public Account updateAccount(Account change) {
		return ad.updateAccount(change);
	}

	public Account deleteAccount(int id) {
		return ad.deleteAccount(id);
	}

	public List<Account> getAccountsOfChecking(boolean checkingAccounts) {

		List<Account> Accounts = ad.getAllAccounts();
		List<Account> refinedAccounts = new ArrayList<Account>();

		for (Account c : Accounts) {
			if (c.isCheckingAccount() == true) {
				refinedAccounts.add(c);
			}
		}

		return refinedAccounts;
	}

	public List<Account> getAccountsOfSavings(boolean savingsAccounts) {

		List<Account> Accounts = ad.getAllAccounts();
		List<Account> refinedAccounts = new ArrayList<Account>();

		for (Account c : Accounts) {
			if (c.isSavingsAccount() == true) {
				refinedAccounts.add(c);
			}
		}
		// movies.forEach(movie -> {
		// if(movie.getPrice() >= price)
		// refinedMovies.add(movie);
		// });

		return refinedAccounts;
	}

	@Override
	public List<Account> getAllAccounts(int id) {
		return ad.getAllAccounts(id);
	}

	@Override
	public Account deleteAccount(int id, int id2) {
		return ad.deleteAccount(id, id2);
	}

	public List<Account> getAllAccountsByParam(int id, int param1, int param2) {
		return ad.getAllAccountsByParam(id, param1, param2);
	}

	@Override
	public Account deposit(Account a, Account b) {
		return ad.deposit(a, b);
	}

	@Override
	public Account updateAccount(Account a, Account b) {
		return ad.updateAccount(a, b);
	}

	@Override
	public Account withdraw(Account a, Account c) {
		return ad.withdraw(a, c);
	}

}
