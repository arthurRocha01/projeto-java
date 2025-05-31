package br.com.poo.modelo;

import br.com.poo.modelo.auxiliares.Data;
import br.com.poo.modelo.auxiliares.Hora;
import br.com.poo.ManipuladorListaEventos;
import br.com.poo.modelo.auxiliares.Artista;

public class ManipuladorShows {
	public Evento evento;
	public Evento[] listaEventos;
	private ManipuladorListaEventos manipuladorListaEventos = new ManipuladorListaEventos();
	
	public Evento criarEvento(String nome, String data, String horario, String artista) {
		this.evento = new Evento();
		this.evento.nome = nome;
		this.evento.data = new Data(data);
		this.evento.hora = new Hora(horario);
		this.evento.artista = new Artista(artista);
		return this.evento;
	}
}
