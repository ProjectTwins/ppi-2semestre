package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TesteVocacionalController implements Initializable {

	int i = 1;
	int pontos = 0;

	@FXML
	private TextArea resultado;

	@FXML
	private Text txtSubtitle;

	@FXML
	private Text question;

	@FXML
	private RadioButton q1;

	@FXML
	private RadioButton q2;

	@FXML
	private RadioButton q3;

	@FXML
	private RadioButton q4;

	@FXML
	private RadioButton q5;

	@FXML
	private RadioButton q6;

	@FXML
	private Button proximo;

	@FXML
	public void onActionBtProximo(ActionEvent e) {

		i = i + 1;

		if (i == 2) {
			comparar();

			txtSubtitle.setText("Pergunta 2");
			question.setText("Quais são seus valores?");
			q1.setText("Recompensa fincanceira para realizações mensuraveis.");
			q2.setText("Conhecimento e aprendizagem.");
			q3.setText("Ideias criativas,emoções,sentimentos.");
			q4.setText("Trabalho para o bem-estar dos demais");
			q5.setText("Dinheiro e status social.");
			q6.setText("Dinheiro e ocupações comerciais ou políticas.");

			if (q1.isSelected()) {
				this.pontos = this.pontos + 1;
			}
			if (q2.isSelected()) {
				this.pontos = this.pontos + 2;
			}
			if (q3.isSelected()) {
				this.pontos = this.pontos + 3;
			}
			if (q4.isSelected()) {
				this.pontos = this.pontos + 4;
			}
			if (q5.isSelected()) {
				this.pontos = this.pontos + 5;
			}
			if (q6.isSelected()) {
				this.pontos = this.pontos + 6;
			}

			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);

		} else if (i == 3) {
			comparar();

			txtSubtitle.setText("Pergunta 3");
			question.setText("Como você se Vê?");
			q1.setText("Prático, conservador, mais habilidades mecanicas que sociais.");
			q2.setText("Analitico, Inteligente, cetico, mais habilidades academicas, que sociais.");
			q3.setText("Aberto a experiencias, inovador, intelectual, mais habilidades criativas que mecanicas.");
			q4.setText("Compreensivo e paciente com sentimentos alheios, mais habilidades sociais que mecanicas.");
			q5.setText("Lider, condutor. Mais habilidades persuasiva que cientifica.");
			q6.setText("Disciplinado, coerente.Mais habilidades tecnicas que artisticas.");

			if (q1.isSelected()) {
				this.pontos = this.pontos + 1;
			}
			if (q2.isSelected()) {
				this.pontos = this.pontos + 2;
			}
			if (q3.isSelected()) {
				this.pontos = this.pontos + 3;
			}
			if (q4.isSelected()) {
				this.pontos = this.pontos + 4;
			}
			if (q5.isSelected()) {
				this.pontos = this.pontos + 5;
			}
			if (q6.isSelected()) {
				this.pontos = this.pontos + 6;
			}

			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);

		} else if (i == 4) {
			comparar();

			txtSubtitle.setText("Pergunta 4");
			question.setText("Como as pessoas veem você?");
			q1.setText("Normal, Franco.");
			q2.setText("Inteligente e introvertido.");
			q3.setText("Incomum, desorganizado e criativo.");
			q4.setText("Útil, agradável e bem disposto.");
			q5.setText("Energético, articulado.");
			q6.setText("Cuidadoso seguidor de regras.");

			if (q1.isSelected()) {
				this.pontos = this.pontos + 1;
			}
			if (q2.isSelected()) {
				this.pontos = this.pontos + 2;
			}
			if (q3.isSelected()) {
				this.pontos = this.pontos + 3;
			}
			if (q4.isSelected()) {
				this.pontos = this.pontos + 4;
			}
			if (q5.isSelected()) {
				this.pontos = this.pontos + 5;
			}
			if (q6.isSelected()) {
				this.pontos = this.pontos + 6;
			}

			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);

		} else if (i == 5) {
			comparar();

			txtSubtitle.setText("Pergunta 5");
			question.setText("O que você procura evitar?");
			q1.setText("Interação com outras pessoas.");
			q2.setText("Persuadir os demais ou vender coisas.");
			q3.setText("Rotinas e regras.");
			q4.setText("Atividades mecanicas e tecnicas.");
			q5.setText("Tópicos cientificos ou intelectuais.");
			q6.setText("Trabalhos sem direção clara.");

			if (q1.isSelected()) {
				this.pontos = this.pontos + 1;
			}
			if (q2.isSelected()) {
				this.pontos = this.pontos + 2;
			}
			if (q3.isSelected()) {
				this.pontos = this.pontos + 3;
			}
			if (q4.isSelected()) {
				this.pontos = this.pontos + 4;
			}
			if (q5.isSelected()) {
				this.pontos = this.pontos + 5;
			}
			if (q6.isSelected()) {
				this.pontos = this.pontos + 6;
			}

			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);

		} else if (i == 6) {
			Utils.currenteStage(e).close();

			if (q1.isSelected()) {
				this.pontos = this.pontos + 1;
			}
			if (q2.isSelected()) {
				this.pontos = this.pontos + 2;
			}
			if (q3.isSelected()) {
				this.pontos = this.pontos + 3;
			}
			if (q4.isSelected()) {
				this.pontos = this.pontos + 4;
			}
			if (q5.isSelected()) {
				this.pontos = this.pontos + 5;
			}
			if (q6.isSelected()) {
				this.pontos = this.pontos + 6;
			}

			if ((this.pontos <= 5)) {
				Stage parentStage = Utils.currenteStage(e);
				ResultadoTesteVocacional("/gui/ResultadoTeste.fxml", parentStage);
				
				

			} else if ((this.pontos > 5) && (this.pontos <= 10)) {
				Stage parentStage = Utils.currenteStage(e);
				ResultadoTesteVocacional("/gui/ResultadoTeste2.fxml", parentStage);
				

			} else if ((this.pontos > 10) && (this.pontos <= 15)) {
				Stage parentStage = Utils.currenteStage(e);
				ResultadoTesteVocacional("/gui/ResultadoTeste3.fxml", parentStage);

			} else if ((this.pontos > 15) && (this.pontos <= 20)) {
				Stage parentStage = Utils.currenteStage(e);
				ResultadoTesteVocacional("/gui/ResultadoTeste4.fxml", parentStage);

			} else if ((this.pontos > 20) && (this.pontos <= 25)) {
				Stage parentStage = Utils.currenteStage(e);
				ResultadoTesteVocacional("/gui/ResultadoTeste5.fxml", parentStage);

			} else if ((this.pontos > 25) && (this.pontos <= 30)) {
				Stage parentStage = Utils.currenteStage(e);
				ResultadoTesteVocacional("/gui/ResultadoTeste6.fxml", parentStage);

			}

		}

		System.out.println(this.pontos);
	}

	@Override
	public void initialize(URL url, ResourceBundle res) {
		
	}

	public void comparar() {
		if (q1.isSelected()) {
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);
		}
		if (q2.isSelected()) {
			q1.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);
		}
		if (q3.isSelected()) {
			q1.setSelected(false);
			q2.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);
		}
		if (q4.isSelected()) {
			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);
		}
		if (q5.isSelected()) {
			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q6.setSelected(false);
		}
		if (q6.isSelected()) {
			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
		}
	}

	private void ResultadoTesteVocacional(String absName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absName));
			AnchorPane anchorPane = loader.load();

			Stage newStage = new Stage();
			newStage.setTitle("Teste Vocacional");
			newStage.setScene(new Scene(anchorPane));
			newStage.setResizable(false);
			newStage.initOwner(parentStage);
			newStage.initModality(Modality.WINDOW_MODAL);
			newStage.show();
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}

	}


	
}
