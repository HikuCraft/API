package org.hikuro.hikucraft.api.entity;

import java.time.Duration;
import java.util.UUID;

public class Statistics {
	private final UUID player;
	private final Duration playTime;

	public Statistics(UUID player, Duration playTime) {
		this.player = player;
		this.playTime = playTime;
	}

	// Getters

	public UUID getPlayer() {
		return player;
	}

	public Duration getPlayTime() {
		return playTime;
	}
}
