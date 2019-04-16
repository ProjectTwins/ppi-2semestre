package model.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO aluno" +
					"(nome, ra, turma) " +
					"VALUES"
					+"(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
					
			st.setString(1, obj.getNome());
			st.setInt(2, obj.getRa());
			st.setString(3, obj.getTurma());
			
			st.executeUpdate();
					 
					
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void atualizarAluno(Aluno obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE aluno" +
					"SET name = ?, turma = ?"+
					"WHERE ra = ?");
					
			st.setString(1, obj.getNome());
			st.setString(2, obj.getTurma());
			st.setInt(3, obj.getRa());
			
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("SELECT * FROM tb_aluno AND tb_materia "+
		"WHERE ra = ? ");
			
			st.setInt(1, ra);
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

}
