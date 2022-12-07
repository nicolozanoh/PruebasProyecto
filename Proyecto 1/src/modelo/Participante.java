package modelo;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Participante extends Usuario{
	private ArrayList<EquipoFantasia> equipos;
	private EquipoFantasia equipoActivo;
	public Participante() {
		this.equipos = new ArrayList<EquipoFantasia>();
	}
	public Participante(String nombreUsuario, String contraseña, double presupuesto) {
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
		return this.contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public ArrayList<EquipoFantasia> getEquipos(){
		return this.equipos;
	}
	 
	public int crearEquipo(ArrayList<Jugador> jugadoresSeleccionados, String nombreEquipo, int numJornadas, Double presupuesto) {
		int resp = 0;
		EquipoFantasia equipoNuevo = new EquipoFantasia();
		
			if (jugadoresSeleccionados.size() == 15){
				//equipo = new EquipoFantasia();
				equipoNuevo.setNombre(nombreEquipo);
				equipoNuevo.setPresupuesto(presupuesto);
				for (int i = 0; i< jugadoresSeleccionados.size();i++) {
					resp = equipoNuevo.comprarJugador(jugadoresSeleccionados.get(i));
					if(resp != 0) {
						break;
					}
				}
				if(resp == 0) {
					equipoNuevo.iniciarPuntosJornada(numJornadas);
					equipoNuevo.seleccionarAlineacionDefault();
					if (this.equipos == null) {
						this.equipos = new ArrayList<EquipoFantasia>();
					}
					this.equipos.add(equipoNuevo);
				}
				
			}
			else{
				resp = 7;
			}
		return resp;
	}
	public int borrarEquipo() {
		int resp = 1;
		
		return resp;
	}
	public void setEquipoActivo(EquipoFantasia equipo) {
		equipoActivo = equipo;
	}
	public EquipoFantasia getEquipoActivo() {
		return this.equipoActivo;
	}
	
//	public int venderJugador(int numJugador) {
//		int resp;
//		try {
//			Jugador jugador = this.equipo.getJugadores().get(numJugador-1);
//			resp = equipo.quitarJugador(numJugador);
//			presupuesto+= 0.97*(jugador.getPrecio());
//		}catch(Exception ex) {
//			resp = 1;
//		}
//		return resp;
//	}
		
//	
//	public int modificarAlineacion(int nuevoTitular, int nuevoSuplente) {
//		int resp = this.equipo.cambiarAlineacion(nuevoTitular, nuevoSuplente);
//		return resp;
//	}
//	public double consultarPuntajesEquipo() {
//		return this.equipo.getPuntosTotales();
//	}
//	public double consultarPuntajeJugador(Jugador jugador) {
//		return jugador.getPuntosTotales();
//	}
//	public void setEquipoFantasia(EquipoFantasia equipo) {
//		this.equipo = equipo;
//	}
	public void cambiarCapitan(int nuevoCapitan) {
		this.equipoActivo.cambiarEquipo(nuevoCapitan);
	}
	public int modificarAlineacionV2(ArrayList<String> jugadoresCambiar) {
		int resp = this.equipoActivo.cambiarAlineacionV2(jugadoresCambiar);
		return resp;
	}
	public int cambiarCapitanV2(ArrayList<String> nuevoCapitan) {
		int resp = this.equipoActivo.cambiarCapitanV2(nuevoCapitan);
		return resp;
	}
	public int venderJugadorV2(ArrayList<String> seleccion) {
		int resp = this.equipoActivo.quitarJugadorV2(seleccion);
		return resp;
	}
	public void organizarJugadores() {
		this.equipoActivo.organizarJugadores();
	}
	
}
