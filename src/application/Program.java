package application;


import java.util.Scanner;

import entities.Aluno;
import model.dao.DaoFactory;
import model.dao.impl.AlunoDaoJDBC;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		AlunoDaoJDBC alunoDaoJDBC = (AlunoDaoJDBC) DaoFactory.criarAluno();

		
		Aluno aluno = new Aluno("Juaquim", null, "3B");
		alunoDaoJDBC.inserirAluno(aluno);
		
		
	
		
		

		sc.close();
	}

}
