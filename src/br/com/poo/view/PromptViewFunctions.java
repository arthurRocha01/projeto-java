package br.com.poo.view;

import java.util.List;
import java.util.Scanner;

import br.com.poo.modelo.Evento;

public class PromptViewFunctions {
	private Scanner scanner = new Scanner(System.in);
	
	private void limparTerminal() {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}
	
	private void pausartela(int segundos) {
		try {
		    Thread.sleep((segundos * 1000));
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
	
	public int inputOpcao(String label) {
		System.out.printf("%s: ", label);
		int input = this.scanner.nextInt();
		return input;
	}
	
	private void header(String header) {
		System.out.println("========================================");
	    System.out.printf("      ️  %s  ", header);
	    System.out.println("========================================");
	}
	
	public int menuSelecao(String nomeMenu, String[] opcoes, int isClean) {
	    if (isClean != 1) limparTerminal();

	    while (true) {
	        header("MENU " + nomeMenu);
	        for (int i = 0; i < opcoes.length; i++) System.out.printf("%d. %s\n", i + 1, opcoes[i]);
	        System.out.printf("%d. Sair\n\n", opcoes.length + 1);
	        System.out.print("Escolha uma opção: ");

	        if (scanner.hasNextInt()) {
	            int opcao = scanner.nextInt();
	            System.out.println();

	            if (opcao == opcoes.length + 1) return -1;
	            if (opcao >= 1 && opcao <= opcoes.length) return opcao;

	            System.out.println("Opção inválida. Tente novamente.\n");
	        } else {
	            System.out.println("\nEntrada inválida. Digite um número.\n");
	            scanner.next();
	        }
	    }
	}
	
	public void telaEventoComprado(Evento evento) {
		limparTerminal();
	    header("EVENTO COMPRADO");
	    System.out.printf("Evento: %s\n", evento.nome);
	    System.out.printf("Data: %02d-%02d-%04d\n", evento.data.dia, evento.data.mes, evento.data.ano);
	    System.out.printf("Horário: %02d:%02d\n", evento.hora.hora, evento.hora.minutos);
	    System.out.printf("Responsável: %s, %d anos\n", evento.artista.nome, evento.artista.idade);
	    System.out.printf("Local: %s, %s, %s, %s, %s, nº %d\n",
	        evento.local.endereco.pais,
	        evento.local.endereco.estado,
	        evento.local.endereco.cidade,
	        evento.local.endereco.bairro,
	        evento.local.endereco.rua,
	        evento.local.endereco.numero);
	    System.out.printf("Capacidade: %d pessoas\n", evento.local.capacidade);
	    System.out.printf("Valor Pago: R$ %.2f\n", evento.ingresso.valor);
	    System.out.println("========================================");
	    System.out.println("💡 Leve este comprovante com você!");
	    System.out.println("========================================\n");
	    pausartela(4);
	}
	
	public int confirmarAcao(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        while (true) {
            System.out.println("========================================");
            System.out.printf("%s (s/n): ", mensagem);
            resposta = scanner.nextLine().trim().toLowerCase();

            if (resposta.equals("s") || resposta.equals("sim")) {
                return 1;
            } else if (resposta.equals("n") || resposta.equals("nao") || resposta.equals("não")) {
                return 0;
            } else {
                System.out.println("⚠️  Resposta inválida. Digite 's' para sim ou 'n' para não.\n");
            }
        }
    }
	
	public void listarEvento(Evento evento, int isClean) {
		if (isClean == 1) limparTerminal();
		
		System.out.println("========================================");
		System.out.printf("ID: %s\n", evento.id);
		
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
	
	public void listarEventos(List<Evento> listaEventos) {
		limparTerminal();
	    for (int i = 0; i < listaEventos.size(); i++) {
	    	Evento evento = listaEventos.get(i);
	        listarEvento(evento, 0);
	    }
	}
	
	public void telaCarrinho(List<Evento> carrinho, double valorTotal) {
	    limparTerminal();
	    header("CARRINHO DE COMPRAS");

	    if (carrinho.isEmpty()) {
	        System.out.println("🛒 Seu carrinho está vazio.\n");
	        pausartela(2);
	        return;
	    }

	    listarEventos(carrinho);

	    System.out.printf("💰 Total: R$ %.2f\n", valorTotal);
	    System.out.println("========================================\n");
	    pausartela(4);
	}

}