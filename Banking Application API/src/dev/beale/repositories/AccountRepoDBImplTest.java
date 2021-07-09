package dev.beale.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.beale.models.Account;

public class AccountRepoDBImplTest {

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
		Account test = ad.createAccount(a);
		assertNotNull(test);
		assertEquals(test.getCid(), 1);
	}

	@Test
	public void testGetAccountInt() {
		AccountDao ad = new AccountRepoDBImpl();
		Account test = ad.getAccount(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAccountIntInt() {
		AccountDao ad = new AccountRepoDBImpl();
		Account test = ad.getAccount(1, 2);
		assertEquals(test.getId(), 1);
		assertEquals(test.getCid(), 2);
	}

	@Test
	public void testGetAllAccounts() {
		AccountDao ad = new AccountRepoDBImpl();
		List<Account> test = ad.getAllAccounts();
		assertNotNull(test);
	}

	@Test
	public void testGetAllAccountsInt() {
		AccountDao ad = new AccountRepoDBImpl();
		List<Account> test = ad.getAllAccounts(1);
		assertNotNull(test);
	}

	@Test
	public void testGetAllAccountsByParam() {
		AccountDao ad = new AccountRepoDBImpl();
		List<Account> test = ad.getAllAccountsByParam(1, 2000, 400);
		assertNotNull(test);
	}

	@Test
	public void testUpdateAccountAccount() {
		AccountDao ad = new AccountRepoDBImpl();
		Account test = ad.updateAccount(a);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testDeleteAccountInt() {
		AccountDao ad = new AccountRepoDBImpl();
		Account test = ad.deleteAccount(12);
		assertEquals(null, test);
	}

	@Test
	public void testWithdraw() {
		AccountDao ad = new AccountRepoDBImpl();
		Account test = ad.withdraw(a, b);
		assertEquals(test.getAmount(), -100);
	}

	@Test
	public void testDeposit() {
		AccountDao ad = new AccountRepoDBImpl();
		Account test = ad.deposit(a, c);
		assertNotNull(test);
		assertEquals(test.getAmount(), 100);
	}

	@Test
	public void testDeleteAccountIntInt() {
		AccountDao ad = new AccountRepoDBImpl();
		Account test = ad.deleteAccount(1, 2);
		assertEquals(null, test);
	}

	@Test
	public void testUpdateAccountAccountAccount() {
		AccountDao ad = new AccountRepoDBImpl();
		Account test = ad.updateAccount(a, c);
		assertEquals(test.getAmount(), 100);
	}

}
