package br.com.poo;

import br.com.poo.controller.AppController;
import br.com.poo.controller.ManipuladorListaEvento;
import br.com.poo.controller.Controller;
import br.com.poo.modelo.Evento;

public class AppMain {
//	private ManipuladorEvento manipuladorEvento = new ManipuladorEvento();
	private Controller controller = new Controller();
	private ManipuladorListaEvento manipuladorListaEvento = new ManipuladorListaEvento();
	
	public static void main(String[] args) {
		AppController app = new AppController();
		app.iniciarPrompt();
//		app.gerarEventosManual();
//		app.gerEventosAutomatico(3);
//		MainView viewApp = new MainView();
	}
	
	// Gera eventos instanciando objeto por objeto manualmente.
//	public void gerarEventosManual() {
//		Evento[] eventos = new Evento[3];
//
//		eventos[0] = controller.criarEvento("Jazz Night", "12-11-2023", "20:00", "Maria,27");
//		eventos[0].informarValor(35);
//		eventos[0].informarLocal("Brasil,SP,São Paulo,Vila Mariana,Rua Aurora,15", 50);
//
//		eventos[1] = controller.criarEvento("Rock in Rua", "25-06-2024", "19:30", "Carlos,30");
//		eventos[1].informarValor(50);
//		eventos[1].informarLocal("Brasil,RJ,Rio de Janeiro,Lapa,Av Mem de Sá,300", 100);
//
//		eventos[2] = controller.criarEvento("Forró Fest", "01-01-2025", "22:00", "Ana,22");
//		eventos[2].informarValor(25);
//		eventos[2].informarLocal("Brasil,PE,Recife,Boa Viagem,Rua das Flores,90", 80);
//		
//		manipuladorListaEvento.listarEventos(eventos);
//	}
	
	// Gera eventos de forma automática e dinâmica.
//	public void gerEventosAutomatico(int numEventos) {
//		Evento[] listaEventos = new Evento[numEventos];
//		listaEventos = manipuladorListaEvento.gerarListaEventos(numEventos);
//		manipuladorListaEvento.listarEventos(listaEventos);
//	}
}
