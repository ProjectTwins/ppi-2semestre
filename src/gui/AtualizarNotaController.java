package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.Materias;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.AlunoDAO;
import model.dao.DaoFactory;

public class AtualizarNotaController implements Initializable {

	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
	@FXML
	private Button btSalvar;
	
	@FXML
	private Button btCancelar;
	
	@FXML
	private TextField portugues;
	@FXML
	private TextField matematica;
	@FXML
	private TextField biologia;
	@FXML
	private TextField fisica;
	@FXML
	private TextField quimica;
	@FXML
	private TextField filosofia;
	@FXML
	private TextField ingles;
	@FXML
	private TextField geografia;
	@FXML
	private TextField historia;
	@FXML
	private TextField sociologia;
	@FXML
	private TextField edFisica;
	@FXML
	private TextField artes;
	
	@FXML
	private TextField ra; 
	
	@FXML
	private void onBtSalvar(ActionEvent event) {
		Utils.currenteStage(event).close();
		AtualizarNotas();
		notifyDataChangeListeners();
	}
	
	@FXML
	private void onBtCancelar(ActionEvent event) {
		Utils.currenteStage(event).close();
	}
	
	public void inscreverDataChange(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}
	
	private void notifyDataChangeListeners() {
		for(DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}
	
	public void initializeNodes() {
		Constraints.setTextFieldMaxLength(portugues, 3);
		Constraints.setTextFieldMaxLength(matematica, 3);
		Constraints.setTextFieldMaxLength(biologia, 3);
		Constraints.setTextFieldMaxLength(fisica, 3);
		Constraints.setTextFieldMaxLength(quimica, 3);
		Constraints.setTextFieldMaxLength(filosofia, 3);
		Constraints.setTextFieldMaxLength(ingles, 3);
		Constraints.setTextFieldMaxLength(geografia, 3);
		Constraints.setTextFieldMaxLength(historia, 3);
		Constraints.setTextFieldMaxLength(sociologia, 3);
		Constraints.setTextFieldMaxLength(edFisica, 3);
		Constraints.setTextFieldMaxLength(artes, 3);
	}
	
	public void AtualizarNotas() {
		Materias mat = new Materias();
		AlunoDAO materias = DaoFactory.criarAluno();
		double vect[] = new double[12];
		
		
		
		mat.setPortugues(Utils.tryParseToDouble(portugues.getText()));
		mat.setMatematica(Utils.tryParseToDouble(matematica.getText()));
		mat.setBiologia(Utils.tryParseToDouble(biologia.getText()));
		mat.setFisica(Utils.tryParseToDouble(fisica.getText()));
		mat.setQuimica(Utils.tryParseToDouble(quimica.getText()));
		mat.setFilosofia(Utils.tryParseToDouble(filosofia.getText()));
		mat.setIngles(Utils.tryParseToDouble(ingles.getText()));
		mat.setGeografia(Utils.tryParseToDouble(geografia.getText()));
		mat.setHistoria(Utils.tryParseToDouble(historia.getText()));
		mat.setSociologia(Utils.tryParseToDouble(sociologia.getText()));
		mat.setEdFisica(Utils.tryParseToDouble(edFisica.getText()));
		mat.setArtes(Utils.tryParseToDouble(artes.getText()));
		mat.setRa(Utils.tryParseToInt(ra.getText()));
		
		int raAluno = Utils.tryParseToInt(ra.getText());
		vect[0] = Utils.tryParseToDouble(portugues.getText());
		vect[1] = Utils.tryParseToDouble(matematica.getText());
		vect[2] = Utils.tryParseToDouble(biologia.getText());
		vect[3] = Utils.tryParseToDouble(fisica.getText());
		vect[4] = Utils.tryParseToDouble(quimica.getText());
		vect[5] = Utils.tryParseToDouble(filosofia.getText());
		vect[6] = Utils.tryParseToDouble(ingles.getText());
		vect[7] = Utils.tryParseToDouble(geografia.getText());
		vect[8] = Utils.tryParseToDouble(historia.getText());
		vect[9] = Utils.tryParseToDouble(sociologia.getText());
		vect[10] = Utils.tryParseToDouble(edFisica.getText());
		vect[11] = Utils.tryParseToDouble(artes.getText());
		
		materias.atualizarNotas(vect,raAluno);

 }
}
