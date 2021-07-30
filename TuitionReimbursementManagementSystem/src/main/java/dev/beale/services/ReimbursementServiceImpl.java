package dev.beale.services;

import java.util.List;

import dev.beale.models.Reimbursement;
import dev.beale.repositories.ReimbursementRepo;

public class ReimbursementServiceImpl implements ReimbursementService {

	public ReimbursementRepo cd;

	public ReimbursementServiceImpl(ReimbursementRepo cd) {
		this.cd = cd;
	}

	public Reimbursement createReimbursement(Reimbursement c) {
		return cd.createReimbursement(c);
	}

	public Reimbursement getReimbursement(int id) {
		return cd.getReimbursement(id);
	}

	public Reimbursement getReimbursement(int id, int rId) {
		return cd.getReimbursement(id, rId);
	}

	public Reimbursement updateReimbursement(Reimbursement change) {
		return cd.updateReimbursement(change);
	}

	public Reimbursement deleteReimbursement(int id) {
		return cd.deleteReimbursement(id);
	}

	@Override
	public Reimbursement getReimbursement(String name) {
		return cd.getReimbursement(name);
	}

	@Override
	public List<Reimbursement> getAllReimbursements(int id, int name) {
		return cd.getAllReimbursement(id, name);
	}
}
