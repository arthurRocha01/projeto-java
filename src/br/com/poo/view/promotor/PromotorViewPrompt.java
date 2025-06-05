package br.com.poo.view.promotor;

import br.com.poo.controller.Controller;

public class PromotorViewPrompt {
    private Controller controller;
    private PromotorViewPromptFunctions display = new PromotorViewPromptFunctions();

    private String[] campos = {
        "Nome", "Data", "Horário", "Artista", "Endereço", "Capacidade", "Valor"
    };

    public PromotorViewPrompt(Controller controller) {
        this.controller = controller;
        iniciarPromotor();
    }

    private void iniciarPromotor() {
        menuCRUD(1);
    }

    private void menuCRUD(int isClean) {
        String[] opcoes = { "Criar", "Ler", "Editar", "Excluir" };
        int opc = this.display.viewFunctions.menuSelecao("PROMOTOR", opcoes, isClean);

        switch (opc) {
            case 1 -> create();
            case 2 -> read();
            case 3 -> update();
            case 4 -> delete();
        }
    }

    private String[] obterValores() {
        return this.display.viewFunctions.pegarEntradas(campos);
    }

    private void confirmarNovaExecucao() {
        int opc = this.display.viewFunctions.confirmarAcao("Deseja criar um novo evento?");
        if (opc == 1) create();
        else menuCRUD(1);
    }

    private void create() {
        String[] entradas = obterValores();
        controller.criarEvento(
            entradas[0], entradas[1], entradas[2],
            entradas[3], entradas[4], entradas[5], entradas[6]
        );
        confirmarNovaExecucao();
    }

    private void exibirEventos() {
    	this.display.viewFunctions.limparTerminal();
    	this.display.viewFunctions.listarEventos(controller.listaEvento);
    }

    private void read() {
    	exibirEventos();
        menuCRUD(0);
    }

    private void update() {
    	exibirEventos();
        int idEvento = display.pegarID();
        String[] entradas = obterValores();
        controller.modificarEvento(entradas, idEvento);
        menuCRUD(1);
    }

    private void delete() {
    	exibirEventos();
        int idEvento = display.pegarID();
        controller.apagarEvento(idEvento);
        menuCRUD(1);
    }
}
