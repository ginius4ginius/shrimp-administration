package com.ginius.shrimp_administration.gestionnaireFichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javafx.stage.FileChooser;

public class GestionnaireFichier {
	
	private static final Logger logger = Logger.getLogger(GestionnaireFichier.class);

	private static ResourceBundle bundle = ResourceBundle.getBundle("com.ginius.shrimp_administration.properties.filePath");
	private static String thisPath = new File(".").getAbsolutePath();
	private static File file = new File(thisPath);
	private static String parent = file.getParent();
	public static final String DEFAULTPATH = parent + bundle.getString("path.default");
	private static String imagePath = parent + bundle.getString("path.image.folder");
	private static String fileName = "";
	
	
	/**
	 * Constructeur private pour empecher d'instancier la classe qui n'est qu'un
	 * utilitaire de méthodes abstraites
	 */
	private GestionnaireFichier() {
		
	}

	/**
	 * Méthode qui permet de copier une image dans le répertoire image du projet.
	 * retourne un objet File correspondant à l'image sauvegardée.
	 * 
	 * @param source
	 * @return
	 */
	public static File copier(File source) {

		InputStream input = null;
		OutputStream output = null;

		String str = source.getAbsolutePath();
		String[] arrOfStr = str.split("\\\\", -2);
		
		for (String a : arrOfStr) {
			fileName = a;
		}

		try {
			input = new FileInputStream(source.getAbsolutePath());
			output = new FileOutputStream(imagePath + fileName);
		} catch (FileNotFoundException e) {
			if (logger.isInfoEnabled()) {
				logger.info("Erreur sur le fichier d'image d'origine ou de destination.");
			}
			return new File(DEFAULTPATH);
		}

		try {
			IOUtils.copy(input, output);
			return new File(imagePath + fileName);
		} catch (IOException e) {
			if (logger.isInfoEnabled()) {
				logger.info("impossible de copier l'image dans le répertoire de destination.");
			}
			return new File(DEFAULTPATH);
		}

	}

	public static void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setTitle("View Pictures");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
	}
	
	/**
	 * Méthode retournant la vérification si le path en paramètre est celui de l'image par defaut
	 * @param image
	 * @return
	 */
	public static boolean isDeffaultImage(File image) {
		
		String path = image.getAbsolutePath();
		
		return (path.equals(DEFAULTPATH)) ?  true : false;
	}

}
