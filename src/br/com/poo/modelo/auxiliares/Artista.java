package br.com.poo.modelo.auxiliares;

public class Artista {
	public String nome;
	public int idade;
	
	public Artista(String infoArtista) {
		criarArtista(infoArtista);
	}
	
	public void criarArtista(String infoArtista) {
		String[] infosArtista = infoArtista.split(",");
		this.nome = infosArtista[0];
		this.idade = Integer.parseInt(infosArtista[1]);
	}
}
