package modelo;

import java.util.Date;

public class Partido {
	private Date fecha;
	private EquipoReal equipoLocal;
	private EquipoReal equipoVisitante;
	private int golesLocal;
	private int golesVisitante;
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EquipoReal getEquipoLocal() {
		return equipoLocal;
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
			this.equipoLocal.actualizarResultadoPartido(numJornada, "SI");
			this.equipoVisitante.actualizarResultadoPartido(numJornada, "NO");
		}
		else if (this.golesLocal < this.golesVisitante) {
			this.equipoVisitante.actualizarResultadoPartido(numJornada, "SI");
			this.equipoLocal.actualizarResultadoPartido(numJornada, "NO");
		}
		else {
			this.equipoVisitante.actualizarResultadoPartido(numJornada, "NO");
			this.equipoLocal.actualizarResultadoPartido(numJornada, "NO");
		}
	}
}
