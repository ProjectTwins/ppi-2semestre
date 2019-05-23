package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Aluno;
import entities.Materias;
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

		try {
			st = conn.prepareStatement("INSERT INTO tb_aluno" + "(nome, turma) " + "VALUES" + "(? , ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());

			st.setString(2, obj.getTurma());

			// Inserindo RA Materias

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
		PreparedStatement st2 = null;

		try {
			st = conn.prepareStatement("DELETE FROM tb_materias " + "WHERE ra = ? ");
			st2 = conn.prepareStatement("DELETE FROM tb_aluno " + "WHERE ra = ? ");
			
			st.setInt(1, ra);
			st2.setInt(1, ra);
			
			st.executeUpdate();
			st2.executeUpdate();

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
	public void inserirNota(double notas[],Integer raAluno,Integer raMaterias) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("INSERT INTO tb_materias "
					+ "( ra , portugues , matematica , biologia , fisica , quimica , filosofia , ingles , geografia , historia , sociologia , edFisica , artes, raMaterias) "
					+ "VALUES (?, ? ,? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ? ) ");

			st.setInt(1, raAluno);
			st.setDouble(2, notas[0]);
			st.setDouble(3, notas[1]);
			st.setDouble(4, notas[2]);
			st.setDouble(5, notas[3]);
			st.setDouble(6, notas[4]);
			st.setDouble(7, notas[5]);
			st.setDouble(8, notas[6]);
			st.setDouble(9, notas[7]);
			st.setDouble(10, notas[8]);
			st.setDouble(11, notas[9]);
			st.setDouble(12, notas[10]);
			st.setDouble(13, notas[11]);
			st.setInt(14, raMaterias);

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}
	
	public void atualizarNotas(double notas[],Integer raAluno) {
		PreparedStatement st = null;
		try {
		st = conn.prepareStatement("update tb_materias "+
				 "set portugues = ?, matematica = ?,biologia = ?, fisica = ?, quimica = ?, filosofia = ?, ingles = ?,geografia = ?,historia = ?, sociologia = ?,edFisica = ?, artes = ? " +
				 "where ra = ? " );
		
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
		st.setInt(13, raAluno);
		
		st.executeUpdate();
		
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	public List<Aluno> ProcurarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM tb_aluno ORDER BY nome");
			rs = st.executeQuery();

			List<Aluno> list = new ArrayList<>();
			while (rs.next()) {
				Aluno obj = new Aluno();
				obj.setRa(rs.getInt("ra"));
				obj.setNome(rs.getString("nome"));
				obj.setTurma(rs.getString("turma"));
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Materias> ProcurarNota() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM " + 
					"tb_aluno " + 
					"INNER JOIN tb_materias " + 
					"ON tb_aluno.ra=tb_materias.ra");
			rs = st.executeQuery();

			List<Materias> list = new ArrayList<>();
			while (rs.next()) {
				Materias obj = new Materias();
				obj.setArtes(rs.getDouble("artes"));
				obj.setBiologia(rs.getDouble("biologia"));
				obj.setEdFisica(rs.getDouble("edFisica"));
				obj.setFilosofia(rs.getDouble("filosofia"));
				obj.setFisica(rs.getDouble("fisica"));
				obj.setGeografia(rs.getDouble("geografia"));
				obj.setHistoria(rs.getDouble("historia"));
				obj.setIngles(rs.getDouble("ingles"));
				obj.setMatematica(rs.getDouble("matematica"));
				obj.setPortugues(rs.getDouble("portugues"));
				obj.setQuimica(rs.getDouble("quimica"));
				obj.setSociologia(rs.getDouble("sociologia"));
				obj.setRa(rs.getInt("ra"));
				obj.setRaMaterias(rs.getInt("raMaterias"));
				
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Materias> ProcurarNotaRa(Integer ra) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from tb_materias where ra = ?" );
			
			st.setInt(1, ra);
			
			rs = st.executeQuery();
			
			List<Materias> list = new ArrayList<>();
			while (rs.next()) {
				Materias obj = new Materias();
				obj.setArtes(rs.getDouble("artes"));
				obj.setBiologia(rs.getDouble("biologia"));
				obj.setEdFisica(rs.getDouble("edFisica"));
				obj.setFilosofia(rs.getDouble("filosofia"));
				obj.setFisica(rs.getDouble("fisica"));
				obj.setGeografia(rs.getDouble("geografia"));
				obj.setHistoria(rs.getDouble("historia"));
				obj.setIngles(rs.getDouble("ingles"));
				obj.setMatematica(rs.getDouble("matematica"));
				obj.setPortugues(rs.getDouble("portugues"));
				obj.setQuimica(rs.getDouble("quimica"));
				obj.setSociologia(rs.getDouble("sociologia"));
				obj.setRa(rs.getInt("ra"));
				obj.setRaMaterias(rs.getInt("raMaterias"));
				
				list.add(obj);
			}
			return list;
			
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}

}
