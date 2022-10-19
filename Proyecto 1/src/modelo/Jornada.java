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
	public int getNumeroJornada() {
		return numeroJornada;
	}
	public void setNumeroJornada(int numeroJornada) {
		this.numeroJornada = numeroJornada;
	}
	public ArrayList<EquipoFantasia> getRankingEquiposFantasia() {
		return rankingEquiposFantasia;
	}
	public void setRankingEquiposFantasia(ArrayList<EquipoFantasia> rankingEquiposFantasia) {

		this.rankingEquiposFantasia.sort((EquipoFantasia a , EquipoFantasia b) -> Double.compare(a.getPuntosJornada().get(getNumeroJornada()), b.getPuntosJornada().get(getNumeroJornada())));
	}
	public ArrayList<Jugador> getRankingJugadores() {
		return rankingJugadores;
	}
	public void setRankingJugadores(ArrayList<Jugador> rankingJugadores) {
		
		this.rankingJugadores.sort((Jugador a , Jugador b) -> Double.compare(a.getPuntosJornada().get(getNumeroJornada()), b.getPuntosJornada().get(getNumeroJornada())));
	}
	public void agregarJugador(Jugador jugador) {
		this.rankingJugadores.add(jugador);
		this.rankingJugadores.sort((Jugador a , Jugador b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
	}
	public void agregarEquipoFantasia(EquipoFantasia equipoFantasia) {
		this.rankingEquiposFantasia.add(equipoFantasia);
		this.rankingEquiposFantasia.sort((EquipoFantasia a , EquipoFantasia b) -> Double.compare(a.getPuntosJornada().get(getNumeroJornada()), b.getPuntosJornada().get(getNumeroJornada())));
	}
	public void actualizarRankingEquiposFantasia() {
		this.rankingEquiposFantasia.sort((EquipoFantasia a , EquipoFantasia b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
	}
	public void actualizarRankingJugadores() {
		this.rankingJugadores.sort((Jugador a , Jugador b) -> Double.compare(a.getPuntosTotales(), b.getPuntosTotales()));
	}
	public Jugador mejorJugadorJornada() {
		ArrayList<Jugador> ranking = this.getRankingJugadores();
		Jugador respuesta = ranking.get(0);
		return respuesta;
	}
	public EquipoFantasia mejorEquipoFantasiaJornada() {
		ArrayList<EquipoFantasia> ranking = this.getRankingEquiposFantasia();
		EquipoFantasia respuesta = ranking.get(0);
		return respuesta;
	}
	public void actualizarResultadosJornada() {
		for(Partido p: this.partidos) {
			p.actualizarResultadoPartido(this.numeroJornada);
		}
	}
}
