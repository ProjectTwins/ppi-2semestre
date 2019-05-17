package application;

import model.AlunoDAO;
import model.dao.DaoFactory;

public class Program {

	public static void main(String[] args) {
		AlunoDAO dao = DaoFactory.criarAluno();
		double vect[] = new double[12];
		
		vect[0]= 1;
				vect[1]= 1;
				vect[2]= 1;
				vect[3]= 1;
				vect[4]= 1;
				vect[5]= 1;
				vect[6]= 1;
				vect[7]= 1;
				vect[8]= 1;
				vect[9]= 1;
				vect[10]= 1;
				vect[11]= 1;
		
		dao.inserirNota(vect, 4, 0);
		
		
	}

}
