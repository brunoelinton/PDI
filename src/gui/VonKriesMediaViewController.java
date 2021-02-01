package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.filechooser.FileNameExtensionFilter;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class VonKriesMediaViewController implements Initializable{
	@FXML
	private AnchorPane anchorPane;
	
	@FXML
	private BorderPane borderPane;

	@FXML
	private Button btAddImagens;
	
	@FXML
	private ListView listViewImagens;

	@FXML
	private Button btProcessar;
	
	@FXML
	private Button btCancelar;
	
	@FXML
	private Button btDiretorio;
	
	@FXML
	private TextField txtFieldlDiretorio;
	
	// CONSTRUTOR
	public VonKriesMediaViewController() {
		
	}
	
	// M�TODO PARA CARREGAR OS ARQUIVOS DE IMAGEM
	@FXML
	public void onBtAddImagens() {
		FileChooser fc = new FileChooser();
		// fc.setInitialDirectory(new File("C:\\Users\\BRUNO\\Pictures"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("BMP Files", "*.bmp"), new ExtensionFilter("GIF Files", "*.gif"), new ExtensionFilter("JPEG Files", "*.jpg;*.jpe;*.jpeg"), new ExtensionFilter("PNG Files", "*.png"));
		
		List<File> selectedFiles = fc.showOpenMultipleDialog(null);
		
		if(selectedFiles != null) {
			for(File files: selectedFiles)
				listViewImagens.getItems().add(files.getAbsoluteFile());
		} else {
			System.out.println("Error");
		}
	}
	
	// M�TODO PARA ADICIONAR A PASTA DE DESTINO DOS ARQUIVOS PROCESSADOS
	@FXML 
	public void onBtPastaDestino() {
		DirectoryChooser diretorioDestino = new DirectoryChooser();
		File diretorioSelecionado = diretorioDestino.showDialog(null);
		
		if(diretorioSelecionado == null) {
			txtFieldlDiretorio.setText("Seleciona a pasta de destino");
		} else {
			txtFieldlDiretorio.setText(diretorioSelecionado.getAbsolutePath());
		}
	}
	
	// M�TODO PARA CANCELAR A OPERA��O
	public void onBtCancelar() {
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		borderPane.prefWidthProperty().bind(anchorPane.widthProperty());	// AJUSTANDO DE FORMA AUTOM�TICA A LARGURA DO 'BORDER PANE' DE ACORDO COM A LARGURA DO 'ANCHOR PANE'
		borderPane.prefHeightProperty().bind(anchorPane.heightProperty());	// AJUSTANDO DE FORMA AUTOM�TICA A ALTURA DO 'BORDER PANE' DE ACORDO COM A ALTURA DO 'ANCHOR PANE'
	}
}
