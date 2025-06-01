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
		this.ingresso = new Ingresso(); // Instancia sua classe filha ao ser instanciada.
	}
	
	// Seta o local e capacidade do objeto Evento.
	public void informarLocal(String infoEndereco, int capacidade) {
		Local novoLocal = new Local(infoEndereco, capacidade); // Instancia um objeto Local para o objeto passando seus dados;
		this.local = novoLocal;
	}
	
	// Seta o valor do ingresso do objeto Evento.
	public void informarValor(double valor) {
		// Verifica se Ingresso existe no objeto.
		if (this.ingresso == null) {
			throw new IllegalStateException("Crie o evento antes de informar o valor.");
		}
		this.ingresso.valor = valor;
	}
}
