
package entities;

import java.io.Serializable;

public class Materias implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;

	public Materias(double[] materias) {
		this.materias = materias;
	}

	private double[] materias;
	
	public double getNota(int pos) {
		return materias[pos];
	}
	
	public void setNota(int pos ,double valor) {
		materias[pos] =  valor;
	}
	
	
}