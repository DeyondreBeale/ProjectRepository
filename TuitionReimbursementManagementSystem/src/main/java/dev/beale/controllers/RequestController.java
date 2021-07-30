package dev.beale.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import dev.beale.models.Request;
import dev.beale.services.RequestService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class RequestController {
	// Gets logs in this class
	static final Logger log = Logger.getLogger(RequestController.class);

	Gson gson = new Gson();
	RequestService es;

	public RequestController(RequestService es) {
		this.es = es;
	}

	public Handler getRequestById = (context) -> {

		String input = context.pathParam("id");
		int id;
		String userName;
		try {
			id = Integer.parseInt(input);
			Request em = es.getRequest(id);
			populateResult(context, em);
			log.info("getting Request by id");
		} catch (NumberFormatException e) {
			log.info("getting Request by username");
			userName = input;
			Request em = es.getRequest(userName);
			populateResult(context, em);
		}
	};

	public Handler createRequest = (context) -> {
		Request em = null;
		try {
			em = gson.fromJson(context.body(), Request.class);
			log.info("getting info to create Request");
			em = es.createRequest(em);
		} catch (NumberFormatException e) {
			em = null;
		}

		populateResult(context, em);
	};

	public Handler getAllRequests = (context) -> {

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
		List<Request> Requests = es.getAllRequests(id, name);
		if (Requests != null) {
			context.result(gson.toJson(Requests));
		} else {
			context.result("[]");
		}
	};

	public Handler updateRequest = (context) -> {
		Request em = gson.fromJson(context.body(), Request.class);
		em.setId(Integer.parseInt(context.pathParam("id")));

		em = es.updateRequest(em);
		log.info("updating Request");
		populateResult(context, em);
	};

	public Handler deleteRequest = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Request em = es.deleteRequest(id);
		log.info("deleting Request");
		populateResult(context, em);
	};

	// Helper Method
	private void populateResult(Context context, Request em) {
		if (em != null) {
			log.info("sent the JSON result");
			context.result(gson.toJson(em));
		} else {
			log.info("did not have a JSON created");
			context.result("{}");
		}
	}
}
