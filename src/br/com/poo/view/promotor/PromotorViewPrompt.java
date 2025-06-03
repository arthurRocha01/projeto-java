package br.com.poo.view.promotor;

import br.com.poo.controller.Controller;
import br.com.poo.view.PromptViewFunctions;

public class PromotorViewPrompt {
	private Controller controller;
	private PromptViewFunctions promptViewFunctions = new PromptViewFunctions();
	
	public PromotorViewPrompt(Controller controller) {
		this.controller = controller;
		inciarPromotor();
	}
	
	private void inciarPromotor() {
		menuCRUD();
	}
	
	private void menuCRUD() {
		String[] opcoes = {
				"Criar", "Ler", "Editar", "Excluir"
		};
		int opc = this.promptViewFunctions.menuSelecao("CRUD", opcoes, 1);
		switch(opc) {
		case 1 -> create();
		case 2 -> read();
		case 3 -> update();
		case 4 -> delete();
		}
	}
	
	private void create() {
		String[] entradas = pegarCamposEvento();
		for (int i = 0; i < entradas.length; i++) System.out.printf("%s", entradas[i]);
		this.controller.criarEvento(entradas[0], entradas[1], entradas[2], entradas[3],
				entradas[3], entradas[4], entradas[5]);
	}
	
	private void read() {
		this.promptViewFunctions.listarEventos(this.controller.listaEvento);
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
		String[] entradas;
		String[] campos = {
				"Nome", "Data", "Horário", "Artista", "Endereço", "Capacidade", "Valor"
		};
		entradas = this.promptViewFunctions.pegarEntradas(campos);
		return entradas;
	}
}
