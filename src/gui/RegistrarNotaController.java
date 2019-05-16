package gui;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Materias;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AlunoDAO;
import model.dao.DaoFactory;

public class RegistrarNotaController implements Initializable {

	@FXML
	private Button registrarNota;
	
	@FXML
	private Button atualizarNota;
	
	@FXML
	private TableView<Materias> tableView;
	
	
	@FXML
	private TableColumn<Materias, Double> portugues;
	
	
	@FXML
	private TableColumn<Materias, Double> matematica;
	
	
	@FXML
	private TableColumn<Materias, Double> biologia;
	
	
	@FXML
	private TableColumn<Materias, Double> fisica;
	
	
	@FXML
	private TableColumn<Materias, Double> quimica;
	
	
	@FXML
	private TableColumn<Materias, Double> filosofia;
	
	
	@FXML
	private TableColumn<Materias, Double> ingles;
	
	
	@FXML
	private TableColumn<Materias, Double> geografia;
	
	
	@FXML
	private TableColumn<Materias, Double> historia;
	
	
	@FXML
	private TableColumn<Materias, Double> sociologia;
	
	
	@FXML
	private TableColumn<Materias, Double> edFisica;
	
	
	@FXML
	private TableColumn<Materias, Double> artes;
	
	
	@FXML
	private TableColumn<Materias, Integer> ra;
	
	@FXML
	public void onActionRegistrarNota() {
		
	}
	
	@FXML
	public void onActionAtualizarNota() {
		
	}
	
	public void iniciarColunas() {
		portugues.setCellValueFactory(new PropertyValueFactory<>("portugues"));
		matematica.setCellValueFactory(new PropertyValueFactory<>("matematica"));
		ingles.setCellValueFactory(new PropertyValueFactory<>("ingles"));
		biologia.setCellValueFactory(new PropertyValueFactory<>("biologia"));
		filosofia.setCellValueFactory(new PropertyValueFactory<>("filosofia"));
		artes.setCellValueFactory(new PropertyValueFactory<>("artes"));
		fisica.setCellValueFactory(new PropertyValueFactory<>("fisica"));
		quimica.setCellValueFactory(new PropertyValueFactory<>("quimica"));
		geografia.setCellValueFactory(new PropertyValueFactory<>("geografia"));
		historia.setCellValueFactory(new PropertyValueFactory<>("historia"));
		sociologia.setCellValueFactory(new PropertyValueFactory<>("sociologia"));
		ra.setCellValueFactory(new PropertyValueFactory<>("ra"));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		iniciarColunas();
	}
	
	private ObservableList<Materias> listMaterias(){
		Materias materias = new Materias();
		AlunoDAO criarMaterias = DaoFactory.criarAluno();
		criarMaterias.ProcurarNota();
		return null;
	}
	
}
