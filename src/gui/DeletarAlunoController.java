package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AlunoDAO;
import model.dao.DaoFactory;

public class DeletarAlunoController implements Initializable {

	@FXML
	private TextField txtRa;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btCancelar;

	public void onBtSalvar(ActionEvent e) {
		DeletarAluno();
		Utils.currenteStage(e).close();
	}

	public void onBtCancelar(ActionEvent e) {
		 Utils.currenteStage(e).close();
	}

	public void initialize(URL url, ResourceBundle rb) {
		initializeNode();
	}

	public void initializeNode() {
		Constraints.setTextFieldInteger(txtRa);
	}

	public void DeletarAluno() {

		AlunoDAO aluno = DaoFactory.criarAluno();
		aluno.deletarPeloRa(Utils.tryParseToInt(txtRa.getText()));

	}

}
