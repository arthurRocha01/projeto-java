package br.com.poo.modelo;

import br.com.poo.modelo.auxiliares.Local;

public class Ingresso {
	public Evento evento;
	public double valor;
	
	public Ingresso() {
		this.evento = new Evento();
	}
	
	public void informarLocal(Ingresso ingresso, String infoEndereco, int capacidade) {
		if (ingresso == null || ingresso.evento == null) {
			throw new IllegalStateException("Crie o evento antes de informar o local.");
		}
		Local novoLocal = new Local(infoEndereco, capacidade);
		this.evento.local = novoLocal;
		this.evento.local.informarEndereco(infoEndereco);
	}
	
	public void informarValor(Ingresso ingresso, double valor) {
		if (ingresso == null) {
			throw new IllegalStateException("Crie o evento antes de informar o valor.");
		}
		ingresso.valor = valor;
	}
}
