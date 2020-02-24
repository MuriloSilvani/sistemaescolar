package br.com.alura.escolalura.models;

public class Nota {
	private Double valor;

	public Nota() {
	}
	
	public Nota(Double nota) {
		this.valor = nota;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}