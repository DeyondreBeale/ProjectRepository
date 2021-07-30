package dev.beale.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import dev.beale.models.Reimbursement;
import dev.beale.services.ReimbursementService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ReimbursementController {

	// Gets logs in this class
	static final Logger log = Logger.getLogger(ReimbursementController.class);

	Gson gson = new Gson();
	ReimbursementService rs;

	public ReimbursementController(ReimbursementService rs) {
		this.rs = rs;
	}

	public Handler getReimbursementById = (context) -> {

		String input = context.pathParam("id");

		int id;
		log.info("Path 'id' to number");
		try {

			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			log.error("Not a number" + e.getMessage());
			id = -1;
		}
		Reimbursement r = rs.getReimbursement(id);

		populateResult(context, r);
	};

	public Handler createReimbursement = (context) -> {

		Reimbursement r = gson.fromJson(context.body(), Reimbursement.class);

		r = rs.createReimbursement(r);

		populateResult(context, r);
	};

	public Handler getAllReimbursements = (context) -> {

		int id;
		int name;

		String input = "";
		String firstParam = "";

		try {
			input = context.pathParam("id");
		} catch (IllegalArgumentException e) {
			log.error("No pathParam of 'id'" + e.getMessage());
			id = -1;
		}
		log.info("getting path 'id' value");
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			log.error("Not a number" + e.getMessage());
			id = -1;
		}
		log.info("Path 'id' to number");

		try {
			firstParam = context.queryParam("approval");

		} catch (IllegalArgumentException e) {
			log.error("No queryParam of 'approval'" + e.getMessage());
			name = -1;
		}
		log.info("Getting query 'approval'");
		try {
			name = Integer.parseInt(firstParam);

		} catch (NumberFormatException e) {
			log.error("Not a number" + e.getMessage());
			name = -1;
		}
		log.info("Path 'name' to number");
		System.out.println(id);
		System.out.println(name);
		List<Reimbursement> reimbursements = rs.getAllReimbursements(id, name);
		if (reimbursements != null) {
			context.result(gson.toJson(reimbursements));
		} else {
			context.result("[]");
		}
	};

	public Handler updateReimbursement = (context) -> {
		Reimbursement r = gson.fromJson(context.body(), Reimbursement.class);

		log.info("Path 'id' to number");

		r = rs.updateReimbursement(r);

		populateResult(context, r);
	};

	public Handler deleteReimbursement = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));
		log.info("Path 'id' to number");

		Reimbursement r = rs.deleteReimbursement(id);

		populateResult(context, r);
	};

	// Helper Method
	private void populateResult(Context context, Reimbursement r) {
		if (r != null) {
			context.result(gson.toJson(r));
			log.info("Sending JSON result");
		} else {
			context.result("{}");
			log.info("error with returning JSON result");
		}
	}

}
