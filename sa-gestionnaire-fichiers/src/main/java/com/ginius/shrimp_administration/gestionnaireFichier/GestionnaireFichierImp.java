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

public class GestionnaireFichierImp implements GestionnaireFichier {

	private static final Logger logger = Logger.getLogger(GestionnaireFichierImp.class);

	private  ResourceBundle bundle = ResourceBundle
			.getBundle("com.ginius.shrimp_administration.properties.filePath");
	private  String thisPath = new File(".").getAbsolutePath();
	private  File file = new File(thisPath);
	private  String parent = file.getParent();
	private   String defaultpath = null;
	private  String imagePath = parent + bundle.getString("path.image.folder");
	private  String fileName = "";
	
	

	public String getDefaultpath() {
		return defaultpath;
	}

	public GestionnaireFichierImp(String source) {
		defaultpath = parent + bundle.getString("path.default."+source);
	}

	public File copier(File source) {

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
			return new File(defaultpath);
		}

		try {
			IOUtils.copy(input, output);
			return new File(imagePath + fileName);
		} catch (IOException e) {
			if (logger.isInfoEnabled()) {
				logger.info("impossible de copier l'image dans le répertoire de destination.");
			}
			return new File(defaultpath);
		}

	}

	public void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setTitle("View Pictures");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
	}

	public boolean isDeffaultImage(File image) {

		String path = image.getAbsolutePath();

		return (path.equals(defaultpath)) ? true : false;
	}

}
