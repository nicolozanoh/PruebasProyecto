package mundo;

import java.io.File;
import java.util.ArrayList;

public class Aplicacion {

	private String tipoUsuarioActivo;
	private ArrayList<Administrador> administrador;
	private ArrayList<Participante> participantes;
	private ArrayList<Temporada> temporadas;
	public String getTipoUsuarioActivo() {
		return tipoUsuarioActivo;
	}
	public void setTipoUsuarioActivo(String tipoUsuarioActivo) {
		this.tipoUsuarioActivo = tipoUsuarioActivo;
	}
	public ArrayList<Administrador> getAdministrador() {
		return administrador;
	}
	public void setAdministrador(ArrayList<Administrador> administrador) {
		this.administrador = administrador;
	}
	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(ArrayList<Temporada> temporadas) {
		this.temporadas = temporadas;
	}
	
	
	public boolean iniciarSesion(String tipoUsuario, String nombreUsuario, String clave) {
		//TODO
		return true;
	}
	public String crearUsuario(String nombreUsuario, String clave) {
		//TODO Devuelve un String confirmando que se creo correctamente el usuario o mensaje de error
		Participante nuevo= new Participante(nombreUsuario, clave);
		return "";
	}
	public void cerrarSesion() {
		//TODO
	}
	public EquipoFantasia mejorEquipoFecha() {
		ArrayList<EquipoFantasia> equiposFecha=new ArrayList<EquipoFantasia>();
		EquipoFantasia mejorEquipo=null;
		for (int i=0; i<participantes.size();i++) {
			equiposFecha.add(participantes.get(i).getEquipo());
		}
		for (int i=0; i<equiposFecha.size();i++) {
			if (equiposFecha.get(i).getPuntosJornada()>mejorEquipo.getPuntosJornada()) {
				mejorEquipo=equiposFecha.get(i);
			}
		}
		return mejorEquipo;
	}
	public Jugador mejorJugadorFecha() {
		//TODO
		return null;
	}
	public EquipoFantasia mejorEquipoActual() {
		//Si es el mejor equipo de fantasia de la temporada actual esto esta bien, si no, esta mal
		ArrayList<EquipoFantasia> equiposTemporadaActual=new ArrayList<EquipoFantasia>();
		EquipoFantasia mejorEquipo=null;
		for (int i=0; i<participantes.size();i++) {
			equiposTemporadaActual.add(participantes.get(i).getEquipo());
		}
		for (int i=0; i<equiposTemporadaActual.size();i++) {
			if (equiposTemporadaActual.get(i).getPuntosTotales()>mejorEquipo.getPuntosTotales()) {
				mejorEquipo=equiposTemporadaActual.get(i);
			}
		}
		return mejorEquipo;
	}
	public Jugador mejorJugadorActual() {
		//TODO
		return null;
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
	public void configurarTemporada(File archivo) {
		//TODO
	}
	public void actualizarDatosPartido(File archivo) {
		//TODO
	}
	
}
