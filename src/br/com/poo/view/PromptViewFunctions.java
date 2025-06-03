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
	
	public int menuSelecao(String nomeMenu, String[] opcoes, int isClean) {
		if (isClean != 1) limparTerminal();
	    int totalOpcoes = opcoes.length;

	    while (true) {
	        System.out.printf("===== MENU %s =====\n", nomeMenu);
	        for (int i = 0; i < totalOpcoes; i++) {
	            System.out.printf("%d. %s\n", i + 1, opcoes[i]);
	        }
	        System.out.printf("%d. Sair\n\n", totalOpcoes + 1);
	        System.out.print("Escolha uma opção: ");

	        if (scanner.hasNextInt()) {
	            int opcao = this.scanner.nextInt();
	            System.out.println();

	            if (opcao == totalOpcoes + 1) {
	                return -1;
	            } else if (opcao >= 1 && opcao <= totalOpcoes) {
	                return opcao; 
	            } else {
	                System.out.println("Opção inválida. Tente novamente.\n");
	            }
	        } else {
	            System.out.println("\nEntrada inválida. Digite um número.\n");
	            scanner.next();
	        }
	    }
	}
	
	public void telaEventoComprado(Evento evento) {
		limparTerminal();
	    System.out.println("========================================");
	    System.out.println("      🎟️  COMPRA CONFIRMADA!  🎉");
	    System.out.println("========================================");
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
	
	public void listarEventos(List<Evento> listaEventos) {
		System.out.println(listaEventos.size());
	    for (int i = 0; i < listaEventos.size(); i++) {
	        Evento evento = listaEventos.get(i);
	        System.out.println("========================================");
	        System.out.printf("ID: %d\n", evento.id);
	        
	        System.out.printf("Nome: %s\n", evento.nome);

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
	
	public void listarEvento(Evento evento) {
		limparTerminal();
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