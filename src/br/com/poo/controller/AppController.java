package br.com.poo.controller;

import br.com.poo.view.MainView; 

public class AppController {
	public Controller controller = new Controller();
	private MainView app = new MainView(this.controller);
	
	public void iniciarGUI() {
		this.app.GUI();
	}
	
	public void iniciarPrompt() {
		this.app.prompt();
	}
}
