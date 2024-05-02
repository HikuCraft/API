package org.hikuro.hikucraft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hikuro.hikucraft.util.Database;
import org.hikuro.hikucraft.entity.Home;

public class DBHomeRepository implements HomeRepository {

	@Override
	public Home findByPlayerAndName(UUID player, String name) throws SQLException {
		Database db = Database.getInstance();
		String query = "SELECT * FROM Home WHERE UUID = ? AND Name = ?";
		ResultSet rs = db.executePreparedQuery(query, player, name);
		return new Home(
				UUID.fromString(rs.getString("UUID")),
				rs.getString("Name"),
				rs.getString("World"),
				rs.getInt("X"),
				rs.getInt("Y"),
				rs.getInt("Z"));
	}

	@Override
	public List<Home> findByPlayer(UUID player) throws SQLException {
		Database db = Database.getInstance();
		String query = "SELECT * FROM Home WHERE UUID = ?";
		ResultSet rs = db.executePreparedQuery(query, player);
		List<Home> homes = new ArrayList<>();
		while (rs.next()) {
			homes.add(
					new Home(
							UUID.fromString(rs.getString("UUID")),
							rs.getString("Name"),
							rs.getString("World"),
							rs.getInt("X"),
							rs.getInt("Y"),
							rs.getInt("Z")));
		}
		return homes;
	}

	@Override
	public void create(Home home) throws SQLException {
		Database db = Database.getInstance();
		String query = "INSERT INTO Home (UUID, Name, World, X, Y, Z) VALUES (?, ?, ?, ?, ?, ?)";
		db.executePreparedUpdate(
				query,
				home.getPlayer(),
				home.getName(),
				home.getWorld(),
				home.getX(),
				home.getY(),
				home.getZ());
	}

	@Override
	public void update(Home home) throws SQLException {
		Database db = Database.getInstance();
		String query =
				"UPDATE Home SET World = ?, X = ?, Y = ?, Z = ? WHERE UUID = ? AND Name = ?";
		db.executePreparedUpdate(
				query,
				home.getWorld(),
				home.getX(),
				home.getY(),
				home.getZ(),
				home.getPlayer(),
				home.getName());
	}

	@Override
	public void delete(UUID player, String name) throws SQLException {
		Database db = Database.getInstance();
		String query = "DELETE FROM Home WHERE UUID = ? AND Name = ?";
		db.executePreparedUpdate(query, player, name);
	}
}
