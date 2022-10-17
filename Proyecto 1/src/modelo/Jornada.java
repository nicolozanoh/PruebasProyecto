package modelo;

import java.util.ArrayList;

public class Jornada {
	
	private ArrayList<Partido> partidos; 
	private int numeroJornada;
	private ArrayList<EquipoFantasia> rankingEquiposFantasia;
	private ArrayList<Jugador> rankingJugadores;
	
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}
	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}
	public int getNumeroFecha() {
		return numeroFecha;
	}
	public void setNumeroFecha(int numeroFecha) {
		this.numeroFecha = numeroFecha;
	}
	public ArrayList<EquipoFantasia> getRankingEquiposFantasia() {
		return rankingEquiposFantasia;
	}
	public void setRankingEquiposFantasia(ArrayList<EquipoFantasia> rankingEquiposFantasia) {

		this.rankingEquiposFantasia.sort((EquipoFantasia a , EquipoFantasia b) -> Double.compare(a.getPuntosJornada().get(getNumeroFecha()), b.getPuntosJornada().get(getNumeroFecha())));
	}
	
	public ArrayList<Jugador> getRankingJugadores() {
		return rankingJugadores;
	}
	public void setRankingJugadores(ArrayList<Jugador> rankingJugadores) {
		
		this.rankingJugadores.sort((Jugador a , Jugador b) -> Double.compare(a.getPuntosJornada().get(getNumeroFecha()), b.getPuntosJornada().get(getNumeroFecha())));
	}
	
	public void agregarJugador(Jugador jugador) {
		this.rankingJugadores.add(jugador);
		this.rankingJugadores.sort((Jugador a , Jugador b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
	}
	
	public void agregarEquipoFantasia(EquipoFantasia equipoFantasia) {
		this.rankingEquiposFantasia.add(equipoFantasia);
		this.rankingEquiposFantasia.sort((EquipoFantasia a , EquipoFantasia b) -> Double.compare(a.getPuntosJornada().get(getNumeroFecha()), b.getPuntosJornada().get(getNumeroFecha())));
	}

}
