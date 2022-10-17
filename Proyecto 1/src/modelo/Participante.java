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
		if (equipo != null) {
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
	public boolean seleccionarTitular(ArrayList<Jugador> jugadores) {
		/*
		 * No se hace validacion de que la lista de titulares esta vacia porque mi 
		 * idea es usarla de una en crear equipo. Devuelve true si todas las condiciones
		 * de un equipo se cumplen.
		 * 
		 * La idea es que en la consola el participante escoja 11 jugadores y se vayan
		 * guardando en una lista y que esa lista sea la que entre por parametro
		 */
		boolean respuesta=false;
		int arquero=0;
		int defensa=0;
		int mediocampista=0;
		int delantero=0;
		if(jugadores.size()==11) {
			for(Jugador j:jugadores) {
				if (j.getPosicion()=="arquero") {
					arquero++;
				}
				else if (j.getPosicion()=="defensa") {
					defensa++;
				}
				else if (j.getPosicion()=="mediocampista") {
					mediocampista++;
				}
				else if (j.getPosicion()=="delantero") {
					delantero++;
				}
			}
			if(arquero==1 && defensa==4 && mediocampista==4 && delantero==2) {
				equipo.setTitulares(jugadores);
				respuesta=true;
			}
			else {
				respuesta=false;
			}
		}
		return respuesta;
	}
	public double consultarPuntajesEquipo() {
		return this.equipo.getPuntosTotales();
	}
	public double consultarPuntajeJugador(Jugador jugador) {
		return jugador.getPuntosTotales();
	}
}
