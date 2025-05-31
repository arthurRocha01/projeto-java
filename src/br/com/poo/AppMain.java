package br.com.poo;

import br.com.poo.modelo.Evento;
import br.com.poo.modelo.ManipuladorShows;

public class AppMain {
	private ManipuladorShows manipuladorShows = new ManipuladorShows();
	private ManipuladorListaEventos manipuladorListaEventos = new ManipuladorListaEventos();
	
	public static void main(String[] args) {
		AppMain app = new AppMain();
//		app.gerarEventoManual();
		app.gerEventoAutomatico(3);
	}
	
	public void gerarEventoManual() {
		Evento[] eventos = new Evento[3];

		eventos[0] = manipuladorShows.criarEvento("Jazz Night", "12-11-2023", "20:00", "Maria,27");
		eventos[0].informarValor(35);
		eventos[0].informarLocal("Brasil,SP,São Paulo,Vila Mariana,Rua Aurora,15", 50);

		eventos[1] = manipuladorShows.criarEvento("Rock in Rua", "25-06-2024", "19:30", "Carlos,30");
		eventos[1].informarValor(50);
		eventos[1].informarLocal("Brasil,RJ,Rio de Janeiro,Lapa,Av Mem de Sá,300", 100);

		eventos[2] = manipuladorShows.criarEvento("Forró Fest", "01-01-2025", "22:00", "Ana,22");
		eventos[2].informarValor(25);
		eventos[2].informarLocal("Brasil,PE,Recife,Boa Viagem,Rua das Flores,90", 80);
		
		manipuladorListaEventos.listarEventos(eventos);
	}
	
	public void gerEventoAutomatico(int numEventos) {
		Evento[] listaEventos = new Evento[numEventos];
		listaEventos = manipuladorListaEventos.gerarListaEventos(numEventos);
		manipuladorListaEventos.listarEventos(listaEventos);
	}
}
