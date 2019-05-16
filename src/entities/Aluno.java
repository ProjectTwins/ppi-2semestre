package entities;

import java.io.Serializable;

public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Integer ra;
	private String turma;
	

	public Aluno(String nome, Integer ra, String turma) {
		this.nome = nome;
		this.ra = ra;
		this.turma = turma;
	}

	public Aluno() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", ra=" + ra + ", turma=" + turma + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
