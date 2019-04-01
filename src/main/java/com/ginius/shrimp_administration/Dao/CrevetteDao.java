package com.ginius.shrimp_administration.Dao;

import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'accés et méthodes CRUD de la base de donnée CREVETTE.
 * 
 * @author giniu
 *
 */
public class CrevetteDao {

	Connexion connexion = Connexion.getInstance("src\\main\\resources\\documents\\database.db");
	List<Crevette> crevetteList = new ArrayList<Crevette>();

	/**
	 * Méthode qui initialise la base de donnée crevette.
	 * 
	 * @param crevettes
	 */
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
			query += "'" + c.getDescription() + "', ";
			query += "'" + c.getTemperature() + "' )";
			try {
				connexion.getStatment().executeUpdate(query);

				System.out.println("-- Insersion de : " + c.toString() + " dans la table crevette réussie");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		connexion.close();

	}

	/**
	 * Méthode permettant de récupérer la liste des crevettes.
	 * @return
	 */
	public List<Crevette> getCrevetteList() {

		connexion.connect();
		crevetteList.clear();
		String query = "SELECT * FROM CREVETTE";
		try {
			ResultSet rs = connexion.getStatment().executeQuery(query);

			while (rs.next()) {
				Crevette crevette = new Crevette();
				crevette.setCrevetteID(rs.getInt("id"));
				crevette.setcategorie(rs.getString("categorie"));
				crevette.setsouscategorie(rs.getString("souscategorie"));
				crevette.setNom(rs.getString("nom"));
				crevette.setGhMin(rs.getInt("ghMin"));
				crevette.setGhMax(rs.getInt("ghMax"));
				crevette.setKhMin(rs.getInt("khMin"));
				crevette.setKhMax(rs.getInt("khMax"));
				crevette.setPhMin(rs.getDouble("phMin"));
				crevette.setPhMax(rs.getDouble("phMax"));
				crevette.setTemperature(rs.getInt("temperature"));
				crevette.setDescription(rs.getString("description"));

				crevetteList.add(crevette);
			}
			connexion.close();
			return crevetteList;
		} catch (SQLException e) {
			e.printStackTrace();
			connexion.close();
			return crevetteList;
		}

	}

	/**
	 * Méthode qui sauvegarde la crevette dans la base de donnée.
	 * 
	 * @param c
	 * @return
	 */
	public boolean saveCrevette(Crevette c) {

		connexion.connect();

		String query = "";
		query += "INSERT INTO CREVETTE (categorie, souscategorie, nom, ghMin,"
				+ "ghMax, khMin, khMax, phMin, phMax, temperature, description )" + " VALUES (";
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
			connexion.close();
			return false;
		}

	}

	/**
	 * Méthode qui supprime la crevette dans la base de donnée.
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteCrevette(int id) {

		connexion.connect();

		String query = "";
		query += "DELETE FROM CREVETTE WHERE id IS " + id + ";";
		try {
			connexion.getStatment().executeUpdate(query);
			System.out.println("-- Supression dans la table de la crevette résussie");
			connexion.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			connexion.close();
			return false;
		}

	}

}
