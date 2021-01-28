package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

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
		System.out.println("onMenuItemSobre");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
