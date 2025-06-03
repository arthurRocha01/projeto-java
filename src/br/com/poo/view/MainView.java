package br.com.poo.view;

import javax.swing.*;

import br.com.poo.controller.Controller;
import br.com.poo.view.cliente.ClientViewPrompt;
import br.com.poo.view.cliente.ClienteView;
import br.com.poo.view.promotor.PromotorView;
import br.com.poo.view.promotor.PromotorViewPrompt;

import java.awt.event.*;

public class MainView extends JFrame {
	private PromptViewFunctions promptViewFunctions = new PromptViewFunctions();
	public Controller controller;
	
	public MainView(Controller controller) {
		this.controller = controller;
	}
	
	public void GUI() {
		setTitle("Sistema de Eventos");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnPromotor = new JButton("Acesso Promotor");
        JButton btnCliente = new JButton("Acesso Cliente");

        btnPromotor.addActionListener(e -> new PromotorView());
        btnCliente.addActionListener(e -> new ClienteView());

        JPanel panel = new JPanel();
        panel.add(btnPromotor);
        panel.add(btnCliente);

        add(panel);
        setVisible(true);
	}
	
	public void prompt() {
		String[] opcoes = {
				"Promotor", "Cliente"
		};
		int opcaoSelecionada = this.promptViewFunctions.menuSelecao("INCIAL", opcoes, 1);
		if (opcaoSelecionada == 1) new PromotorViewPrompt(this.controller);
		if (opcaoSelecionada == 2) new ClientViewPrompt(this.controller);
	}
}
