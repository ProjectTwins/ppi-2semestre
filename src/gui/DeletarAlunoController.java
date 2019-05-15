package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
	@FXML
	private TextField txtRa;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btCancelar;

	public void onBtSalvar(ActionEvent e) {
		DeletarAluno();
		Utils.currenteStage(e).close();
		notifyDataChangeListeners();
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
	
	public void inscreverDataChange(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}
	
	private void notifyDataChangeListeners() {
		for(DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
	}

	public void DeletarAluno() {

		AlunoDAO aluno = DaoFactory.criarAluno();
		aluno.deletarPeloRa(Utils.tryParseToInt(txtRa.getText()));

	}

}
