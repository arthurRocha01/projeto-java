package br.com.poo.modelo.auxiliares;

public class Hora {
	private int hora;
	private int minutos;
	
	public Hora(String horario) {
		criarHora(horario);
	}
	
	public void criarHora(String horario) {
		String[] infosHorario = horario.split(":");
		this.hora = Integer.parseInt(infosHorario[0]);
		this.hora = Integer.parseInt(infosHorario[1]);
	}
}
