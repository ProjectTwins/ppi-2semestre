package model;

import entities.Aluno;
import entities.Materias;

public interface AlunoDAO {
	public void inserirAluno(Aluno obj);
	public void atualizarAluno(Aluno obj);
	public void inserirNota(Materias obj);
	public void deletarPeloRa(Integer ra);
	public void procurarPeloRa(Integer ra);
}
