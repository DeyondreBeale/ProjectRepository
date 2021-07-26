package dev.beale.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import dev.beale.models.Employee;
import dev.beale.services.EmployeeService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EmployeeController {

	// Gets logs in this class
	static final Logger log = Logger.getLogger(EmployeeController.class);

	Gson gson = new Gson();
	EmployeeService es;

	// Please don't ever actually skip the Service layer.
	public EmployeeController(EmployeeService es) {
		this.es = es;
	}

	public Handler getEmployeeById = (context) -> {

		String input = context.pathParam("id");
		int id;
		String userName;
		try {
			id = Integer.parseInt(input);
			Employee em = es.getEmployee(id);
			populateResult(context, em);
			log.info("getting employee by id");
		} catch (NumberFormatException e) {
			log.info("getting employee by username");
			userName = input;
			Employee em = es.getEmployee(userName);
			populateResult(context, em);
		}
	};

	public Handler createEmployee = (context) -> {

		Employee em = gson.fromJson(context.body(), Employee.class);
		log.info("getting info to create employee");
		em = es.createEmployee(em);

		populateResult(context, em);
	};

	public Handler getAllEmployees = (context) -> {

		String name = context.queryParam("name", "");

		if (name == "") {

			List<Employee> employees = es.getAllEmployees();
			if (employees != null) {
				context.result(gson.toJson(employees));
			} else {
				context.result("[]");
			}
			log.info("created a employee list");
		} else {
			getEmployeeByName(context);
		}
	};

	public Handler updateEmployee = (context) -> {
		Employee em = gson.fromJson(context.body(), Employee.class);
		em.setId(Integer.parseInt(context.pathParam("id")));

		em = es.updateEmployee(em);
		log.info("updating employee");
		populateResult(context, em);
	};

	public Handler deleteEmployee = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Employee em = es.deleteEmployee(id);
		log.info("deleting employee");
		populateResult(context, em);
	};

	private Employee getEmployeeByName(Context context) {

		String name = context.queryParam("name");
		System.out.println(name);

		Employee em = es.getEmployee(name);
		log.info("getting employee by query name");
		populateResult(context, em);
		return em;
	};

	// Helper Method
	private void populateResult(Context context, Employee em) {
		if (em != null) {
			log.info("sent the JSON result");
			context.result(gson.toJson(em));
		} else {
			log.info("did not have a JSON created");
			context.result("{}");
		}
	}
}
