package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entities.Materias;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AlunoDAO;
import model.dao.DaoFactory;

public class InformacaoAlunoController implements Initializable {

	@FXML
	private TableView<Materias> tableView;

	@FXML
	private TextArea txtArea;

	@FXML
	private Button btTeste;

	@FXML
	private TableColumn<Materias, Integer> ra;

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

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		iniciarColunas();

	}

	public void iniciarColunas() {
		ra.setCellValueFactory(new PropertyValueFactory<>("ra"));
		portugues.setCellValueFactory(new PropertyValueFactory<>("portugues"));
		matematica.setCellValueFactory(new PropertyValueFactory<>("matematica"));
		biologia.setCellValueFactory(new PropertyValueFactory<>("biologia"));
		fisica.setCellValueFactory(new PropertyValueFactory<>("fisica"));
		ingles.setCellValueFactory(new PropertyValueFactory<>("ingles"));
		geografia.setCellValueFactory(new PropertyValueFactory<>("geografia"));
		historia.setCellValueFactory(new PropertyValueFactory<>("historia"));
		sociologia.setCellValueFactory(new PropertyValueFactory<>("sociologia"));
		edFisica.setCellValueFactory(new PropertyValueFactory<>("edFisica"));
		quimica.setCellValueFactory(new PropertyValueFactory<>("quimica"));
		artes.setCellValueFactory(new PropertyValueFactory<>("artes"));
		filosofia.setCellValueFactory(new PropertyValueFactory<>("filosofia"));

		tableView.setItems(listarNotas());

	}

	private ObservableList<Materias> listarNotas() {
		LogonViewController logonRa = new LogonViewController();
		AlunoDAO alunoDao = DaoFactory.criarAluno();
		List<Materias> list = alunoDao.ProcurarNotaRa(logonRa.auxSenha);
		return FXCollections.observableArrayList(list);

	}
	private void textArea() {
		txtArea.setText("Aqui voc� pode consultar as suas notas e responder a um teste vocacional caso tenha interesse em saber em qual cursos voc� possivelmente\r\n" + 
				"se encaixaria, caso haja duvidas ou encontre problemas, favor informar na secretaria.");
	}

}