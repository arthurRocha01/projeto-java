package br.com.poo.view.cliente;

import br.com.poo.controller.Controller;
import br.com.poo.modelo.Evento;

public class ClientViewPrompt {

    private Controller controller;
    private ClienteViewPromptFunctions display = new ClienteViewPromptFunctions();

    public ClientViewPrompt(Controller controller) {
        this.controller = controller;
        iniciarCliente();
    }

    private void iniciarCliente() {
        exibirEventos();

        String[] opcoes = { "Selecionar Evento", "Ver Carrinho" };
        int opcao = display.viewFunctions.menuSelecao("Cliente", opcoes, 0);

        switch (opcao) {
            case 1 -> selecionarEvento();
            case 2 -> exibirCarrinho();
        }
    }

    private void exibirEventos() {
    	this.display.viewFunctions.limparTerminal();
        this.display.viewFunctions.listarEventos(controller.listaEvento);
    }

    private void selecionarEvento() {
    	exibirEventos();
        int idEvento = display.pegarIdEvento("ID do Evento");
        Evento evento = controller.pegarEvento(idEvento);

        display.viewFunctions.listarEvento(evento, 1);
        exibirMenuEvento(evento);
    }

    private void comprarEvento(Evento evento) {
    	this.display.viewFunctions.listarEvento(evento, 1);
    	int confirmacao = display.viewFunctions.confirmarAcao("Deseja comprar o evento?");
    	if (confirmacao == 1) {
    		controller.adcionarEventoCarrinho(evento);
    		display.exibirComprovanteCompra(evento);
    	}
    	iniciarCliente();
    }

    private void exibirMenuEvento(Evento evento) {
    	this.display.viewFunctions.listarEvento(evento, 1);
        String[] opcoes = { "Comprar" };
        int opcao = display.viewFunctions.menuSelecao("Evento", opcoes, 0);

        if (opcao == 1) comprarEvento(evento);
    }

    private void exibirCarrinho() {
        double total = controller.pegarTotalCarrinho();
        display.exibirCarrinhoDeEventos(controller.listaEvento, total);
        iniciarCliente();
    }
}
