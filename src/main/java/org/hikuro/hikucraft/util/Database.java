package org.hikuro.hikucraft.util;

import java.sql.*;

public class Database {
	private static String URL = "jdbc:mysql://localhost:3306/HikuCraft";
	private static String USERNAME = "HikuCraft_user";
	private static String PASSWORD = "HikuCraft_user_psw";
	private static Database instance;
	private Connection connection;

	private Database() {
		this.connect(URL, USERNAME, PASSWORD);
	}

	public static void setParameters(String url, String username, String password) {
		URL = url;
		USERNAME = username;
		PASSWORD = password;
	}

	public static synchronized Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	protected void connect(String url, String username, String password) {
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void executePreparedUpdate(String query, Object... params) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		for (int i = 0; i < params.length; i++) {
			preparedStatement.setObject(i + 1, params[i].toString());
		}
		preparedStatement.executeUpdate();
	}

	public ResultSet executePreparedQuery(String query, Object... params) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		for (int i = 0; i < params.length; i++) {
			preparedStatement.setObject(i + 1, params[i].toString());
		}
		resultSet = preparedStatement.executeQuery();
		return resultSet;
	}

	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		instance = null;
	}
}
