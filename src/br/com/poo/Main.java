package br.com.poo;

import br.com.poo.modelo.Ingresso;
import br.com.poo.modelo.ManipuladorShows;

public class Main {
	public static void main(String[] args) {
		ManipuladorShows manipuladorShows = new ManipuladorShows();
		Ingresso s1 = manipuladorShows.criarShow("Rick and Morty", "10-09-2008", "18:30", "Nicolas,32");
		s1.informarValor(s1, 20);
		s1.informarLocal(s1, "Brasil,bahia,salvador,pau da lima,pg,23", 10);
		
		System.out.println(s1.evento.nome);
		System.out.println(s1.valor);
		System.out.println(s1.evento.local.endereco.cidade);
	}
}
