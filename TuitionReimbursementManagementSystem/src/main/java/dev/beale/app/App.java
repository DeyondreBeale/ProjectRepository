package dev.beale.app;

import org.apache.log4j.Logger;

import dev.beale.controllers.EmployeeController;
import dev.beale.controllers.ReimbursementController;
import dev.beale.controllers.RequestController;
import dev.beale.repositories.EmployeeRepo;
import dev.beale.repositories.EmployeeRepoImpl;
import dev.beale.repositories.ReimbursementRepo;
import dev.beale.repositories.ReimbursementRepoImpl;
import dev.beale.repositories.RequestRepo;
import dev.beale.repositories.RequestRepoImpl;
import dev.beale.services.EmployeeService;
import dev.beale.services.EmployeeServiceImpl;
import dev.beale.services.ReimbursementService;
import dev.beale.services.ReimbursementServiceImpl;
import dev.beale.services.RequestService;
import dev.beale.services.RequestServiceImpl;
import io.javalin.Javalin;

public class App {
	static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {

		// Establish Javalin object
		Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());
		log.info("Javalin Created");

		// Establish the Routes/Endpoints Javalin will manage
		establishRoutes(app);

		// Run Javalin
		app.start(7000);

		log.info("Javalin Started");
	}

	private static void establishRoutes(Javalin app) {

		// Going to define a list of routes/endpoints Javalin will manage
		EmployeeRepo er = new EmployeeRepoImpl();
		EmployeeService es = new EmployeeServiceImpl(er);
		EmployeeController ec = new EmployeeController(es);

		ReimbursementRepo rr = new ReimbursementRepoImpl();
		ReimbursementService rs = new ReimbursementServiceImpl(rr);
		ReimbursementController rc = new ReimbursementController(rs);

		RequestRepo rR = new RequestRepoImpl();
		RequestService rS = new RequestServiceImpl(rR);
		RequestController rC = new RequestController(rS);

		er.getEmployee(0);
		log.info("Started hibernate early with empty employee get");

		// Establish a route to the 'landing' page
		app.get("/", (ctx) -> ctx.result("This is Our TRMS Home Page!"));

		// Establish routes to every possibility
		app.get("/Employees", ec.getAllEmployees);
		app.get("/Employees/:id", ec.getEmployeeById);

		app.get("Employees/:id/Reimbursements", rc.getAllReimbursements);
		app.get("Employees/:id/Requests", rC.getAllRequests);
		app.get("/Reimbursements", rc.getAllReimbursements);
		app.get("/Reimbursements/:id", rc.getReimbursementById);
		app.get("/Requests/:id", rC.getRequestById);
		app.get("/Requests", rC.getAllRequests);

		app.post("/Employees", ec.createEmployee);
		app.post("/Employees/:id/Reimbursements", rc.createReimbursement);
		app.post("/Employees/:id/Requests", rC.createRequest);
		app.post("/Employees/:id/Reimbursements/:rId", rc.updateReimbursement);

		app.put("/Employees/:id", ec.updateEmployee);
		app.put("/Reimbursements/:id", rc.updateReimbursement);
		app.put("/Requests/:id", rC.updateRequest);

		app.delete("/Employees/:id", ec.deleteEmployee);
		app.delete("/Reimbursements/:id", rc.deleteReimbursement);
	}
}
