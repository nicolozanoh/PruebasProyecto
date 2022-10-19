package modelo;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true,
					   value = {"equipo"})
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
		if (equipo == null) {
			if (jugadoresSeleccionados.size() == 15){
				this.equipo = new EquipoFantasia();
				for (int i = 0; i< jugadoresSeleccionados.size();i++) {
					resp = comprarJugador(jugadoresSeleccionados.get(i));
					if(resp != 0) {
						this.equipo = null;
						break;
					}
				}
				if(resp == 0) {
					this.equipo.seleccionarAlineacionDefault();
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
		int resp = 1;
		if(this.equipo != null) {
			this.equipo = null;
			resp = 0;
		}
		return resp;
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
	public int modificarAlineacion(int nuevoTitular, int nuevoSuplente) {
		int resp = this.equipo.cambiarAlineacion(nuevoTitular, nuevoSuplente);
		if (resp== 0) {
			System.out.println("Su equipo ha sido modificado exitosamente.");
		}
		if (resp== 1) {
			System.out.println("Error: Los jugadores seleccionados no juegan en la misma posición.");
		}
		if (resp== 2) {
			System.out.println("Error: Los números seleccionados no son validos.");
		}
		return resp;
	}
	public double consultarPuntajesEquipo() {
		return this.equipo.getPuntosTotales();
	}
	public double consultarPuntajeJugador(Jugador jugador) {
		return jugador.getPuntosTotales();
	}
	public void setEquipoFantasia(EquipoFantasia equipo) {
		this.equipo = equipo;
	}

}
