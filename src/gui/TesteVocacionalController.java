package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

public class TesteVocacionalController implements Initializable {
	
	int i = 0;
	int pontos = 0;
	
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
		if(i == 0) {
			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);
			
			txtSubtitle.setText("Pergunta 1");
			question.setText("Do que você gosta?");
			q1.setText("Uso de ferramentas e coisas.");
			q2.setText("Explorar e entender coisas e eventos.");
			q3.setText("Ler livros, atividades artisticas, musicais e escritas.");
			q4.setText("Ajudar, Ensinar, tratar, aconselhar, servir aos demais.");
			q5.setText("Persuadir e dirigir aos demais.");
			q6.setText("Atingir objetivos claros, disciplina");
			
			if(q1.equals(true)) {
				
			}
			
		}
		
		if(i == 2) {
			
			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);
			
			txtSubtitle.setText("Pergunta 2");
			question.setText("Quais são seus valores?");
			q1.setText("Recompensa fincanceira para realizações mensuraveis.");
			q2.setText("Conhecimento e aprendizagem.");
			q3.setText("Ideias criativas,emoções,sentimentos.");
			q4.setText("Trabalho para o bem-estar dos demais");
			q5.setText("Dinheiro e status social.");
			q6.setText("Dinheiro e ocupações comerciais ou políticas.");
			
			if(q1.equals(true)) {
				
			}
		}else if(i == 3) {  
			
			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);
			
			txtSubtitle.setText("Pergunta 3");
			question.setText("Como você se Vê?");
			q1.setText("Prático, conservador, mais habilidades mecanicas que sociais.");
			q2.setText("Analitico, Inteligente, cetico, mais habilidades academicas, que sociais.");
			q3.setText("Aberto a experiencias, inovador, intelectual, mais habilidades criativas que mecanicas.");
			q4.setText("Compreensivo e paciente com sentimentos alheios, mais habilidades sociais que mecanicas.");
			q5.setText("Lider, condutor. Mais habilidades persuasiva que cientifica.");
			q6.setText("Disciplinado, coerente.Mais habilidades tecnicas que artisticas.");
			
		}
		else if(i == 4) {
			
			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);
			
			txtSubtitle.setText("Pergunta 4");
			question.setText("Como as pessoas veem você?");
			q1.setText("Normal, Franco.");
			q2.setText("Inteligente e introvertido.");
			q3.setText("Incomum, desorganizado e criativo.");
			q4.setText("Útil, agradável e bem disposto.");
			q5.setText("Energético, articulado.");
			q6.setText("Cuidadoso seguidor de regras.");
			
		}
		else if(i == 5) {
			
			q1.setSelected(false);
			q2.setSelected(false);
			q3.setSelected(false);
			q4.setSelected(false);
			q5.setSelected(false);
			q6.setSelected(false);
			
			txtSubtitle.setText("Pergunta 5");
			question.setText("O que você procura evitar?");
			q1.setText("Interação com outras pessoas.");
			q2.setText("Persuadir os demais ou vender coisas.");
			q3.setText("Rotinas e regras.");
			q4.setText("Atividades mecanicas e tecnicas.");
			q5.setText("Tópicos cientificos ou intelectuais.");
			q6.setText("Trabalhos sem direção clara.");
			
		}else if(i == 6) {
			Utils.currenteStage(e).close();
		}
		
		i = i + 1;
		System.out.println(i);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

	}
	
	
	
}
