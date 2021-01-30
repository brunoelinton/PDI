package gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	
	// MÉTODO QUE EXIBE UMA JANELA DE ALERTA
	public static void showAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type);		// CRIANDO UM ALERTA E INFORMANDO O TIPO DE ALERTA
		
		alert.setTitle(title);				// CONFIGURANDO O TÍTULO DO ALERTA
		alert.setHeaderText(header);		// CONFIGURANDO O CABEÇALHO DO ALERTA
		alert.setContentText(content);		// CONFIGURANDO O CONTEÚDO DO ALERTA
		alert.show();						// EXIBINDO O ALERTA
	}
}
