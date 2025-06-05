package br.com.poo.view;

import java.util.Arrays; 
import java.util.List;

import javax.swing.*;

import br.com.poo.controller.Controller;
import br.com.poo.view.cliente.ClientViewPrompt;
import br.com.poo.view.promotor.PromotorView;
import br.com.poo.view.promotor.PromotorViewPrompt;

public class MainView extends JFrame {
	private PromptViewFunctions promptViewFunctions = new PromptViewFunctions();
	private GUIViewFunctions guiViewFunciontios = new GUIViewFunctions(this);
	public Controller controller;
	
	public MainView(Controller controller) {
		this.controller = controller;
	}
	
	public void GUI() {
		int [] size = { 300, 150 };
		this.guiViewFunciontios.criarTela("Sistema de Eventos", size);

        JButton btnPromotor = this.guiViewFunciontios.criarButton("Acesso Promotor");
        JButton btnCliente = this.guiViewFunciontios.criarButton("Acesso Cliente");
        
        List<JComponent> componentes = Arrays.asList(btnPromotor, btnCliente);
        JPanel painel = this.guiViewFunciontios.criarPainel(componentes);
        add(painel);
        setVisible(true);

        btnPromotor.addActionListener(e -> new PromotorView(this.controller, guiViewFunciontios));
//        btnCliente.addActionListener(e -> new ClienteView());
	}
	
	public void prompt() {
		String[] opcoes = {
				"Promotor", "Cliente"
		};
		
		while(true) {
			int opcaoSelecionada = this.promptViewFunctions.menuSelecao("INCIAL", opcoes, 1);
			if (opcaoSelecionada == 1) new PromotorViewPrompt(this.controller);
//			if (opcaoSelecionada == 2) new ClientViewPrompt(this.controller);
		}
	}
}
