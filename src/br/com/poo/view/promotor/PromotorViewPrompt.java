package br.com.poo.view.promotor;

import br.com.poo.controller.Controller;
import br.com.poo.view.PromptViewFunctions;

public class PromotorViewPrompt {
	private Controller controller;
	private PromptViewFunctions promptViewFunctions = new PromptViewFunctions();
	private String[] campos = {
		    "Nome", "Data", "Horário", "Artista", "Endereço", "Capacidade", "Valor"
	};
	
	public PromotorViewPrompt(Controller controller) {
		this.controller = controller;
		inciarPromotor();
	}
	
	private void inciarPromotor() {
		menuCRUD(1);
	}
	
	private void menuCRUD(int isClean) {
		String[] opcoes = {
				"Criar", "Ler", "Editar", "Excluir"
		};
		int opc = this.promptViewFunctions.menuSelecao("CRUD", opcoes, isClean);
		switch(opc) {
		case 1 -> create();
		case 2 -> read();
		case 3 -> update();
		case 4 -> delete();
		}
	}
	
	private void create() {
		String[] entradas = pegarCamposEvento();
		this.controller.criarEvento(entradas[0], entradas[1], entradas[2], entradas[3],
				entradas[4], entradas[5], entradas[6]);
		int opc = this.promptViewFunctions.confirmarAcao("Deseja criar um novo evento?");
		if (opc == 1) create();
		if (opc == 0) menuCRUD(1);
	}
	
	private void read() {
		this.promptViewFunctions.listarEventos(this.controller.listaEvento);
		menuCRUD(0);
	}
	
	private void update() {
		int idEvento = this.promptViewFunctions.pegarID();
		String[] entradas = pegarCamposEvento();
		this.controller.modificarEvento(entradas, idEvento);
	}
	
	private void delete() {
		int idEvento = this.promptViewFunctions.pegarID();
		this.controller.apagarEvento(idEvento);
	}
	
	private String[] pegarCamposEvento() {
		String[] entradas = this.promptViewFunctions.pegarEntradas(this.campos);
		return entradas;
	}
}
