package dev.beale.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.beale.models.Request;
import dev.beale.repositories.RequestRepo;
import dev.beale.repositories.RequestRepoImpl;

public class RequestServiceImplTest {

	private Request a;

	@Before
	public void init() {
		a = new Request();
		a.setId(101);
		a.setEid(101);
		a.setRid(101);
		a.setDepartment("BenCo");
		a.setReason("Not Good Enough");
		a.setDateSent("000");
		a.setUrgent(true);
		a.setDenied(false);

	}

	@Test
	public void testCreateRequest() {
		RequestRepo ad = new RequestRepoImpl();
		RequestService es = new RequestServiceImpl(ad);
		Request test = es.createRequest(a);
		assertNotNull(test);
		assertEquals(test.getId(), 5);
	}

	@Test
	public void testGetRequestInt() {
		RequestRepo ad = new RequestRepoImpl();
		RequestService es = new RequestServiceImpl(ad);
		Request test = es.getRequest(101);
		assertNotNull(test);
		assertEquals(test.getId(), 101);
	}

	@Test
	public void testGetRequestName() {
		RequestRepo ad = new RequestRepoImpl();
		RequestService es = new RequestServiceImpl(ad);
		Request test = es.getRequest("100");
		assertNotNull(test);
		assertEquals(test.getReason(), "Not Good Enough");
	}

	@Test
	public void testGetAllRequests() {
		RequestRepo ad = new RequestRepoImpl();
		RequestService es = new RequestServiceImpl(ad);
		List<Request> test = es.getAllRequests(1, -1);
		assertNotNull(test);
	}

	@Test
	public void testUpdateRequestRequest() {
		RequestRepo ad = new RequestRepoImpl();
		RequestService es = new RequestServiceImpl(ad);
		Request test = es.updateRequest(a);
		assertEquals(test.getId(), 101);
	}

	@Test
	public void testDeleteRequestInt() {
		RequestRepo ad = new RequestRepoImpl();
		RequestService es = new RequestServiceImpl(ad);
		Request test = es.deleteRequest(101);
		assertEquals(a, test);
	}

}
