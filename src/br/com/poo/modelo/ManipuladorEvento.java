package br.com.poo.modelo;

import br.com.poo.modelo.auxiliares.Data;
import br.com.poo.modelo.auxiliares.Hora;
import br.com.poo.ManipuladorListaEvento;
import br.com.poo.modelo.auxiliares.Artista;

public class ManipuladorEvento {
	public Evento evento;
	
	// Cria um Evento passando seus dados para suas determinadas classes.
	public Evento criarEvento(String nome, String data, String horario, String artista) {
		this.evento = new Evento();
		this.evento.nome = nome;
		this.evento.data = new Data(data);
		this.evento.hora = new Hora(horario);
		this.evento.artista = new Artista(artista);
		return this.evento;
	}
}
