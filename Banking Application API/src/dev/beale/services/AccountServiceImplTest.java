package dev.beale.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.beale.models.Account;
import dev.beale.repositories.AccountDao;
import dev.beale.repositories.AccountRepoDBImpl;

public class AccountServiceImplTest {

	private Account a;
	private Account b;
	private Account c;

	@Before
	public void init() {
		a = new Account();
		a.setCid(1);
		a.setBalance(100);
		a.setAmount(0);
		a.setCheckingAccount(true);
		a.setSavingsAccount(false);

		b = new Account();
		b.setAmount(-100);

		c = new Account();
		c.setAmount(100);
	}

	@Test
	public void testCreateAccount() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		Account test = ar.createAccount(a);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

	@Test
	public void testGetAccountInt() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		Account test = ar.getAccount(1);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

	@Test
	public void testGetAccountIntInt() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		Account test = ar.getAccount(1, 2);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
		assertEquals(test.getCid(), 2);
	}

	@Test
	public void testGetAllAccounts() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		List<Account> test = ar.getAllAccounts();
		assertNotNull(test);
	}

	@Test
	public void testUpdateAccountAccount() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		Account test = ar.updateAccount(a);
		assertNotNull(test);
	}

	@Test
	public void testDeleteAccountInt() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		Account test = ar.deleteAccount(1);
		assertNotNull(test);
		assertEquals(null, test);
	}
	/*
	 * @Test public void testGetAccountsOfChecking() { AccountServiceImpl as = new
	 * AccountServiceImpl(cd); List<Account> test = as.getAllAccounts(1);
	 * assertNotNull(test); }
	 */

	/*
	 * @Test public void testGetAccountsOfSavings() { AccountServiceImpl as = new
	 * AccountServiceImpl(cd); List<Account> test = as.getAllAccounts(1);
	 * assertNotNull(test); }
	 */

	@Test
	public void testGetAllAccountsInt() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		List<Account> test = ar.getAllAccounts(1);
		assertNotNull(test);
	}

	@Test
	public void testDeleteAccountIntInt() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		Account test = ar.deleteAccount(1, 2);
		assertNotNull(test);
	}

	@Test
	public void testGetAllAccountsByParam() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		List<Account> test = ar.getAllAccountsByParam(1, 2000, 400);
		assertNotNull(test);
	}

	@Test
	public void testDeposit() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		Account test = ar.deposit(a, b);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

	@Test
	public void testUpdateAccountAccountAccount() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		Account test = ar.getAccount(1);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

	@Test
	public void testWithdraw() {
		AccountDao ad = new AccountRepoDBImpl();
		AccountService ar = new AccountServiceImpl(ad);
		Account test = ar.getAccount(1);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

}
