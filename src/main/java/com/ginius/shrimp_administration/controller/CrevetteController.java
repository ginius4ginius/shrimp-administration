package com.ginius.shrimp_administration.controller;

import java.io.File;
import java.util.List;

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

	
	
	/**
	 * retourne une liste de crevette depuis le fichier XML
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
			System.out.println(e);

			return crevetteList;
		}

	}
	
	/**
	 * sauvegarde de le liste de crevette dnas le fichier XML
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
		}catch (JAXBException e) {
			return false;
		}
		
		

		

	}

}
