package org.hikuro.hikucraft.entity;

import java.util.UUID;

public class Economy {
	private UUID player;
	private double balance;

	public Economy(UUID player, double balance) {
		this.player = player;
		this.balance = balance;
	}

	public UUID getPlayer() {
		return player;
	}

	public double getBalance() {
		return balance;
	}
}
