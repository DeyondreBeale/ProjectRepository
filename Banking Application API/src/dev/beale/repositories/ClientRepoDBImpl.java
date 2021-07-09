package dev.beale.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dev.beale.models.Client;
import dev.beale.util.JDBCCon;

public class ClientRepoDBImpl implements ClientDao {

	// Gets logs
	static final Logger log = Logger.getLogger(ClientRepoDBImpl.class);

	// gets connection of database
	public static Connection conn = JDBCCon.getConnection();

	@Override
	public Client createClient(Client c) {

		// Instructions for database
		String sql = "INSERT INTO clients VALUES (default, ?,?,?) RETURNING *";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			// set values for the placeholders: ?
			log.info("Setting Up Values");
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPassword());

			// Stores the information
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				log.info("Creating New Client");
				return buildClient(rs);
			}
		} catch (SQLException e) {
			log.error("Database Connection Issues" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problems with Setting Info");
		return null;

	}

	@Override
	public Client getClient(int id) {

		// Instructions for database
		String sql = "SELECT * FROM clients WHERE c_id = ?";

		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);

			// Set values for Placeholders
			log.info("Setting Up Values");
			ps.setInt(1, id);

			// ExecuteQuery, store the results
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Creating New Client");
				return buildClient(rs);
			}

		} catch (SQLException e) {
			log.error("Database Connection Issues" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problem with Setting Info");
		return null;
	}

	@Override
	public List<Client> getAllClients() {

		// Instructions for database
		String sql = "SELECT * FROM clients";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			// Creates a list of clients
			List<Client> clients = new ArrayList<Client>();
			while (rs.next()) {

				clients.add(buildClient(rs));
			}
			log.info("Sending Clients List");
			return clients;

		} catch (SQLException e) {
			log.error("Database Connection Errors" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problems with Setting Info");
		return null;
	}

	@Override
	public Client updateClient(Client change) {

		// Instructions for database
		String sql = ("UPDATE clients SET name=?,email=?,password=? WHERE c_id=? RETURNING *");

		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);

			// Set values for Placeholders
			log.info("Setting Up Values");
			ps.setString(1, change.getName());
			ps.setString(2, change.getEmail());
			ps.setString(3, change.getPassword());
			ps.setInt(4, change.getId());

			// ExecuteQuery, store the results
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Creating new Client");
				return buildClient(rs);
			}

		} catch (SQLException e) {
			log.error("Database Connection Problems" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problems with Setting Info");
		return null;
	}

	@Override
	public Client deleteClient(int id) {

		// Instructions for database
		String sql = "DELETE FROM clients WHERE c_id = ? RETURNING *";

		try {

			// Set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);

			// Set values for Placeholders
			log.info("Setting Up Values");
			ps.setInt(1, id);

			// ExecuteQuery, store the results
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Creating New Client");
				return buildClient(rs);
			}

		} catch (SQLException e) {
			log.error("Database Connection Errors" + e.getMessage());
			e.printStackTrace();
		}
		log.info("Problems with Setting Info");
		return null;
	}

	private Client buildClient(ResultSet rs) throws SQLException {

		log.info("Setting Up New Client");

		Client c = new Client();
		c.setId(rs.getInt("c_id"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setPassword(rs.getString("password"));
		return c;
	}

}
