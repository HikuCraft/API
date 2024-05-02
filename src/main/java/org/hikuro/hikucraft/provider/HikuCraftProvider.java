package org.hikuro.hikucraft.provider;

import org.hikuro.hikucraft.api.HikuCraftAPI;

public class HikuCraftProvider {

	private static HikuCraftAPI hikuCraftAPI;

	public static HikuCraftAPI get() {
		if (hikuCraftAPI == null) {
			hikuCraftAPI = new HikuCraftAPI();
		}
		return hikuCraftAPI;
	}

}
