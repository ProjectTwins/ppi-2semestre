package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.Aluno;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AlunoDAO;
import model.dao.DaoFactory;

public class AlunoAtualizar implements Initializable {

	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

	@FXML
	private TextField txtRa;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTurma;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btCancelar;

	public void inscreverDataChange(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

	private void notifyDataChangeListeners() {
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
	}

	public void onBtSalvar(ActionEvent event) {
		AtualizarAluno();
		Utils.currenteStage(event).close();
		notifyDataChangeListeners();
	}

	public void onBtCancelar(ActionEvent event) {
		gui.util.Utils.currenteStage(event).close();
	}

	public void initialize(URL url, ResourceBundle rs) {
		initializeNodes();

	}

	public void initializeNodes() {
		Constraints.setTextFieldMaxLength(txtNome, 30);
		Constraints.setTextFieldMaxLength(txtTurma, 2);
		Constraints.setTextFieldInteger(txtRa);
	}
	
	public void AtualizarAluno() {
		Aluno aluno = new Aluno();
		AlunoDAO dao = DaoFactory.criarAluno();
		
		aluno.setNome(txtNome.getText());
		aluno.setTurma(txtTurma.getText());
		aluno.setRa(gui.util.Utils.tryParseToInt(txtRa.getText()));
		
		dao.atualizarAluno(aluno);
	}

}
