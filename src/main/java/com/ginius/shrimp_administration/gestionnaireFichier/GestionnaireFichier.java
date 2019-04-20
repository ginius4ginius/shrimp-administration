package com.ginius.shrimp_administration.gestionnaireFichier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import javafx.stage.FileChooser;

public class GestionnaireFichier {

	
	private static String thisPath = new File(".").getAbsolutePath();
	private static File file = new File(thisPath);
	private static String parent = file.getParent();
	public final static String defaultPath = parent + "/src/main/resources/images/nouvelle_crevette.jpg";
	private static String imagePath = parent + "/src/main/resources/images/";
	private static InputStream input;
	private static OutputStream output;
	private static String fileName="";
	
/**
 * Méthode qui permet de copier une image dans le répertoire image du projet.
 * retourne un objet FIle correspondant à l'image sauvegardée.
 * @param source
 * @return
 */
	public static File copier(File source) {
		
		String str = source.getAbsolutePath(); 
        String[] arrOfStr = str.split("\\\\", -2); 
        for (String a : arrOfStr) {
        	fileName = a;
        }
        
		try {
			input = new FileInputStream(source.getAbsolutePath());
		} catch (FileNotFoundException e1) {
			System.out.println("Erreur sur le fichier d'image d'origine.");
			return null;
		}

		try {
			output = new FileOutputStream(imagePath+fileName);
		} catch (FileNotFoundException e1) {
			System.out.println("Erreur sur le fichier d'image de destination.");
			return null;
		}

		try {
			IOUtils.copy(input, output);
			return new File(imagePath+fileName);
		} catch (IOException e) {
			System.out.println("impossible de copier l'image dnas le répertoire de destination.");
			return null;
		}

	}
	
	
	
	public static void configureFileChooser(final FileChooser fileChooser) {      
	            fileChooser.setTitle("View Pictures");
	            fileChooser.setInitialDirectory(
	                new File(System.getProperty("user.home"))
	            );                 
	            fileChooser.getExtensionFilters().addAll(
	                new FileChooser.ExtensionFilter("All Images", "*.*"),
	                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
	                new FileChooser.ExtensionFilter("PNG", "*.png")
	            );
	    }

}
