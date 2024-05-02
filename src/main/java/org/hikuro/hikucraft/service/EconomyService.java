package org.hikuro.hikucraft.service;

import java.util.UUID;

public class EconomyService {

	public void deposit(UUID player, double amount) {
		// Deposit money to player's account
	}

	public void withdraw(UUID player, double amount) {
		// Withdraw money from player's account
	}

	public double getBalance(UUID player) {
		// Get player's account balance
		return 0.0;
	}

	public boolean hasEnough(UUID player, double amount) {
		// Check if player has enough money
		return false;
	}

	public void transfer(UUID fromPlayer, UUID toPlayer, double amount) {
		// Transfer money from one player to another
	}

	public void setBalance(UUID player, double amount) {
		// Set player's account balance
	}

	public void resetBalance(UUID player) {
		// Reset player's account balance
	}
}
