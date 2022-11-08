package modelo;

import java.util.ArrayList;
import java.util.Collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
						//value={"rankingEquiposFantasia","rankingJugadores"})
public class Jornada {
	private ArrayList<Partido> partidos; 
	private int numeroJornada;
	private ArrayList<EquipoFantasia> rankingEquiposFantasia;
	private ArrayList<Jugador> rankingJugadores;
	private String fechaPrimerPartido;
	private String fechaUltimoPartido;
	public Jornada () {
		partidos = new ArrayList<Partido>();
		this.rankingEquiposFantasia = new ArrayList<EquipoFantasia>();
		this.rankingJugadores = new ArrayList<Jugador>();
	}
	public void setFechaPrimerPartido(String fecha) {
		this.fechaPrimerPartido = fecha;
	}
	public String getFechaPrimerPartido() {
		return this.fechaPrimerPartido;
	}
	public String getFechaUltimoPartido() {
		return fechaUltimoPartido;
	}
	public void setFechaUltimoPartido(String fechaUltimoPartido) {
		this.fechaUltimoPartido = fechaUltimoPartido;
	}
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
		this.rankingEquiposFantasia = rankingEquiposFantasia;
		ArrayList<EquipoFantasia>cRank = new ArrayList<EquipoFantasia>(rankingEquiposFantasia);
		cRank.removeAll(Collections.singleton(null));
		if (this.rankingEquiposFantasia!=null && cRank.size()>2) {
			this.rankingEquiposFantasia.sort((EquipoFantasia a , EquipoFantasia b) -> -(Double.compare(a.getPuntosJornada().get(getNumeroJornada()-1), b.getPuntosJornada().get(getNumeroJornada()-1))));
		}
	}
	public ArrayList<Jugador> getRankingJugadores() {
		return rankingJugadores;
	}
	public void setRankingJugadores(ArrayList<Jugador> rankingJugadores) {
		this.rankingJugadores = rankingJugadores;
		ArrayList<Jugador>cRank = new ArrayList<Jugador>(rankingJugadores);
		cRank.removeAll(Collections.singleton(null));
		if (this.rankingJugadores!=null && cRank.size()>=2) {
			this.rankingJugadores.sort((Jugador a , Jugador b) -> -(Double.compare(a.getPuntosJornada().get(getNumeroJornada()), b.getPuntosJornada().get(getNumeroJornada()))));
		}
	}
	public Jugador mejorJugadorJornada() {
		try {
			return this.rankingJugadores.get(0);
		}catch (Exception ex) {
			return null;
		}
	}
	public EquipoFantasia mejorEquipoFantasiaJornada() {
		try {
			return this.rankingEquiposFantasia.get(0);
		}catch(Exception ex) {
			return null;
		}
	}
	public void actualizarResultadosJornada() {
		for(Partido p: this.partidos) {
			p.actualizarResultadoPartido(this.numeroJornada);
		}
	}
}
