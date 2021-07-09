package dev.beale.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCCon {

	private static Connection conn = null;

	public static Connection getConnection() {

		/*
		 * To establish a connection we need 3 credentials url(endpoint), username, and
		 * password
		 */

		if (conn == null) {

			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);

			// Establish Connection
			String endpoint = "beale-revature-postgres.cvvxax5mwtgl.us-east-2.rds.amazonaws.com";

			// URL Format (postgres JDBC):
			// jdbc:postgresql://[endpoint]/[database]
			String url = "jdbc:postgresql://" + endpoint + "/postgres";

			System.out.println("Enter your database username: ");
			String input = scan.next();
			String username = input;

			System.out.println("Enter your database password: ");
			String input1 = scan.next();
			String password = input1;

			scan.close();

			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return conn;
	}
}
