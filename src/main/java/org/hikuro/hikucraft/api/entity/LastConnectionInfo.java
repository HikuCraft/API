package org.hikuro.hikucraft.api.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class LastConnectionInfo {
	private final UUID player;
	private final LocalDateTime date;
	private final Duration timeSpent;
	private final String world;
	private final int x;
	private final int y;
	private final int z;

	public LastConnectionInfo(
			UUID player,
			LocalDateTime date,
			Duration timeSpent,
			String world,
			int x,
			int y,
			int z) {
		this.player = player;
		this.date = date;
		this.timeSpent = timeSpent;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// Getters

	public UUID getPlayer() {
		return player;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Duration getTimeSpent() {
		return timeSpent;
	}

	public String getWorld() {
		return world;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
}
