package application;

import java.util.Scanner;

import entities.Aluno;
import entities.Materias;
import model.dao.DaoFactory;
import model.dao.impl.AlunoDaoJDBC;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		AlunoDaoJDBC alunoDaoJDBC = (AlunoDaoJDBC) DaoFactory.criarAluno();

		double[] notas = new double[12];

		notas[0] = 4;
		notas[1] = 3;
		notas[2] = 6;
		notas[3] = 7;
		notas[4] = 8;
		notas[5] = 9;
		notas[6] = 10;
		notas[7] = 3;
		notas[8] = 2;
		notas[9] = 1;
		notas[10] = 0;
		notas[11] = 4;

		alunoDaoJDBC.inserirNota(notas , 1);

		sc.close();
	}

}
