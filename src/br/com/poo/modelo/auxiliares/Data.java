package br.com.poo.modelo.auxiliares;

public class Data {
	public int dia;
	public int mes;
	public int ano;
	
	public Data(String data) {
		setData(data);
	}
	
	public void setData(String data) {
		String[] infosData = data.split("/");
		this.dia = Integer.parseInt(infosData[0]);
		this.mes = Integer.parseInt(infosData[1]);
		this.ano = Integer.parseInt(infosData[2]);
	}
	
	public String getData() {
		String data = String.format("%d/%d/%d", this.dia, this.mes, this.ano);
		return data;
	}
}
