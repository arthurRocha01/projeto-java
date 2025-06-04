package br.com.poo.modelo.auxiliares;

public class Artista {
	public String nome;
	
	public Artista(String infoArtista) {
		criarArtista(infoArtista);
	}
	
	public void criarArtista(String nomeArtista) {
		this.nome = nomeArtista;
	}
}
