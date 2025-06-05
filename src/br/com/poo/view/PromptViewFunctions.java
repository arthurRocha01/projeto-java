package br.com.poo.view;

import java.util.List;
import java.util.Scanner;

import br.com.poo.modelo.Evento;
import br.com.poo.modelo.auxiliares.Data;
import br.com.poo.modelo.auxiliares.Endereco;
import br.com.poo.modelo.auxiliares.Hora;

public class PromptViewFunctions {
    private Scanner scanner = new Scanner(System.in);

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

    private void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void pausartela(int segundos) {
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

    public void exibirInfo(String label, int value) {
        System.out.printf("%-12s: %d\n", label, value);
    }

    public int menuSelecao(String nomeMenu, String[] opcoes, int isClean) {
        if (isClean == 1) limparTerminal();

        exibirHeader("Menu " + nomeMenu);
        for (int i = 0; i < opcoes.length; i++) {
            System.out.printf("%d. %s\n", i + 1, opcoes[i]);
        }
        exibirMensagem("0. Sair\n");
        System.out.print("Escolha uma opção: ");
        return pegarInt();
    }

    private String fragmentarDado(Object object) {
        if (object instanceof Data data) return String.format("%02d/%02d/%04d", data.dia, data.mes, data.ano);
        if (object instanceof Hora hora) return String.format("%02d:%02d", hora.hora, hora.minutos);
        if (object instanceof Endereco endereco)
            return String.format("%s - %s, Nº %d", endereco.cidade, endereco.rua, endereco.numero);
        return object.toString();
    }

    public void listarEvento(Evento evento, int isClean) {
        if (isClean == 1) limparTerminal();

        System.out.println("+---------------------------------------+");
        exibirInfo("ID", evento.id);
        exibirInfo("Nome", evento.nome);
        exibirInfo("Data", fragmentarDado(evento.data));
        exibirInfo("Horário", fragmentarDado(evento.hora));
        exibirInfo("Artista", evento.artista.nome);
        exibirInfo("Endereço", fragmentarDado(evento.local.endereco));
        exibirInfo("Capacidade", evento.local.capacidade);
        exibirInfo("Valor", String.format("R$ %.2f", evento.ingresso.valor));
        System.out.println("+---------------------------------------+\n");
    }

    public void exibirHeader(String header) {
        System.out.println("========================================");
        System.out.println(header.toUpperCase());
        System.out.println("========================================\n");
    }

    public void listarEventos(List<Evento> listaEventos) {
        limparTerminal();
        exibirHeader("Eventos Disponíveis");

        for (Evento evento : listaEventos) {
            listarEvento(evento, 0);
        }

        pausartela(1);
    }

    private int verificarTipoNumero(String tipo) {
        String[] tiposNumeros = {
            "Dia", "Mês", "Ano",
            "Hora", "Minuto",
            "Número", "Capacidade", "Valor"
        };
        for (String tipoNum : tiposNumeros) {
            if (tipo.equalsIgnoreCase(tipoNum)) return 1;
        }
        return 0;
    }

    public String lerLinha(String label) {
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
                    String dia = lerLinha("Dia");
                    String mes = lerLinha("Mês");
                    String ano = lerLinha("Ano");
                    inputs[i] = dia + "/" + mes + "/" + ano;
                }
                case "Horário" -> {
                    String hora = lerLinha("Hora");
                    String minuto = lerLinha("Minuto");
                    inputs[i] = hora + ":" + minuto;
                }
                case "Endereço" -> {
                    String cidade = lerLinha("Cidade");
                    String rua = lerLinha("Rua");
                    String numero = lerLinha("Número");
                    inputs[i] = cidade + "," + rua + "," + numero;
                }
                default -> inputs[i] = lerLinha(campo);
            }
        }

        return inputs;
    }
}
