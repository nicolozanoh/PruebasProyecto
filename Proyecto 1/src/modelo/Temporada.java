package modelo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
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
	public ArrayList<EquipoFantasia> getRankingEquiposFantasia() {
		return rankingEquiposFantasia;
	}
	public void setRankingEquiposFantasia(ArrayList<EquipoFantasia>equipos) {
		equipos.sort((EquipoFantasia a , EquipoFantasia b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
		this.rankingEquiposFantasia = equipos;
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
	public void actualizarRankingEquiposFantasia( ) {
		this.rankingEquiposFantasia.sort((EquipoFantasia a , EquipoFantasia b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
	}
	public void actualizarRankingJugadores() {
		this.rankingJugadores.sort((Jugador a , Jugador b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
	}
	public Jugador mejorJugadorTemporada() {
		ArrayList<Jugador> ranking = this.getRankingJugadores();
		Jugador respuesta = ranking.get(0);
		return respuesta;
	}
	public EquipoFantasia mejorEquipoFantasiaTemporada() {
		ArrayList<EquipoFantasia> ranking = this.getRankingEquiposFantasia();
		EquipoFantasia respuesta = ranking.get(0);
		return respuesta;
	}
}
