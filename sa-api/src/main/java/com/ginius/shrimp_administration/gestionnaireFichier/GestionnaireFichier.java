package com.ginius.shrimp_administration.gestionnaireFichier;

import java.io.File;

import javafx.stage.FileChooser;

public interface GestionnaireFichier {
	
	/**
	 * Méthode qui permet de copier une image dans le répertoire image du projet.
	 * retourne un objet File correspondant à l'image sauvegardée.
	 * 
	 * @param source
	 * @return
	 */
	public  File copier(File source);
	
	/**
	 * Configuration du répertoire de récupération de photos
	 * @param fileChooser
	 */
	public  void configureFileChooser(final FileChooser fileChooser);
	
	/**
	 * Méthode retournant la vérification si le path en paramètre est celui de l'image par defaut
	 * @param image
	 * @return
	 */
	public  boolean isDeffaultImage(File image);
	
	public String getDefaultpath();
	
	
	
	

}
