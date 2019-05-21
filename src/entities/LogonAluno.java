package entities;

import model.AlunoDAO;
import model.dao.DaoFactory;

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
	
	public LogonAluno() {
	}

	public boolean Autenticacao() {
		this.raAut = alunodao.procurarPeloRa(this.senhaRa).getRa();
		this.nomeAut = alunodao.procurarPeloRa(this.senhaRa).getNome();
		
		if ((this.nome.equals(this.nomeAut)) && (this.senhaRa == this.raAut)) {
			return true;
		} else
			return false;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSenhaRa() {
		return senhaRa;
	}

	public void setSenhaRa(Integer senhaRa) {
		this.senhaRa = senhaRa;
	}

	public Integer getRaAut() {
		return raAut;
	}

	public void setRaAut(Integer raAut) {
		this.raAut = raAut;
	}

	public String getNomeAut() {
		return nomeAut;
	}

	public void setNomeAut(String nomeAut) {
		this.nomeAut = nomeAut;
	}
	
	
	
}