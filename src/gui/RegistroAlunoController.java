package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entities.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AlunoDAO;
import model.dao.DaoFactory;

public class RegistroAlunoController implements Initializable {

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
	private void onBtRegistrar(ActionEvent event) {
		System.out.println("Registrar funcionando!");
	}

	@FXML
	private void onBtDeletar(ActionEvent event) {
		System.out.println("Deletar funcionando!");
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

}
