package gui;

import java.io.IOException;

import entities.Aluno;
import entities.Logon;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LogonViewController {


	@FXML
	private TextField login;
	@FXML
	private TextField senha;
	@FXML
	private Button entrar;

	@FXML
	public String onActionLogin() {
		return login.getText();
	}

	@FXML
	public String onActionSenha() {
		return senha.getText();
	}

	@FXML
	public void onActionEntrar(ActionEvent event) {

		Logon logon = new Logon(onActionLogin(), onActionSenha());

		if (logon.Autentica��o() == true) {
			
			
			Aluno obj = new Aluno();
			Stage parentStage = Utils.currenteStage(event);
			parentStage.close();
			criarRegistroAluno(obj,"/gui/RegistroAluno.fxml",parentStage);

		} else {
			Alerts.showAlert("Falha na Autentica��o", "", "Login ou Senha inv�lidos", AlertType.ERROR);
		}

	}

	private void criarRegistroAluno(Aluno obj,String absName,Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absName));
			VBox newVBox = loader.load();

			Stage newStage = new Stage();
			newStage.setTitle("Registro dos Alunos");
			newStage.setScene(new Scene(newVBox));
			newStage.setResizable(true);
			newStage.initOwner(parentStage);
			newStage.initModality(Modality.WINDOW_MODAL);
			newStage.show();
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}