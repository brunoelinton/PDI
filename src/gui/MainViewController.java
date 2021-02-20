package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainViewController implements Initializable {
	// CONSTRUTOR
	public MainViewController() {
		System.out.println("Controller iniciado!");
	}
	
	private static Parent root;
	
	/*-----------< CONTROLES DA TELA PRINCIPAL >-----------*/
	@FXML
	private MenuItem menuItemFechar;
	
	@FXML
	private MenuItem menuItemVonKriesMedia;
	
	@FXML
	private MenuItem menuItemVonKriesMediana;
	
	@FXML
	private MenuItem menuItemSobre;
	
	@FXML
	private StackPane parentContainer;
	
	@FXML
	private AnchorPane anchorRoot;
	
	/*-----------< EVENTOS PARA CADA UMA DAS OPÇÕES DO MENU DA TELA PRINCIPAL >-----------*/

	// MÉTODO QUE FINALIZA A APLICAÇÃO
	@FXML
	public void onMenuItemFechar() {
		Platform.exit();
	}
	
	@FXML
	public void onMenuItemProcessamentoLote() {
		
		System.out.println("onMenuItemVonKriesMédia");
		try {
			root = FXMLLoader.load(getClass().getResource("/gui/ProcessamentoLoteView.fxml"));
			// Scene  scene =  menuItemVonKriesMedia.getParentPopup().getScene();
			Scene scene = Main.getMainScene();
			root.translateYProperty().set(scene.getHeight());
			
			parentContainer.getChildren().add(root);
			
			Timeline timeline = new Timeline();
	        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
	        KeyFrame kf = new KeyFrame(Duration.seconds(0.5), kv);
	        timeline.getKeyFrames().add(kf);
	        timeline.setOnFinished(t -> {
	            parentContainer.getChildren().remove(anchorRoot);
	        });
	        timeline.play();
		} catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error to calling Von Kries Media Process Image", e.getMessage(), AlertType.ERROR);
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void onMenuItemVonKriesMediana() {
		System.out.println("onMenuItemVonKriesMediana");
	}
	
	@FXML
	public void onMenuItemSobre() {
		// OBTENDO O 'PALCO' A PARTIR DO ACIONAMENTO DO ITEM 'AJUDA'
		Stage parentStage = (Stage)menuItemSobre.getParentPopup().getOwnerWindow();
		
		// INVOCANDO O MÉTODO PARA EXIBIÇÃO DA TELA 'SOBRE', INFORMANDO:
		// --> QUAL VIEW SERÁ CARREGADA
		// --> QUAL É O 'PALCO' DE ORIGEM 
		createDiologSobre("/gui/SobreView.fxml", parentStage);	
	}
	
	// MÉTODO PARA EXIBIÇÃO DA JANELA DE 'AJUDA'
	private void createDiologSobre(String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Sobre o PDI");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		} catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
			e.printStackTrace();
		}
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

	public static Parent getRoot() {
		return root;
	}
}
