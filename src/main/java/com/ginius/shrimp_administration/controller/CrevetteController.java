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

import com.ginius.shrimp_administration.entities.crevette.Crevettes;
import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;
import com.ginius.shrimp_administration.entities.crevette.ObjectFactory;

/**
 * 
 * @author giniu
 *
 */
public class CrevetteController {

	ObjectFactory factory = new ObjectFactory();
	Crevettes crevettesListFactory = factory.createCrevettes();

	public static List<Crevette> crevetteList;
	public static JAXBContext ctx = null;

	/** Constructeur privé */
	private CrevetteController() {
	}

	/** Instance unique non préinitialisée */
	private static CrevetteController INSTANCE = null;

	/** Point d'accès pour l'instance unique du singleton */
	public static CrevetteController getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CrevetteController();
		}
		return INSTANCE;
	}

	/**
	 * retourne une liste de crevette depuis le fichier XML
	 * 
	 * @return
	 */
	public static List<Crevette> getCrevetteList() {

		System.out.println("----Récupération des crevettes----");
		try {
			ctx = JAXBContext.newInstance("com.ginius.shrimp_administration.entities.crevette");

			Unmarshaller unmarchaller = (Unmarshaller) ctx.createUnmarshaller();
			Crevettes crevettes = (Crevettes) (unmarchaller
					.unmarshal(new File("C:\\Users\\giniu\\Documents\\shrimp-administration-data\\crevettes.xml")));
			System.out.println("-Récupération réussie-");
			return crevettes.getCrevette();

		} catch (JAXBException e) {
			System.out.println(e.getMessage());

			return crevetteList;
		}

	}

	/**
	 * retourne la liste des categories depuis le fichier txt
	 * 
	 * @return
	 */
	public static List<String> getCrevetteCategoryList() {

		System.out.println("----Récupération de la catégorie des crevettes----");
		// String path=new File(".").getAbsolutePath();
		// System.out.println(path);

		List<String> crevetteCategory = new ArrayList<String>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File("src\\main\\resources\\documents\\crevetteCategory.txt"));
			System.out.println("-Récupération réussie-");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		while (scan.hasNext()) {
			crevetteCategory.add(scan.next());
		}

		return crevetteCategory;

	}

	/**
	 * retourne la liste des souscategories depuis le fichier txt
	 * 
	 * @return
	 */
	public static List<String> getCrevetteSousCategoryList() {

		System.out.println("----Récupération de la souscatégorie des crevettes----");

		List<String> crevetteSousCategory = new ArrayList<String>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File("src\\main\\resources\\documents\\crevetteSousCategory.txt"));
			System.out.println("-Récupération réussie-");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("-Récupération echouée-");
		}
		while (scan.hasNext()) {
			crevetteSousCategory.add(scan.next());
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
			marshaller.marshal(crevettesList, System.out);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(crevettesList,
					new File("C:\\Users\\giniu\\Documents\\shrimp-administration-data\\crevettes.xml"));
			return true;
		} catch (JAXBException e) {
			return false;
		}

	}

}
