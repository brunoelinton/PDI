package gui;

import gui.util.Alerts;
import techniques.VonKriesMedia;

import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class VonKriesMediaViewController implements Initializable{
	// LISTA DE IMAGENS
	List<File> selectedFiles = null;
	
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
	
	// MÉTODO PARA CARREGAR OS ARQUIVOS DE IMAGEM
	@FXML
	public void onBtAddImagens() {
		FileChooser fc = new FileChooser();
		// fc.setInitialDirectory(new File("C:\\Users\\BRUNO\\Pictures"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("BMP Files", "*.bmp"), new ExtensionFilter("GIF Files", "*.gif"), new ExtensionFilter("JPEG Files", "*.jpg;*.jpe;*.jpeg"), new ExtensionFilter("PNG Files", "*.png"));
		
		selectedFiles = fc.showOpenMultipleDialog(null);
		
		if(selectedFiles != null) {
			for(File files: selectedFiles) {
				listViewImagens.getItems().add(files.getAbsoluteFile());
			}
			
		} else {
			System.out.println("Error");
		}
	}
	
	// MÉTODO PARA ADICIONAR A PASTA DE DESTINO DOS ARQUIVOS PROCESSADOS
	@FXML 
	public void onBtPastaDestino() {
		DirectoryChooser diretorioDestino = new DirectoryChooser();
		File diretorioSelecionado = diretorioDestino.showDialog(null);
		
		if(diretorioSelecionado == null) {
			txtFieldlDiretorio.setText("Seleciona a pasta de destino");
		} else {
			txtFieldlDiretorio.setText(diretorioSelecionado.getAbsolutePath());
			System.out.println(diretorioSelecionado.getPath());
		}
	}
	
	// MÉTODO PARA CANCELAR A OPERAÇÃO
	@FXML
	public void onBtCancelar() {
		
	}

	// MÉTODO PARA PROCESSAR AS IMAGENS
	@FXML
	public void onBtProcessar(ActionEvent event) {
		VonKriesMedia tecnicaVonkrieKriesMedia = new VonKriesMedia();
		BufferedImage imagemOriginal = null;
		BufferedImage imagemProcessada = null;
		int count = 0;
		try {
			for(File file: selectedFiles) {
				imagemOriginal = ImageIO.read(new File(file.getAbsolutePath()));
				imagemProcessada = tecnicaVonkrieKriesMedia.GreennKG(imagemOriginal);
				ImageIO.write(imagemProcessada, "PNG",new File(txtFieldlDiretorio.getText()+"\\out" + count + ".png"));
				// imagemOriginal = ImageIO.read(new File(file.getAbsolutePath()));
				// ImageIO.write(imagemOriginal, "PNG",new File(txtFieldlDiretorio.getText()+"\\out" + count + ".png"));
				count++;
			}
			
		} catch(IOException e) {
			e.printStackTrace();
			Alerts.showAlert("Error", "Error in processing images", e.getMessage(), AlertType.ERROR);
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		borderPane.prefWidthProperty().bind(anchorPane.widthProperty());	// AJUSTANDO DE FORMA AUTOMÁTICA A LARGURA DO 'BORDER PANE' DE ACORDO COM A LARGURA DO 'ANCHOR PANE'
		borderPane.prefHeightProperty().bind(anchorPane.heightProperty());	// AJUSTANDO DE FORMA AUTOMÁTICA A ALTURA DO 'BORDER PANE' DE ACORDO COM A ALTURA DO 'ANCHOR PANE'
	}
}
