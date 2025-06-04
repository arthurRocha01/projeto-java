package br.com.poo.modelo.auxiliares;

public class Endereco {
	public String cidade;
	public String rua;
	public int numero;
	
	public Endereco(String infosEndereco) {
		setEndereco(infosEndereco);
	}
	
	public void setEndereco(String infosEndereco) {
		String[] infos = infosEndereco.split(",");
		this.cidade = infos[0];
		this.rua = infos[1];
		this.numero = Integer.parseInt(infos[2]);
	}
}
