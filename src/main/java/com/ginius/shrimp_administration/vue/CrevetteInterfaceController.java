package com.ginius.shrimp_administration.vue;

import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;
import com.ginius.shrimp_administration.vue.MainAppController;
import com.gluonhq.charm.glisten.control.Icon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ginius.shrimp_administration.controller.AquariumController;
import com.ginius.shrimp_administration.entities.aquarium.Aquariums.Aquarium;
import com.ginius.shrimp_administration.entities.crevette.*;
import com.ginius.shrimp_administration.entities.crevette.CrevetteCategory;

public class CrevetteInterfaceController {

	private int crevetteId;
	private int lastPosition;
	JAXBContext ctx = null;

	@FXML
	private TextField nomTf;

	@FXML
	private TextField ghMinTf;

	@FXML
	private TextField ghMaxTf;

	@FXML
	private TextField khMinTf;

	@FXML
	private TextField khMaxTf;

	@FXML
	private TextField phMinTf;

	@FXML
	private TextField phMaxTf;

	@FXML
	private TextField temperatureTf;

	@FXML
	private Icon exit;

	@FXML
	private Button saveCrevette;

	@FXML
	private ComboBox<String> crevetteCategoryList;

	private ObservableList<String> obsListcrevetteCategory = FXCollections.observableArrayList();

	List<Crevette> listeInitiale;

	@FXML
	private void initialize() {

		// gestion de la combobox

		CrevetteCategory[] listCategory = CrevetteCategory.values();

		for (CrevetteCategory s : listCategory) {
			obsListcrevetteCategory.add(s.name());
		}

		crevetteCategoryList.getItems().setAll(obsListcrevetteCategory);
		crevetteCategoryList.getSelectionModel().select(1);

		// gestion des boutons
		exit.setVisible(true);
		saveCrevette.setVisible(true);

	}

	@FXML
	private void saveCrevette() {

		// on transformer le fichier XML en objet de type liste pour récupérer la liste
		// des crevettes
		try {
			ctx = JAXBContext.newInstance("com.ginius.shrimp_administration.entities.crevette");
			Unmarshaller unmarchaller = null;
			unmarchaller = (Unmarshaller) ctx.createUnmarshaller();
			Crevettes crevettes = null;
			crevettes = (Crevettes) (unmarchaller
					.unmarshal(new File("C:\\Users\\giniu\\Documents\\shrimp-administration-data\\crevettes.xml")));
			listeInitiale = crevettes.getCrevette();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		// génération d'un nouvel identifiant
		lastPosition = listeInitiale.size() - 1;
		crevetteId = listeInitiale.get(lastPosition).getCrevetteID() + 1;

		// création d'une nouvel objetfactory
		ObjectFactory factory = new ObjectFactory();
		Crevettes crevettesList = factory.createCrevettes();
		Crevette crevette = factory.createCrevettesCrevette();

		crevette.setCrevetteID(crevetteId);
		crevette.setVariete(crevetteCategoryList.getSelectionModel().getSelectedItem().toString());
		crevette.setNom(nomTf.getText());
		crevette.setGhMax(Integer.parseInt(ghMaxTf.getText()));
		crevette.setGhMin(Integer.parseInt(ghMinTf.getText()));
		crevette.setKhMax(Integer.parseInt(khMaxTf.getText()));
		crevette.setKhMin(Integer.parseInt(khMinTf.getText()));
		crevette.setPhMax(Double.parseDouble(phMaxTf.getText()));
		crevette.setPhMin(Double.parseDouble(phMinTf.getText()));
		crevette.setTemperature(Integer.parseInt(temperatureTf.getText()));
		listeInitiale.add(crevette);
		crevettesList.getCrevette().addAll(listeInitiale);

		try {
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.marshal(crevettesList, System.out);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(crevettesList,
					new File("C:\\Users\\giniu\\Documents\\shrimp-administration-data\\crevettes.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		/*
		 * MainAppController mainAppController = new MainAppController();
		 * ObservableList<Crevette> listeCrevetteMain =
		 * mainAppController.getLesCrevettes(); listeCrevetteMain.add(crevette);
		 */

	}

	@FXML
	public void exit(MouseEvent me) throws Throwable {
		Stage stage = (Stage) exit.getScene().getWindow();
		stage.close();

	}

}
