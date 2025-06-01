package br.com.poo.modelo.auxiliares;

public class Local {
	public Endereco endereco;
	public int capacidade;
	
	public Local(String infosEndereco, int capacidade) {
		this.endereco = new Endereco(infosEndereco); // Instancia um classe filha Endereco ao ser instanciado.
		this.capacidade = capacidade;
	}
}
