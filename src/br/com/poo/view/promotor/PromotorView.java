package br.com.poo.view.promotor;

import javax.swing.*; 
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import br.com.poo.controller.Controller;
import br.com.poo.view.GUIViewFunctions;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle.Control;

public class PromotorView extends JFrame {
    private JTextField nomeField;
    private JButton addButton, editButton, deleteButton;
    private JTable table;
    private DefaultTableModel tableModel;

    Controller controller = new Controller();
    GUIViewFunctions guiViewFunction;;

    public PromotorView(Controller controller, GUIViewFunctions guiViewFunctions) {
    	this.controller = controller;
    	this.guiViewFunction = guiViewFunctions;
    	this.guiViewFunction.trocarWindowPai(this);
    	
    	int[] size = { 900, 400 };
    	this.guiViewFunction.criarTela("Promotor", size);

        nomeField = this.guiViewFunction.criarCampo(20);
        addButton = this.guiViewFunction.criarButton("Adcionar");
        editButton = this.guiViewFunction.criarButton("Editar");
        deleteButton = this.guiViewFunction.criarButton("Excluir");

        String[] colunas = {
            "Nome do Evento", "Data", "Horário", "Artista", "Endereço", "Capacidade", "Valor"
        };
        this.guiViewFunction.criarTabelaEventos(colunas);

        
        List<JComponent> componentes = Arrays.asList(nomeField, addButton, editButton, deleteButton);
        JPanel painel = this.guiViewFunction.criarPainel(componentes);
        add(painel);
        setVisible(true);
        
        addButton.addActionListener(e -> adicionar());
        editButton.addActionListener(e -> editar());
    }

    private void adicionar() {
        TelaAdcionar telaAdcionar = new TelaAdcionar(this, this.controller, guiViewFunction);
        telaAdcionar.setVisible(true);
    }
    
    private void editar() {
    	TelaEditar telaEditar = new TelaEditar(this, this.controller, this.table, this.tableModel);
    	telaEditar.setVisible(true);
    }

    public void atualizar() {
    	tableModel.setRowCount(0);
        List<String[]> eventos = this.controller.pegarEventosCriados();
        for (String[] evento: eventos) {
        	tableModel.addRow(evento);
        }
    }
}