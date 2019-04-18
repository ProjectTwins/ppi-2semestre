package model;

import java.util.List;

import entities.Aluno;
import entities.Materias;

public interface AlunoDAO {
	public void inserirAluno(Aluno obj);
	public void atualizarAluno(Aluno obj);
	public void inserirNota(Materias materias ,Integer ra);
	public void deletarPeloRa(Integer ra);
	Aluno procurarPeloRa(Integer ra); 
}
