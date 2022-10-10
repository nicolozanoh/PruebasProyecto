package modelo;

import java.util.ArrayList;


public class Temporada {

	private ArrayList<Jornada> jornadas;
	private ArrayList<Jugador> jugadores;
	private ArrayList<EquipoFantasia> equiposFantasia;
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
	public ArrayList<EquipoFantasia> getRankingEquiposFantasia(ArrayList<EquipoFantasia> rankingEquiposFantasia) {
		return rankingEquiposFantasia;
	}
	public void setRankingEquiposFantasia() {
		this.equiposFantasia.sort((EquipoFantasia a , EquipoFantasia b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
		this.rankingEquiposFantasia = this.equiposFantasia;
	}
	public ArrayList<Jugador> getRankingJugadores() {
		return rankingJugadores;
	}
	public void setRankingJugadores() {
		this.jugadores.sort((Jugador a , Jugador b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
		this.rankingJugadores = this.jugadores;
	}
	
	public void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}
	
	public void agregarEquipoFantasia(EquipoFantasia equipoFantasia) {
		this.equiposFantasia.add(equipoFantasia);
	}
	
	public Jugador mejorJugadorJornada(Jornada jornada) {
		ArrayList<Jugador> ranking = jornada.getRankingJugadores();
		Jugador respuesta = ranking.get(0);
		return respuesta;
	}
	
	public EquipoFantasia mejorEquipoFantasiaJornada(Jornada jornada) {
		ArrayList<EquipoFantasia> ranking = jornada.getRankingEquiposFantasia();
		EquipoFantasia respuesta = ranking.get(0);
		return respuesta;
	}
}
