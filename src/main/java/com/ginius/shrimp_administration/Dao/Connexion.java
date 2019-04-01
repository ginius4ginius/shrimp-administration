package com.ginius.shrimp_administration.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Classe permettant la liaison à la base de donnée SQLITE. 
 * @author giniu
 *
 */
public class Connexion {
    private String DBPath = "src\\main\\resources\\documents\\database.db";
    private Connection connection = null;
    private Statement statement = null;
    
    /** Constructeur privé */
	private Connexion(String dBPath) {
		DBPath = dBPath;
	}

	/** Instance unique non préinitialisée */
	private static Connexion INSTANCE = null;

	/** Point d'accès pour l'instance unique du singleton */
	public static Connexion getInstance(String dBPath) {
		if (INSTANCE == null) {
			INSTANCE = new Connexion(dBPath);
		}
		return INSTANCE;
	}
 
 
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a " + DBPath + " avec succès");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connecxion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connecxion");
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
            e.printStackTrace();
        }
    }
}
