package br.com.poo.view;

import javax.swing.*;

import br.com.poo.controller.PromotorController;
import br.com.poo.view.promotor.PromotorView;

import java.awt.event.*;

public class MainView extends JFrame {
	private PromptViewFunctions promptViewFunctions = new PromptViewFunctions();
	public PromotorController promotorController = new PromotorController();
	
	public MainView() {
		
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
		int opcaoSelecionada = this.promptViewFunctions.menuSelecao("INCIAL", opcoes, 0);
		if (opcaoSelecionada == 1) new ClientViewPrompt(promotorController);
	}
}
