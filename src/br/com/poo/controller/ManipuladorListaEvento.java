package br.com.poo.controller;

import java.util.Random;
import java.util.List;

import br.com.poo.modelo.Evento;

public class ManipuladorListaEvento {
	public List<Evento> listaEvento; 
	
	private Random rand = new Random();
	private String[] titulos = {"Jazz Night", "Rock in Rua", "Forró Fest", "Hip Hop Beats", "Clássicos ao Vivo", "Trap Brasil", "Indie Wave"};
    private String[] datas = {"10-09-2024", "12-11-2023", "25-06-2024", "01-01-2025", "05-08-2024", "18-09-2023"};
    private String[] horarios = {"18:30", "20:00", "19:30", "22:00", "21:15", "17:45"};
    private String[] responsaveis = {"Ana,22", "Carlos,30", "Maria,27", "Pedro,28", "Lívia,35", "João,33"};
    private String[] enderecos = {
        "Brasil,SP,São Paulo,Vila Mariana,Rua Aurora,15",
        "Brasil,RJ,Rio de Janeiro,Lapa,Av Mem de Sá,300",
        "Brasil,PE,Recife,Boa Viagem,Rua das Flores,90",
        "Brasil,MG,Belo Horizonte,Savassi,Rua Paraíba,200",
        "Brasil,RS,Porto Alegre,Moinhos,Rua Padre Chagas,11"
    };
	
	public void gerarListaEventos(Controller controller, int numEventos) {
	    for (int i = 0; i < numEventos; i++) {
	        String nome = titulos[this.rand.nextInt(titulos.length)];
	        String data = datas[this.rand.nextInt(datas.length)];
	        String horario = horarios[this.rand.nextInt(horarios.length)];
	        String responsavel = responsaveis[this.rand.nextInt(responsaveis.length)];
	        String endereco = enderecos[this.rand.nextInt(enderecos.length)];
	        String capacidade = Integer.toString(this.rand.nextInt(100) + 20);
	        String valorIngresso = Double.toString(this.rand.nextInt(60) + 10);

	        controller.criarEvento(nome, data, horario, responsavel, endereco, capacidade, valorIngresso);
	    }
	}
}
