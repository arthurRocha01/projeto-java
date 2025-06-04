package br.com.poo.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.table.DefaultTableModel;

import br.com.poo.modelo.Evento;
import br.com.poo.modelo.auxiliares.Artista;
import br.com.poo.modelo.auxiliares.Data;
import br.com.poo.modelo.auxiliares.Hora;

public class Controller {

    public Evento evento;
    public ArrayList<Evento> listaEvento = new ArrayList<Evento>();
    public ArrayList<Evento> carrinho = new ArrayList<Evento>();
    int id = 0;
    
    public ManipuladorListaEvento manipuladorListaEvento = new ManipuladorListaEvento();

    public void criarEvento(String nome, String data, String horario, String artista, String infoEndereco, String capacidade, String valor) {
        this.evento = new Evento();
        this.evento.id = id++;
        this.evento.nome = nome;
        this.evento.data = new Data(data);
        this.evento.hora = new Hora(horario);
        this.evento.artista = new Artista(artista);
        this.evento.informarLocal(infoEndereco, capacidade);
        this.evento.informarValor(valor);
        listaEvento.add(this.evento);
    }

    public List<String[]> pegarEventosCriados() {
        DecimalFormat df = new DecimalFormat("0.00");
        List<String[]> linhas = new ArrayList<>();

        for (Evento evento : listaEvento) {
            String nome = evento.nome;
            String data = String.format("%02d/%02d/%04d",
                    evento.data.dia, evento.data.mes, evento.data.ano);
            String horario = String.format("%02d:%02d",
                    evento.hora.hora, evento.hora.minutos);
            String artista = String.format("%s",
                    evento.artista.nome);
            String endereco = String.format("%s, %s, nº %d",
                    evento.local.endereco.cidade,
                    evento.local.endereco.rua,
                    evento.local.endereco.numero);
            String capacidade = String.valueOf(evento.local.capacidade);
            String valor = "R$ " + df.format(evento.ingresso.valor);

            linhas.add(new String[] { nome, data, horario, artista, endereco, capacidade, valor });
        }

        return linhas;
    }
    
    public int verificarStringsVazias(String[] strings) {
    	for (String string : strings) {
    			if (string.isEmpty()) {
    				return 0;
    			}
    	}
    	return 1;
    }
    
    public void modificarEvento(String[] dadosEvento, int idEvento) {
    	Evento evento = pegarEvento(idEvento);
    	
    	for(int i = 0; i < dadosEvento.length; i++) {
    	System.out.printf("%d - %s\n", i, dadosEvento[i]);
    	}
    	
    	evento.nome = dadosEvento[0];
    	evento.data.setData(dadosEvento[1]);
    	evento.hora.setHora(dadosEvento[2]);
    	evento.artista.nome = dadosEvento[3];
    	evento.local.endereco.setEndereco(dadosEvento[4]);
    	evento.local.setCapacidade(dadosEvento[5]);
    	evento.ingresso.setValor(dadosEvento[6]);
    }
    
    public Evento pegarEvento(int id) {
    	for (int i = 0; i < this.listaEvento.size(); i++) {
    		Evento evento = this.listaEvento.get(i);
    		if (evento.id == id) return evento;
    	}
    	return null;
    }
    
    public void adcionarEventoCarrinho(Evento evento) {
    	this.carrinho.add(evento);
    }
    
    public double pegarTotalCarrinho() {
    	double total = 0;
    	for (int i = 0; i < this.carrinho.size(); i++) {
    		Evento evento = carrinho.get(i);
    		total += evento.ingresso.valor;
    	}
    	return total;
    }
    
    public void apagarEvento(int idEvento) {
    	this.listaEvento.remove(idEvento);
    }
}
