package model.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import entities.Aluno;
import model.AlunoDAO;

public class AlunoDaoJDBC implements AlunoDAO {

	private Connection conn;

	public AlunoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	Aluno aluno = new Aluno();

	@Override
	public void inserirAluno(Aluno obj) {
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO tb_aluno" + "(nome, turma) " + "VALUES" + "(?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());

			st.setString(2, obj.getTurma());
			
			
			//Inserindo RA Materias
			
			st2 = conn.prepareStatement("INSERT INTO tb_materias "
					+ "(portugues , matematica , biologia , fisica , quimica , filosofia , ingles , geografia , historia , sociologia , ed_fisica , artes , raMaterias) "
					+ "VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?) ");


			
			for(int i = 1 ; i <= 12 ; i++){
			 st2.setInt(i , 0);

         }
			
			st2.setInt(13, 2);

			st.executeUpdate();
			st2.executeUpdate();

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
			st = conn.prepareStatement("DELETE FROM tb_aluno " + "WHERE ra = ? ");

			st.setInt(1, ra);
			st.executeUpdate();

		} catch (SQLException e) {
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
			if (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setRa(rs.getInt("ra"));
				aluno.setNome(rs.getString("nome"));
				aluno.setTurma(rs.getString("turma"));
				return aluno;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void inserirNota(double notas[], Integer ra) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("INSERT INTO tb_materias "
					+ "(portugues , matematica , biologia , fisica , quimica , filosofia , ingles , geografia , historia , sociologia , ed_fisica , artes) "
					+ "VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?) " + "WHERE raMaterias = ? ");

			st.setDouble(1, notas[0]);
			st.setDouble(2, notas[1]);
			st.setDouble(3, notas[2]);
			st.setDouble(4, notas[3]);
			st.setDouble(5, notas[4]);
			st.setDouble(6, notas[5]);
			st.setDouble(7, notas[6]);
			st.setDouble(8, notas[7]);
			st.setDouble(9, notas[8]);
			st.setDouble(10, notas[9]);
			st.setDouble(11, notas[10]);
			st.setDouble(12, notas[11]);
			st.setInt(13, ra);
			
			st.setInt(1, 0);

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

}
