package entities;

import model.AlunoDAO;
import model.dao.DaoFactory;
import model.dao.impl.AlunoDaoJDBC;

public class LogonAluno {
	
	AlunoDAO alunodao = DaoFactory.criarAluno();
	
	private String nome;
	private Integer senhaRa;
	
	
	private Integer raAut;
	private String nomeAut;


	public LogonAluno(String nome, Integer senhaRa) {
		this.nome = nome;
		this.senhaRa = senhaRa;
	}

	public boolean Autenticacao() {
		this.raAut = alunodao.procurarPeloRa(this.senhaRa).getRa();
		this.nomeAut = alunodao.procurarPeloRa(this.senhaRa).getNome();
		
		if ((this.nome.equals(this.nomeAut)) && (this.senhaRa == this.raAut)) {
			return true;
		} else
			return false;

	}
	
}