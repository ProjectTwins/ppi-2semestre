package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.Aluno;
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

public class RegistroAlunoController implements Initializable,DataChangeListener {

	
	@FXML
	private TableView<Aluno> tableView;

	@FXML
	private TableColumn<Aluno, Integer> colunaRa;

	@FXML
	private TableColumn<Aluno, String> colunaNome;

	@FXML
	private TableColumn<Aluno, String> colunaTurma;

	@FXML
	private Button btRegistrar;

	@FXML
	private Button btDeletar;

	@FXML
	private Button btAtualizar;
	
	@FXML
	private void onBtRegistrar(ActionEvent event) {
		Aluno obj = new Aluno();
		Stage parentStage = Utils.currenteStage(event);
		JanelaRegistrar("/gui/RegistrarAluno.fxml", parentStage,obj);

	}
	
	@FXML
	private void onBtAtualizar(ActionEvent event) {
		Aluno obj = new Aluno();
		Stage parentStage = Utils.currenteStage(event);
		JanelaAtualizar(obj, "/gui/AlunoAtualizar.fxml", parentStage);
	}

	@FXML
	private void onBtDeletar(ActionEvent event) {
		Stage parentStage = Utils.currenteStage(event);
		JanelaDelete("/gui/DeletarAluno.fxml", parentStage);
	}

	public void initialize(URL url, ResourceBundle rb) {
		iniciarColunas();

	}

	public void iniciarColunas() {
		colunaRa.setCellValueFactory(new PropertyValueFactory<>("ra"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaTurma.setCellValueFactory(new PropertyValueFactory<>("turma"));

		tableView.setItems(listaAluno());
	}
	
	private ObservableList<Aluno> listaAluno(){
		AlunoDAO alunoDao = DaoFactory.criarAluno();
		List<Aluno> list = alunoDao.ProcurarTodos();
		return FXCollections.observableArrayList(list);
	}
	
	private void JanelaDelete(String absoluteName,Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			DeletarAlunoController controller = loader.getController();
			controller.inscreverDataChange(this);
			
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Remova um aluno");
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
	
	private void JanelaAtualizar(Aluno obj,String absoluteName,Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			AlunoAtualizar controller = loader.getController();
			controller.inscreverDataChange(this);
			
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Atualize um aluno");
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
	
	private void JanelaRegistrar(String absoluteName, Stage parentStage , Aluno obj) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			RegistrarAlunoController controller = loader.getController();
			controller.inscreverDataChange(this);
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Registrar um Aluno");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
			e.printStackTrace();
		}
	}

	public void onDataChanged() {
		iniciarColunas();
		
	}

}
