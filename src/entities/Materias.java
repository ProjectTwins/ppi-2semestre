package entities;

public class Materias {

	public void setRa(Integer ra) {
		this.ra = ra;
	}

	public void setMatematica(Double matematica) {
		this.matematica = matematica;
	}

	public void setPortugues(Double portugues) {
		this.portugues = portugues;
	}

	public void setGeografia(Double geografia) {
		this.geografia = geografia;
	}

	public void setBiologia(Double biologia) {
		this.biologia = biologia;
	}

	public void setFisica(Double fisica) {
		this.fisica = fisica;
	}

	public void setQuimica(Double quimica) {
		this.quimica = quimica;
	}

	public void setFilosofia(Double filosofia) {
		this.filosofia = filosofia;
	}

	public void setIngles(Double ingles) {
		this.ingles = ingles;
	}

	public void setHistoria(Double historia) {
		this.historia = historia;
	}

	public void setSociologia(Double sociologia) {
		this.sociologia = sociologia;
	}

	public void setEdFisica(Double edFisica) {
		this.edFisica = edFisica;
	}

	public void setArtes(Double artes) {
		this.artes = artes;
	}

	private Integer raMaterias;
	private Integer ra;
	private Double matematica;
	private Double portugues;
	private Double geografia;
	private Double biologia;
	private Double fisica;
	private Double quimica;
	private Double filosofia;
	private Double ingles;
	private Double historia;
	private Double sociologia;
	private Double edFisica;
	private Double artes;
	
	public Integer getRaMaterias() {
		return raMaterias;
	}

	public void setRaMaterias(Integer raMaterias) {
		this.raMaterias = raMaterias;
	}

	public Materias() {
		
	}
	

	public Materias(Integer raMaterias) {
		this.raMaterias = raMaterias;
	}

	public Materias(Integer raMaterias, Integer ra, Double matematica, Double portugues, Double geografia,
			Double biologia, Double fisica, Double quimica, Double filosofia, Double ingles, Double historia,
			Double sociologia, Double edFisica, Double artes) {
		super();
		this.raMaterias = raMaterias;
		this.ra = ra;
		this.matematica = matematica;
		this.portugues = portugues;
		this.geografia = geografia;
		this.biologia = biologia;
		this.fisica = fisica;
		this.quimica = quimica;
		this.filosofia = filosofia;
		this.ingles = ingles;
		this.historia = historia;
		this.sociologia = sociologia;
		this.edFisica = edFisica;
		this.artes = artes;
	}

	public Integer getRa() {
		return ra;
	}

	public Double getMatematica() {
		return matematica;
	}

	public Double getPortugues() {
		return portugues;
	}

	public Double getGeografia() {
		return geografia;
	}

	public Double getBiologia() {
		return biologia;
	}

	public Double getFisica() {
		return fisica;
	}

	public Double getQuimica() {
		return quimica;
	}

	public Double getFilosofia() {
		return filosofia;
	}

	public Double getIngles() {
		return ingles;
	}

	public Double getHistoria() {
		return historia;
	}

	public Double getSociologia() {
		return sociologia;
	}

	public Double getEdFisica() {
		return edFisica;
	}

	public Double getArtes() {
		return artes;
	}
	
	
	
	
	
	
}
