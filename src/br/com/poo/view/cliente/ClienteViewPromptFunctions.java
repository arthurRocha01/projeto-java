package br.com.poo.view.cliente;

import java.util.List;

import br.com.poo.modelo.Evento;
import br.com.poo.view.PromptViewFunctions;

public class ClienteViewPromptFunctions {
	public PromptViewFunctions viewFunctions = new PromptViewFunctions();
	
	public int pegarIdEvento(String label) {
		int idEvento = Integer.parseInt(this.viewFunctions.pegarLinha(label));
		return idEvento;
	}
	
	private void exibirDadosBurtos(Evento evento) {
		 this.viewFunctions.exibirInfo("Comprador", "Nirton Afonso de Oliveira Filho");
		 this.viewFunctions.exibirInfo("Evento", evento.nome);
		 this.viewFunctions.exibirInfo("Data", evento.data.getData());
		 this.viewFunctions.exibirInfo("Horário", evento.hora.getHora());
		 this.viewFunctions.exibirInfo("Artista", evento.artista.nome);
		 this.viewFunctions.exibirInfo("Local", evento.local.endereco.getEndereco());
		 this.viewFunctions.exibirInfo("Valor pago", String.format("R$ %.2f", evento.ingresso.valor));
		 this.viewFunctions.exibirFaixa();
	}
	
	public void exibirComprovanteCompra(Evento evento) {
	    this.viewFunctions.limparTerminal();

	    this.viewFunctions.exibirHeader("COMPROVANTE DE COMPRA");
	    exibirDadosBurtos(evento);
	    this.viewFunctions.exibirMensagem("Compra realizada com sucesso!\n");
	    this.viewFunctions.pausartela(2);
	}
	
	public void exibirCarrinhoDeEventos(List<Evento> carrinho, double valorTotal) {
		this.viewFunctions.limparTerminal();
		this.viewFunctions.exibirHeader("Carrinho de Compras");

	    if (carrinho.isEmpty()) {
	    	this.viewFunctions.exibirMensagem("Seu carrinho está vazio.\n");
	    	this.viewFunctions.pausartela(2);
	        return;
	    }
	    
	    for (Evento evento : carrinho) {
	        System.out.println("----------------------------------------");
	        exibirDadosBurtos(evento);
	    }

	    System.out.println("----------------------------------------");
	    this.viewFunctions.exibirInfo("Total a pagar", String.format("R$ %.2f", valorTotal));
	    this.viewFunctions.exibirFaixa();
	    this.viewFunctions.pausartela(2);
	}
}
