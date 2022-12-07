package modelo;

import java.util.ArrayList;
import java.util.Collections;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

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
	public EquipoFantasia getEquipoFantasia(String nombreDelEquipo) {
		boolean centinela = false;
		int contador=0;
		EquipoFantasia respuesta=null;
		while(centinela==false) {
			if(nombreDelEquipo==equiposFantasia.get(contador).getNombre()) {
				respuesta=equiposFantasia.get(contador);
				centinela=true;
			}
			else {
				contador++;
			}
		}
		return respuesta;
	}
	
	public JFreeChart graficoComparacionEquipos(int nRanking) {
		
		DefaultCategoryDataset dts = new DefaultCategoryDataset();
		for (int i=0; i<nRanking;i++) {
			EquipoFantasia equipo= rankingEquiposFantasia.get(i);
			
			for (int j=0; j<equipo.getPuntosJornada().size()-1; j++) {
				dts.addValue(equipo.getPuntosJornada().get(j),equipo.getNombre(),""+(j+1));
			}
		}
		JFreeChart graficoLineas = ChartFactory.createLineChart("Evolucion de los mejores equipos"
				, "Puntos" , "Jornadas" , dts, PlotOrientation.VERTICAL, true, false, false);
		return graficoLineas;
	}
//	public void graficoPuntosJugadoresEquipo(Participante usuario) {
//		ArrayList<Jugador> jugadores =usuario.getEquipo().getJugadores();
//		
//		DefaultCategoryDataset dts = new DefaultCategoryDataset();
//		
//		for (int i = 0; i<jugadores.size(); i++)
//			  dts.addValue(jugadores.get(i).getPuntosTotales(), "Puntos Totales", jugadores.get(i).getNombre());
//
//		JFreeChart chart = ChartFactory.createBarChart("Aporte de jugadores en la temporada" , "Puntos" , "Equipos" , dts);
//		
//	}
}
