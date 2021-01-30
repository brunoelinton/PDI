package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController implements Initializable {
	// CONSTRUTOR
	public MainViewController() {
		System.out.println("Controller iniciado!");
	}
	
	
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
	private Button button;
	
	/*-----------< EVENTOS PARA CADA UMA DAS OPÇÕES DO MENU DA TELA PRINCIPAL >-----------*/

	// MÉTODO QUE FINALIZA A APLICAÇÃO
	@FXML
	public void onMenuItemFechar() {
		Platform.exit();
	}
	
	@FXML
	public void onMenuItemVonKriesMedia() {
		System.out.println("onMenuItemVonKriesMédia");
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

}
