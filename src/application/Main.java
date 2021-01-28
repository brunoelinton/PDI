package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// INSTANCIANDO UM OBJETO 'loader' DO TIPO 'FXMLLoader' PARA PODER CARREGAR A VIEW DA JANELA PRINCIPAL
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));

			// A JANELA É ENTÃO CARREGADA CARREGADA/ATRIBUÍDA À UM CONTAINER GENÉRICO DO TIPO 'Parent' 
			Parent parent = loader.load();
			
			// INSTANCIAMOS O OBJETO 'scene' DO TIPO 'Scene'  PARA REPRESENTAR A "CENA" QUE SERÁ EXIBIDA NA JANELA PRINCIPAL DA APLICAÇÃO
			// NESSA INSTANCIAÇÃO INFORMAMOS QUEM É O ELEMENTO RAIZ DA CENA - NESSE CASO É O CONTAINER/OBJETO 'parent' DO TIPO 'PARENT'
			Scene scene = new Scene(parent);
			
			// AGORA NÓS INSERIMOS NO "PALCO" A CENA QUE SERÁ EXIBIDA
			// O PALCO É REPRESENTADO PELA VARIÁVEL 'primaryStage' QUE É DO TIPO 'Stage', ISTO É, "PALCO"
			primaryStage.setScene(scene);
			
			// FEITO TUDO ISSO O PALCO ESTÁ PRONTO E A JANELA PODE SER EXIBIDA
			// A EXIBIÇÃO É FEITA INVOCANDO O MÉTODO 'show()', PERTENCENDO AO OBJETO 'primaryStage' - NOSSO PALCO
			primaryStage.show();
		} catch(IOException e) {	// CAPTURANDO O ERRO CASO NÃO SEJA POSSÍVEL REALIZAR O PROCESSO ACIMA
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
