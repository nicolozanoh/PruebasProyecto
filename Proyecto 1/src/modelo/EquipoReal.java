package modelo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EquipoReal {
	private String nombre;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Boolean> resultadoPartido;
	public EquipoReal() {
		jugadores = new ArrayList<Jugador>();
		resultadoPartido = new ArrayList<Boolean>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public ArrayList<Boolean> getResultadoPartido() {
		return resultadoPartido;
	}
	public void setResultadoPartido(ArrayList<Boolean> resultadoPartido) {
		this.resultadoPartido = resultadoPartido;
	}
	public void actualizarResultadoPartido(int numJornada, Boolean resultado) {
		if(this.resultadoPartido == null) {
			this.resultadoPartido = new ArrayList<Boolean>();
		}
		this.resultadoPartido.add(numJornada-1, resultado);
		for(Jugador j: jugadores) {
			j.actualizarPuntosJornada(numJornada, 1);
		}
		
	}	
}
