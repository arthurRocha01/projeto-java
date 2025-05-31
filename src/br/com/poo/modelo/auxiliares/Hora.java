package br.com.poo.modelo.auxiliares;

public class Hora {
	public int hora;
	public int minutos;
	
	public Hora(String horario) {
		criarHora(horario);
	}
	
	public void criarHora(String horario) {
		String[] infosHorario = horario.split(":");
		this.hora = Integer.parseInt(infosHorario[0]);
		this.minutos = Integer.parseInt(infosHorario[1]);
	}
}
