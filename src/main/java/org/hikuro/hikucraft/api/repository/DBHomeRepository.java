package org.hikuro.hikucraft.api.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hikuro.hikucraft.Database;
import org.hikuro.hikucraft.api.entity.Home;

public class DBHomeRepository implements HomeRepository {

	@Override
	public Home getByIdAndOwner(UUID id, String owner) throws SQLException {
		Database db = Database.getInstance();
		String query = "SELECT * FROM homes WHERE id = ? AND owner = ?";
		ResultSet rs = db.executePreparedQuery(query, id, owner);
		return new Home(
				UUID.fromString(rs.getString("UUID")),
				rs.getString("Owner"),
				rs.getString("World"),
				rs.getInt("X"),
				rs.getInt("Y"),
				rs.getInt("Z"));
	}

	@Override
	public List<Home> getByOwner(String owner) throws SQLException {
		Database db = Database.getInstance();
		String query = "SELECT * FROM homes WHERE owner = ?";
		ResultSet rs = db.executePreparedQuery(query, owner);
		List<Home> homes = new ArrayList<>();
		while (rs.next()) {
			homes.add(
					new Home(
							UUID.fromString(rs.getString("UUID")),
							rs.getString("Owner"),
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
		String query = "INSERT INTO Home (UUID, Owner, World, X, Y, Z) VALUES (?, ?, ?, ?, ?, ?)";
		db.executePreparedUpdate(
				query,
				home.getOwner().toString(),
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
				"UPDATE Home SET World = ?, X = ?, Y = ?, Z = ? WHERE UUID = ? AND Owner = ?";
		db.executePreparedUpdate(
				query,
				home.getWorld(),
				home.getX(),
				home.getY(),
				home.getZ(),
				home.getOwner().toString(),
				home.getName());
	}

	@Override
	public void delete(UUID id, String owner) throws SQLException {
		Database db = Database.getInstance();
		String query = "DELETE FROM homes WHERE id = ? AND owner = ?";
		db.executePreparedUpdate(query, id, owner);
	}
}
