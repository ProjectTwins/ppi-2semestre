package gui;

import java.io.IOException;

import gui.util.Alerts;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class IniciarTesteController {

	@FXML
	private Button sim;
	
	@FXML
	private Button nao;
	
	@FXML
	public void onActionBtSim(ActionEvent e) {
		Stage parentStage = Utils.currenteStage(e);
		IniciarTesteVocacional("/gui/TesteVocacional.fxml", parentStage);
	
		
	}
	@FXML
	public void onActionBtNao(ActionEvent e) {
		Utils.currenteStage(e).close();
	}
	
	private void IniciarTesteVocacional(String absName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absName));
			VBox vbox = loader.load();

			Stage newStage = new Stage();
			newStage.setTitle("Teste Vocacional");
			newStage.setScene(new Scene(vbox));
			newStage.setResizable(false);
			newStage.initOwner(parentStage);
 			newStage.initModality(Modality.WINDOW_MODAL);
			newStage.show();
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	
}
