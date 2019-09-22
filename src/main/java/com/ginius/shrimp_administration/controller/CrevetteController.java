package com.ginius.shrimp_administration.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.ginius.shrimp_administration.entities.crevette.Crevettes;
import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;
import com.ginius.shrimp_administration.entities.crevette.ObjectFactory;

/**
 * 
 * @author giniu
 *
 */
public class CrevetteController {

	public static final Logger logger = Logger.getLogger(CrevetteController.class);

	ObjectFactory factory = new ObjectFactory();
	Crevettes crevettesListFactory = factory.createCrevettes();

	private static List<Crevette> crevetteList;
	private static JAXBContext ctx = null;
	private static String crevettesXmlFile = "C:\\Users\\giniu\\Documents\\shrimp-administration-data\\crevettes.xml";
	private static String inWork = "Récupération en cours...";
	private static String recupSuccess = "-Récupération réussie-";
	private static String recupFail = "-Récupération echouée-";
	private static String error = "ERREUR";

	/** Constructeur privé */
	private CrevetteController() {
	}

	/** Instance unique non préinitialisée */
	private static CrevetteController instance = null;

	/** Point d'accès pour l'instance unique du singleton */
	public static CrevetteController getInstance() {
		if (instance == null) {
			instance = new CrevetteController();
		}
		return instance;
	}

	/**
	 * retourne une liste de crevette depuis le fichier XML
	 * 
	 * @return
	 */
	public static List<Crevette> getCrevetteList() {

		if (logger.isInfoEnabled()) {
			logger.info("Tentative de récupération des crevettes");
		}

		try {
			if (logger.isInfoEnabled()) {
				logger.info(inWork);
			}
			ctx = JAXBContext.newInstance("com.ginius.shrimp_administration.entities.crevette");

			Unmarshaller unmarchaller = ctx.createUnmarshaller();
			Crevettes crevettes = (Crevettes) (unmarchaller.unmarshal(new File(crevettesXmlFile)));

			if (logger.isInfoEnabled()) {
				logger.info(recupSuccess);
			}

			return crevettes.getCrevette();

		} catch (JAXBException e) {
			logger.warn(error + recupFail + " - " + e.getMessage());

			return crevetteList;
		}

	}

	/**
	 * retourne la liste des categories depuis le fichier txt
	 * 
	 * @return
	 */
	public static List<String> getCrevetteCategoryList() {

		if (logger.isInfoEnabled()) {
			logger.info("Tentative de récupération des catégories de crevette");
		}

		List<String> crevetteCategory = new ArrayList<>();

		try (Scanner scan = new Scanner(new File("src\\main\\resources\\documents\\crevetteCategory.txt"))) {

			if (logger.isInfoEnabled()) {
				logger.info(inWork);
			}

			while (scan.hasNext()) {
				crevetteCategory.add(scan.next());
			}

			if (logger.isInfoEnabled()) {
				logger.info(recupSuccess);
			}
		} catch (FileNotFoundException e) {
			logger.warn(error + recupFail + " - " + e.getMessage());
		}

		return crevetteCategory;

	}

	/**
	 * retourne la liste des souscategories depuis le fichier txt
	 * 
	 * @return
	 */
	public static List<String> getCrevetteSousCategoryList() {

		if (logger.isInfoEnabled()) {
			logger.info("Tentative de récupération des sous catégories de crevette");
		}

		List<String> crevetteSousCategory = new ArrayList<>();
		try (Scanner scan = new Scanner(new File("src\\main\\resources\\documents\\crevetteSousCategory.txt"))) {

			if (logger.isInfoEnabled()) {
				logger.info(inWork);
			}

			while (scan.hasNext()) {
				crevetteSousCategory.add(scan.next());
			}
			if (logger.isInfoEnabled()) {
				logger.info(recupSuccess);
			}

		} catch (FileNotFoundException e) {
			logger.warn(error + recupFail + " - " + e.getMessage());
		}

		return crevetteSousCategory;

	}

	/**
	 * sauvegarde de le liste de crevette dnas le fichier XML
	 * 
	 * @param crevettesList
	 * @return
	 */
	public static boolean saveCrevetteList(Crevettes crevettesList) {

		try {
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(crevettesList, new File(crevettesXmlFile));
			return true;
		} catch (JAXBException e) {
			logger.warn(error + e.getMessage());
			return false;
		}

	}

}
