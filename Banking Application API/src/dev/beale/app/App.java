package dev.beale.app;

import org.apache.log4j.Logger;

import dev.beale.controllers.AccountController;
import dev.beale.controllers.ClientController;
import dev.beale.repositories.AccountDao;
import dev.beale.repositories.AccountRepoDBImpl;
import dev.beale.repositories.ClientDao;
import dev.beale.repositories.ClientRepoDBImpl;
import dev.beale.services.AccountService;
import dev.beale.services.AccountServiceImpl;
import dev.beale.services.ClientService;
import dev.beale.services.ClientServiceImpl;
import io.javalin.Javalin;

public class App {

	static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {

		// Establish Javalin object
		Javalin app = Javalin.create();
		log.info("Javalin Created");

		// Establish the Routes/Endpoints Javalin will manage
		establishRoutes(app);

		// Run Javalin
		app.start(7000);

		log.info("Javalin Started");
	}

	private static void establishRoutes(Javalin app) {

		// Going to define a list of routes/endpoints Javalin will manage
		ClientDao cd = new ClientRepoDBImpl();
		ClientService cs = new ClientServiceImpl(cd);
		ClientController cc = new ClientController(cs);

		AccountDao ad = new AccountRepoDBImpl();
		AccountService as = new AccountServiceImpl(ad);
		AccountController ac = new AccountController(as);

		// Establish a route to the 'landing' page
		app.get("/", (ctx) -> ctx.result("This is Our Banking App Home Page!"));

		// Establish routes to every possibility
		app.get("/clients", cc.getAllClients);
		app.get("/clients/:cId", cc.getClientById);

		app.get("clients/:cId/accounts", ac.getAllAccounts);
		app.get("/clients/:cId/accounts/:aId", ac.getAccountById);

		app.post("/clients", cc.createClient);

		app.post("/clients/:cId/accounts", ac.createAccount);

		app.put("/clients/:cId", cc.updateClient);

		app.put("/clients/:cId/accounts/:aId", ac.updateAccount);

		app.delete("/clients/:cId", cc.deleteClient);

		app.delete("/clients/:cId/accounts/:aId", ac.deleteAccount);

		app.patch("/clients/:cId/accounts/:aId", ac.withdrawOrDeposit);

		app.patch("/clients/:cId/accounts/:aId/transfer/:id", ac.transfer);
	}
}
