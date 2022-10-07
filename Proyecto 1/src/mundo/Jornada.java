package mundo;

import java.util.ArrayList;

public class Jornada {
	
	private ArrayList<Partido> partidos; 
	private int numeroFecha;
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
		this.rankingEquiposFantasia = rankingEquiposFantasia;
	}
	public ArrayList<Jugador> getRankingJugadores() {
		return rankingJugadores;
	}
	public void setRankingJugadores(ArrayList<Jugador> rankingJugadores) {
		this.rankingJugadores = rankingJugadores;
	}
	
	

}
