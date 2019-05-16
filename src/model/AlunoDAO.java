package model;

import java.util.List;

import entities.Aluno;
import entities.Materias;

public interface AlunoDAO {
	public void inserirAluno(Aluno obj);

	public void atualizarAluno(Aluno obj);

	public void inserirNota(double[] notas, Integer raAluno);

	public void deletarPeloRa(Integer ra);

	Aluno procurarPeloRa(Integer ra);
	
	List<Aluno> ProcurarTodos();
	
	List<Materias> ProcurarNota();
}
