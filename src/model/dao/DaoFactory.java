package model.dao;

import db.DB;
import model.AlunoDAO;
import model.dao.impl.AlunoDaoJDBC;

public class DaoFactory {

	public static AlunoDAO criarAluno() {
		return new AlunoDaoJDBC(DB.getConnection());
	}
}