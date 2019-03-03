package com.ginius.shrimp_administration.controller;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.ginius.shrimp_administration.entities.crevette.Crevettes;
import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;
import com.ginius.shrimp_administration.entities.crevette.ObjectFactory;

public class CrevetteController {

	ObjectFactory factory = new ObjectFactory();
	Crevettes crevettesListFactory = factory.createCrevettes();

	public static List<Crevette> crevetteList;
	public static JAXBContext ctx = null;

	public static List<Crevette> getCrevetteList() {

		System.out.println("----Récupération des crevettes----");
		try {
			ctx = JAXBContext.newInstance("com.ginius.shrimp_administration.entities.crevette");

			Unmarshaller unmarchaller = (Unmarshaller) ctx.createUnmarshaller();
			Crevettes crevettes = (Crevettes) (unmarchaller
					.unmarshal(new File("C:\\Users\\giniu\\Documents\\shrimp-administration-data\\crevettes.xml")));
			System.out.println("-Récupération réussie-");
			return crevettes.getCrevette();

		} catch (Exception e) {
			System.out.println(e);

			return crevetteList;
		}

	}

}
