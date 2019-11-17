package com.ginius.shrimp_administration.vue;

import com.ginius.shrimp_administration.entities.crevette.Crevettes.Crevette;
import com.ginius.shrimp_administration.gestionnaireFichier.GestionnaireFichier;
import com.ginius.shrimp_administration.gestionnaireFichier.GestionnaireFichierImp;
import com.ginius.shrimp_administration.validation.Validation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;

import com.ginius.shrimp_administration.controller.CrevetteController;
import com.ginius.shrimp_administration.dao.CrevetteDao;

/**
 * 
 * @author giniu
 *
 */
public class CrevetteInterfaceController {
	
	private Stage newCrevetteWindow;

	CrevetteDao crevetteDao;

	JAXBContext ctx = null;

	int crevettePossede;
	
	Image defaultImage;

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
	private ImageView imageCrevette;

	private File fileImageCrevette;

	@FXML
	private ToggleButton crevettePossedeCb;
	
	@FXML
	private Button imageButton;
	
	private FileChooser fileChooser;
	
	private GestionnaireFichier gestionnaireFichier;

	@FXML
	private void initialize() {
		
		gestionnaireFichier = new GestionnaireFichierImp("crevette");

		fileImageCrevette = new File(gestionnaireFichier.getDefaultpath());
		 defaultImage = new Image(fileImageCrevette.toURI().toString());
		imageCrevette.setImage(defaultImage);
		imageCrevette.setFitHeight(250);
		imageCrevette.setX(100);

		// initialisation des instances des controlleurs d'accés aux fichiers xml.
		CrevetteController.getInstance();
		crevetteDao = new CrevetteDao();

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

		// gestion des bulles d'aide
		nomTf.setTooltip(new Tooltip("Texte entre 1 et 20 caractères."));
		ghMinTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères."));
		ghMaxTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères."));
		khMinTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères."));
		khMaxTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères."));
		phMinTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères avec virgule."));
		phMaxTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères avec virgule."));
		temperatureTf.setTooltip(new Tooltip("Chiffre de 1 à 2 caractères."));
		descriptionTa.setTooltip(new Tooltip("Texte entre 1 et 200 caractères."));

	}

	@FXML
	public void chooseCrevetteImage() {

		fileChooser = new FileChooser();
	     gestionnaireFichier.configureFileChooser(fileChooser);
	     File file = fileChooser.showOpenDialog(newCrevetteWindow);
	     if (file != null) {
	    	 String path = file.getAbsolutePath().toString();
	    	 fileImageCrevette = new File(path);
				Image image = new Image(fileImageCrevette.toURI().toString());
				imageCrevette.setImage(image);
        }

	}

	/**
	 * Méthode permettant de sauvegarder l'entité crevette créé dans le fichier XML.
	 */
	@FXML
	private void saveCrevette() {

		if (pasDeChampsVides() && pasDeChampsIncorrectes()) {

			if (crevettePossedeCb.isSelected()) {
				crevettePossede = 1;
			} else
				crevettePossede = 0;

			Crevette c = new Crevette();

			c.setCategorie(crevetteCategoryList.getSelectionModel().getSelectedItem().toString());
			c.setSousCategorie(crevetteSousCategoryList.getSelectionModel().getSelectedItem().toString());
			c.setNom(nomTf.getText());
			c.setGhMax(Integer.parseInt(ghMaxTf.getText()));
			c.setGhMin(Integer.parseInt(ghMinTf.getText()));
			c.setKhMax(Integer.parseInt(khMaxTf.getText()));
			c.setKhMin(Integer.parseInt(khMinTf.getText()));
			c.setPhMax(Double.parseDouble(phMaxTf.getText()));
			c.setPhMin(Double.parseDouble(phMinTf.getText()));
			c.setTemperature(Integer.parseInt(temperatureTf.getText()));
			c.setDescription(descriptionTa.getText());
			c.setPossede(crevettePossede);
			c.setImage(gestionnaireFichier.copier(fileImageCrevette).getAbsolutePath().toString());

			if (crevetteDao.saveCrevette(c)) {
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
				imageCrevette.setImage(defaultImage);
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

	/**
	 * Méthode permettant de fermer la fenêtre courante.
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
