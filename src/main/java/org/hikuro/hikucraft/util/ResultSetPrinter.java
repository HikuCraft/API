package org.hikuro.hikucraft.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetPrinter {
	public static void printResultSet(ResultSet resultSet) throws SQLException {
		ResultSetMetaData metaData = resultSet.getMetaData();
		int columnCount = metaData.getColumnCount();

		// Afficher les noms des colonnes
		for (int i = 1; i <= columnCount; i++) {
			System.out.print(metaData.getColumnName(i));
			if (i < columnCount) {
				System.out.print(", ");
			}
		}
		System.out.println();

		// Afficher les valeurs des colonnes pour chaque ligne
		while (resultSet.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(resultSet.getString(i));
				if (i < columnCount) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
}
