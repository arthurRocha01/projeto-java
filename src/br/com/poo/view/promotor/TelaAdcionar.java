package br.com.poo.view.promotor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import br.com.poo.controller.ManipuladorListaEvento;
import br.com.poo.controller.Controller;
import br.com.poo.modelo.Evento;
import br.com.poo.modelo.auxiliares.Artista;

public class TelaAdcionar extends JDialog {
    private JTextField nomeField, dataField, horarioField, artistaField, localField, valorField, capacidadeField;
    private JButton salvarButton, cancelarButton;
    private ManipuladorListaEvento display = new ManipuladorListaEvento();
    public Controller controller;

    public TelaAdcionar(JFrame parent, Controller controller) {
        super(parent, "Adicionar Evento", true);
        this.controller = controller;
        setLayout(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos
        nomeField = new JTextField(20);
        nomeField.setText("test");
        dataField = new JTextField(20);
        dataField.setText("12/12/1212");
        horarioField = new JTextField(20);
        horarioField.setText("12:12");
        artistaField = new JTextField(20);
        artistaField.setText("test,12");
        localField = new JTextField(20);
        localField.setText("12,12,12,12,12,12");
        valorField = new JTextField(20);
        valorField.setText("12");
        capacidadeField = new JTextField(20);
        capacidadeField.setText("12");

        // Adiciona campos com rótulos
        adicionarCampo(formPanel, gbc, 0, "Nome:", nomeField);
        adicionarCampo(formPanel, gbc, 1, "Data (dd/mm/aaaa):", dataField);
        adicionarCampo(formPanel, gbc, 2, "Horário (hh:mm):", horarioField);
        adicionarCampo(formPanel, gbc, 3, "Artista:", artistaField);
        adicionarCampo(formPanel, gbc, 4, "Local:", localField);
        adicionarCampo(formPanel, gbc, 5, "Valor:", valorField);
        adicionarCampo(formPanel, gbc, 6, "Capacidade:", capacidadeField);

        // Botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");

        salvarButton.addActionListener(e -> salvar());
        cancelarButton.addActionListener(e -> dispose());

        buttonPanel.add(salvarButton);
        buttonPanel.add(cancelarButton);

        // Adiciona ao layout principal
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(420, 400);
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    private void adicionarCampo(JPanel panel, GridBagConstraints gbc, int y, String label, JTextField field) {
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.weightx = 0.3;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        panel.add(field, gbc);
    }

    private void salvar() {
    	String nome = nomeField.getText().trim();
        String data = dataField.getText().trim();
        String horario = horarioField.getText().trim();
        String artista = artistaField.getText().trim();
        String infoEndereco = localField.getText().trim();
        String capacidade = capacidadeField.getText().trim();
        String valor = valorField.getText().trim();

        this.controller.criarEvento(nome, data, horario, artista, infoEndereco, capacidade, valor);
    }
}
