package modelo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EquipoReal {
	private String nombre;
	private ArrayList<Jugador> jugadores;
	private ArrayList<String> resultadoPartido; // Puede tener como valor "SI" o "NO"
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
	public ArrayList<String> getResultadoPartido() {
		return resultadoPartido;
	}
	public void setResultadoPartido(ArrayList<String> resultadoPartido) {
		this.resultadoPartido = resultadoPartido;
	}
	public void actualizarResultadoPartido(int numJornada, String resultado) {
		this.resultadoPartido.add(numJornada, resultado);
		if(this.resultadoPartido.get(numJornada) == "SI") {
			for(Jugador j: jugadores) {
				j.actualizarPuntosJornada(numJornada, 1);
			}
		}
		else if (this.resultadoPartido.get(numJornada) == "NO") {
			for(Jugador j: jugadores) {
				j.actualizarPuntosJornada(numJornada, 0);
			}
		}
	}	
}
