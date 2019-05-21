package application;

import java.util.List;

import entities.Materias;
import model.AlunoDAO;
import model.dao.DaoFactory;

public class Program {

	public static void main(String[] args) {
		AlunoDAO dao = DaoFactory.criarAluno();
		
		AlunoDAO alunoDao = DaoFactory.criarAluno();
		List<Materias> list = alunoDao.ProcurarNotaRa(6);
		System.out.println(list);

		
		
	}

}
