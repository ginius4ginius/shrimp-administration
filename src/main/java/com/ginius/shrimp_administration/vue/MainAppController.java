package com.ginius.shrimp_administration.vue;

import java.io.IOException;
import java.util.List;

import com.ginius.shrimp_administration.App;
import com.ginius.shrimp_administration.controller.AquariumController;
import com.ginius.shrimp_administration.controller.CrevetteController;
import com.ginius.shrimp_administration.entities.aquarium.Aquariums.Aquarium;
import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;
import com.gluonhq.charm.glisten.control.Icon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author giniu
 *
 */
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

	// éléments pour pane crevette

	@FXML
	private Label categorie;
	@FXML
	private Label souscatégorie;
	@FXML
	private Label nom;
	@FXML
	private TextField nomTf;
	@FXML
	private Label ghmin;
	@FXML
	private TextField ghminTf;
	@FXML
	private Label ghmax;
	@FXML
	private TextField ghmaxTf;
	@FXML
	private Label khmin;
	@FXML
	private TextField khminTf;
	@FXML
	private Label khmax;
	@FXML
	private TextField khmaxTf;
	@FXML
	private Label phmin;
	@FXML
	private TextField phminTf;
	@FXML
	private Label phmax;
	@FXML
	private TextField phmaxTf;
	@FXML
	private Label temperature;
	@FXML
	private TextField temperatureTf;
	@FXML
	private Label description;
	@FXML
	private TextArea descriptionTa;
	@FXML
	private Pane crevettepane;

	@FXML
	private void initialize() {
		// masque du pane crevette
		crevettepane.setVisible(false);
		description.setVisible(false);
		descriptionTa.setVisible(false);
		temperature.setVisible(false);
		temperatureTf.setVisible(false);
		categorie.setVisible(false);
		souscatégorie.setVisible(false);
		nom.setVisible(false);
		nomTf.setVisible(false);
		ghmaxTf.setVisible(false);
		ghmax.setVisible(false);
		ghminTf.setVisible(false);
		ghmin.setVisible(false);
		khmaxTf.setVisible(false);
		khmax.setVisible(false);
		khminTf.setVisible(false);
		khmin.setVisible(false);
		khmaxTf.setVisible(false);
		khmax.setVisible(false);
		khminTf.setVisible(false);
		khmin.setVisible(false);

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

	@FXML
	private void handleAfficherCrevettes() {
		// affichage du pane crevette
		nomTf.clear();
		ghmaxTf.clear();
		ghminTf.clear();
		khmaxTf.clear();
		khminTf.clear();
		khmaxTf.clear();
		khminTf.clear();
		phmaxTf.clear();
		phminTf.clear();
		temperatureTf.clear();
		crevettepane.setVisible(true);
		description.setVisible(true);
		descriptionTa.setVisible(true);
		temperature.setVisible(true);
		temperatureTf.setVisible(true);
		categorie.setVisible(true);
		souscatégorie.setVisible(true);
		nom.setVisible(true);
		nomTf.setVisible(true);
		ghmaxTf.setVisible(true);
		ghmax.setVisible(true);
		ghminTf.setVisible(true);
		ghmin.setVisible(true);
		khmaxTf.setVisible(true);
		khmax.setVisible(true);
		khminTf.setVisible(true);
		khmin.setVisible(true);
		khmaxTf.setVisible(true);
		khmax.setVisible(true);
		khminTf.setVisible(true);
		khmin.setVisible(true);

		lesCrevettes.clear();

		List<Crevette> liste = CrevetteController.getCrevetteList();

		for (Crevette c : liste) {

			Crevette crevette = new Crevette(c.getcategorie(), c.getsouscategorie(), c.getNom(), c.getGhMin(),
					c.getGhMax(), c.getKhMin(), c.getKhMax(), c.getPhMin(), c.getKhMax(), c.getTemperature(),
					c.getCrevetteID(), c.getDescription());

			lesCrevettes.add(crevette);

		}

		aquariumList.setVisible(false);
		crevettesList.setVisible(true);
		newCrevette.setVisible(true);
		delete.setVisible(true);

	}

	@FXML
	private void handleAfficherAquariums() {
		// masque du pane crevette
				crevettepane.setVisible(false);
				description.setVisible(false);
				descriptionTa.setVisible(false);
				temperature.setVisible(false);
				temperatureTf.setVisible(false);
				categorie.setVisible(false);
				souscatégorie.setVisible(false);
				nom.setVisible(false);
				nomTf.setVisible(false);
				ghmaxTf.setVisible(false);
				ghmax.setVisible(false);
				ghminTf.setVisible(false);
				ghmin.setVisible(false);
				khmaxTf.setVisible(false);
				khmax.setVisible(false);
				khminTf.setVisible(false);
				khmin.setVisible(false);
				khmaxTf.setVisible(false);
				khmax.setVisible(false);
				khminTf.setVisible(false);
				khmin.setVisible(false);

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
	 public void handleCrevetteItem(MouseEvent event) {
		System.out.println("clicked on " + crevettesList.getSelectionModel().getSelectedItem());
		
		categorie.setText(crevettesList.getSelectionModel().getSelectedItem().getcategorie());
		souscatégorie.setText(crevettesList.getSelectionModel().getSelectedItem().getsouscategorie());
		nomTf.setText(crevettesList.getSelectionModel().getSelectedItem().getNom());
		ghminTf.setText(Integer.toString(crevettesList.getSelectionModel().getSelectedItem().getGhMin()));
		ghmaxTf.setText(Integer.toString(crevettesList.getSelectionModel().getSelectedItem().getGhMax()));
		khminTf.setText(Integer.toString(crevettesList.getSelectionModel().getSelectedItem().getKhMin()));
		khmaxTf.setText(Integer.toString(crevettesList.getSelectionModel().getSelectedItem().getKhMax()));
		phminTf.setText(Double.toString(crevettesList.getSelectionModel().getSelectedItem().getPhMin()));
		phmaxTf.setText(Double.toString(crevettesList.getSelectionModel().getSelectedItem().getPhMax()));
		temperatureTf.setText(Integer.toString(crevettesList.getSelectionModel().getSelectedItem().getTemperature()));
		descriptionTa.setText(crevettesList.getSelectionModel().getSelectedItem().getDescription());
		
         
     }

	@FXML
	public void exit(MouseEvent me) throws Throwable {
		Stage stage = (Stage) exit.getScene().getWindow();
		stage.close();

	}

	@FXML
	public void newCrevette(ActionEvent event) {
		
		// masque du pane crevette
		crevettepane.setVisible(false);
		description.setVisible(false);
		descriptionTa.setVisible(false);
		temperature.setVisible(false);
		temperatureTf.setVisible(false);
		categorie.setVisible(false);
		souscatégorie.setVisible(false);
		nom.setVisible(false);
		nomTf.setVisible(false);
		ghmaxTf.setVisible(false);
		ghmax.setVisible(false);
		ghminTf.setVisible(false);
		ghmin.setVisible(false);
		khmaxTf.setVisible(false);
		khmax.setVisible(false);
		khminTf.setVisible(false);
		khmin.setVisible(false);
		khmaxTf.setVisible(false);
		khmax.setVisible(false);
		khminTf.setVisible(false);
		khmin.setVisible(false);

		aquariumList.setVisible(false);
		crevettesList.setVisible(false);

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
