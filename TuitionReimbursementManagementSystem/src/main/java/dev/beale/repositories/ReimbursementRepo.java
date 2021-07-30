package dev.beale.repositories;

import java.util.List;

import dev.beale.models.Reimbursement;

public interface ReimbursementRepo {

	public Reimbursement createReimbursement(Reimbursement r);

	public Reimbursement getReimbursement(int id);

	public Reimbursement getReimbursement(int id, int rId);

	public Reimbursement getReimbursement(String name);

	public Reimbursement updateReimbursement(Reimbursement change);

	public Reimbursement deleteReimbursement(int id);

	public List<Reimbursement> getAllReimbursement(int id, int name);

}
