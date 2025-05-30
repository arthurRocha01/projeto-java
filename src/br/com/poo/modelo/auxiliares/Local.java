package br.com.poo.modelo.auxiliares;

import br.com.poo.modelo.Ingresso;

public class Local {
	public Endereco endereco;
	public int capacidade;
	
	public Local(String strInfoEndereco, int capacidade) {
		this.endereco = new Endereco();
		this.capacidade = capacidade;
	}
	
	public void informarEndereco(String infoEndereco) {
		String[] infosEndereco = infoEndereco.split(",");
//		System.out.println(infosEndereco[0]);
		this.endereco.pais = infosEndereco[0];
		this.endereco.estado = infosEndereco[1];
		this.endereco.cidade = infosEndereco[2];
		this.endereco.bairro = infosEndereco[3];
		this.endereco.rua = infosEndereco[4];
		this.endereco.numero = Integer.parseInt(infosEndereco[5]);
	}
}
