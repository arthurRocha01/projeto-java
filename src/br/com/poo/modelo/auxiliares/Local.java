package br.com.poo.modelo.auxiliares;

public class Local {
	public Endereco endereco;
	public int capacidade;
	
	public Local(String infosEndereco, String capacidade) {
		this.endereco = new Endereco(infosEndereco);
		this.capacidade = Integer.parseInt(capacidade);
	}
}
