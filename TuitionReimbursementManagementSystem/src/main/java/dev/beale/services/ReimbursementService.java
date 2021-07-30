package dev.beale.services;

import java.util.List;

import dev.beale.models.Reimbursement;

public interface ReimbursementService {

	public Reimbursement getReimbursement(String name);

	public Reimbursement getReimbursement(int id);

	public Reimbursement getReimbursement(int id, int rId);

	public Reimbursement createReimbursement(Reimbursement m);

	public Reimbursement updateReimbursement(Reimbursement change);

	public Reimbursement deleteReimbursement(int id);

	public List<Reimbursement> getAllReimbursements(int id, int name);
}
