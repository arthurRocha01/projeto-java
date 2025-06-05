package br.com.poo.view.promotor;

import java.util.Scanner;
import br.com.poo.view.PromptViewFunctions;

public class PromotorViewPromptFunctions {
    private Scanner scanner = new Scanner(System.in);
    public PromptViewFunctions viewFunctions = new PromptViewFunctions();

    private int exibirCrud(String[] opcoes) {
        viewFunctions.exibirMensagem("Escolha uma opção: ");
        if (scanner.hasNextInt()) {
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 0) return -1;
            if (opcao >= 1 && opcao <= opcoes.length) return opcao;

            viewFunctions.exibirMensagem("Opção inválida. Tente novamente.");
        } else {
            viewFunctions.exibirMensagem("Entrada inválida. Digite um número.");
            scanner.next();
        }
        return 0;
    }

    private int verificarAcao(String mensagem) {
        System.out.println("========================================");
        System.out.printf("%s (s/n): ", mensagem);
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("s") || input.equals("sim")) return 1;
        if (input.equals("n") || input.equals("nao") || input.equals("não")) return 0;

        viewFunctions.exibirMensagem("Resposta inválida. Digite 's' para sim ou 'n' para não.");
        return verificarAcao(mensagem);
    }

    public int confirmarAcao(String mensagem) {
        return verificarAcao(mensagem);
    }

    public int pegarID() {
        System.out.print("ID: ");
        return viewFunctions.pegarInt();
    }
}
