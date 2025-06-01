package br.com.poo;

import br.com.poo.modelo.Evento;
import br.com.poo.modelo.ManipuladorEvento;

public class AppMain {
	private ManipuladorEvento manipuladorEvento = new ManipuladorEvento(); // Manipula a ciação de Evento.
	private ManipuladorListaEvento manipuladorListaEvento = new ManipuladorListaEvento(); // Manipula a criação de um lista Evento dinâmica.
	
	public static void main(String[] args) {
		AppMain app = new AppMain();
//		app.gerarEventosManual();
		app.gerEventosAutomatico(3);
	}
	
	// Gera eventos instanciando objeto por objeto manualmente.
	public void gerarEventosManual() {
		Evento[] eventos = new Evento[3];

		eventos[0] = manipuladorEvento.criarEvento("Jazz Night", "12-11-2023", "20:00", "Maria,27");
		eventos[0].informarValor(35);
		eventos[0].informarLocal("Brasil,SP,São Paulo,Vila Mariana,Rua Aurora,15", 50);

		eventos[1] = manipuladorEvento.criarEvento("Rock in Rua", "25-06-2024", "19:30", "Carlos,30");
		eventos[1].informarValor(50);
		eventos[1].informarLocal("Brasil,RJ,Rio de Janeiro,Lapa,Av Mem de Sá,300", 100);

		eventos[2] = manipuladorEvento.criarEvento("Forró Fest", "01-01-2025", "22:00", "Ana,22");
		eventos[2].informarValor(25);
		eventos[2].informarLocal("Brasil,PE,Recife,Boa Viagem,Rua das Flores,90", 80);
		
		manipuladorListaEvento.listarEventos(eventos);
	}
	
	// Gera eventos de forma automática e dinâmica.
	public void gerEventosAutomatico(int numEventos) {
		Evento[] listaEventos = new Evento[numEventos];
		listaEventos = manipuladorListaEvento.gerarListaEventos(numEventos);
		manipuladorListaEvento.listarEventos(listaEventos);
	}
}
