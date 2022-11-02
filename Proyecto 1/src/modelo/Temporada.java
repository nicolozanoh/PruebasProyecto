package modelo;

import java.util.ArrayList;
import java.util.Collections;

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
		ArrayList<EquipoFantasia>cEquipos = new ArrayList<EquipoFantasia>(equipos);
		cEquipos.removeAll(Collections.singleton(null));
		if (equipos!=null && cEquipos.size()>=2) {
			cEquipos.sort((EquipoFantasia a , EquipoFantasia b) -> -(Double.compare(a.getPuntosTotales(), b.getPuntosTotales())));
		}
		this.rankingEquiposFantasia = cEquipos;
	}
	public ArrayList<Jugador> getRankingJugadores() {
		return rankingJugadores;
	}
	public void setRankingJugadores() {
		ArrayList<Jugador>cJugadores = new ArrayList<Jugador>(this.jugadores);
		cJugadores.removeAll(Collections.singleton(null));
		if (this.jugadores!=null && cJugadores.size()>=2) {
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
		ArrayList<EquipoFantasia>cRank = new ArrayList<EquipoFantasia>(this.rankingEquiposFantasia);
		cRank.removeAll(Collections.singleton(null));
		if (this.rankingEquiposFantasia!=null && cRank.size()>=2) {
			this.rankingEquiposFantasia.sort((EquipoFantasia a , EquipoFantasia b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
		}
	}
	public void actualizarRankingJugadores() {
		ArrayList<Jugador>cRank = new ArrayList<Jugador>(this.rankingJugadores);
		cRank.removeAll(Collections.singleton(null));
		if (this.rankingJugadores!=null && cRank.size()>=2) {
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
