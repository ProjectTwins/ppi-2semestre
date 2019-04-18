package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Aluno;
import entities.Materias;
import model.AlunoDAO;

public class AlunoDaoJDBC implements AlunoDAO {

	private Connection conn;
	Materias materias = new Materias(new double[12]);

	public AlunoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	Aluno aluno = new Aluno();
	@Override
	public void inserirAluno(Aluno obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO tb_aluno" + "(nome, turma) " + "VALUES" + "(?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());
			
			st.setString(2, obj.getTurma());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void atualizarAluno(Aluno obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE tb_aluno " + "SET nome = ?, turma = ? " + "WHERE ra = ? ");

			st.setString(1, obj.getNome());
			st.setString(2, obj.getTurma());
			st.setInt(3, obj.getRa());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deletarPeloRa(Integer ra) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"DELETE FROM tb_aluno " +
					"WHERE ra = ? "
					);
			
			st.setInt(1, ra);
			st.executeUpdate();
			
		}
		catch(SQLException e){
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public Aluno procurarPeloRa(Integer ra) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM tb_aluno " + "WHERE ra = ? ");

			st.setInt(1, ra);
			rs = st.executeQuery();
			if(rs.next()) {
				Aluno obj = new Aluno();
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void inserirNota(Materias materias, Integer ra) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("INSERT INTO tb_materias "
					+ "(portugues , matematica , biologia , fisica , quimica , filosofia , ingles , geografia , historia , sociologia , educacao_fisica , artes) "
					+ "VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?) " + "WHERE ra = ? ");

			st.setDouble(1, materias.getNota(0));
			st.setDouble(2, materias.getNota(1));
			st.setDouble(3, materias.getNota(2));
			st.setDouble(4, materias.getNota(3));
			st.setDouble(5, materias.getNota(4));
			st.setDouble(6, materias.getNota(5));
			st.setDouble(7, materias.getNota(6));
			st.setDouble(8, materias.getNota(7));
			st.setDouble(9, materias.getNota(8));
			st.setDouble(10, materias.getNota(9));
			st.setDouble(11, materias.getNota(10));
			st.setDouble(12, materias.getNota(11));
			st.setInt(13, ra);

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	

}
