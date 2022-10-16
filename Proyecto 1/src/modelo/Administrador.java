package modelo;
import java.io.File;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Administrador implements Usuario{

	private String nombreUsuario;
	private String contraseña;
	
	public void configurarTemporada(File archivo) {
		//TODO
	}
	public void actualizarDatosPartido(File archivo) {
		//TODO
	}
	
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
}
