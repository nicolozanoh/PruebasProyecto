package mundo;

import java.util.Date;

public class Partido {

	private Date fecha;
	private EquipoReal equipoLocal;
	private EquipoReal equipoVisitante;
	
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
	
	
}
