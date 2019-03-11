package com.ginius.shrimp_administration.controller;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.ginius.shrimp_administration.entities.aquarium.Aquariums;
import com.ginius.shrimp_administration.entities.aquarium.Aquariums.Aquarium;
import com.ginius.shrimp_administration.entities.aquarium.ObjectFactory;

/**
 * 
 * @author giniu
 *
 */
public class AquariumController {

	ObjectFactory factory = new ObjectFactory();
	Aquariums aquariumsListFactory = factory.createAquariums();

	public static List<Aquarium> aquariumList;
	public static JAXBContext ctx = null;

	/** Constructeur privé */
	private AquariumController() {
	}

	/** Instance unique non préinitialisée */
	private static AquariumController INSTANCE = null;

	/** Point d'accès pour l'instance unique du singleton */
	public static AquariumController getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AquariumController();
		}
		return INSTANCE;
	}

	public static List<Aquarium> getAquariumList() {

		System.out.println("----Récupération des aquariums----");
		try {
			ctx = JAXBContext.newInstance("com.ginius.shrimp_administration.entities.aquarium");

			Unmarshaller unmarchaller = (Unmarshaller) ctx.createUnmarshaller();
			Aquariums aquariums = (Aquariums) (unmarchaller
					.unmarshal(new File("C:\\Users\\giniu\\Documents\\shrimp-administration-data\\aquariums.xml")));
			System.out.println("-Récupération réussie-");
			return aquariums.getAquarium();

		} catch (Exception e) {
			System.out.println(e);

			return aquariumList;
		}

	}

}
