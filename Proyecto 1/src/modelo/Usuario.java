package modelo;

public abstract class Usuario {
	protected String nombreUsuario;
	protected String contraseña;
	public abstract String getNombreUsuario();
	public abstract String getContraseña();
}
