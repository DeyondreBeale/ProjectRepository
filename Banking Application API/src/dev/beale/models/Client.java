package dev.beale.models;

import org.apache.log4j.Logger;

public class Client {

	static final Logger log = Logger.getLogger(Client.class);
	String name;
	int id;
	String email;
	String password;

	public Client() {
		super();
	}

	public Client(String name, int id, String email, String password) {
		super();
		log.info("Setting Client Values");
		this.name = name;
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", id=" + id + ", password=" + password + ", email=" + email + "]";
	}

}
