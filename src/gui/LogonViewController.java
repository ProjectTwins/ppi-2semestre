package gui;


import java.io.IOException;

import application.Main;
import entities.Logon;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LogonViewController {

	Alerts alert = new Alerts();

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

	public synchronized void loadView(String path) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
			VBox newVbox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVbox = (VBox) ((javafx.scene.control.ScrollPane) mainScene.getRoot()).getContent();

			mainVbox.getChildren().clear();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	@FXML
	public void onActionEntrar() {

		Logon logon = new Logon(onActionLogin(), onActionSenha());

		if (logon.Autenticação() == true) {

			loadView("/gui/RegistroAluno.fxml");
		} else {
			alert.showAlert("Falha na Autenticação", "", "Login ou Senha inválidos", AlertType.ERROR);
		}

	}

}
