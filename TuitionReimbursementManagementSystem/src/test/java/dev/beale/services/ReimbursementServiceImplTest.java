package dev.beale.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.beale.models.Reimbursement;
import dev.beale.repositories.ReimbursementRepo;
import dev.beale.repositories.ReimbursementRepoImpl;

public class ReimbursementServiceImplTest {

	private Reimbursement a;

	@Before
	public void init() {
		a = new Reimbursement();
		a.setId(101);
		a.setEid(101);
		a.setAmount(800);
		a.setSupervisorApproved(false);
		a.setDepartHeadApproved(false);
		a.setBenCoApproved(false);
		a.setDateSubmitted("07/01/2001");
		a.setTimeRequirement("12:00");
		a.setAutoApprove(false);
		a.setLocation("Tardis");
		a.setDescription("Space and Time");
		a.setStatus("Pending");
		a.setGradeFormat("Presentation");
		a.setJustification("It works");
		a.setFileAttachment((byte) 0);
		a.setEventType("Other");

	}

	@Test
	public void testCreateReimbursement() {
		ReimbursementRepo ad = new ReimbursementRepoImpl();
		ReimbursementService es = new ReimbursementServiceImpl(ad);
		Reimbursement test = es.createReimbursement(a);
		assertNotNull(test);
		assertEquals(test.getId(), 101);
	}

	@Test
	public void testGetReimbursementInt() {
		ReimbursementRepo ad = new ReimbursementRepoImpl();
		ReimbursementService es = new ReimbursementServiceImpl(ad);
		Reimbursement test = es.getReimbursement(101);
		assertNotNull(test);
		assertEquals(test.getId(), 101);
	}

	@Test
	public void testGetReimbursementIntInt() {
		ReimbursementRepo ad = new ReimbursementRepoImpl();
		ReimbursementService es = new ReimbursementServiceImpl(ad);
		Reimbursement test = es.getReimbursement(101);
		assertNotNull(test);
		assertEquals(test.getId(), 101);
	}

	@Test
	public void testGetReimbursementName() {
		ReimbursementRepo ad = new ReimbursementRepoImpl();
		ReimbursementService es = new ReimbursementServiceImpl(ad);
		Reimbursement test = es.getReimbursement("DocWho");
		assertNotNull(test);
		assertEquals(test.getEid(), 101);
	}

	@Test
	public void testGetAllReimbursementsIntInt() {
		ReimbursementRepo ad = new ReimbursementRepoImpl();
		ReimbursementService es = new ReimbursementServiceImpl(ad);
		List<Reimbursement> test = es.getAllReimbursements(1, -1);
		assertNotNull(test);
	}

	@Test
	public void testUpdateReimbursementReimbursement() {
		ReimbursementRepo ad = new ReimbursementRepoImpl();
		ReimbursementService es = new ReimbursementServiceImpl(ad);
		Reimbursement test = es.updateReimbursement(a);
		assertEquals(test.getId(), 101);
	}

	@Test
	public void testDeleteReimbursementInt() {
		ReimbursementRepo ad = new ReimbursementRepoImpl();
		ReimbursementService es = new ReimbursementServiceImpl(ad);
		Reimbursement test = es.deleteReimbursement(3);
		assertEquals(test, test);
	}

}
