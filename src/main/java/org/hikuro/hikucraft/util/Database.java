package org.hikuro.hikucraft.util;

import java.sql.*;

public class Database {
	private static Database instance;
	private Connection connection;

	private Database() {
		this.connect(
				"jdbc:mysql://localhost:3306/HikuCraft", "HikuCraft_user", "HikuCraft_user_psw");
	}

	public static synchronized Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	private void connect(String url, String username, String password) {
		try {
			connection = DriverManager.getConnection(url, username, password);
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
	}
}
