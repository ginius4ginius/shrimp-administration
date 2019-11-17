package com.ginius.shrimp_administration.vue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.stage.FileChooser;

import com.ginius.shrimp_administration.App;
import com.ginius.shrimp_administration.controller.AquariumController;
import com.ginius.shrimp_administration.controller.CrevetteController;
import com.ginius.shrimp_administration.dao.CrevetteDao;
import com.ginius.shrimp_administration.entities.aquarium.Aquariums.Aquarium;
import com.ginius.shrimp_administration.entities.aquarium.Aquariums.Aquarium.DataAquarium;
import com.ginius.shrimp_administration.entities.crevette.Crevettes;
import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;
import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette.CrevetteData;
import com.ginius.shrimp_administration.gestionnaireFichier.GestionnaireFichier;
import com.ginius.shrimp_administration.gestionnaireFichier.GestionnaireFichierImp;
import com.ginius.shrimp_administration.validation.Validation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
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

	private Stage newCrevetteWindow;
	private Stage mainWindow;

	int crevetteId;
	int crevettePossede;

	@FXML
	private Button delete;

	@FXML
	private Button saveCrevette;

	@FXML
	private Button exit;

	@FXML
	private Button newCrevette;

	@FXML
	private ListView<Crevette> crevettesList;

	private ObservableList<Crevette> lesCrevettes = FXCollections.observableArrayList();

	@FXML
	private ListView<Aquarium> aquariumList;

	private ObservableList<Aquarium> lesAquariums = FXCollections.observableArrayList();

	App app;

	CrevetteDao crevetteDao;
	List<Crevette> liste = new ArrayList<Crevette>();

	// éléments pour pane crevette
	@FXML
	private Label categorie;
	@FXML
	private Label souscategorie;
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
	private Label paraMaintenance;
	@FXML
	private TextArea descriptionTa;
	@FXML
	private Pane crevettepane;
	@FXML
	private ToggleButton crevettePossedeCb;
	@FXML
	private Separator separator;
	@FXML
	private ImageView imageCrevette;

	private File fileImageCrevette;

	private FileChooser fileChooser;
	
	private GestionnaireFichier gestionnaireFichier;
	
	

	@FXML
	private void initialize() {
		
		gestionnaireFichier = new GestionnaireFichierImp("crevette");
		crevetteDao = new CrevetteDao();
		List<Crevette> crevetteList = new ArrayList<Crevette>();
		crevetteList = CrevetteController.getCrevetteList();

		crevetteDao.initialiseCrevette(crevetteList);

		String path = gestionnaireFichier.getDefaultpath();

		fileImageCrevette = new File(path);
		Image image = new Image(fileImageCrevette.toURI().toString());
		imageCrevette.setImage(image);
		imageCrevette.setFitHeight(250);
		imageCrevette.setX(100);

		// masque du pane crevette
		crevettepane.setVisible(false);
		description.setVisible(false);
		imageCrevette.setVisible(false);
		paraMaintenance.setVisible(false);
		separator.setVisible(false);
		descriptionTa.setVisible(false);
		temperature.setVisible(false);
		temperatureTf.setVisible(false);
		categorie.setVisible(false);
		souscategorie.setVisible(false);
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
		crevettePossedeCb.setVisible(false);
		crevettePossedeCb.setSelected(false);

		crevettesList.setItems(lesCrevettes);
		crevettesList.setVisible(false);
		aquariumList.setItems(lesAquariums);
		aquariumList.setVisible(false);
		delete.setVisible(false);
		exit.setVisible(true);
		saveCrevette.setVisible(false);
		newCrevette.setVisible(false);

		// gestion des bulles d'aide
		nomTf.setTooltip(new Tooltip("Texte entre 1 et 20 caractères."));
		ghminTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères."));
		ghmaxTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères."));
		khminTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères."));
		khmaxTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères."));
		phminTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères avec virgule."));
		phmaxTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères avec virgule."));
		temperatureTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères."));
		descriptionTa.setTooltip(new Tooltip("Texte entre 1 et 200 caractères."));

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

	/**
	 * Méthode qui supprime la crevette selectionnée dans la liste
	 */
	@FXML
	private void deleteCrevette() {

		crevetteId = crevettesList.getSelectionModel().getSelectedItem().getCrevetteID();

		if (crevetteDao.deleteCrevette(crevetteId)) {
			crevettesList.setVisible(false);
			// masque du pane crevette
			crevettepane.setVisible(false);
			description.setVisible(false);
			paraMaintenance.setVisible(false);
			imageCrevette.setVisible(false);
			separator.setVisible(false);
			descriptionTa.clear();
			descriptionTa.setVisible(false);
			temperature.setVisible(false);
			temperatureTf.setVisible(false);
			categorie.setVisible(false);
			souscategorie.setVisible(false);
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
			crevettePossedeCb.setVisible(false);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Crevette supprimée avec succés.");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("problème rencontré, crevette non supprimée.");
		}

	}

	/**
	 * Méthode qui affiche le bloc d'information des crevettes
	 */
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
		paraMaintenance.setVisible(true);
		imageCrevette.setVisible(true);
		separator.setVisible(true);
		descriptionTa.setVisible(true);
		temperature.setVisible(true);
		temperatureTf.setVisible(true);
		categorie.setVisible(true);
		souscategorie.setVisible(true);
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
		crevettePossedeCb.setVisible(true);
		crevettePossedeCb.setSelected(false);

		String path = gestionnaireFichier.getDefaultpath();
		fileImageCrevette = new File(path);
		Image image = new Image(fileImageCrevette.toURI().toString());
		imageCrevette.setImage(image);

		refreshCrevetteList();

		aquariumList.setVisible(false);
		crevettesList.setVisible(true);

		saveCrevette.setVisible(true);
		newCrevette.setVisible(true);
		delete.setVisible(true);

	}

	/**
	 * Méthode qui affiche le bloc d'information des aquariums
	 */
	@FXML
	private void handleAfficherAquariums() {
		// masque du pane crevette
		crevettepane.setVisible(false);
		description.setVisible(false);
		paraMaintenance.setVisible(false);
		imageCrevette.setVisible(false);
		separator.setVisible(false);
		descriptionTa.setVisible(false);
		temperature.setVisible(false);
		temperatureTf.setVisible(false);
		categorie.setVisible(false);
		souscategorie.setVisible(false);
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
		crevettePossedeCb.setVisible(false);

		lesAquariums.clear();

		List<Aquarium> liste = AquariumController.getAquariumList();

		for (Aquarium a : liste) {
			DataAquarium dataAquarium = new DataAquarium();
			dataAquarium.setLongueur(a.getLongueur());
			dataAquarium.setLargeur(a.getLargeur());
			dataAquarium.setHauteur(a.getHauteur());
			dataAquarium.setLitrageBrut(a.getLitrageBrut());
			dataAquarium.setLitrageNet(a.getLitrageNet());
			dataAquarium.setSubstratID(a.getSubstratID());
			dataAquarium.setEauID(a.getEauID());
			dataAquarium.setFiltrationID(a.getFiltrationID());
			dataAquarium.setEclairageID(a.getEclairageID());
			dataAquarium.setCrevettes(a.getCrevettes());
			dataAquarium.setAquariumID(a.getAquariumID());
			

			Aquarium aquarium = new Aquarium(dataAquarium);

			lesAquariums.add(aquarium);

		}

		crevettesList.setVisible(false);
		aquariumList.setVisible(true);
		newCrevette.setVisible(false);
		saveCrevette.setVisible(false);
		delete.setVisible(false);

	}

	/**
	 * Méthode qui affiche les informations de la crevette de la liste dans les
	 * champs prévus a cet effet.
	 * 
	 * @param event
	 */
	@FXML
	public void handleCrevetteItem(MouseEvent event) {

		categorie.setText(crevettesList.getSelectionModel().getSelectedItem().getCategorie());
		souscategorie.setText(crevettesList.getSelectionModel().getSelectedItem().getSousCategorie());
		nomTf.setText(crevettesList.getSelectionModel().getSelectedItem().getNom());
		ghminTf.setText(Integer.toString(crevettesList.getSelectionModel().getSelectedItem().getGhMin()));
		ghmaxTf.setText(Integer.toString(crevettesList.getSelectionModel().getSelectedItem().getGhMax()));
		khminTf.setText(Integer.toString(crevettesList.getSelectionModel().getSelectedItem().getKhMin()));
		khmaxTf.setText(Integer.toString(crevettesList.getSelectionModel().getSelectedItem().getKhMax()));
		phminTf.setText(Double.toString(crevettesList.getSelectionModel().getSelectedItem().getPhMin()));
		phmaxTf.setText(Double.toString(crevettesList.getSelectionModel().getSelectedItem().getPhMax()));
		temperatureTf.setText(Integer.toString(crevettesList.getSelectionModel().getSelectedItem().getTemperature()));
		descriptionTa.setText(crevettesList.getSelectionModel().getSelectedItem().getDescription());

		String path = crevettesList.getSelectionModel().getSelectedItem().getImage();
		
		
		if (path.length() == 4) {
			fileImageCrevette = new File(gestionnaireFichier.getDefaultpath());
			Image image = new Image(fileImageCrevette.toURI().toString());
			imageCrevette.setImage(image);
			
		} else {
			fileImageCrevette = new File(path);
			Image image = new Image(fileImageCrevette.toURI().toString());
			imageCrevette.setImage(image);

		}

		if (crevettesList.getSelectionModel().getSelectedItem().getPossede() == 1) {
			crevettePossedeCb.setSelected(true);
		} else
			crevettePossedeCb.setSelected(false);

	}

	/**
	 * Méthode permettant de fermer la fenêtre courante.
	 * 
	 * @param me
	 * @throws Throwable
	 */
	@FXML
	public void exit(ActionEvent event) throws Throwable {

		Crevettes list = new Crevettes();
		List<Crevette> liste = crevetteDao.getCrevetteList();

		for (Crevette c : liste) {
			list.getCrevette().add(c);
		}

		CrevetteController.saveCrevetteList(list);
		Stage stage = (Stage) exit.getScene().getWindow();
		stage.close();

	}

	@FXML
	public void newCrevette(ActionEvent event) {

		// masque du pane crevette
		crevettepane.setVisible(false);
		description.setVisible(false);
		paraMaintenance.setVisible(false);
		imageCrevette.setVisible(false);
		separator.setVisible(false);
		descriptionTa.setVisible(false);
		temperature.setVisible(false);
		temperatureTf.setVisible(false);
		categorie.setVisible(false);
		souscategorie.setVisible(false);
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
		crevettePossedeCb.setVisible(false);
		crevettePossedeCb.setSelected(false);

		aquariumList.setVisible(false);
		crevettesList.setVisible(false);

		newCrevette.setVisible(false);
		saveCrevette.setVisible(false);
		delete.setVisible(false);

		// creation chargeur pour le fichier FXML
		FXMLLoader NewCrevetteloader = new FXMLLoader();
		// retourne l'URL à charger ainsi que son emplacement
		NewCrevetteloader.setLocation(MainAppController.class.getResource("CrevetteInterface.fxml"));

		Parent root = null;
		try {
			root = NewCrevetteloader.load();

		} catch (IOException e) {
			e.printStackTrace();
		}

		Scene scene = new Scene(root);

		newCrevetteWindow = new Stage();
		newCrevetteWindow.setTitle("Nouvelle crevette");
		newCrevetteWindow.initStyle(StageStyle.UNDECORATED);
		newCrevetteWindow.setScene(scene);

		newCrevetteWindow.show();

	}

	/**
	 * Méthode qui supprime la crevette selectionnée dans la liste
	 */
	@FXML
	private void updateCrevette() {

		int index = crevettesList.getSelectionModel().getSelectedIndex();

		if (pasDeChampsVides() && pasDeChampsIncorrectes()) {

			crevetteId = crevettesList.getSelectionModel().getSelectedItem().getCrevetteID();
			if (crevettePossedeCb.isSelected()) {
				crevettePossede = 1;
			} else
				crevettePossede = 0;
			
			CrevetteData crevetteData = new CrevetteData();
			crevetteData.setCrevetteID(crevetteId);
			crevetteData.setCategorie(categorie.getText());
			crevetteData.setNom(nomTf.getText());
			crevetteData.setSousCategorie(souscategorie.getText());
			crevetteData.setGhMin(Integer.parseInt(ghmaxTf.getText()));
			crevetteData.setGhMax(Integer.parseInt(ghminTf.getText()));
			crevetteData.setKhMin(Integer.parseInt(khminTf.getText()));
			crevetteData.setKhMax(Integer.parseInt(khmaxTf.getText()));
			crevetteData.setPhMin(Double.parseDouble(phminTf.getText()));
			crevetteData.setPhMax(Double.parseDouble(phmaxTf.getText()));
			crevetteData.setTemperature(Integer.parseInt(temperatureTf.getText()));
			crevetteData.setDescription(descriptionTa.getText());
			crevetteData.setPossede(crevettePossede);
			
			if(gestionnaireFichier.isDeffaultImage(fileImageCrevette)) {
				crevetteData.setImage(gestionnaireFichier.copier(fileImageCrevette).getAbsolutePath().toString());
			}else {
				crevetteData.setImage(fileImageCrevette.getAbsolutePath().toString());
			}
			

			Crevette crevette = new Crevette(crevetteData);

			if (crevetteDao.updateCrevette(crevette)) {
				refreshCrevetteList();
				crevettesList.getSelectionModel().select(index);

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("Crevette modifiée avec succés");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("problème rencontré, crevette non modifiée.");
			}

		}

	}

	public void refreshCrevetteList() {

		lesCrevettes.clear();
		liste = crevetteDao.getCrevetteList();

		for (Crevette c : liste) {
			
			CrevetteData crevetteData = new CrevetteData();
			crevetteData.setCrevetteID(c.getCrevetteID());
			crevetteData.setCategorie(c.getCategorie());
			crevetteData.setNom(c.getNom());
			crevetteData.setSousCategorie(c.getSousCategorie());
			crevetteData.setGhMin(c.getGhMin());
			crevetteData.setGhMax(c.getGhMax());
			crevetteData.setKhMin(c.getKhMin());
			crevetteData.setKhMax(c.getKhMax());
			crevetteData.setPhMin(c.getPhMin());
			crevetteData.setPhMax(c.getPhMax());
			crevetteData.setTemperature(c.getTemperature());
			crevetteData.setDescription(c.getDescription());
			crevetteData.setPossede(c.getPossede());
			crevetteData.setImage(c.getImage());

			Crevette crevette = new Crevette(crevetteData);

			lesCrevettes.add(crevette);

		}
	}

	/**
	 * Vérifie si un champs du formulaire est vide.
	 * 
	 * @return
	 */
	private boolean pasDeChampsVides() {

		String nom = nomTf.getText();
		String ghmax = ghmaxTf.getText();
		String ghmin = ghminTf.getText();
		String khmax = khmaxTf.getText();
		String khmin = khminTf.getText();
		String phmax = phmaxTf.getText();
		String phmin = phminTf.getText();
		String temperature = temperatureTf.getText();
		if (nom.isEmpty() || ghmax.isEmpty() || ghmin.isEmpty() || khmax.isEmpty() || khmin.isEmpty() || phmax.isEmpty()
				|| phmin.isEmpty() || temperature.isEmpty()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Informations incomplètes");
			alert.setHeaderText("Compléter les champs indiqués");
			if (nom.isEmpty())
				nomTf.setPromptText("à compléter");
			if (ghmax.isEmpty())
				ghmaxTf.setPromptText("à compléter");
			if (ghmin.isEmpty())
				ghminTf.setPromptText("à compléter");
			if (khmax.isEmpty())
				khmaxTf.setPromptText("à compléter");
			if (khmin.isEmpty())
				khminTf.setPromptText("à compléter");
			if (phmax.isEmpty())
				phmaxTf.setPromptText("à compléter");
			if (phmin.isEmpty())
				phminTf.setPromptText("à compléter");
			if (temperature.isEmpty())
				temperatureTf.setPromptText("à compléter");

			alert.showAndWait();
			return false;
		} else
			return true;
	}

	/**
	 * Vérifie si un champs du formulaire est de mauvais type.
	 * 
	 * @return
	 */
	private boolean pasDeChampsIncorrectes() {

		String messageErreur = "";
		String nom = nomTf.getText();
		String ghmax = ghmaxTf.getText();
		String ghmin = ghminTf.getText();
		String khmax = khmaxTf.getText();
		String khmin = khminTf.getText();
		String phmax = phmaxTf.getText();
		String phmin = phminTf.getText();
		String temperature = temperatureTf.getText();
		String description = descriptionTa.getText();
		if (nom.length() > 20 || Validation.errTypeInteger(ghmax) || Validation.errTypeInteger(ghmin)
				|| Validation.errTypeInteger(khmax) || Validation.errTypeInteger(khmin)
				|| Validation.errTypeIntegerOrDouble(phmin) || Validation.errTypeIntegerOrDouble(phmax)
				|| Validation.errTypeInteger(temperature) || description.length() > 2000) {
			if (nom.length() > 20)
				messageErreur = messageErreur + " Nom : moin de 20 caractères";
			if (Validation.errTypeInteger(ghmax))
				messageErreur = messageErreur + " gh Max : invalide";
			if (Validation.errTypeInteger(ghmin))
				messageErreur = messageErreur + " gh Min : invalide";
			if (Validation.errTypeInteger(khmax))
				messageErreur = messageErreur + " kh Max : invalide";
			if (Validation.errTypeInteger(khmin))
				messageErreur = messageErreur + " kh Min : invalide";
			if (Validation.errTypeIntegerOrDouble(phmax))
				messageErreur = messageErreur + " ph Max : invalide";
			if (Validation.errTypeIntegerOrDouble(phmin))
				messageErreur = messageErreur + " ph Min : invalide";
			if (Validation.errTypeInteger(temperature))
				messageErreur = messageErreur + " temperature : invalide";
			if (description.length() > 2000)
				messageErreur = messageErreur + " Description : moin de 2000 caractères";

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Informations incomplètes");
			alert.setHeaderText(messageErreur);

			alert.showAndWait();
			return false;
		} else
			return true;
	}

	@FXML
	public void updateCrevetteImage(MouseEvent event) {

		fileChooser = new FileChooser();
		gestionnaireFichier.configureFileChooser(fileChooser);
		File file = fileChooser.showOpenDialog(mainWindow);
		if (file != null) {
			String path = file.getAbsolutePath().toString();
			fileImageCrevette = new File(path);
			Image image = new Image(fileImageCrevette.toURI().toString());
			imageCrevette.setImage(image);
		}

	}

}
