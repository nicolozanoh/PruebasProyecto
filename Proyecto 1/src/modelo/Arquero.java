package modelo;

public class Arquero extends Jugador{

	private int golesRecibidos;
	private int penaltisAtajados;
	
	public double calcularPuntaje() {
		this.puntosTotales = 0;

		// Debemos poner si el jugador es cápitan del equipo de fantasia o no
		// Debemos tener en cuenta si el equipo del jugador gano el partido o no
		this.puntosTotales = this.puntosTotales + 5 * this.golesAnotados;
		this.puntosTotales = this.puntosTotales + 3 * this.asistencias;
		this.puntosTotales = this.puntosTotales + -2 * this.penaltisErrados;
		this.puntosTotales = this.puntosTotales + -1 * this.amarillas;
		this.puntosTotales = this.puntosTotales + -3 * this.rojas;
		this.puntosTotales = this.puntosTotales + -2 * this.autogoles;
		if(this.golesRecibidos == 0) {
			this.puntosTotales = this.puntosTotales + 4;
		}
		if(this.penaltisAtajados > 0) {
			this.puntosTotales = this.puntosTotales + 5;
		}
		if(this.minutosJugados > 1 && this.minutosJugados <= 60) {
			this.puntosTotales = this.puntosTotales + 1;
		}
		if(this.minutosJugados > 60) {
			this.puntosTotales = this.puntosTotales + 2;
		}
		
		return this.puntosTotales;
	}
	
	
	public int getGolesRecibidos() {
		return golesRecibidos;
	}
	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}
	public int getPenaltisAtajado() {
		return penaltisAtajados;
	}
	public void setPenaltisAtajado(int penaltisAtajado) {
		this.penaltisAtajados = penaltisAtajado;
	}

}
