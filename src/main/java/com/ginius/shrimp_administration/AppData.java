package com.ginius.shrimp_administration;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ginius.shrimp_administration.entities.crevette.Crevettes;
import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;

import javafx.fxml.FXMLLoader;

import com.ginius.shrimp_administration.entities.crevette.ObjectFactory;

/**
 * 
 * @author giniu
 *
 */
public class AppData {

	public static int crevetteId;
	public static int lastPosition;
	public static FXMLLoader loader = new FXMLLoader();

	public static void main(String[] args) {

	ObjectFactory factory = new ObjectFactory();
	Crevettes crevettesList = factory.createCrevettes();

	Crevette crevette1 = factory.createCrevettesCrevette();
	crevette1.setCrevetteID(1);
	crevette1.setcategorie("CARIDINA");
	crevette1.setsouscategorie("CANTONENSIS");
	crevette1.setNom("Tiger blue");
	crevette1.setGhMax(15);
	crevette1.setGhMin(5);
	crevette1.setKhMax(10);
	crevette1.setKhMin(0);crevette1.setPhMax(6.5);crevette1.setPhMin(7.5);crevette1.setTemperature(20);

	crevettesList.getCrevette().add(crevette1);

	Crevette crevette2 = factory.createCrevettesCrevette();

	crevette2.setCrevetteID(2);crevette2.setcategorie("NEOCARIDINA");
	crevette2.setsouscategorie("DAVIDI");
	crevette2.setNom("Sakura red");
	crevette2.setGhMax(15);
	crevette2.setGhMin(5);
	crevette2.setKhMax(10);
	crevette2.setKhMin(0);
	crevette2.setPhMax(6.5);
	crevette2.setPhMin(7.5);
	crevette2.setTemperature(20);

	crevettesList.getCrevette().add(crevette2);

	JAXBContext ctx = null;

	try
	{
		ctx = JAXBContext.newInstance("com.ginius.shrimp_administration.entities.crevette");
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.marshal(crevettesList, System.out);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(crevettesList,
				new File("C:\\Users\\giniu\\Documents\\shrimp-administration-data\\crevettes.xml"));

		System.out.println("-------------------");

		Unmarshaller unmarchaller = (Unmarshaller) ctx.createUnmarshaller();
		Crevettes crevettes = (Crevettes) (unmarchaller
				.unmarshal(new File("C:\\Users\\giniu\\Documents\\shrimp-administration-data\\crevettes.xml")));

		List<Crevette> listeFinale = crevettes.getCrevette();

		for (Crevette crevette : listeFinale) {
			System.out.println("Crevette nom : " + crevette.getNom());

		}

		System.out.println("insersion d'une nouvelle crevette et mise à jour de la liste");

		lastPosition = listeFinale.size() - 1;
		crevetteId = listeFinale.get(lastPosition).getCrevetteID() + 1;

		Crevette crevette3 = factory.createCrevettesCrevette();

		crevette3.setCrevetteID(crevetteId);
		crevette3.setcategorie("NEOCARIDINA");
		crevette3.setsouscategorie("PALMATA");
		crevette3.setNom("Blue pearl");
		crevette3.setGhMax(15);
		crevette3.setGhMin(5);
		crevette3.setKhMax(10);
		crevette3.setKhMin(0);
		crevette3.setPhMax(6.5);
		crevette3.setPhMin(7.5);
		crevette3.setTemperature(20);

		crevettesList.getCrevette().add(crevette3);

		marshaller.marshal(crevettesList, System.out);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(crevettesList,
				new File("C:\\Users\\giniu\\Documents\\shrimp-administration-data\\crevettes.xml"));

		System.out.println("-------------------");

		crevettes = (Crevettes) (unmarchaller
				.unmarshal(new File("C:\\Users\\giniu\\Documents\\shrimp-administration-data\\crevettes.xml")));

		listeFinale = crevettes.getCrevette();

		for (Crevette crevette : listeFinale) {
			System.out.println("Crevette nom : " + crevette.getNom());

		}

	}catch(
	JAXBException e)
	{ // TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
