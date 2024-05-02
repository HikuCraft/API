package org.hikuro.hikucraft.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hikuro.hikucraft.entity.Home;
import org.hikuro.hikucraft.repository.HomeRepository;

public class HomeService {
	private final HomeRepository homeRepository;

	public HomeService(HomeRepository homeRepository) {
		this.homeRepository = homeRepository;
	}

	public Home getHomeByIdAndOwner(UUID id, String owner) {
		try {
			return this.homeRepository.getByIdAndOwner(id, owner);
		} catch (SQLException e) {
			return null;
		}
	}

	public List<Home> getHomesByOwner(String owner) {
		try {
			return this.homeRepository.getByOwner(owner);
		} catch (SQLException e) {
			return new ArrayList<>();
		}
	}

	public void createHome(Home home) {
		try {
			this.homeRepository.create(home);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updateHome(Home home) {
		try {
			this.homeRepository.update(home);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void deleteHome(UUID id, String owner) {
		try {
			this.homeRepository.delete(id, owner);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
