package gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	
	// M�TODO QUE EXIBE UMA JANELA DE ALERTA
	public static void showAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type);		// CRIANDO UM ALERTA E INFORMANDO O TIPO DE ALERTA
		
		alert.setTitle(title);				// CONFIGURANDO O T�TULO DO ALERTA
		alert.setHeaderText(header);		// CONFIGURANDO O CABE�ALHO DO ALERTA
		alert.setContentText(content);		// CONFIGURANDO O CONTE�DO DO ALERTA
		alert.show();						// EXIBINDO O ALERTA
	}
}
