package br.com.poo.view.cliente;

import br.com.poo.controller.Controller; 
import br.com.poo.modelo.Evento;
import br.com.poo.view.PromptViewFunctions;

public class ClientViewPrompt {
	private Controller controller;
	private PromptViewFunctions promptViewFunctions = new PromptViewFunctions();
	
	public ClientViewPrompt(Controller controller) {
		this.controller = controller;
		iniciarCliente() ;
	}
	
	private void iniciarCliente() {
		exibirEventos();
		String[] opcoes = { "Selecionar Evento", "Ver Carrinho" };
		int opc = this.promptViewFunctions.menuSelecao("PROMOTOR", opcoes, 0);
		if (opc == 1) selecionarEvento();
		if (opc == 2) exibirCarrinho();
	}

	private void exibirEventos() {
//		this.controller.manipuladorListaEvento.gerarListaEventos(controller, 5);
		this.promptViewFunctions.listarEventos(
				this.controller.listaEvento
		);
	}

	private void selecionarEvento() {
		int idEventoSelecionado = this.promptViewFunctions.inputOpcao("ID do Evento");
		Evento eventoSelecionado = this.controller.pegarEvento(idEventoSelecionado);
		this.promptViewFunctions.listarEvento(eventoSelecionado, 1);
		String[] opcoes = { "Comprar" };
		int opc = this.promptViewFunctions.menuSelecao("EVENTO", opcoes, 1);
		if (opc == 1) comprarEvento(eventoSelecionado);
	}
	
	
	private void comprarEvento(Evento evento) {
		if (this.promptViewFunctions.confirmarAcao("Deseja comprar o evento?") == 1) {
			this.promptViewFunctions.telaEventoComprado(evento);
			this.controller.adcionarEventoCarrinho(evento);
		}
		iniciarCliente();
	}
	
	private void exibirCarrinho() {
		double valorTotal = this.controller.pegarTotalCarrinho();
		this.promptViewFunctions.telaCarrinho(controller.carrinho, valorTotal);
		iniciarCliente();
	}
}
