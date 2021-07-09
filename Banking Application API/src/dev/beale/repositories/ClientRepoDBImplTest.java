package dev.beale.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.beale.models.Client;

public class ClientRepoDBImplTest {

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
		Client test = cd.createClient(c);
		assertNotNull(test);
		assertEquals(test.getName(), "Johnny");
	}

	@Test
	public void testGetClient() {
		ClientDao cd = new ClientRepoDBImpl();
		Client test = cd.getClient(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllClients() {
		ClientDao cd = new ClientRepoDBImpl();
		List<Client> test = cd.getAllClients();
		assertNotNull(test);
	}

	@Test
	public void testUpdateClient() {
		ClientDao cd = new ClientRepoDBImpl();
		Client test = cd.updateClient(c);
		assertNotNull(test);
		assertEquals(test.getName(), "Johnny");
	}

	@Test
	public void testDeleteClient() {
		ClientDao cd = new ClientRepoDBImpl();
		Client test = cd.deleteClient(1);
		assertEquals(null, test);
	}

}
