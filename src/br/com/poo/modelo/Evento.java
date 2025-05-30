package br.com.poo.modelo;

import br.com.poo.modelo.auxiliares.Artista;
import br.com.poo.modelo.auxiliares.Data;
import br.com.poo.modelo.auxiliares.Hora;
import br.com.poo.modelo.auxiliares.Local;

public class Evento {
	public Ingresso ingresso;
	public String nome;
	public Data data;
	public Hora hora;
	public Artista artista;
	public Local local;
	
	public Evento() {
		this.ingresso = new Ingresso();
	}
	
	public void informarLocal(String infoEndereco, int capacidade) {
//		if (this == null) {
//			throw new IllegalStateException("Crie o evento antes de informar o local.");
//		}
		Local novoLocal = new Local(infoEndereco, capacidade);
		this.local = novoLocal;
		this.local.informarEndereco(infoEndereco);
	}
	
	public void informarValor(double valor) {
		if (this.ingresso == null) {
			throw new IllegalStateException("Crie o evento antes de informar o valor.");
		}
		this.ingresso.valor = valor;
	}
}
