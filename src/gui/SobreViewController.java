package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SobreViewController implements Initializable {
	private static String msg =
								"O PDI � um programa que processa imagens subaqu�ticas atrav�s de t�cnicas de \n"
								+ "t�cnicas de aprimoramento que visam a corre��o dos efeitos provocados por uma \n"
								+ "uma s�rie de fatores decorrentes do pr�prio meio";

	@FXML
	public Label labelDescription = new Label();
	
	// CONSTRUTOR
	public SobreViewController() {
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		labelDescription.setText(msg);
	}
	
	/*
	public String createDescription() {
		StringBuilder msg = new StringBuilder();
		
		msg.append("O PDI � um programa que processa imagens subaqu�ticas\n");
		msg.append("atrav�s de t�cnicas de aprimoramento que visam a corre��o\n");
		msg.append("dos efeitos provocados por uma s�rie de fatores decorrentes\n");
		msg.append("do pr�prio meio.");
		
		return msg.toString();
	}
	*/
	
	
}
