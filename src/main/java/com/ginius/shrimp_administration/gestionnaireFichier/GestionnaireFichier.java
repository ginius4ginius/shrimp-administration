package com.ginius.shrimp_administration.gestionnaireFichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.ginius.shrimp_administration.dao.CrevetteDao;

import javafx.stage.FileChooser;

public class GestionnaireFichier {

	public static final Logger logger = Logger.getLogger(CrevetteDao.class);

	private static String thisPath = new File(".").getAbsolutePath();
	private static File file = new File(thisPath);
	private static String parent = file.getParent();
	private static String imagePath = parent + "/src/main/resources/images/";
	private static String fileName = "";
	
	public static final String DEFAULTPATH = parent + "/src/main/resources/images/nouvelle_crevette.jpg";

	/**
	 * Constructeur private pour empecher d'instancier la classe qui n'est qu'un
	 * utilitaire de méthodes abstraites
	 */
	private GestionnaireFichier() {

	}

	/**
	 * Méthode qui permet de copier une image dans le répertoire image du projet.
	 * retourne un objet FIle correspondant à l'image sauvegardée.
	 * 
	 * @param source
	 * @return
	 */
	public static File copier(File source) {

		String str = source.getAbsolutePath();
		String[] arrOfStr = str.split("\\\\", -2);

		for (String a : arrOfStr) {
			fileName = a;
		}

		try (InputStream input = new FileInputStream(source.getAbsolutePath());
				OutputStream output = new FileOutputStream(imagePath + fileName)) {

			try {
				IOUtils.copy(input, output);
				return new File(imagePath + fileName);
			} catch (IOException e) {
				logger.warn(("ERREUR : " + e.getMessage()));
				return new File(DEFAULTPATH);
			}

		} catch (IOException e) {
			logger.warn(("ERREUR : " + e.getMessage()));
			return new File(DEFAULTPATH);
		}

	}

	public static void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setTitle("View Pictures");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
	}

}
