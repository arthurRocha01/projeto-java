package br.com.poo.view.promotor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import br.com.poo.controller.PromotorController;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class PromotorView extends JFrame {
    private JTextField nomeField;
    private JButton addButton, editButton, updateButton, deleteButton;
    private JTable table;
    private DefaultTableModel tableModel;

    PromotorController promotorController = new PromotorController();

    public PromotorView() {
        super("Gerenciamento de Eventos");

        // Campo de texto
        nomeField = new JTextField(20);

        // Botões
        addButton = new JButton("Adicionar");
        editButton = new JButton("Editar");
        updateButton = new JButton("Atualizar");
        deleteButton = new JButton("Excluir");

        // Tabela
        String[] colunas = {
            "Nome do Evento", "Data", "Horário", "Artista", "Endereço", "Capacidade", "Valor"
        };

        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede edição direta na tabela
            }
        };

        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setRowHeight(25);
        table.setFont(new Font("SansSerif", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(table);

        // Ajuste das larguras mínimas das colunas
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(120); // Nome
        columnModel.getColumn(4).setPreferredWidth(200); // Endereço

        // Painel de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);

        // Eventos
        addButton.addActionListener(e -> adicionar());
        editButton.addActionListener(e -> editar());
        updateButton.addActionListener(e -> atualizar());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                nomeField.setText(tableModel.getValueAt(row, 0).toString()); // Corrigido: coluna 0 é o nome
            }
        });

        // Layout principal
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionar() {
        TelaAdcionar telaAdcionar = new TelaAdcionar(this, this.promotorController);
        telaAdcionar.setVisible(true);
    }
    
    private void editar() {
    	TelaEditar telaEditar = new TelaEditar(this, this.promotorController, this.table, this.tableModel);
    	telaEditar.setVisible(true);
    }

    public void atualizar() {
    	tableModel.setRowCount(0);
        List<String[]> eventos = this.promotorController.pegarEventosCriados();
        for (String[] evento: eventos) {
        	tableModel.addRow(evento);
        }
    }
}