package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import model.AlunoDAO;
import model.dao.DaoFactory;
import model.dao.impl.AlunoDaoJDBC;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		AlunoDaoJDBC alunoDaoJDBC = (AlunoDaoJDBC) DaoFactory.criarAluno();

		Aluno aluno = alunoDaoJDBC.procurarPeloRa(4);
		System.out.println(aluno);
		
		

		sc.close();
	}

}
