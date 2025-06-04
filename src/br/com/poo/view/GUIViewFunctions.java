package br.com.poo.view;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import br.com.poo.modelo.Evento;

public class GUIViewFunctions {
    private Window parent;

    public GUIViewFunctions(Window parent) {
        this.parent = parent;
    }

    public void trocarWindowPai(Window parent) {
        this.parent = parent;
    }

    public void criarTela(String nome, int[] size) {
        if (parent instanceof JFrame frame) {
            frame.setTitle(nome);
            frame.setSize(size[0], size[1]);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(10, 10));
            frame.setVisible(true);
        } else if (parent instanceof JDialog dialog) {
            dialog.setTitle(nome);
            dialog.setSize(size[0], size[1]);
            dialog.setLocationRelativeTo(null);
            dialog.setLayout(new BorderLayout(10, 10));
            dialog.setVisible(true);
        }
    }

    public void criarJanela(int[] size, String title) {
    	JDialog dialogo = new JDialog(parent, title, Dialog.ModalityType.APPLICATION_MODAL);
        dialogo.setSize(size[0], size[1]);
        dialogo.setLayout(null);

        JButton fechar = new JButton("Fechar");
        fechar.setBounds(100, 70, 100, 25);
        fechar.addActionListener(e -> dialogo.dispose());

        dialogo.add(fechar);
        dialogo.setLocationRelativeTo(parent);
        dialogo.setVisible(true);
    }

    public JPanel criarPainel(List<JComponent> componentes) {
        JPanel panel = new JPanel();
        for (JComponent comp : componentes) panel.add(comp);
        return panel;
    }

    private void adicionarCampo(JPanel panel, GridBagConstraints gbc, int y, String label, JComponent field) {
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.weightx = 0.3;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        panel.add(field, gbc);
    }

    public JPanel criarForm(List<JComponent> componentes, String[] labels) {
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < componentes.size(); i++) {
            adicionarCampo(form, gbc, i, labels[i], componentes.get(i));
        }
        return form;
    }

    public JButton criarButton(String nome) {
        return new JButton(nome);
    }

    public JTextField criarCampo(int size) {
        return new JTextField(size);
    }

    public JScrollPane criarTabelaEventos(JTable tabela, String[] colunas) {
        tabela.setFillsViewportHeight(true);
        tabela.setRowHeight(25);
        tabela.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tabela.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        TableColumnModel columnModel = tabela.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(120);
        if (columnModel.getColumnCount() > 4)
            columnModel.getColumn(4).setPreferredWidth(200);

        return new JScrollPane(tabela);
    }
    
    private String[] extrairDadosEvento(Evento evento) {
    	String id = Integer.toString(evento.id);
    	String nome = evento.nome;
    	String data = evento.data.getData();
    	String horario = evento.hora.getHora();
    	String artista = evento.artista.nome;
    	String endereco = evento.local.endereco.getEndereco();
    	String capacidade = Integer.toString(evento.local.capacidade);
    	String valor = Double.toString(evento.ingresso.valor);
    	
    	return new String[] { id, nome, data, horario, artista, endereco, capacidade, valor };
    }
    
//    public void adcionarEventoTabela(JFrame parent, TableModel tableModel, List<Evento> listaEvento) {
//    	for (int i = 0; i < listaEvento.size(); i++) {
//    		Evento evento = listaEvento.get(i);
//    		String[] dadosEvento = extrairDadosEvento(evento);
//    		tableModel.
//    	}
//    }
}
