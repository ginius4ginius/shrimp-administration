package com.ginius.shrimp_administration.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Classe permettant la liaison à la base de donnée SQLITE.
 * 
 * @author giniu
 *
 */
public class Connection {

	public static final Logger logger = Logger.getLogger(Connection.class);
	
	private String bdPath = "src\\main\\resources\\documents\\database.db";
	private java.sql.Connection connection = null;
	private Statement statement = null;

	/** Constructeur privé */
	private Connection(String dBPath) {
		bdPath = dBPath;
	}

	/** Instance unique non préinitialisée */
	private static Connection instance = null;

	/** Point d'accès pour l'instance unique du singleton */
	public static Connection getInstance(String dBPath) {
		if (instance == null) {
			instance = new Connection(dBPath);
		}
		return instance;
	}

	public void connect() {
		if (logger.isInfoEnabled()) {
			logger.info("Tentative de connexion à la base de donnée...");
		}

		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + bdPath);
			statement = connection.createStatement();

			if (logger.isInfoEnabled()) {
				logger.info("Connexion a " + bdPath + " avec succès");
			}
		} catch (ClassNotFoundException e) {
			logger.warn("ERREUR : erreur de connexion - " + e.getMessage());
		} catch (SQLException e) {
			logger.warn("ERREUR : erreur de connexion - " + e.getMessage());
		}
	}

	public Statement getStatment() {
		return this.statement;
	}

	public void close() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			logger.warn("ERREUR : " + e.getMessage());
		}
	}
}
