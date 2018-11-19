package com.cg.fund.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.fund.exception.FundException;

public class JdbcUtility {
	private static Connection connection = null;

	public static Connection getConnection() throws FundException {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(
					"resources/jdbc.properties")));
			String driver = properties.getProperty("db.driver");
			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");

			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, username,
						password);

			} catch (ClassNotFoundException e) {
				throw new FundException("Unable to load the class");
			} catch (SQLException e) {
				throw new FundException("Connection was not established");
			}

		} catch (IOException e) {
			throw new FundException(
					"Unable to read the data from the file, Try again");
		}
		return connection;
	}
	public static void closeConnection() throws FundException{
		try {
			connection.close();
		} catch (SQLException e) {
			throw new FundException("Unable to close the connection");
		}
	}

}
