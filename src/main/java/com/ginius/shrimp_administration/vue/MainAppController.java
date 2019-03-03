package com.ginius.shrimp_administration.vue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.ginius.shrimp_administration.App;
import com.ginius.shrimp_administration.controller.AquariumController;
import com.ginius.shrimp_administration.controller.CrevetteController;
import com.ginius.shrimp_administration.entities.aquarium.Aquariums.Aquarium;
import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;
import com.ginius.shrimp_administration.entities.crevette.CrevetteCategory;
import com.ginius.shrimp_administration.entities.crevette.Crevettes;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.impl.charm.a.b.b.t;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainAppController {

	@FXML
	private Icon delete;

	@FXML
	private Icon exit;

	@FXML
	private Button newCrevette;

	@FXML
	private ListView<Crevette> crevettesList;

	private ObservableList<Crevette> lesCrevettes = FXCollections.observableArrayList();

	@FXML
	private ListView<Aquarium> aquariumList;

	private ObservableList<Aquarium> lesAquariums = FXCollections.observableArrayList();

	App app;

	@FXML
	private void initialize() {

		crevettesList.setItems(lesCrevettes);
		crevettesList.setVisible(false);
		aquariumList.setItems(lesAquariums);
		aquariumList.setVisible(false);
		delete.setVisible(false);
		exit.setVisible(true);
		newCrevette.setVisible(false);

	}

	public ObservableList<Crevette> getLesCrevettes() {
		return lesCrevettes;
	}

	public void setLesCrevettes(ObservableList<Crevette> lesCrevettes) {
		this.lesCrevettes = lesCrevettes;
	}

	public ObservableList<Aquarium> getLesAquariums() {
		return lesAquariums;
	}

	public void setLesAquariums(ObservableList<Aquarium> lesAquariums) {
		this.lesAquariums = lesAquariums;
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void handleAfficherCrevettes() {

		lesCrevettes.clear();

		List<Crevette> liste = CrevetteController.getCrevetteList();

		for (Crevette c : liste) {

			Crevette crevette = new Crevette(c.getVariete(), c.getNom(), c.getGhMin(), c.getGhMax(), c.getKhMin(),
					c.getKhMax(), c.getPhMin(), c.getKhMax(), c.getTemperature(), c.getCrevetteID());

			lesCrevettes.add(crevette);

		}

		aquariumList.setVisible(false);
		crevettesList.setVisible(true);
		newCrevette.setVisible(true);
		delete.setVisible(true);

	}

	@SuppressWarnings("unchecked")
	@FXML
	private void handleAfficherAquariums() {

		lesAquariums.clear();

		List<Aquarium> liste = AquariumController.getAquariumList();

		for (Aquarium a : liste) {

			Aquarium aquarium = new Aquarium(a.getLongueur(), a.getLargeur(), a.getHauteur(), a.getLitrageBrut(),
					a.getLitrageNet(), a.getSubstratID(), a.getEauID(), a.getFiltrationID(), a.getEclairageID(),
					a.getCrevettes(), a.getAquariumID());

			lesAquariums.add(aquarium);

		}

		crevettesList.setVisible(false);
		aquariumList.setVisible(true);
		newCrevette.setVisible(false);
		delete.setVisible(true);

	}

	@FXML
	public void exit(MouseEvent me) throws Throwable {
		Stage stage = (Stage) exit.getScene().getWindow();
		stage.close();

	}

	@FXML
	public void newCrevette(ActionEvent event) {

		// creation chargeur pour le fichier FXML
		FXMLLoader loader = new FXMLLoader();
		// retourne l'URL à charger ainsi que son emplacement
		loader.setLocation(MainAppController.class.getResource("CrevetteInterface.fxml"));

		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scene scene = new Scene(root);

		// New window (Stage)
		Stage newWindow = new Stage();
		newWindow.setTitle("Nouvelle crevette");
		newWindow.initStyle(StageStyle.UNDECORATED);
		newWindow.setScene(scene);
		newWindow.show();

	}

}
