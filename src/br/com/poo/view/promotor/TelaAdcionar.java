package br.com.poo.view.promotor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

import br.com.poo.controller.ManipuladorListaEvento;
import br.com.poo.controller.Controller;
import br.com.poo.modelo.Evento;
import br.com.poo.modelo.auxiliares.Artista;
import br.com.poo.view.GUIViewFunctions;

public class TelaAdcionar extends JDialog {
    private JTextField nomeField, dataField, horarioField, artistaField, localField, valorField, capacidadeField;
    private JButton salvarButton, cancelarButton;
    private ManipuladorListaEvento display = new ManipuladorListaEvento();
    public Controller controller;
    GUIViewFunctions guiViewFunctions = new GUIViewFunctions();

    public TelaAdcionar(JFrame parent, Controller controller, GUIViewFunctions guiViewFunctions) {
    	super(parent, "Adicionar Evento", true);
        this.controller = controller;

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
        
        List<JComponent> componentes = Arrays.asList(nomeField, dataField, horarioField, artistaField, localField, valorField, capacidadeField);
        String[] labels = {
        		"Nome", "Data", "Hora", "Artista", "Local", "Valor", "Capacidade"
        };
        JPanel form = this.guiViewFunctions.criarForm(componentes, labels);
        add(form);

        // Botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");

        salvarButton.addActionListener(e -> salvar());
        cancelarButton.addActionListener(e -> dispose());

        buttonPanel.add(salvarButton);
        buttonPanel.add(cancelarButton);

        // Adiciona ao layout principal
//        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(420, 400);
        setResizable(false);
        setLocationRelativeTo(parent);
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
