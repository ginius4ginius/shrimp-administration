package com.ginius.shrimp_administration.vue;

import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;

import com.ginius.shrimp_administration.controller.CrevetteController;
import com.ginius.shrimp_administration.entities.crevette.*;

/**
 * 
 * @author giniu
 *
 */
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
	private Button exit;

	@FXML
	private Button saveCrevette;

	@FXML
	private ComboBox<String> crevetteCategoryList;

	private ObservableList<String> obsListcrevetteCategory = FXCollections.observableArrayList();

	@FXML
	private ComboBox<String> crevetteSousCategoryList;

	private ObservableList<String> obsListcrevetteSousCategory = FXCollections.observableArrayList();

	List<Crevette> listeInitiale;

	@FXML
	private TextArea descriptionTa;

	@FXML
	private void initialize() {

		// gestion de la combobox

		List<String> listCategory = CrevetteController.getCrevetteCategoryList();
		List<String> listSousCategory = CrevetteController.getCrevetteSousCategoryList();

		for (String s : listCategory) {
			obsListcrevetteCategory.add(s);
		}

		crevetteCategoryList.getItems().setAll(obsListcrevetteCategory);
		crevetteCategoryList.getSelectionModel().select(1);

		
		for (String s : listSousCategory) {
			obsListcrevetteSousCategory.add(s);
		}

		crevetteSousCategoryList.getItems().setAll(obsListcrevetteSousCategory);
		crevetteSousCategoryList.getSelectionModel().select(1);

		// gestion des boutons
		exit.setVisible(true);
		saveCrevette.setVisible(true);

	}

	/**
	 * méthode permettant de sauvegarder l'entité crevette créé dans le fichier XML.
	 */
	@FXML
	private void saveCrevette() {

		if (pasDeChampsVides() && pasDeChampsIncorrectes()) {
			// récupération de la liste des crevettes.
			listeInitiale = CrevetteController.getCrevetteList();

			// génération d'un nouvel identifiant
			lastPosition = listeInitiale.size() - 1;
			crevetteId = listeInitiale.get(lastPosition).getCrevetteID() + 1;

			// création d'une nouvel objetfactory
			ObjectFactory factory = new ObjectFactory();
			Crevettes crevettesList = factory.createCrevettes();
			Crevette crevette = factory.createCrevettesCrevette();

			crevette.setCrevetteID(crevetteId);
			crevette.setcategorie(crevetteCategoryList.getSelectionModel().getSelectedItem().toString());
			crevette.setsouscategorie(crevetteSousCategoryList.getSelectionModel().getSelectedItem().toString());
			crevette.setNom(nomTf.getText());
			crevette.setGhMax(Integer.parseInt(ghMaxTf.getText()));
			crevette.setGhMin(Integer.parseInt(ghMinTf.getText()));
			crevette.setKhMax(Integer.parseInt(khMaxTf.getText()));
			crevette.setKhMin(Integer.parseInt(khMinTf.getText()));
			crevette.setPhMax(Double.parseDouble(phMaxTf.getText()));
			crevette.setPhMin(Double.parseDouble(phMinTf.getText()));
			crevette.setTemperature(Integer.parseInt(temperatureTf.getText()));

			if (descriptionTa.lengthProperty().get() > 0) {
				crevette.setDescription(descriptionTa.getText());
			}

			listeInitiale.add(crevette);
			// ajout de la crevette dans la liste initiale
			crevettesList.getCrevette().addAll(listeInitiale);

			// génération du fichier XML avec la liste mise à jour
			if (CrevetteController.saveCrevetteList(crevettesList)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("Crevette ajoutée avec succés");
				alert.showAndWait();

				// rafraichissement des textFields
				nomTf.setPromptText("");
				ghMaxTf.setPromptText("");
				ghMinTf.setPromptText("");
				khMaxTf.setPromptText("");
				khMinTf.setPromptText("");
				phMaxTf.setPromptText("");
				phMinTf.setPromptText("");
				temperatureTf.setPromptText("");
				nomTf.clear();
				ghMinTf.clear();
				ghMaxTf.clear();
				khMinTf.clear();
				khMaxTf.clear();
				phMinTf.clear();
				phMaxTf.clear();
				temperatureTf.clear();
				descriptionTa.clear();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("problème rencontré, crevette non ajoutée");
			}
		}
	}

	/**
	 * Vérifie si un champs du formulaire est vide.
	 * 
	 * @return
	 */
	private boolean pasDeChampsVides() {

		String nom = nomTf.getText();
		String ghmax = ghMaxTf.getText();
		String ghmin = ghMinTf.getText();
		String khmax = khMaxTf.getText();
		String khmin = khMinTf.getText();
		String phmax = phMaxTf.getText();
		String phmin = phMinTf.getText();
		String temperature = temperatureTf.getText();
		if (nom.isEmpty() || ghmax.isEmpty() || ghmin.isEmpty() || khmax.isEmpty() || khmin.isEmpty() || phmax.isEmpty()
				|| phmin.isEmpty() || temperature.isEmpty()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Informations incomplètes");
			alert.setHeaderText("Compléter les champs indiqués");
			if (nom.isEmpty())
				nomTf.setPromptText("à compléter");
			if (ghmax.isEmpty())
				ghMaxTf.setPromptText("à compléter");
			if (ghmin.isEmpty())
				ghMinTf.setPromptText("à compléter");
			if (khmax.isEmpty())
				khMaxTf.setPromptText("à compléter");
			if (khmin.isEmpty())
				khMinTf.setPromptText("à compléter");
			if (phmax.isEmpty())
				phMaxTf.setPromptText("à compléter");
			if (phmin.isEmpty())
				phMinTf.setPromptText("à compléter");
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
		String ghmax = ghMaxTf.getText();
		String ghmin = ghMinTf.getText();
		String khmax = khMaxTf.getText();
		String khmin = khMinTf.getText();
		String phmax = phMaxTf.getText();
		String phmin = phMinTf.getText();
		String temperature = temperatureTf.getText();
		if (nom.length() > 20 || errTypeInteger(ghmax) || errTypeInteger(ghmin) || errTypeInteger(khmax)
				|| errTypeInteger(khmin) || errTypeDouble(phmin) || errTypeDouble(phmax)
				|| errTypeInteger(temperature)) {
			if (nom.length() > 20)
				messageErreur = messageErreur + " Nom : moin de 20 caractères";
			if (errTypeInteger(ghmax))
				messageErreur = messageErreur + " gh Max : invalide";
			if (errTypeInteger(ghmin))
				messageErreur = messageErreur + " gh Min : invalide";
			if (errTypeInteger(khmax))
				messageErreur = messageErreur + " kh Max : invalide";
			if (errTypeInteger(khmin))
				messageErreur = messageErreur + " kh Min : invalide";
			if (errTypeDouble(phmax))
				messageErreur = messageErreur + " ph Max : invalide";
			if (errTypeDouble(phmin))
				messageErreur = messageErreur + " ph Max : invalide";
			if (errTypeInteger(temperature))
				messageErreur = messageErreur + " temperature : invalide";

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Informations incomplètes");
			alert.setHeaderText(messageErreur);

			alert.showAndWait();
			return false;
		} else
			return true;
	}

	/**
	 * méthode qui valide le type composé de numérique.
	 * 
	 * @param text
	 * @return
	 */
	private boolean errTypeInteger(String text) {
		
		String patterString = "[0-9]{2}";
		Pattern pattern = Pattern.compile(patterString);
		Matcher matcher = pattern.matcher(text);
		if (matcher.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * méthode qui valide le type composé de numérique.
	 * 
	 * @param text
	 * @return
	 */
	private boolean errTypeDouble(String text) {

		String patterString = "[0-9]{2}(\\.[0-9]{2})";
		Pattern pattern = Pattern.compile(patterString);
		Matcher matcher = pattern.matcher(text);
		if (matcher.matches()) {
			return false;
		}
		return true;

	}

	/**
	 * méthode permettant de fermer la fenêtre courante.
	 * 
	 * @param me
	 * @throws Throwable
	 */
	@FXML
	public void exit(ActionEvent event) throws Throwable {
		Stage stage = (Stage) exit.getScene().getWindow();
		stage.close();

	}

}
