package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import application.Main;
import gui.util.Alerts;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.util.Duration;
import techniques.VonKriesMedia;

public class ProcessamentoLoteViewController implements Initializable{
	// LISTA DE IMAGENS
	List<File> selectedFiles = null;
	File[] files;
	
	@FXML
	private AnchorPane anchorPane;
	
	@FXML
	private BorderPane borderPane;

	@FXML
	private Button btAddImagens;
	
	@FXML
	private ListView<File> listViewImagens;

	@FXML
	private Button btProcessar;
	
	@FXML
	private Button btCancelar;
	
	@FXML
	private Button btDiretorio;
	
	@FXML
	private TextField txtFieldDiretorioOrigem;
	
	@FXML
	private TextField txtFieldDiretorioDestino;
	
	@FXML
	private CheckBox chkBoxVonKriesMedia;
	
	@FXML
	private CheckBox chkBoxVonKriesMediana;
	
	@FXML
	private CheckBox chkBoxOutra;
	
	// CONSTRUTOR
	public ProcessamentoLoteViewController() {
		
	}
	
	// MÉTODO PARA CARREGAR OS ARQUIVOS DE IMAGEM
	@FXML
	public void onBtAddPastaOrigem() {
		DirectoryChooser diretorioOrigem = new DirectoryChooser();
		File diretorioSelecionado = diretorioOrigem.showDialog(null);
		
		if(diretorioSelecionado == null) {
			txtFieldDiretorioOrigem.setText("Seleciona a pasta de destino");
		} else {
			txtFieldDiretorioOrigem.setText(diretorioSelecionado.getAbsolutePath());
			System.out.println(diretorioSelecionado.getPath());
		}
		
		files = diretorioSelecionado.listFiles();
		if(files != null) {
			for(File file: files) {
				listViewImagens.getItems().add(file.getAbsoluteFile());
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
			txtFieldDiretorioDestino.setText("Seleciona a pasta de destino");
		} else {
			txtFieldDiretorioDestino.setText(diretorioSelecionado.getAbsolutePath());
			System.out.println(diretorioSelecionado.getPath());
		}
	}
	
	// MÉTODO PARA CANCELAR A OPERAÇÃO
	@FXML
	public void onBtCancelar() {
		System.out.println("Exit VonKriesMédia");
		txtFieldDiretorioOrigem.setText(null);
		txtFieldDiretorioDestino.setText(null);
		chkBoxVonKriesMedia.setDisable(true);
		
		// DESALOCANDO OS ITENS DO 'listviewImagens' EXIBIDOS NA TELA
		if (files != null) {
			for(File file: files) {
				listViewImagens.getItems().remove(file);
			}
			
			// DESALOCANDO O VETOR DE IMAGENS
			Arrays.fill(files, null);	// SETANDO CADA POSIÇÃO COMO NULL
			files = null;				// LIBERANDO O VETOR
		}
		try {
			Parent root = MainViewController.getRoot();
			Scene scene = Main.getMainScene();
			root.translateYProperty().set(0);

			Timeline timeline = new Timeline();
	        KeyValue kv = new KeyValue(root.translateYProperty(), scene.getHeight()*2, Interpolator.EASE_IN);
	        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
	        timeline.getKeyFrames().add(kf);
	        timeline.play();
			
		} catch(IllegalStateException e) {
			Alerts.showAlert("IO Exception", "Error to calling Von Kries Media Process Image", e.getMessage(), AlertType.ERROR);
		}
		
	}

	// MÉTODO PARA PROCESSAR AS IMAGENS
	@FXML
	public void onBtProcessar(ActionEvent event) {
		VonKriesMedia tecnicaVonkrieKriesMedia = new VonKriesMedia();
		BufferedImage imagemOriginal = null;
		BufferedImage imagemProcessada = null;
		int count = 0;
		try {
			for(File file: files) {
				imagemOriginal = ImageIO.read(new File(file.getAbsolutePath()));
				imagemProcessada = tecnicaVonkrieKriesMedia.GreennKG(imagemOriginal);
				ImageIO.write(imagemProcessada, "PNG",new File(txtFieldDiretorioDestino.getText()+"\\out" + count + "VKMedia.png"));
				// imagemOriginal = ImageIO.read(new File(file.getAbsolutePath()));
				// ImageIO.write(imagemOriginal, "PNG",new File(txtFieldlDiretorio.getText()+"\\out" + count + ".png"));
				count++;
			}
			
		} catch(IOException e) {
			e.printStackTrace();
			Alerts.showAlert("Error", "Error in processing images", e.getMessage(), AlertType.ERROR);
		}
	}
	
	@FXML
	public void chkVKMedia() {
		if(chkBoxVonKriesMedia.isSelected()) {
			System.out.println("Von Kries Média!");
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//borderPane.prefWidthProperty().bind(anchorPane.widthProperty());	// AJUSTANDO DE FORMA AUTOMÁTICA A LARGURA DO 'BORDER PANE' DE ACORDO COM A LARGURA DO 'ANCHOR PANE'
		//borderPane.prefHeightProperty().bind(anchorPane.heightProperty());	// AJUSTANDO DE FORMA AUTOMÁTICA A ALTURA DO 'BORDER PANE' DE ACORDO COM A ALTURA DO 'ANCHOR PANE'
		
		borderPane.prefHeightProperty().bind(Main.getMainScene().heightProperty());	// AJUSTANDO DE FORMA AUTOMÁTICA A ALTURA DO 'BORDER PANE' DE ACORDO COM A ALTURA DO 'ANCHOR PANE'
        borderPane.prefWidthProperty().bind(Main.getMainScene().widthProperty());	// AJUSTANDO DE FORMA AUTOMÁTICA A LARGURA DO 'BORDER PANE' DE ACORDO COM A LARGURA DO 'ANCHOR PANE'
        
		btProcessar.disableProperty().bind(listViewImagens.itemsProperty().isNull().or(txtFieldDiretorioDestino.textProperty().isEmpty()).or(chkBoxVonKriesMedia.selectedProperty().not()));
		
	}
}
