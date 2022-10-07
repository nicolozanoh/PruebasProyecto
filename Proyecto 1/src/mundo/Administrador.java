package mundo;

public class Administrador {

	private String nombreUsuario;
	private String contraseña;
	private Temporada temporadaActual;
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Temporada getTemporadaActual() {
		return temporadaActual;
	}
	public void setTemporadaActual(Temporada temporadaActual) {
		this.temporadaActual = temporadaActual;
	}
	
}
