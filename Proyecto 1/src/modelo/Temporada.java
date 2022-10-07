package modelo;

import java.util.ArrayList;

public class Temporada {

	private ArrayList<Jornada> jornadas;
	private ArrayList<Jugador> jugadores;
	private ArrayList<EquipoFantasia> rankingEquiposFantasia;
	private ArrayList<Jugador> rankingJugadores;
	public ArrayList<Jornada> getJornadas() {
		return jornadas;
	}
	public void setJornadas(ArrayList<Jornada> jornadas) {
		this.jornadas = jornadas;
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public ArrayList<EquipoFantasia> getRankingEquiposFantasia() {
		return rankingEquiposFantasia;
	}
	public void setRankingEquiposFantasia(ArrayList<EquipoFantasia> rankingEquiposFantasia) {
		this.rankingEquiposFantasia = rankingEquiposFantasia;
	}
	public ArrayList<Jugador> getRankingJugadores() {
		return rankingJugadores;
	}
	public void setRankingJugadores(ArrayList<Jugador> rankingJugadores) {
		this.rankingJugadores = rankingJugadores;
	}
	
	
	
}
