package modelo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Participante implements Usuario{

	private String nombreUsuario;
	private String contraseña;
	private double presupuesto;
	//private EquipoFantasia equipo;
	//private Temporada temporadaActual;
	
	public Participante() {
		
	}
	public Participante(String nombreUsuario, String contraseña, double presupuesto) {
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.presupuesto = presupuesto;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return this.contraseña;
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
//	public EquipoFantasia getEquipo() {
//		return equipo;
//	}
//	public void setEquipo(EquipoFantasia equipo) {
//		this.equipo = equipo;
//	}
//	public Temporada getTemporadaActual() {
//		return temporadaActual;
//	}
//	public void setTemporadaActual(Temporada temporadaActual) {
//		this.temporadaActual = temporadaActual;
//	}
	
	
	public void crearEquipo() {
		//TODO
	}
//	public String venderJugador(Jugador jugador) {
//		equipo.quitarJugador(jugador);
//		presupuesto+= 0.97*(jugador.getPrecio());
//		return "Se vendio exitosamente el jugador";
//	}
//	public String comprarJugador(Jugador jugador) {
//		String respuesta="No se puede comprar el jugador porque el equipo esta completo o porque la posicion del "
//				+ "jugador esta completa.";
//		if (equipo.agregarJugador(jugador)==true) {
//			presupuesto+= -1*jugador.getPrecio();
//			respuesta="Se ha comprado exitosamente el jugador.";
//		}
//		return respuesta;
//	}
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
