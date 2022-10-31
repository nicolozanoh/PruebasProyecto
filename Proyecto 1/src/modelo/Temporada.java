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
		if (equipos!=null && equipos.size()>2) {
			equipos.sort((EquipoFantasia a , EquipoFantasia b) -> -(Double.compare(a.getPuntosTotales(), b.getPuntosTotales())));
		}
		this.rankingEquiposFantasia = equipos;
	}
	public ArrayList<Jugador> getRankingJugadores() {
		return rankingJugadores;
	}
	public void setRankingJugadores() {
		if (this.jugadores!=null && this.jugadores.size()>2) {
			this.jugadores.sort((Jugador a , Jugador b) -> -(Double.compare(a.getPuntosTotales(), b.getPuntosTotales())));
		}
		this.rankingJugadores = this.jugadores;
	}
	public void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}
	public void agregarEquipoFantasia(EquipoFantasia equipoFantasia) {
		this.equiposFantasia.add(equipoFantasia);
	}
	public void actualizarRankingEquiposFantasia( ) {
		if (this.rankingEquiposFantasia!=null && this.rankingEquiposFantasia.size()>2) {
			this.rankingEquiposFantasia.sort((EquipoFantasia a , EquipoFantasia b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
		}
	}
	public void actualizarRankingJugadores() {
		if (this.rankingJugadores!=null && this.rankingJugadores.size()>2) {
			this.rankingJugadores.sort((Jugador a , Jugador b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
		}
	}
	public Jugador mejorJugadorTemporada() {
		return this.rankingJugadores.get(0);
	}
	public EquipoFantasia mejorEquipoFantasiaTemporada() {
		return this.rankingEquiposFantasia.get(0);
	}
}
