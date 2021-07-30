package dev.beale.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.beale.models.Request;

public class RequestRepoImplTest {

	private Request a;

	@Before
	public void init() {
		a = new Request();
		a.setId(100);
		a.setEid(100);
		a.setRid(100);
		a.setDepartment("BenCo");
		a.setReason("Not Good Enough");
		a.setDateSent("000");
		a.setUrgent(true);
		a.setDenied(false);

	}

	@Test
	public void testCreateRequest() {
		RequestRepo ad = new RequestRepoImpl();
		Request test = ad.createRequest(a);
		assertNotNull(test);
		assertEquals(test.getId(), 5);
	}

	@Test
	public void testGetRequestInt() {
		RequestRepo ad = new RequestRepoImpl();
		Request test = ad.getRequest(4);
		assertNotNull(test);
		assertEquals(test.getDepartment(), "BenCo");
	}

	@Test
	public void testGetRequestName() {
		RequestRepo ad = new RequestRepoImpl();
		Request test = ad.getRequest("100");
		assertNotNull(test);
		assertEquals(test.getReason(), "Not Good Enough");
	}

	@Test
	public void testGetAllRequests() {
		RequestRepo ad = new RequestRepoImpl();
		List<Request> test = ad.getAllRequests(1, -1);
		assertNotNull(test);
	}

	@Test
	public void testUpdateRequestRequest() {
		RequestRepo ad = new RequestRepoImpl();
		Request current = ad.getRequest(3);
		Request test = ad.updateRequest(current);
		assertNotNull(test);
	}

	@Test
	public void testDeleteRequestInt() {
		RequestRepo ad = new RequestRepoImpl();
		Request test = ad.deleteRequest(5);
		assertNotNull(test);
	}

}
