package com.ginius.shrimp_administration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author giniu
 *
 */
public class App extends Application {
	

	public static int crevetteId;
	public static int lastPosition;
	public static FXMLLoader loader = new FXMLLoader();
	public static final String TITLE =  "shrimp-administration";

	@Override
	public void start(final Stage primaryStage) throws Exception {

		// retourne l'URL à charger ainsi que son emplacement
		loader.setLocation(App.class.getResource("vue/MainApp.fxml"));

		// charger l'objet correspondant au loader à l'object racine
		AnchorPane rootLayout = (AnchorPane) loader.load();

		Scene scene = new Scene(rootLayout);

		primaryStage.setTitle(TITLE);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}
}
