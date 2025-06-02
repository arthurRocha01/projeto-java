package br.com.poo.modelo.auxiliares;

public class Endereco {
	public String pais;
	public String estado;
	public String cidade;
	public String bairro;
	public String rua;
	public int numero;
	
	public Endereco(String infosEndereco) {
		informarEndereco(infosEndereco);
	}
	
	private void informarEndereco(String infosEndereco) {
		String[] infos = infosEndereco.split(",");
		this.pais = infos[0];
		this.estado = infos[1];
		this.cidade = infos[2];
		this.bairro = infos[3];
		this.rua = infos[4];
		this.numero = Integer.parseInt(infos[5]);
	}
	
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%d",
				this.pais, this.estado, this.cidade,
				this.bairro, this.rua, this.numero);
	}
}
