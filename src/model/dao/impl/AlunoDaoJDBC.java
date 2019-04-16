package model.dao.impl;



import java.sql.Connection;

import entities.Aluno;
import entities.Materias;
import model.AlunoDAO;

public class AlunoDaoJDBC implements AlunoDAO{

	
	private Connection conn;
	
	public AlunoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void inserirAluno(Aluno obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarAluno(Aluno obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserirNota(Materias obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPeloRa(Integer ra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procurarPeloRa(Integer ra) {
		// TODO Auto-generated method stub
		
	}

}
