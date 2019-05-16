package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.Aluno;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AlunoDAO;
import model.dao.DaoFactory;

public class RegistrarAlunoController implements Initializable{

	List<DataChangeListener> dataChange = new ArrayList<DataChangeListener>();
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField turma;
	
	@FXML
	private TextField ra;
	
	@FXML
	private Button salvar;
	
	@FXML
	private Button cancelar;
	
	
	public void RegistrarAluno() {
		Aluno obj = new Aluno();
		AlunoDAO conn = DaoFactory.criarAluno();
		
		obj.setNome(nome.getText());
		obj.setTurma(turma.getText());

		
		conn.inserirAluno(obj);
		
	}
	
	
	@FXML
	public void onActionSalvar(ActionEvent e) {
		RegistrarAluno();
		notifyDataChangeListeners();
		Utils.currenteStage(e).close();
	}
	
	@FXML
	public void onActionCancelar(ActionEvent e) {
		Utils.currenteStage(e).close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	Constraints.setTextFieldMaxLength(turma, 2);
	Constraints.setTextFieldMaxLength(nome, 30);
		
	}
	
	public void inscreverDataChange(DataChangeListener listener) {
		dataChange.add(listener);
	}
	
	private void notifyDataChangeListeners() {
		for(DataChangeListener listener : dataChange) {
			listener.onDataChanged();
		}
	}

	
}
