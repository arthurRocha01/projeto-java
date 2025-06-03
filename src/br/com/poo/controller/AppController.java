package br.com.poo.controller;

import br.com.poo.view.MainView;
import br.com.poo.view.promotor.PromotorViewPrompt;

public class AppController {
	public Controller controller = new Controller();
	private MainView app = new MainView(controller);
	
	public void iniciarGUI() {
		this.app.GUI();
	}
	
	public void iniciarPrompt() {
		this.app.prompt();
	}
}
