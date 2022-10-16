package procesamiento;


import java.io.File;
import java.util.ArrayList;
import modelo.ManejoPersistencia;
import modelo.Administrador;
import modelo.EquipoFantasia;
import modelo.Jugador;
import modelo.Participante;
import modelo.Temporada;
import modelo.Usuario;

public class Aplicacion {

	private Administrador administrador;
	private ArrayList<Participante> participantes;
	private ArrayList<Temporada> temporadas;
	private String tipoUsuarioActivo;
	private Temporada temporadaActual;
	private ManejoPersistencia loader;
	private Usuario usuarioActivo;
	
	public Aplicacion() {
		administrador = new Administrador();
		participantes = new ArrayList<Participante>();
		temporadas = new ArrayList<Temporada>();
		temporadaActual = new Temporada();
		loader = new ManejoPersistencia();
		
	}
	public String getTipoUsuarioActivo() {
		return tipoUsuarioActivo;
	}

	public void setTipoUsuarioActivo(String tipoUsuarioActivo) {
		this.tipoUsuarioActivo = tipoUsuarioActivo;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
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
	
	public int iniciarSesion(String nombreUsuario, String clave) {
		int resp = 2;
		if (this.administrador != null) {
			if(this.administrador.getNombreUsuario() == nombreUsuario) {
				resp = 1;
				if(this.administrador.getContraseña() == clave) {
					resp = 0;
					this.usuarioActivo = this.administrador;
				}
			}
		}
		if (this.participantes != null && resp == 2){
			for(int i = 0; i< this.participantes.size(); i++) {
				if (this.participantes.get(i).getNombreUsuario().equals(nombreUsuario)) {
					resp = 1;
					if (this.participantes.get(i).getContraseña().equals(clave)) {
						resp = 0;
						this.usuarioActivo = this.participantes.get(i);
					}
				}
			}
		}
		return resp;
	}

	public int crearCuenta(String nombreUsuario, String clave) {
		int resp = 0;
		if (this.participantes != null) {
			for(int i = 0; i<this.participantes.size(); i++) {
				if(this.participantes.get(i).getNombreUsuario() == nombreUsuario){
					resp = 1;
				}
			}
		}
		else {
			this.participantes = new ArrayList<Participante>();
		}
		if (resp == 0) {
			Participante nuevo = new Participante(nombreUsuario, clave, 1000000);
			this.participantes.add(nuevo);
			loader.guardarParticipantes(this.participantes);
		}
		return resp;
	}
	
	public Usuario getUsuarioActivo() {
		return this.usuarioActivo;
	}

	public void cerrarSesion() {
		//TODO
	}

//	public EquipoFantasia mejorEquipoFecha(int jornada) {
//		ArrayList<EquipoFantasia> equiposFecha=new ArrayList<EquipoFantasia>();
//		EquipoFantasia mejorEquipo=null;
//		for (int i=0; i<participantes.size();i++) {
//			equiposFecha.add(participantes.get(i).getEquipo());
//		}
//		for (int i=0; i<equiposFecha.size();i++) {
//			if (equiposFecha.get(i).getPuntosJornada().get(jornada-1)>mejorEquipo.getPuntosJornada().get(jornada-1)) {
//				mejorEquipo=equiposFecha.get(i);
//			}
//		}
//		return mejorEquipo;
//	}

//	public Jugador mejorJugadorFecha() {
//		//TODO
//		//Si es el mejor equipo de fantasia de la temporada actual esto esta bien, si no, esta mal
//		ArrayList<EquipoFantasia> equiposTemporadaActual=new ArrayList<EquipoFantasia>();
//		EquipoFantasia mejorEquipo=null;
//		for (int i=0; i<participantes.size();i++) {
//			equiposTemporadaActual.add(participantes.get(i).getEquipo());
//		}
//		for (int i=0; i<equiposTemporadaActual.size();i++) {
//			if (equiposTemporadaActual.get(i).getPuntosTotales()>mejorEquipo.getPuntosTotales()) {
//				mejorEquipo=equiposTemporadaActual.get(i);
//			}
//		}
//		return null;
//	}
	

	/*
	 * public EquipoFantasia mejorEquipoActual() { //Si es el mejor equipo de
	 * fantasia de la temporada actual esto esta bien, si no, esta mal
	 * ArrayList<EquipoFantasia> equiposTemporadaActual=new
	 * ArrayList<EquipoFantasia>(); EquipoFantasia mejorEquipo=null; for (int i=0;
	 * i<participantes.size();i++) {
	 * equiposTemporadaActual.add(participantes.get(i).getEquipo()); } for (int i=0;
	 * i<equiposTemporadaActual.size();i++) { if
	 * (equiposTemporadaActual.get(i).getPuntosTotales()>mejorEquipo.
	 * getPuntosTotales()) { mejorEquipo=equiposTemporadaActual.get(i); } } return
	 * mejorEquipo; }
	 */

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

	public int consultarPuntajeEquipo(EquipoFantasia equipo) {
		//TODO No deberia recibir por parametro el equipo?
		
		return 0;
	}

	public double consultarPuntajeJugador(Jugador jugador) {
		// Suponiendo que entra por parametro un jugador y que se consultan los puntos totales
		return jugador.getPuntosTotales();
	}

	public void configurarTemporada(File archivo) {
		//TODO
	}
	
	public void actualizarDatosPartido(File archivo) {
		//TODO
	}
	
	public int ejecutarCargarParticipantes() {
		
		File archivoParticipantes = new File("data/participantes.json");
		
		try {
			if (archivoParticipantes.exists()) {
				participantes = this.loader.cargarParticipantes(archivoParticipantes);
			}
		} 
		catch(Exception ex){
		
		}
		
		
		return 0;
		
	}
	
	public int ejecutarCargarAdministrador() {
		
		File archivoAdministrador = new File("data/administrador.json");
		
		if (archivoAdministrador.exists()) {
			administrador = this.loader.cargarAdministrador(archivoAdministrador);
		}
		
		return 0;
		
	}
	
	public int ejecutarCargarTemporadaActual() {
		
		File archivoParticipantes = new File("data/participantes.json");
		
		if (archivoParticipantes.exists()) {
			this.temporadaActual = this.loader.cargarTemporadaActual();
		}
		
		return 0;
		
	}
	
}
