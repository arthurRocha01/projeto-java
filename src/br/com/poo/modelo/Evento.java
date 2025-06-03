package br.com.poo.modelo;

import br.com.poo.modelo.auxiliares.Artista;
import br.com.poo.modelo.auxiliares.Data;
import br.com.poo.modelo.auxiliares.Hora;
import br.com.poo.modelo.auxiliares.Local;

public class Evento {
	public int id;
	public Ingresso ingresso;
	public String nome;
	public Data data;
	public Hora hora;
	public Artista artista;
	public Local local;
	
	public Evento() {
		this.ingresso = new Ingresso();
	}
	
	public void informarLocal(String infoEndereco, String capacidade) {
		Local novoLocal = new Local(infoEndereco, capacidade);
		this.local = novoLocal;
	}
	
	public void informarValor(String valor) {
		if (this.ingresso == null) {
			throw new IllegalStateException("Crie o evento antes de informar o valor.");
		}
		this.ingresso.valor = Double.parseDouble(valor);
	}
}
