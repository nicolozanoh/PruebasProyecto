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
	private Temporada temporadaActual;
	private ManejoPersistencia loader;
	private Usuario usuarioActivo;
	public Aplicacion() {
		administrador = new Administrador();
		participantes = new ArrayList<Participante>();
		temporadaActual = new Temporada();
		loader = new ManejoPersistencia();
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
	public Temporada getTemporada() {
		return this.temporadaActual;
	}
	public void setTemporadas(Temporada temporada) {
		this.temporadaActual = temporada;
	}
	public int iniciarSesion(String nombreUsuario, String clave) {
		int resp = 2;
		if (this.administrador != null) {
			if(this.administrador.getNombreUsuario() == nombreUsuario) {
				resp = 1;
				if(this.administrador.getContraseña() == clave) {
					resp = 0;
					this.usuarioActivo = administrador;
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
						File archivoEquipo = new File ("data/equipos/"+this.usuarioActivo.getNombreUsuario()+".json");
						if (archivoEquipo.exists()) {
							cargarEquipoParticipanteActivo(archivoEquipo);
						}
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
	public void cerrarSesion() {
		this.usuarioActivo = null;
	}
	public EquipoFantasia mejorEquipoFecha(int jornada) {
		ArrayList<EquipoFantasia> equiposFecha=new ArrayList<EquipoFantasia>();
		EquipoFantasia mejorEquipo=null;
		for (int i=0; i<participantes.size();i++) {
			equiposFecha.add(participantes.get(i).getEquipo());
		}
		for (int i=0; i<equiposFecha.size();i++) {
			if (equiposFecha.get(i).getPuntosJornada().get(jornada-1)>mejorEquipo.getPuntosJornada().get(jornada-1)) {
				mejorEquipo=equiposFecha.get(i);
			}
		}
		return mejorEquipo;
	}
	public Jugador mejorJugadorFecha() {
		//TODO
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
		return null;
	}
	public EquipoFantasia mejorEquipoActual() { //Si es el mejor equipo de fantasia de la temporada actual esto esta bien, si no, esta mal
		  ArrayList<EquipoFantasia> equiposTemporadaActual=new ArrayList<EquipoFantasia>(); 
		  EquipoFantasia mejorEquipo=null; 
		  for (int i=0;i<participantes.size();i++) {
			  equiposTemporadaActual.add(participantes.get(i).getEquipo()); 
		  } 
		  for (int i=0;i<equiposTemporadaActual.size();i++) { 
			  if(equiposTemporadaActual.get(i).getPuntosTotales()>mejorEquipo.getPuntosTotales()) { 
				  mejorEquipo=equiposTemporadaActual.get(i); 
				  } 
			  } 
		  return mejorEquipo; 
	  }
	public Jugador mejorJugadorActual() {
		//TODO
		return null;
	}
	public int crearEquipo(String[] jugadoresSeleccionados) {
		int resp = 0;
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		for (int i = 0; i<jugadoresSeleccionados.length;i++) {
			jugadores.add(this.temporadaActual.getJugadores().get(Integer.parseInt(jugadoresSeleccionados[i])-1));
		}
		resp = ((Participante) usuarioActivo).crearEquipo(jugadores);
		return resp;
	}
	public int venderJugador(int numJugador) {
		int resp = ((Participante)this.getUsuarioActivo()).venderJugador(numJugador);
		return resp;
	}
	public int comprarJugador(int numJugador) {
		int resp;
		try {		
			Jugador jugador = this.getTemporada().getJugadores().get(numJugador- 1);
			resp = ((Participante)this.getUsuarioActivo()).comprarJugador(jugador);
			if (resp == 0) {
				guardarEquipo();
				loader.guardarParticipantes(participantes);
			}
		}catch(Exception ex){
			resp = 1;
		}
		return resp;
	}
	public int cambiarAlineacion(int nuevoTitular, int nuevoSuplente) {
		int resp = ((Participante)this.usuarioActivo).modificarAlineacion(nuevoTitular, nuevoSuplente);
		loader.guardarEquipo(((Participante)this.usuarioActivo).getEquipo(), this.usuarioActivo.getNombreUsuario());
		return resp;
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
		File archivoParticipantes = new File("data/usuarios/participantes.json");
		try {
			if (archivoParticipantes.exists()) {
				participantes = this.loader.cargarParticipantes(archivoParticipantes);
			}
		} 
		catch(Exception ex){
		
		}
		return 0;
	}
	public Usuario getUsuarioActivo() {
		return this.usuarioActivo;
	}
	public int ejecutarCargarAdministrador() {
		
		File archivoAdministrador = new File("data/usuarios/administrador.json");
		
		if (archivoAdministrador.exists()) {
			administrador = this.loader.cargarAdministrador(archivoAdministrador);
		}
		
		return 0;
		
	}
	public int ejecutarCargarTemporadaActual() {
		File archivoJugadores = new File("data/temporada/jugadores.json");
		if (archivoJugadores.exists()) {
			this.temporadaActual.setJugadores(this.loader.cargarJugadores(archivoJugadores));
		}
		return 0;
	}
	public int guardarEquipo() {
		loader.guardarEquipo(((Participante)this.usuarioActivo).getEquipo(), ((Participante)this.usuarioActivo).getNombreUsuario());
		loader.guardarParticipantes(participantes);
		return 0;
	}
	public int borrarEquipo() {
		int resp = ((Participante)this.usuarioActivo).borrarEquipo();
		loader.borrarEquipo(this.usuarioActivo.getNombreUsuario());
		return resp;
	}
	public void cargarEquipoParticipanteActivo(File archivoEquipo) {
		((Participante)this.usuarioActivo).setEquipoFantasia(loader.cargarEquipoParticipanteActivo(archivoEquipo));
		
	}
	public int guardarCambiosParticipante() {
		int resp = 1;
		if (((Participante)this.getUsuarioActivo()).getEquipo().getJugadores().size()==15) {
			resp = 0;
			guardarEquipo();
			loader.guardarParticipantes(participantes);
		}
		return resp;
	}
}
