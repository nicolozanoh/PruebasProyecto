package mundo;

import java.io.File;
import java.util.ArrayList;

public class Administrador {

	private String nombreUsuario;
	private String contraseña;
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
	public Temporada getTemporadaActual() {
		return temporadaActual;
	}
	public void setTemporadaActual(Temporada temporadaActual) {
		this.temporadaActual = temporadaActual;
	}
	
	public void configurarTemporada(File archivo) {
		//TODO
	}
	public void actualizarDatosPartido(File archivo) {
		//TODO
	}
	
}
