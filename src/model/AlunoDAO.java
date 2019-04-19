package model;

import entities.Aluno;

public interface AlunoDAO {
	public void inserirAluno(Aluno obj);

	public void atualizarAluno(Aluno obj);

	public void inserirNota(double[] notas, Integer ra);

	public void deletarPeloRa(Integer ra);

	Aluno procurarPeloRa(Integer ra);
}
