package dev.beale.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import dev.beale.models.Client;
import dev.beale.services.ClientService;
import io.javalin.http.Handler;

public class ClientController {

	// gets logs
	static final Logger log = Logger.getLogger(ClientController.class);

	ClientService cs;

	Gson gson = new Gson();

	public ClientController(ClientService cs) {
		this.cs = cs;
	}

	// Controller is responsible for managing Application login
	// what is it that our application will need to be able to do

	public Handler getAllClients = (context) -> {

		// creates a list from method
		List<Client> clients = cs.getAllClients();

		context.result(gson.toJson(clients));
	};

	public Handler getClientById = (ctx) -> {

		// gets values from app.class request
		String input = ctx.pathParam("cId");
		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Seting Id to int");

		} catch (NumberFormatException e) {
			log.error("Error Retrieving id" + e.getMessage());
			id = -1;
		}

		// Calls specific method
		Client c = cs.getClient(id);

		if (c != null) {
			ctx.result(gson.toJson(c));

		} else {
			log.info("Missing Client Info");
			ctx.status(404);
		}

	};
	public Handler createClient = (context) -> {

		// Gets values from postman (body)
		Client c = gson.fromJson(context.body(), Client.class);

		c = cs.createClient(c);

		if (c != null) {
			context.result(gson.toJson(c));
			context.status(201);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler updateClient = (context) -> {

		// gets values from postman (body)
		Client c = gson.fromJson(context.body(), Client.class);

		// calls specified method
		c = cs.updateClient(c);

		if (c != null) {
			context.result(gson.toJson(c));
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
	};

	public Handler deleteClient = (context) -> {

		// gets values from app.class request
		String input = context.pathParam("cId");

		int id;

		try {
			id = Integer.parseInt(input);
			log.info("Changes Id to interger");
		} catch (NumberFormatException e) {
			log.error("Error with changing id" + e.getMessage());
			id = -1;
		}

		// Calls specified method
		Client c = cs.deleteClient(id);

		if (c != null) {
			// sends results to postman
			context.result(gson.toJson(c));
			context.status(204);
		} else {
			log.info("Missing Client Info");
			context.status(404);
		}
		;
	};
}
