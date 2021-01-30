package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	// DEPEND�NCIA PARA A CENA DA JANELA PRINCIPAL
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// INSTANCIANDO UM OBJETO 'loader' DO TIPO 'FXMLLoader' PARA PODER CARREGAR A VIEW DA JANELA PRINCIPAL
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));

			// A JANELA � ENT�O CARREGADA/ATRIBU�DA � UM CONTAINER GEN�RICO DO TIPO 'Parent' 
			Parent parent = loader.load();
			
			// INSTANCIAMOS O OBJETO 'scene' DO TIPO 'Scene'  PARA REPRESENTAR A "CENA" QUE SER� EXIBIDA NA JANELA PRINCIPAL DA APLICA��O
			// NESSA INSTANCIA��O INFORMAMOS QUEM � O ELEMENTO RAIZ DA CENA - QUE NESSE CASO � O CONTAINER/OBJETO 'parent' DO TIPO 'PARENT'
			mainScene = new Scene(parent);
			
			// AGORA N�S INSERIMOS NO "PALCO" A CENA QUE SER� EXIBIDA
			// O PALCO � REPRESENTADO PELA VARI�VEL 'primaryStage' QUE � DO TIPO 'Stage', ISTO �, "PALCO"
			primaryStage.setScene(mainScene);
			
			// CONFIGURANDO O 'PALCO', ISTO �, A JANELA PRINCIPAL DA APLICA��O PARA SER EXIBIDA NO TAMANHO M�XIMO
			//primaryStage.setMaximized(true);
			
			// FEITO TUDO ISSO O PALCO EST� PRONTO E A JANELA PODE SER EXIBIDA
			// A EXIBI��O � FEITA INVOCANDO O M�TODO 'show()', PERTENCENDO AO OBJETO 'primaryStage' - NOSSO PALCO
			primaryStage.show();
		} catch(IOException e) {	// CAPTURANDO O ERRO CASO N�O SEJA POSS�VEL REALIZAR O PROCESSO ACIMA
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	// M�TODO QUE RECUPERA A CENA DA JANELA PRINCIPAL
	public static Scene getMainScene() {
		return mainScene;
	} 
}
