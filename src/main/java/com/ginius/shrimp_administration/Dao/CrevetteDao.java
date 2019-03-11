package com.ginius.shrimp_administration.Dao;

import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;

import java.sql.SQLException;
import java.util.List;

public class CrevetteDao {

	Connexion connexion = Connexion.getInstance("src\\main\\resources\\documents\\database.db");

	public void initialiseCrevette(List<Crevette> crevettes) {

		connexion.connect();

		String sqlDropTable = "DROP TABLE IF EXISTS CREVETTE";

		String sqlNewTable = "CREATE TABLE IF NOT EXISTS CREVETTE (\n" + "	'id' INTEGER PRIMARY KEY,\n"
				+ "	'categorie' TEXT NOT NULL,\n" + "	'souscategorie' TEXT NOT NULL,\n" + "	'nom' TEXT NOT NULL,\n"
				+ "	'ghMin' INTEGER NOT NULL,\n" + "	'ghMax' INTEGER NOT NULL,\n" + "	'khMin' INTEGER NOT NULL,\n"
				+ "	'khMax' INTEGER NOT NULL,\n" + "	'phMin' DECIMAL NOT NULL,\n" + "	'phMax' DECIMAL NOT NULL,\n"
				+ "	'description' TEXT NULL,\n" + "	'temperature' INTEGER NOT NULL);";

		try {
			connexion.getStatment().executeUpdate(sqlDropTable);
			System.out.println("Suppression de la table Crevette réussie");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connexion.getStatment().executeUpdate(sqlNewTable);
			System.out.println("Génération de la table Crevette réussie");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Crevette c : crevettes) {

			String query = "";
			query += "INSERT INTO CREVETTE VALUES (";
			query += "'" + c.getCrevetteID() + "', ";
			query += "'" + c.getcategorie() + "', ";
			query += "'" + c.getsouscategorie() + "', ";
			query += "'" + c.getNom() + "', ";
			query += "'" + c.getGhMin() + "', ";
			query += "'" + c.getGhMax() + "', ";
			query += "'" + c.getKhMin() + "', ";
			query += "'" + c.getKhMax() + "', ";
			query += "'" + c.getPhMin() + "', ";
			query += "'" + c.getPhMax() + "', ";
			query += "'" + c.getTemperature() + "', ";
			query += "'" + c.getDescription() + "' )";
			try {
				connexion.getStatment().executeUpdate(query);

				System.out.println("-- Insersion de : " + c.toString() + " dans la table crevette réussie");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		connexion.close();

	}

	public boolean saveCrevette(Crevette c) {

		connexion.connect();

		String query = "";
		query += "INSERT INTO CREVETTE (categorie, souscategorie, nom, ghMin,"
				+ "ghMax, khMin, khMax, phMin, phMax, temperature, description )"
				+ " VALUES (";
		//query += "'" + c.getCrevetteID() + "', ";
		query += "'" + c.getcategorie() + "', ";
		query += "'" + c.getsouscategorie() + "', ";
		query += "'" + c.getNom() + "', ";
		query += "'" + c.getGhMin() + "', ";
		query += "'" + c.getGhMax() + "', ";
		query += "'" + c.getKhMin() + "', ";
		query += "'" + c.getKhMax() + "', ";
		query += "'" + c.getPhMin() + "', ";
		query += "'" + c.getPhMax() + "', ";
		query += "'" + c.getTemperature() + "', ";
		query += "'" + c.getDescription() + "' )";
		try {
			connexion.getStatment().executeUpdate(query);
			System.out.println("-- Insersion de : " + c.toString() + " dans la table crevette réussie");
			connexion.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
