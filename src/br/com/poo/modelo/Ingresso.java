package br.com.poo.modelo;

public class Ingresso {
	public Evento evento;
	public double valor;
	
	public void setValor(String valor) { 
		this.valor = Double.parseDouble(valor.trim());
	}
}
