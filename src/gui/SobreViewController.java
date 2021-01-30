package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SobreViewController implements Initializable {
	private static String msg =
								"O PDI é um programa que processa imagens subaquáticas através de técnicas de \n"
								+ "técnicas de aprimoramento que visam a correção dos efeitos provocados por uma \n"
								+ "uma série de fatores decorrentes do próprio meio";

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
		
		msg.append("O PDI é um programa que processa imagens subaquáticas\n");
		msg.append("através de técnicas de aprimoramento que visam a correção\n");
		msg.append("dos efeitos provocados por uma série de fatores decorrentes\n");
		msg.append("do próprio meio.");
		
		return msg.toString();
	}
	*/
	
	
}
