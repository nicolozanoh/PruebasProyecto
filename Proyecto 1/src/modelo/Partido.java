package modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Partido {
	private String fecha;
	private EquipoReal equipoLocal;
	private EquipoReal equipoVisitante;
	private int numeroJornada;
	private int golesLocal;
	private int golesVisitante;
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public EquipoReal getEquipoLocal() {
		return equipoLocal;
	}
	public int getNumeroJornada() {
		return numeroJornada;
	}
	public void setEquipoLocal(EquipoReal equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public EquipoReal getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(EquipoReal equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public int getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	public int getGolesVisitante() {
		return golesVisitante;
	}
	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	public void actualizarResultadoPartido(int numJornada) {
		if (this.golesLocal > this.golesVisitante) {
			this.equipoLocal.actualizarResultadoPartido(numJornada, true);
			this.equipoVisitante.actualizarResultadoPartido(numJornada, false);
		}
		else if (this.golesLocal < this.golesVisitante) {
			this.equipoVisitante.actualizarResultadoPartido(numJornada, true);
			this.equipoLocal.actualizarResultadoPartido(numJornada, false);
		}
		else {
			this.equipoVisitante.actualizarResultadoPartido(numJornada, false);
			this.equipoLocal.actualizarResultadoPartido(numJornada, false);
		}
	}
}
