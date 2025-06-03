package br.com.poo.view.cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ClienteView extends JFrame {
    private DefaultListModel<String> carrinhoModel = new DefaultListModel<>();
    private JList<String> carrinhoList = new JList<>(carrinhoModel);

    public ClienteView() {
        setTitle("Área do Cliente");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextField txtEvento = new JTextField(15);
        JButton btnComprar = new JButton("Comprar Ingresso");
        JButton btnImprimir = new JButton("Imprimir Ingressos");

        btnComprar.addActionListener(e -> {
            String evento = txtEvento.getText();
            if (!evento.isEmpty()) {
                carrinhoModel.addElement("Ingresso: " + evento);
                txtEvento.setText("");
            }
        });

        btnImprimir.addActionListener(e -> {
            if (carrinhoModel.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Carrinho vazio.");
                return;
            }
            StringBuilder recibo = new StringBuilder("Ingressos:\n");
            for (int i = 0; i < carrinhoModel.size(); i++) {
                recibo.append(carrinhoModel.get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(this, recibo.toString());
        });

        JPanel panelTop = new JPanel();
        panelTop.add(new JLabel("Evento:"));
        panelTop.add(txtEvento);
        panelTop.add(btnComprar);
        panelTop.add(btnImprimir);

        JScrollPane scrollPane = new JScrollPane(carrinhoList);

        add(panelTop, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
