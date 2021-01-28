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
	
	/*-----------< EVENTOS PARA CADA UMA DAS OP��ES DO MENU DA TELA PRINCIPAL >-----------*/

	// M�TODO QUE FINALIZA A APLICA��O
	@FXML
	public void onMenuItemFechar() {
		Platform.exit();
	}
	
	@FXML
	public void onMenuItemVonKriesMedia() {
		System.out.println("onMenuItemVonKriesM�dia");
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
