package model;

import java.util.List;

import entities.Aluno;
import entities.Materias;

public interface AlunoDAO {
	public void inserirAluno(Aluno obj);

	public void atualizarAluno(Aluno obj);

	public void inserirNota(double[] notas, Integer raAluno, Integer raMaterias);
	
	public void atualizarNotas(double [] notas, Integer ra);
	
	public void deletarPeloRa(Integer ra);

	Aluno procurarPeloRa(Integer ra);
	
	List<Aluno> ProcurarTodos();
	
	List<Materias> ProcurarNota();
	
	List<Materias> ProcurarNotaRa(Integer ra);
}
