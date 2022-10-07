package mundo;

public class Participante {

	private String nombreUsuario;
	private String contraseña;
	private double presupuesto;
	private EquipoFantasia equipo;
	private Temporada temporadaActual;
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public EquipoFantasia getEquipo() {
		return equipo;
	}
	public void setEquipo(EquipoFantasia equipo) {
		this.equipo = equipo;
	}
	public Temporada getTemporadaActual() {
		return temporadaActual;
	}
	public void setTemporadaActual(Temporada temporadaActual) {
		this.temporadaActual = temporadaActual;
	}
	
	
}
