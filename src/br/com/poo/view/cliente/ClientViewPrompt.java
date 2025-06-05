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
        int opcao = display.viewFunctions.menuSelecao("Promotor", opcoes, 0);

        switch (opcao) {
            case 1 -> selecionarEvento();
            case 2 -> exibirCarrinho();
        }
    }

    private void exibirEventos() {
        display.viewFunctions.listarEventos(controller.listaEvento);
    }

    private void selecionarEvento() {
        int idEvento = display.pegarIdEvento("ID do Evento");
        Evento evento = controller.pegarEvento(idEvento);

        display.viewFunctions.listarEvento(evento, 1);
        exibirMenuEvento(evento);
    }

    private void exibirMenuEvento(Evento evento) {
        String[] opcoes = { "Ver mais...", "Comprar" };
        int opcao = display.viewFunctions.menuSelecao("Evento", opcoes, 1);

        if (opcao == 1) comprarEvento(evento);
    }

    private void comprarEvento(Evento evento) {
        int confirmacao = display.viewFunctions.confirmarAcao("Deseja comprar o evento?");
        if (confirmacao == 1) {
            controller.adcionarEventoCarrinho(evento);
            display.exibirComprovanteCompra(evento);
        }
        iniciarCliente();
    }

    private void exibirCarrinho() {
        double total = controller.pegarTotalCarrinho();
        display.exibirCarrinhoDeEventos(controller.listaEvento, total);
        iniciarCliente();
    }
}
