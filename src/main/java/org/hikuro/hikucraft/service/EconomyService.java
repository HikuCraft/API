package org.hikuro.hikucraft.service;

import java.sql.SQLException;
import java.util.UUID;
import org.hikuro.hikucraft.repository.EconomyRepository;

public class EconomyService {
	private final EconomyRepository economyRepository;

	public EconomyService(EconomyRepository economyRepository) {
		this.economyRepository = economyRepository;
	}

	public void deposit(UUID player, double amount) {
		try {
			double balance = this.getBalance(player);
			this.economyRepository.saveBalance(player, balance + amount);
		} catch (SQLException e) {
			// TODO: Handle exception
			e.printStackTrace();
		}
	}

	public void withdraw(UUID player, double amount) {
		try {
			double balance = this.getBalance(player);
			if (balance < amount)
				throw new IllegalArgumentException(
						"Insufficient funds"); // TODO: Create custom exception
			this.economyRepository.saveBalance(player, balance - amount);
		} catch (SQLException e) {
			// TODO: Handle exception
			e.printStackTrace();
		}
	}

	public double getBalance(UUID player) {
		try {
			return this.economyRepository.findBalance(player);
		} catch (SQLException e) {
			// TODO: Handle exception
			return 0.0;
		}
	}

	public boolean hasEnough(UUID player, double amount) {
		return this.getBalance(player) >= amount;
	}

	public void transfer(UUID fromPlayer, UUID toPlayer, double amount) {
		if (fromPlayer.equals(toPlayer))
			throw new IllegalArgumentException(
					"Cannot transfer to self"); // TODO: Create custom exception
		this.withdraw(fromPlayer, amount);
		this.deposit(toPlayer, amount);
	}

	public void setBalance(UUID player, double amount) {
		try {
			this.economyRepository.saveBalance(player, amount);
		} catch (SQLException e) {
			// TODO: Handle exception
			e.printStackTrace();
		}
	}

	public void resetBalance(UUID player) {
		try {
			this.economyRepository.resetBalance(player);
		} catch (SQLException e) {
			// TODO: Handle exception
			e.printStackTrace();
		}
	}
}
