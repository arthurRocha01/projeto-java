package br.com.poo.view;

import java.util.List;
import java.util.Scanner;

import br.com.poo.modelo.Evento;

public class PromptViewFunctions {
    private Scanner scanner = new Scanner(System.in);
    
    private final int larguraTotal = 50;
    private final String separador = "+" + "=".repeat(larguraTotal - 2) + "+";
    private final String linhaSimples = "+" + "-".repeat(larguraTotal - 2) + "+";

    public int pegarInt() {
        while (!scanner.hasNextInt()) {
            exibirMensagem("Digite um número válido.");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public double pegarDouble() {
        while (!scanner.hasNextDouble()) {
            exibirMensagem("Digite um número decimal válido.");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    public String pegarString() {
        return scanner.nextLine().trim();
    }

    private void exibirLabel(String label) {
        System.out.printf("%s: ", label);
    }

    private String pegarApenasNumeros(String label) {
        String entrada = pegarString();
        if (entrada.matches("[0-9]+")) return entrada;
        exibirMensagem("Entrada inválida. Apenas números.");
        exibirLabel(label);
        return pegarApenasNumeros(label);
    }

    private String pegarApenasNumerosELetras(String label) {
        String entrada = scanner.nextLine().trim();
        if (entrada.matches("[a-zA-Z0-9]+")) return entrada;
        exibirMensagem("Entrada inválida. Apenas letras e números.");
        exibirLabel(label);
        return pegarApenasNumerosELetras(label);
    }

    public void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pausartela(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirInfo(String label, String value) {
        System.out.printf("%-12s: %s\n", label, value);
    }

    private void exibirInfo(String rotulo, Object valor) {
        System.out.printf("| %-15s: %-"+(larguraTotal - 20)+"s |\n", rotulo, valor);
    }

    public int menuSelecao(String nomeMenu, String[] opcoes, int isClean) {
        if (isClean == 1) limparTerminal();

        exibirHeader("Menu " + nomeMenu);
        for (int i = 0; i < opcoes.length; i++) {
            System.out.printf("%d. %s\n", i + 1, opcoes[i]);
        }
        exibirMensagem("0. Sair");
        System.out.print("\nEscolha uma opção: ");
        return pegarInt();
    }

    public void listarEvento(Evento evento, int isClean) {
        if (isClean == 1) limparTerminal();

        System.out.println(linhaSimples);
        exibirInfo("ID", evento.id);
        exibirInfo("Nome", evento.nome);
        exibirInfo("Data", evento.data.getData());
        exibirInfo("Horário", evento.hora.getHora());
        exibirInfo("Artista", evento.artista.nome);
        exibirInfo("Endereço", evento.local.endereco.getEndereco());
        exibirInfo("Capacidade", evento.local.capacidade);
        exibirInfo("Valor", evento.ingresso.getValor());
        System.out.println(linhaSimples + "\n");
    }
    
    public void exibirFaixa() {
        System.out.println(separador);
    }

    public void exibirHeader(String header) {
        System.out.println();
        exibirFaixa();
        System.out.printf("| %-"+(larguraTotal - 4)+"s |\n", header.toUpperCase());
        exibirFaixa();
        System.out.println();
    }
    
    public void listarEventos(List<Evento> listaEventos) {
        limparTerminal();
        exibirHeader("Eventos Disponíveis");

        for (Evento evento : listaEventos) {
            listarEvento(evento, 0);
        }

        exibirFaixa();
        System.out.println();
        pausartela(1);
    }
    
    private int verificarAcao(String mensagem) {
        System.out.println();
        exibirFaixa();
        System.out.printf("| %-"+(larguraTotal - 4)+"s |\n", mensagem + " (s/n)");
        exibirFaixa();
        System.out.print("> ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("s") || input.equals("sim")) return 1;
        if (input.equals("n") || input.equals("nao") || input.equals("não")) return 0;

        exibirMensagem("Resposta inválida. Digite 's' para sim ou 'n' para não.");
        return verificarAcao(mensagem);
    }

    public int confirmarAcao(String mensagem) {
        return verificarAcao(mensagem);
    }

    private int verificarTipoNumero(String tipo) {
        String[] tiposNumeros = {
            "Dia", "Mês", "Ano",
            "Hora", "Minuto",
            "Número", "Capacidade", "Valor",
            "ID"
        };
        for (String tipoNum : tiposNumeros) {
            if (tipo.equalsIgnoreCase(tipoNum)) return 1;
        }
        return 0;
    }

    public String pegarLinha(String label) {
        exibirLabel(label);
        if (verificarTipoNumero(label) == 1) return pegarApenasNumeros(label);
        return pegarApenasNumerosELetras(label);
    }

    public String[] pegarEntradas(String[] campos) {
        String[] inputs = new String[campos.length];

        for (int i = 0; i < campos.length; i++) {
            String campo = campos[i];
            switch (campo) {
                case "Data" -> {
                    String dia = pegarLinha("Dia");
                    String mes = pegarLinha("Mês");
                    String ano = pegarLinha("Ano");
                    inputs[i] = dia + "/" + mes + "/" + ano;
                }
                case "Horário" -> {
                    String hora = pegarLinha("Hora");
                    String minuto = pegarLinha("Minuto");
                    inputs[i] = hora + ":" + minuto;
                }
                case "Endereço" -> {
                    String cidade = pegarLinha("Cidade");
                    String rua = pegarLinha("Rua");
                    String numero = pegarLinha("Número");
                    inputs[i] = cidade + "," + rua + "," + numero;
                }
                default -> inputs[i] = pegarLinha(campo);
            }
        }
        
        pausartela(2);
        return inputs;
    }
    
    public void exibirTelaSaida() {
        final int larguraTotal = 50;
        String borda = "+" + "=".repeat(larguraTotal - 2) + "+";
        
        System.out.println();
        System.out.println(borda);
        System.out.printf("| %-"+(larguraTotal - 4)+"s |\n", "Obrigado por usar o sistema!");
        System.out.printf("| %-"+(larguraTotal - 4)+"s |\n", "Volte sempre :)");
        System.out.println(borda);
        System.out.println();
    }

}
