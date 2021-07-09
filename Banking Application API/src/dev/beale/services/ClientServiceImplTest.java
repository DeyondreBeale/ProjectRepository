package dev.beale.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.beale.models.Client;
import dev.beale.repositories.ClientDao;
import dev.beale.repositories.ClientRepoDBImpl;

public class ClientServiceImplTest {

	private Client c;

	@Before
	public void init() {
		c = new Client();
		c.setName("Johnny");
		c.setEmail("AppleTree@yahoo.com");
		c.setPassword("Sav3th3Tr33s");
	}

	@Test
	public void testCreateClient() {
		ClientDao cd = new ClientRepoDBImpl();
		ClientService cr = new ClientServiceImpl(cd);
		Client test = cr.createClient(c);
		assertNotNull(test);
		assertEquals(test.getName(), "Johnny");
	}

	@Test
	public void testGetClient() {
		ClientDao cd = new ClientRepoDBImpl();
		ClientService cr = new ClientServiceImpl(cd);
		Client test = cr.getClient(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllClients() {
		ClientDao cd = new ClientRepoDBImpl();
		ClientService cr = new ClientServiceImpl(cd);
		List<Client> test = cr.getAllClients();
		assertNotNull(test);
	}

	@Test
	public void testUpdateClient() {
		ClientDao cd = new ClientRepoDBImpl();
		ClientService cr = new ClientServiceImpl(cd);
		Client test = cr.updateClient(c);
		assertEquals(test.getName(), "Johnny");
	}

	@Test
	public void testDeleteClient() {
		ClientDao cd = new ClientRepoDBImpl();
		ClientService cr = new ClientServiceImpl(cd);
		Client test = cr.deleteClient(1);
		assertEquals(null, test);
	}

	@Test
	public void testGetClientsWithCheckingAccounts() {
		ClientDao cd = new ClientRepoDBImpl();
		ClientService cr = new ClientServiceImpl(cd);
		;
		Client test = cr.getClient(1);
		assertNotNull(test);
		assertEquals(test.getName(), 1);
	}

	@Test
	public void testForgotPassword() {
		ClientDao cd = new ClientRepoDBImpl();
		ClientService cr = new ClientServiceImpl(cd);
		Client test = cr.getClient(1);
		assertNotNull(test);
		assertEquals(test.getName(), 1);
	}

}
