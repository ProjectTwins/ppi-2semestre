
package entities;

public class Materias {
	
	
	
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