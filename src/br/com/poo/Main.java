package br.com.poo;

import br.com.poo.modelo.Evento;
import br.com.poo.modelo.ManipuladorShows;

public class Main {
	public static void main(String[] args) {
		ManipuladorShows manipuladorShows = new ManipuladorShows();
		Evento s1 = manipuladorShows.criarEvento("Rick and Morty", "10-09-2008", "18:30", "Nicolas,32");
		s1.informarValor( 20);
		s1.informarLocal("Brasil,bahia,salvador,pau da lima,pg,23", 10);
		
		System.out.println(s1.nome);
		System.out.println(s1.ingresso.valor);
		System.out.println(s1.local.endereco.cidade);
	}
}
