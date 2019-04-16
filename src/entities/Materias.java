
package entities;

public class Materias {
	
	private double[] materias = new double[12];
	
	public double getNota(int pos) {
		return materias[pos];
	}
	
	public void setNota(int pos ,double valor) {
		materias[pos] =  valor;
	}
}