package application;

import model.AlunoDAO;
import model.dao.DaoFactory;

public class Program {

	public static void main(String[] args) {
		AlunoDAO dao = DaoFactory.criarAluno();

		
	}

}
