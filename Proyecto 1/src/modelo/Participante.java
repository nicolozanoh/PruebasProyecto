package modelo;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Participante extends Usuario{

//	private String nombreUsuario;
//	private String contraseña;
	private double presupuesto;
	private EquipoFantasia equipo;
	
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
	public EquipoFantasia getEquipo() {
		return equipo;
	}
	
	public int crearEquipo(ArrayList<Jugador> jugadoresSeleccionados) {
		int resp = 0;
			if (jugadoresSeleccionados.size() != 15){
				this.equipo = new EquipoFantasia();
				for (int i = 0; i< jugadoresSeleccionados.size();i++) {
					resp = comprarJugador(jugadoresSeleccionados.get(i));
					if(resp != 0) {
						this.equipo = null;
						break;
					}
				}
			}
			else{
				resp = 7;
			}
		}
		else {
			resp = 6;
		}
			
		return resp;
	}
	public int borrarEquipo() {
		this.equipo = null;
		return 0;
	}

	public String venderJugador(Jugador jugador) {
		equipo.quitarJugador(jugador);
		presupuesto+= 0.97*(jugador.getPrecio());
		return "Se vendio exitosamente el jugador";
	}
	public int comprarJugador(Jugador jugador) {
		int respuesta= 0;
		if (this.equipo.getNumeroJugadores() < 15)
		{
			respuesta = this.equipo.agregarJugador(jugador);
			if (respuesta == 0) {
				presupuesto+= -1*jugador.getPrecio();
			}
		}
		else {
			respuesta = 1;
		}
		return respuesta;
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
