package com.ginius.shrimp_administration.dao;

import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Classe d'accés et méthodes CRUD de la base de donnée CREVETTE.
 * 
 * @author giniu
 *
 */
public class CrevetteDao {

	public static final Logger logger = Logger.getLogger(CrevetteDao.class);

	Connection connexion = Connection.getInstance("src\\main\\resources\\documents\\database.db");
	List<Crevette> crevetteList = new ArrayList<>();
	private String crevetteSucces = " dans la table crevette réussie";

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
				+ "	'description' TEXT NULL,\n" + "	'image' TEXT NULL,\n"
				+ "	'temperature' INTEGER NOT NULL,'possede' boolean NOT NULL default 0);";

		try {
			connexion.getStatment().executeUpdate(sqlDropTable);
			if (logger.isInfoEnabled()) {
				logger.info("Suppression de la table Crevette réussi");
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}

		try {
			connexion.getStatment().executeUpdate(sqlNewTable);
			if (logger.isInfoEnabled()) {
				logger.info("Génération de la table Crevette réussie");
			}
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}

		for (Crevette c : crevettes) {

			String query = "";
			query += "INSERT INTO CREVETTE VALUES (";
			query += "'" + c.getCrevetteID() + "', ";
			query += "'" + c.getCategorie() + "', ";
			query += "'" + c.getSousCategorie() + "', ";
			query += "'" + c.getNom() + "', ";
			query += "'" + c.getGhMin() + "', ";
			query += "'" + c.getGhMax() + "', ";
			query += "'" + c.getKhMin() + "', ";
			query += "'" + c.getKhMax() + "', ";
			query += "'" + c.getPhMin() + "', ";
			query += "'" + c.getPhMax() + "', ";
			query += "'" + c.getDescription() + "', ";
			query += "'" + c.getImage() + "', ";
			query += "'" + c.getTemperature() + "', ";
			query += "'" + c.getPossede() + "' )";
			try {
				connexion.getStatment().executeUpdate(query);
				if (logger.isInfoEnabled()) {
					logger.info("Insersion de la crevette : " + c.getNom() + crevetteSucces);
				}

			} catch (SQLException e) {
				logger.warn(e.getMessage());
			}

		}

		connexion.close();

	}

	/**
	 * Méthode permettant de récupérer la liste des crevettes.
	 * 
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
				crevette.setCategorie(rs.getString("categorie"));
				crevette.setSousCategorie(rs.getString("souscategorie"));
				crevette.setNom(rs.getString("nom"));
				crevette.setGhMin(rs.getInt("ghMin"));
				crevette.setGhMax(rs.getInt("ghMax"));
				crevette.setKhMin(rs.getInt("khMin"));
				crevette.setKhMax(rs.getInt("khMax"));
				crevette.setPhMin(rs.getDouble("phMin"));
				crevette.setPhMax(rs.getDouble("phMax"));
				crevette.setTemperature(rs.getInt("temperature"));
				crevette.setDescription(rs.getString("description"));
				crevette.setImage(rs.getString("image"));
				crevette.setPossede(rs.getInt("possede"));

				crevetteList.add(crevette);
			}
			connexion.close();
			return crevetteList;
		} catch (SQLException e) {
			logger.warn(e.getMessage());
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
		
		String mStr = c.getDescription().replace( "'" , "''" );

		connexion.connect();

		String query = "";
		query += "INSERT INTO CREVETTE (categorie, souscategorie, nom, ghMin,"
				+ "ghMax, khMin, khMax, phMin, phMax, temperature, description, image, possede )" + " VALUES (";
		query += "'" + c.getCategorie() + "', ";
		query += "'" + c.getSousCategorie() + "', ";
		query += "'" + c.getNom() + "', ";
		query += "'" + c.getGhMin() + "', ";
		query += "'" + c.getGhMax() + "', ";
		query += "'" + c.getKhMin() + "', ";
		query += "'" + c.getKhMax() + "', ";
		query += "'" + c.getPhMin() + "', ";
		query += "'" + c.getPhMax() + "', ";
		query += "'" + c.getTemperature() + "', ";
		query += "'" + mStr + "', ";
		query += "'" + c.getImage() + "', ";
		query += "'" + c.getPossede() + "' )";
		try {
			connexion.getStatment().executeUpdate(query);
			System.out.println("-- Insersion de : " + c.toString() + crevetteSucces);
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

	/**
	 * Méthode qui sauvegarde la crevette dans la base de donnée.
	 * 
	 * @param cmodifie
	 * @return
	 */
	public boolean updateCrevette(Crevette c) {
		
		String mStr = c.getDescription().replace( "'" , "''" );

		connexion.connect();

		String query = "";
		query += "UPDATE CREVETTE SET categorie = '" + c.getCategorie() + "', souscategorie = '" + c.getSousCategorie()
				+ "', nom = '" + c.getNom() + "', ghMin = " + c.getGhMin() + ",ghMax = " + c.getGhMax() + ","
				+ " khMin = " + c.getKhMin() + ", khMax = " + c.getKhMax() + ", phMin = " + c.getPhMin() + ","
				+ " phMax = " + c.getPhMax() + ", temperature = " + c.getTemperature() + "," + " description = '"
				+ mStr + "', image = '" + c.getImage() + "', possede = " + c.getPossede() + " WHERE id = "
				+ c.getCrevetteID() + ";";

		try {
			connexion.getStatment().executeUpdate(query);
			System.out.println("-- update de : " + c.toString() + crevetteSucces);
			connexion.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			connexion.close();
			return false;
		}

	}

}
