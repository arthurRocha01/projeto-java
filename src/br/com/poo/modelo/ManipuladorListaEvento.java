package br.com.poo.modelo;

import java.util.Random;
import br.com.poo.controller.PromotorController;

public class ManipuladorListaEvento {
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
	
//	public Evento[] gerarListaEventos(int numEventos) {
//		PromotorController promotorController = new PromotorController();
//	    Evento[] listaEventos = new Evento[numEventos];
//
//	    for (int i = 0; i < listaEventos.length; i++) {
//	        String titulo = titulos[this.rand.nextInt(titulos.length)];
//	        String data = datas[this.rand.nextInt(datas.length)];
//	        String horario = horarios[this.rand.nextInt(horarios.length)];
//	        String responsavel = responsaveis[this.rand.nextInt(responsaveis.length)];
//	        String endereco = enderecos[this.rand.nextInt(enderecos.length)];
//	        int capacidade = this.rand.nextInt(100) + 20;
//	        int valorIngresso = this.rand.nextInt(60) + 10;
//
//	        listaEventos[i] = promotorController.criarEvento(titulo, data, horario, responsavel, endereco, capacidade, valorIngresso);
//	        listaEventos[i].informarValor(valorIngresso);
//	        listaEventos[i].informarLocal(endereco, capacidade);
//	    }
//	    return listaEventos;
//	}
	
	public void listarEventos(Evento[] listaEventos) {
		for (int i = 0; i < listaEventos.length; i++) {
			System.out.println("========================================");
			System.out.printf("Título: %s\n", listaEventos[i].nome);

			System.out.printf("Data: %02d-%02d-%04d\n", 
			    listaEventos[i].data.dia, 
			    listaEventos[i].data.mes, 
			    listaEventos[i].data.ano);

			System.out.printf("Horário: %02d:%02d\n", 
			    listaEventos[i].hora.hora, 
			    listaEventos[i].hora.minutos);

			System.out.printf("Responsável: %s, %d anos\n",
			    listaEventos[i].artista.nome,
			    listaEventos[i].artista.idade);

			System.out.printf("Valor do Ingresso: R$ %.2f\n", 
			    listaEventos[i].ingresso.valor);

			System.out.printf("Local: %s, %s, %s, %s, %s, nº %d\n", 
			    listaEventos[i].local.endereco.pais,
			    listaEventos[i].local.endereco.estado,
			    listaEventos[i].local.endereco.cidade,
			    listaEventos[i].local.endereco.bairro,
			    listaEventos[i].local.endereco.rua,
			    listaEventos[i].local.endereco.numero);

			System.out.printf("Capacidade: %d pessoas\n", 
			    listaEventos[i].local.capacidade);

			System.out.println("========================================\n");

		}
	}
	
	public void listarEvento(Evento evento) {
		System.out.println("========================================");
		System.out.printf("Título: %s\n", evento.nome);

		System.out.printf("Data: %02d-%02d-%04d\n", 
		    evento.data.dia, 
		    evento.data.mes, 
		    evento.data.ano);

		System.out.printf("Horário: %02d:%02d\n", 
		    evento.hora.hora, 
		    evento.hora.minutos);

		System.out.printf("Responsável: %s, %d anos\n",
		    evento.artista.nome,
		    evento.artista.idade);

		System.out.printf("Valor do Ingresso: R$ %.2f\n", 
		    evento.ingresso.valor);

		System.out.printf("Local: %s, %s, %s, %s, %s, nº %d\n", 
		    evento.local.endereco.pais,
		    evento.local.endereco.estado,
		    evento.local.endereco.cidade,
		    evento.local.endereco.bairro,
		    evento.local.endereco.rua,
		    evento.local.endereco.numero);

		System.out.printf("Capacidade: %d pessoas\n", 
		    evento.local.capacidade);

		System.out.println("========================================\n");
	}
}
