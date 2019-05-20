package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entities.Aluno;
import entities.Materias;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.AlunoDAO;
import model.dao.DaoFactory;

public class RegistrarNotaController implements Initializable,DataChangeListener {

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
	public void onActionRegistrarNota(ActionEvent event) {
		Materias obj = new Materias();
		Stage parentStage = Utils.currenteStage(event);
		JanelaRegistrarNota("/gui/InserirNotas.fxml", parentStage, obj);
	}
	
	@FXML
	public void onActionAtualizarNota(ActionEvent event) {
		Materias obj = new Materias();
		Stage parentStage = Utils.currenteStage(event);
		JanelaAtualizarNota("/gui/AtualizarNotas.fxml", parentStage, obj);
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
		edFisica.setCellValueFactory(new PropertyValueFactory<>("edFisica"));
		ra.setCellValueFactory(new PropertyValueFactory<>("ra"));
		
		tableView.setItems(listMaterias());
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		iniciarColunas();
	}
	
	private ObservableList<Materias> listMaterias(){
		AlunoDAO alunoDao = DaoFactory.criarAluno();
		List<Materias> list = alunoDao.ProcurarNota();
		return FXCollections.observableArrayList(list);
		
	}
	private void JanelaRegistrarNota(String absoluteName,Stage parentStage,Materias obj) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			InserirNotasController controller = loader.getController();
			controller.inscreverDataChange(this);
			
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Insira as notas");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	private void JanelaAtualizarNota(String absoluteName,Stage parentStage,Materias obj) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			AtualizarNotaController controller = loader.getController();
			controller.inscreverDataChange(this);
			
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Atualize as notas");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void onDataChanged() {
		iniciarColunas();
		
	}
	

	
}
