package gui.util;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Utils {
	// MÉTODO QUE ACESSA O 'Stage', ISTO É, O PALCO DE ONDE O EVENTO FOI ACIONADO
	public static Stage currentStage(ActionEvent event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}
}
