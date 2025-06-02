package br.com.poo.view;

import javax.swing.*;

import br.com.poo.view.promotor.PromotorView;

import java.awt.event.*;

public class MainView extends JFrame {
	public MainView() {
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
}
