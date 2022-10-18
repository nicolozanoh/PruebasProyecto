package modelo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Arquero extends Jugador{

	private int golesRecibidos;
	private int penaltisAtajados;
	private ArrayList<Integer> golesRecibidosJornada;
	private ArrayList<Integer> penaltisAtajadosJornada;
	

	public ArrayList<Integer> getGolesRecibidosJornada() {
		return golesRecibidosJornada;
	}


	public void setGolesRecibidosJornada(ArrayList<Integer> golesRecibidosJornada) {
		this.golesRecibidosJornada = golesRecibidosJornada;
	}


	public ArrayList<Integer> getPenaltisAtajadosJornada() {
		return penaltisErradosJornada;
	}


	public void setPenaltiAtajadosJornada(ArrayList<Integer> penaltisErradosJornada) {
		this.penaltisErradosJornada = penaltisErradosJornada;
	}


	public double calcularPuntaje(int numJornada) {
		this.puntosJornada.add(numJornada-1, (double) 0);


		this.puntosJornada.add(numJornada-1, 5 * (double) this.golesAnotadosJornada.get(numJornada-1));
		this.puntosJornada.add(numJornada-1, 3 * (double) this.asistenciasJornada.get(numJornada-1));
		this.puntosJornada.add(numJornada-1, -2 * (double) this.penaltisErradosJornada.get(numJornada-1));
		this.puntosJornada.add(numJornada-1, -1 * (double) this.amarillasJornada.get(numJornada-1));
		this.puntosJornada.add(numJornada-1, -3 * (double) this.rojasJornada.get(numJornada-1));
		this.puntosJornada.add(numJornada-1, -2 * (double) this.autogolesJornada.get(numJornada-1));
		if(this.golesRecibidosJornada.get(numJornada-1) == 0) {
			this.puntosJornada.add(numJornada-1, (double) 4);
		}
		if(this.penaltisAtajadosJornada.get(numJornada-1) > 0) {
			this.puntosJornada.add(numJornada-1, (double) 5);
		}
		if(this.minutosJugadosJornada.get(numJornada-1) > 1 && this.minutosJugadosJornada.get(numJornada-1) <= 60) {
			this.puntosJornada.add(numJornada-1, (double) 1);
		}
		if(this.minutosJugadosJornada.get(numJornada-1) > 60) {
			this.puntosJornada.add(numJornada-1, (double) 2);
		}
		
		this.actualizarPuntosTotales();
		return this.puntosTotales;
	}
	
	
	public int getGolesRecibidos() {
		return golesRecibidos;
	}
	public void setGolesRecibidos() {
		this.golesRecibidos = 0;
		for (int d: golesRecibidosJornada) {
			this.golesRecibidos+=d;
		}
	}
	public int getPenaltisAtajados() {
		return penaltisAtajados;
	}
	public void setPenaltisAtajados() {
		this.penaltisAtajados = 0;
		for (int d: penaltisAtajadosJornada) {
			this.penaltisAtajados+=d;
		}
	}

}
