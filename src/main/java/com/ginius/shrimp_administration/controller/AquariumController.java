package com.ginius.shrimp_administration.controller;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.ginius.shrimp_administration.entities.aquarium.Aquariums;
import com.ginius.shrimp_administration.entities.aquarium.Aquariums.Aquarium;
import com.ginius.shrimp_administration.entities.aquarium.ObjectFactory;

/**
 * 
 * @author giniu
 *
 */
public class AquariumController {

	public static final Logger logger = Logger.getLogger(AquariumController.class);

	ObjectFactory factory = new ObjectFactory();
	Aquariums aquariumsListFactory = factory.createAquariums();

	private static List<Aquarium> aquariumList;
	private static String aquarium = "C:\\Users\\giniu\\Documents\\shrimp-administration-data\\aquariums.xml";

	/** Constructeur privé */
	private AquariumController() {
	}

	/** Instance unique non préinitialisée */
	private static AquariumController instance = null;

	/** Point d'accès pour l'instance unique du singleton */
	public static AquariumController getInstance() {
		if (instance == null) {
			instance = new AquariumController();
		}
		return instance;
	}

	public static List<Aquarium> getAquariumList() {

		if (logger.isInfoEnabled()) {
			logger.info("Tentative de récupération des aquariums");
		}

		try {
			if (logger.isInfoEnabled()) {
				logger.info("Récupération en cours...");
			}
			JAXBContext ctx = JAXBContext.newInstance("com.ginius.shrimp_administration.entities.aquarium");

			Unmarshaller unmarchaller = ctx.createUnmarshaller();
			Aquariums aquariums = (Aquariums) (unmarchaller.unmarshal(new File(aquarium)));

			if (logger.isInfoEnabled()) {
				logger.info("Récupération terminée avec succés");
			}

			return aquariums.getAquarium();

		} catch (Exception e) {
			logger.warn("ERREUR : erreur lors de la récupération des aquarium - " + e.getMessage());

			return aquariumList;
		}

	}

}
