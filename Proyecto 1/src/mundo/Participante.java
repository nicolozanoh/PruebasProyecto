package mundo;

public class Participante {

	private String nombreUsuario;
	private String contraseña;
	private double presupuesto;
	private EquipoFantasia equipo;
	private Temporada temporadaActual;
	
	public Participante(String nombreUsuario, String contraseña) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}
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
	
	
	public void crearEquipo() {
		//TODO
	}
	public String venderJugador() {
		//TODO Devuelve un String confirmando la venta del jugador
		return "";
	}
	public void comprarJugador() {
		//TODO
	}
	public void seleccionarTitular(Jugador nuevoTitular, Jugador nuevoSuplente) {
		//TODO
	}
	public int consultarPuntajesEquipo() {
		//TODO No deberia recibir por parametro el equipo?
		return 0;
	}
	public int consultarPuntajeJugador() {
		//TODO Es el puntaje de toda la temporada? o de cada fecha?
		return 0;
	}
	
	
}
