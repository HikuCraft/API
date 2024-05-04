package org.hikuro.hikucraft.service;

import java.util.UUID;
import org.hikuro.hikucraft.entity.Economy;
import org.hikuro.hikucraft.repository.EconomyRepository;

public class EconomyService {
	private final EconomyRepository economyRepository;

	public EconomyService(EconomyRepository economyRepository) {
		this.economyRepository = economyRepository;
	}

	public void create(UUID player) {
		try {
			this.economyRepository.save(new Economy(player, 0.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deposit(UUID player, double amount) {
		try {
			double balance = this.getBalance(player);
			this.economyRepository.update(new Economy(player, balance + amount));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void withdraw(UUID player, double amount) {
		try {
			double balance = this.getBalance(player);
			this.economyRepository.update(new Economy(player, balance - amount));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double getBalance(UUID player) {
		try {
			return this.economyRepository.getById(player).getBalance();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				this.economyRepository.save(new Economy(player, 0.0));
				return 0.0;
			} catch (Exception e2) {
				e2.printStackTrace();
				return 0.0;
			}
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
			this.economyRepository.update(new Economy(player, amount));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetBalance(UUID player) {
		try {
			this.economyRepository.update(new Economy(player, 0.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
