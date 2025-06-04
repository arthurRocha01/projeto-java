package br.com.poo.view.promotor;

import javax.swing.*; 
import javax.swing.table.DefaultTableModel;

import br.com.poo.controller.Controller;
import java.awt.*;

public class TelaEditar extends JFrame {
    JFrame parent;

    // Campos de entrada
    private JTextField nomeField;
    private JTextField dataDiaField, dataMesField, dataAnoField;
    private JTextField horarioHoraField, horarioMinutoField;
    private JTextField artistaField;
    private JTextField paisField, estadoField, cidadeField, bairroField, ruaField, numeroField;
    private JTextField valorField;
    private JTextField capacidadeField;

    JTable table;
    DefaultTableModel tableModel;
    Controller controller = new Controller();

    public TelaEditar(JFrame parent, Controller controller, JTable table, DefaultTableModel tableModel) {
        this.parent = parent;
        this.controller = controller;
        this.table = table;
        this.tableModel = tableModel;

        setTitle("Editar Evento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        painel.add(new JLabel("Nome do Evento:"));
        nomeField = new JTextField();
        painel.add(nomeField);

        painel.add(new JLabel("Data (Dia/Mês/Ano):"));
        JPanel dataPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dataDiaField = new JTextField(2);
        dataMesField = new JTextField(2);
        dataAnoField = new JTextField(4);
        dataPanel.add(new JLabel("Dia:"));
        dataPanel.add(dataDiaField);
        dataPanel.add(new JLabel("Mês:"));
        dataPanel.add(dataMesField);
        dataPanel.add(new JLabel("Ano:"));
        dataPanel.add(dataAnoField);
        painel.add(dataPanel);

        painel.add(new JLabel("Horário (Hora e Minutos):"));
        JPanel horarioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        horarioHoraField = new JTextField(2);
        horarioMinutoField = new JTextField(2);
        horarioPanel.add(new JLabel("Hora:"));
        horarioPanel.add(horarioHoraField);
        horarioPanel.add(new JLabel("Minuto:"));
        horarioPanel.add(horarioMinutoField);
        painel.add(horarioPanel);

        painel.add(new JLabel("Nome do Artista:"));
        artistaField = new JTextField();
        painel.add(artistaField);

        painel.add(new JLabel("Local do Evento:"));
        paisField = new JTextField(); paisField.setBorder(BorderFactory.createTitledBorder("País"));
        estadoField = new JTextField(); estadoField.setBorder(BorderFactory.createTitledBorder("Estado"));
        cidadeField = new JTextField(); cidadeField.setBorder(BorderFactory.createTitledBorder("Cidade"));
        bairroField = new JTextField(); bairroField.setBorder(BorderFactory.createTitledBorder("Bairro"));
        ruaField = new JTextField(); ruaField.setBorder(BorderFactory.createTitledBorder("Rua"));
        numeroField = new JTextField(); numeroField.setBorder(BorderFactory.createTitledBorder("Número"));

        painel.add(paisField);
        painel.add(estadoField);
        painel.add(cidadeField);
        painel.add(bairroField);
        painel.add(ruaField);
        painel.add(numeroField);

        painel.add(new JLabel("Valor do Ingresso:"));
        valorField = new JTextField();
        painel.add(valorField);

        painel.add(new JLabel("Capacidade Máxima:"));
        capacidadeField = new JTextField();
        painel.add(capacidadeField);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel.add(Box.createRigidArea(new Dimension(0, 10)));
        painel.add(salvarButton);
        salvarButton.addActionListener(e -> editar());

        add(new JScrollPane(painel));
        setVisible(true);
    }

    public void editar() {
        String nome = nomeField.getText().trim();
        String dataDia = dataDiaField.getText().trim();
        String dataMes = dataMesField.getText().trim();
        String dataAno = dataAnoField.getText().trim();
        String horarioHora = horarioHoraField.getText().trim();
        String horarioMinuto = horarioMinutoField.getText().trim();
        String artista = artistaField.getText().trim();
        String pais = paisField.getText().trim();
        String estado = estadoField.getText().trim();
        String cidade = cidadeField.getText().trim();
        String bairro = bairroField.getText().trim();
        String rua = ruaField.getText().trim();
        String numero = numeroField.getText().trim();
        String valor = valorField.getText().trim();
        String capacidade = capacidadeField.getText().trim();
        
        String[] fields = {
        	    nome, dataDia, dataMes, dataAno,
        	    horarioHora, horarioMinuto, artista,
        	    pais, estado, cidade, bairro,
        	    rua, numero, valor, capacidade
        	};

        if (this.controller.verificarStringsVazias(fields) == 0) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos antes de salvar.");
            return;
        }
        
        int eventoSelecionado = table.getSelectedRow();
        if (eventoSelecionado == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um evento para editar.");
            return;
        }
        
//        this.controller.modificarEvento(tableModel, fields, eventoSelecionado);
        this.dispose();
    }
}
