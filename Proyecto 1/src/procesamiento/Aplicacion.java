package procesamiento;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import modelo.ManejoPersistencia;
import modelo.Administrador;
import modelo.Arquero;
import modelo.Defensa;
import modelo.EquipoFantasia;
import modelo.EquipoReal;
import modelo.Jornada;
import modelo.Jugador;
import modelo.Participante;
import modelo.Partido;
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
			if(this.administrador.getNombreUsuario().equals(nombreUsuario)) {
				resp = 1;
				if(this.administrador.getContraseña().equals(clave)) {
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
						//File archivoEquipo = new File ("data/equipos/"+this.usuarioActivo.getNombreUsuario()+".json");
						/*
						 * if (archivoEquipo.exists()) { cargarEquipoParticipanteActivo(archivoEquipo);
						 * }
						 */
					}
				}
			}
		}
		return resp;
	}
	public int crearCuenta(String nombreUsuario, String clave) {
		int resp = 0;
		if(nombreUsuario.equals("")||clave.equals("")) {
			resp = 1;
		}
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
	public EquipoFantasia mejorEquipoFecha(int numJornada) {
		try {
			Jornada jornada = this.temporadaActual.getJornadas().get(numJornada-1);
			return jornada.mejorEquipoFantasiaJornada();
		}catch(Exception ex){
			return null;
		}
		
	}
	public Jugador mejorJugadorFecha(int numJornada) {
		Jornada jornada = this.temporadaActual.getJornadas().get(numJornada-1);
		return jornada.mejorJugadorJornada();
	}
	public EquipoFantasia mejorEquipoActual() { //Si es el mejor equipo de fantasia de la temporada actual esto esta bien, si no, esta mal
		/*
		 * ArrayList<EquipoFantasia> equiposTemporadaActual=new
		 * ArrayList<EquipoFantasia>(); EquipoFantasia mejorEquipo=null; for (int
		 * i=0;i<participantes.size();i++) {
		 * equiposTemporadaActual.add(participantes.get(i).getEquipo()); } for (int
		 * i=0;i<equiposTemporadaActual.size();i++) {
		 * if(equiposTemporadaActual.get(i).getPuntosTotales()>mejorEquipo.
		 * getPuntosTotales()) { mejorEquipo=equiposTemporadaActual.get(i); } } return
		 * mejorEquipo;
		 */
		
		return this.temporadaActual.mejorEquipoFantasiaTemporada();
	  }
	public Jugador mejorJugadorActual() {
		return this.temporadaActual.mejorJugadorTemporada();
	}
	public int crearEquipo(String[] jugadoresSeleccionados, String nombreEquipo) {
		int resp = 0;
	
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		for (int i = 0; i<jugadoresSeleccionados.length;i++) {
			jugadores.add(this.temporadaActual.getJugadores().get(Integer.parseInt(jugadoresSeleccionados[i])-1));
		}
		resp = ((Participante) usuarioActivo).crearEquipo(jugadores, nombreEquipo, this.temporadaActual.getJornadas().size());
		return resp;
	}
	public int venderJugador(int numJugador) {
		boolean modificar = permitirModificar();
		int resp;
		if (modificar) {
			resp = ((Participante)this.getUsuarioActivo()).venderJugador(numJugador);
		}
		else {
			resp = 3;
		}
		return resp;
	}
	public int comprarJugador(int numJugador) {
		int resp;
		boolean modificar = permitirModificar();
		if(modificar) {
			try {		
				Jugador jugador = this.getTemporada().getJugadores().get(numJugador- 1);
				resp = ((Participante)this.getUsuarioActivo()).comprarJugador(jugador);
				if (resp == 0) {
					((Participante)this.getUsuarioActivo()).getEquipo().getSuplentes().add(jugador);
					guardarEquipo();
					loader.guardarParticipantes(participantes);
				}
			}catch(Exception ex){
				resp = 1;
			}
		}
		else{
			resp = 8;
		}
		return resp;
	}
	public int cambiarAlineacion(int nuevoTitular, int nuevoSuplente) {
		boolean modificar = permitirModificar();
		int resp;
		if(modificar) {
			resp = ((Participante)this.usuarioActivo).modificarAlineacion(nuevoTitular, nuevoSuplente);
			//loader.guardarEquipo(((Participante)this.usuarioActivo).getEquipo(), this.usuarioActivo.getNombreUsuario());
			loader.guardarParticipantes(participantes);
		}
		else {
			resp = 3;
		}
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
	public int cargarParticipantes() {
		File archivoParticipantes = new File("data\\usuarios\\participantes.json");
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
	public int cargarAdministrador() {
		
		File archivoAdministrador = new File("data\\usuarios\\administrador.json");
		
		if (archivoAdministrador.exists()) {
			administrador = this.loader.cargarAdministrador(archivoAdministrador);
		}
		
		return 0;
		
	}
	public int cargarTemporadaActual() {
		File archivoJugadores = new File("data\\temporada\\jugadores.json");
		File archivoJornadas = new File("data\\temporada\\jornadas.json");
		int resp = 2;
		if (archivoJugadores.exists()) {
			this.temporadaActual.setJugadores(this.loader.cargarJugadores(archivoJugadores));
			resp--;
		}
		if (archivoJornadas.exists()) {
			this.temporadaActual.setJornadas(this.loader.cargarJornadas(archivoJornadas));
			resp--;
		}
		return resp;
	}
	public void actualizarReferencias() {
		Jugador jugador;
		Participante participante;
		String nombre;
		String equipo;
		String posicion;
		Partido partido;
		for(int i = 0; i<this.temporadaActual.getJugadores().size();i++) {
			jugador = this.temporadaActual.getJugadores().get(i);
			for(int j = 0; j<this.participantes.size();j++) {
				participante = this.participantes.get(j);
				if (participante.getEquipo()!= null) {
					for(int h = 0; h<participante.getEquipo().getJugadores().size(); h++) {
						nombre =participante.getEquipo().getJugadores().get(h).getNombre();
						equipo = participante.getEquipo().getJugadores().get(h).getNombreEquipo();
						posicion = participante.getEquipo().getJugadores().get(h).getPosicion();
						if(nombre.equals(jugador.getNombre())&&equipo.equals(jugador.getNombreEquipo())&&posicion.equals(jugador.getPosicion())) {
							participante.getEquipo().getJugadores().set(h, jugador);
							break;
						}
					}
					for(int h = 0; h<participante.getEquipo().getTitulares().size(); h++) {
						nombre =participante.getEquipo().getTitulares().get(h).getNombre();
						equipo = participante.getEquipo().getTitulares().get(h).getNombreEquipo();
						posicion = participante.getEquipo().getTitulares().get(h).getPosicion();
						if(nombre.equals(jugador.getNombre())&&equipo.equals(jugador.getNombreEquipo())&&posicion.equals(jugador.getPosicion())) {
							participante.getEquipo().getTitulares().set(h, jugador);
							break;
						}
					}
					for(int h = 0; h<participante.getEquipo().getSuplentes().size(); h++) {
						nombre =participante.getEquipo().getSuplentes().get(h).getNombre();
						equipo = participante.getEquipo().getSuplentes().get(h).getNombreEquipo();
						posicion = participante.getEquipo().getSuplentes().get(h).getPosicion();
						if(nombre.equals(jugador.getNombre())&&equipo.equals(jugador.getNombreEquipo())&&posicion.equals(jugador.getPosicion())) {
							participante.getEquipo().getSuplentes().set(h, jugador);
							break;
						}
					}
				}
			}
			
			for(int j = 0; j<this.temporadaActual.getJornadas().size();j++) {
				for(int h = 0; h < this.temporadaActual.getJornadas().get(j).getPartidos().size();h++) {
					partido = this.temporadaActual.getJornadas().get(j).getPartidos().get(h);
					for (int k = 0; k<partido.getEquipoLocal().getJugadores().size();k++) {
						nombre =partido.getEquipoLocal().getJugadores().get(k).getNombre();
						equipo = partido.getEquipoLocal().getJugadores().get(k).getNombreEquipo();
						posicion = partido.getEquipoLocal().getJugadores().get(k).getPosicion();
						if(nombre.equals(jugador.getNombre())&&equipo.equals(jugador.getNombreEquipo())&&posicion.equals(jugador.getPosicion())) {
							this.temporadaActual.getJornadas().get(j).getPartidos().get(h).getEquipoLocal().getJugadores().set(k, jugador);
							break;
						}
					}
					for (int k = 0; k<partido.getEquipoVisitante().getJugadores().size();k++) {
						nombre =partido.getEquipoVisitante().getJugadores().get(k).getNombre();
						equipo = partido.getEquipoVisitante().getJugadores().get(k).getNombreEquipo();
						posicion = partido.getEquipoVisitante().getJugadores().get(k).getPosicion();
						if(nombre.equals(jugador.getNombre())&&equipo.equals(jugador.getNombreEquipo())&&posicion.equals(jugador.getPosicion())) {
							this.temporadaActual.getJornadas().get(j).getPartidos().get(h).getEquipoVisitante().getJugadores().set(k, jugador);
							break;
						}
					}
				}
			}
		}
	}
	
	public int guardarEquipo() {
		//loader.guardarEquipo(((Participante)this.usuarioActivo).getEquipo(), ((Participante)this.usuarioActivo).getNombreUsuario());
		loader.guardarParticipantes(participantes);
		return 0;
	}
	public int borrarEquipo() {
		int resp = ((Participante)this.usuarioActivo).borrarEquipo();
		loader.guardarParticipantes(participantes);
		return resp;
	}

	/*
	 * public void cargarEquipoParticipanteActivo(File archivoEquipo) {
	 * ((Participante)this.usuarioActivo).setEquipoFantasia(loader.
	 * cargarEquipoParticipanteActivo(archivoEquipo));
	 * 
	 * }
	 */
	public int guardarCambiosParticipante() {
		int resp = 1;
		if (((Participante)this.getUsuarioActivo()).getEquipo().getJugadores().size()==15) {
			resp = 0;
			guardarEquipo();
			loader.guardarParticipantes(participantes);
		}
		return resp;
	}
	public int cargarConfiguracionTemporada(String rutaJugadores, String rutaPartidos) {
		File nuevoArchivoJugadores = new File(rutaJugadores);
		File nuevoArchivoPartidos = new File(rutaPartidos);
		File archivoJugadores = new File("data\\temporada\\jugadores.json");
		File archivoJornadas = new File("data\\temporada\\jornadas.json");
		ArrayList<Partido> partidos = new ArrayList<Partido>();
		int resp = 3;
		if(!(archivoJugadores.exists()|| archivoJornadas.exists())) {
			resp = 2;
			if (nuevoArchivoPartidos.exists()) {
				partidos = this.loader.cargarPartidos(nuevoArchivoPartidos);
				resp=1;
			}
			if (nuevoArchivoJugadores.exists()) {
				this.temporadaActual.setJugadores(this.loader.cargarJugadores(nuevoArchivoJugadores));
				resp = 0;
			}
			if (resp == 0) {
				ArrayList<EquipoReal> equipos = new ArrayList<EquipoReal>();
				equipos = this.loader.llenarEquiposReales(this.temporadaActual.getJugadores());
				partidos = this.loader.llenarJugadoresPartidos(partidos, equipos);
				this.temporadaActual.setJornadas(this.loader.llenarJornadas(partidos));
				this.loader.guardarJornadas(this.temporadaActual.getJornadas());
				for (int i = 0; i<this.temporadaActual.getJugadores().size();i++) {
					this.temporadaActual.getJugadores().get(i).iniciarPuntosJornada(this.temporadaActual.getJornadas().size());
				}
				this.loader.guardarJugadores(this.temporadaActual.getJugadores());
			}
			else {
				this.temporadaActual.setJugadores(null);
			}
		}
		return resp;
		
	}
	public void borrarArchivosTemporada() {
		this.loader.borrarArchivosTemporada();
	}
	public boolean permitirModificar() {
		LocalDateTime fechaActual = LocalDateTime.now();
		LocalDateTime fechaPrimerPartido;
		LocalDateTime fechaUltimoPartido;
		LocalDateTime inicioJornada;
		LocalDateTime finJornada;
		boolean resp = true;
		for (int i = 0; i<this.temporadaActual.getJornadas().size();i++) {
			fechaPrimerPartido = LocalDateTime.parse(this.temporadaActual.getJornadas().get(i).getFechaPrimerPartido());
			inicioJornada = LocalDateTime.of(fechaPrimerPartido.getYear(), fechaPrimerPartido.getMonth(), fechaPrimerPartido.getDayOfMonth(), 00, 00);
			fechaUltimoPartido = LocalDateTime.parse(this.temporadaActual.getJornadas().get(i).getFechaUltimoPartido());
			finJornada = LocalDateTime.of(fechaUltimoPartido.getYear(), fechaUltimoPartido.getMonth(), fechaUltimoPartido.getDayOfMonth()+1, 00, 00);
			if (fechaActual.isAfter(inicioJornada)&&fechaActual.isBefore(finJornada)) {
				resp = false;
				break;
			}
		}
		return resp;
	}
	public int cargarResultadoPartido(String rutaResultadoPartido) {
		File resultadoPartido = new File(rutaResultadoPartido);
		Partido datosPartido = this.loader.cargarResultadoPartido(resultadoPartido);
		Jugador jugadorResultado;
		Jugador jugadorLista;
		int numJornada = datosPartido.getNumeroJornada();
		for (int i = 0; i<datosPartido.getEquipoLocal().getJugadores().size();i++) {
			jugadorResultado = datosPartido.getEquipoLocal().getJugadores().get(i);
			for (int j = 0; j<this.temporadaActual.getJugadores().size();j++) {
				jugadorLista = this.temporadaActual.getJugadores().get(j);
				if(jugadorLista.getNombre().equals(jugadorResultado.getNombre())&&jugadorLista.getPosicion().equals(jugadorResultado.getPosicion())) {
					jugadorLista.getMinutosJugadosJornada().add(numJornada-1, jugadorResultado.getMinutosJugados());
					jugadorLista.getMinutoInicioJornada().add(numJornada-1, jugadorResultado.getMinutoInicio());
					jugadorLista.getMinutoSustitucionJornada().add(numJornada-1, jugadorResultado.getMinutoSustitucion());
					jugadorLista.getGolesAnotadosJornada().add(numJornada-1, jugadorResultado.getGolesAnotados());
					jugadorLista.getAutogolesJornada().add(numJornada-1, jugadorResultado.getAutogoles());
					jugadorLista.getAsistenciasJornada().add(numJornada-1, jugadorResultado.getAsistencias());
					jugadorLista.getPenaltisErradosJornada().add(numJornada-1, jugadorResultado.getPenaltisErrados());
					jugadorLista.getAmarillasJornada().add(numJornada-1, jugadorResultado.getAmarillas());
					jugadorLista.getRojasJornada().add(numJornada-1, jugadorResultado.getRojas());
					if(jugadorResultado.getPosicion().equals("arquero")) {
						Arquero arqueroResultado = (Arquero)jugadorResultado;
						Arquero arqueroLista = (Arquero)jugadorLista;
						arqueroLista.getGolesRecibidosJornada().add(numJornada-1, arqueroResultado.getGolesRecibidos());
						arqueroLista.getPenaltisAtajadosJornada().add(numJornada-1, arqueroResultado.getPenaltisAtajados());
						
					}
					if(jugadorResultado.getPosicion().equals("defensa")) {
						Defensa defensaResultado = (Defensa)jugadorResultado;
						Defensa defensaLista = (Defensa)jugadorLista;
						defensaLista.getGolesRecibidosJornada().add(numJornada-1, defensaResultado.getGolesRecibidos());
					}
				}
			} 
		}
		for (int i = 0; i<datosPartido.getEquipoVisitante().getJugadores().size();i++) {
			jugadorResultado = datosPartido.getEquipoVisitante().getJugadores().get(i);
			for (int j = 0; j<this.temporadaActual.getJugadores().size();j++) {
				jugadorLista = this.temporadaActual.getJugadores().get(j);
				if(jugadorLista.getNombre().equals(jugadorResultado.getNombre())&&jugadorLista.getPosicion().equals(jugadorResultado.getPosicion())) {
					jugadorLista.getMinutosJugadosJornada().add(numJornada-1, jugadorResultado.getMinutosJugados());
					jugadorLista.getMinutoInicioJornada().add(numJornada-1, jugadorResultado.getMinutoInicio());
					jugadorLista.getMinutoSustitucionJornada().add(numJornada-1, jugadorResultado.getMinutoSustitucion());
					jugadorLista.getGolesAnotadosJornada().add(numJornada-1, jugadorResultado.getGolesAnotados());
					jugadorLista.getAutogolesJornada().add(numJornada-1, jugadorResultado.getAutogoles());
					jugadorLista.getAsistenciasJornada().add(numJornada-1, jugadorResultado.getAsistencias());
					jugadorLista.getPenaltisErradosJornada().add(numJornada-1, jugadorResultado.getPenaltisErrados());
					jugadorLista.getAmarillasJornada().add(numJornada-1, jugadorResultado.getAmarillas());
					jugadorLista.getRojasJornada().add(numJornada-1, jugadorResultado.getRojas());
					if(jugadorResultado.getPosicion().equals("arquero")) {
						Arquero arqueroResultado = (Arquero)jugadorResultado;
						Arquero arqueroLista = (Arquero)jugadorLista;
						arqueroLista.getGolesRecibidosJornada().add(numJornada-1, arqueroResultado.getGolesRecibidos());
						arqueroLista.getPenaltisAtajadosJornada().add(numJornada-1, arqueroResultado.getPenaltisAtajados());
						
					}
					if(jugadorResultado.getPosicion().equals("defensa")) {
						Defensa defensaResultado = (Defensa)jugadorResultado;
						Defensa defensaLista = (Defensa)jugadorLista;
						defensaLista.getGolesRecibidosJornada().add(numJornada-1, defensaResultado.getGolesRecibidos());
					}
				}
			} 
		}
		Jornada jornada = new Jornada();
		Partido partido = new Partido();
		for(int i = 0; i<this.temporadaActual.getJornadas().size();i++) {
			jornada = temporadaActual.getJornadas().get(i);
			if (jornada.getNumeroJornada()==numJornada) {
				for (int j = 0; j<jornada.getPartidos().size();j++) {
					partido = jornada.getPartidos().get(j);
					if(partido.getEquipoLocal().getNombre().equals(datosPartido.getEquipoLocal().getNombre())&&partido.getEquipoVisitante().getNombre().equals(datosPartido.getEquipoVisitante().getNombre())) {
						partido.setGolesLocal(datosPartido.getGolesLocal());
						partido.setGolesVisitante(datosPartido.getGolesVisitante());
						break;
					}
				}
				break;
			}
		}
		partido.actualizarResultadoPartido(numJornada);
		actualizarPuntosEquipos(numJornada);
		actualizarRankingEquiposJornada(numJornada);
		actualizarRankingJugadoresJornada(numJornada);
		actualizarRankingEquipos();
		actualizarRankingJugadores();
		
		loader.guardarJornadas(this.temporadaActual.getJornadas());
		loader.guardarJugadores(this.temporadaActual.getJugadores());
		loader.guardarParticipantes(this.participantes);
		
		return 0;
	}
	public void actualizarPuntosEquipos(int numJornada) {
		ArrayList<EquipoFantasia> equipos = crearArrayEquipos();
		EquipoFantasia equipo = new EquipoFantasia();
		for (int i = 0; i < equipos.size();i++) {
			equipo = equipos.get(i);
			if (equipo!=null) {
				equipo.actualizarPuntosJornada(numJornada);
			}
		}
	}
	public void actualizarRankingEquiposJornada(int numJornada) {
		ArrayList<EquipoFantasia> equipos = crearArrayEquipos();
		Jornada jornada = new Jornada();
		for (int j = 0; j <this.temporadaActual.getJornadas().size();j++) {
			if (this.temporadaActual.getJornadas().get(j).getNumeroJornada()==numJornada) {
				jornada = this.temporadaActual.getJornadas().get(j);
				jornada.setRankingEquiposFantasia(equipos);
				break;
			}
		}
	}
	public void actualizarRankingJugadoresJornada(int numJornada) {
		Jornada jornada = new Jornada();
		for (int j = 0; j <this.temporadaActual.getJornadas().size();j++) {
			if (this.temporadaActual.getJornadas().get(j).getNumeroJornada()==numJornada) {
				jornada = this.temporadaActual.getJornadas().get(j);
				jornada.setRankingJugadores(this.temporadaActual.getJugadores());
				break;
			}
		}
	}
	public void actualizarRankingEquipos() {
		ArrayList<EquipoFantasia> equipos = crearArrayEquipos();
		this.temporadaActual.setRankingEquiposFantasia(equipos);
	}
	public void actualizarRankingJugadores() {
		this.temporadaActual.setRankingJugadores();
	}
	public ArrayList<EquipoFantasia> crearArrayEquipos(){
		ArrayList<EquipoFantasia> equipos = new ArrayList<EquipoFantasia>();
		EquipoFantasia equipo = new EquipoFantasia();
		for (int i = 0; i<this.participantes.size();i++) {
			equipo = this.participantes.get(i).getEquipo();
			equipos.add(equipo);
		}
		return equipos;
	}
	/*
	 * public ArrayList<EquipoReal> crearArrayEquiposReales(){
	 * ArrayList<EquipoFantasia> equipos = new ArrayList<EquipoFantasia>();
	 * EquipoFantasia equipo = new EquipoFantasia(); for (int i = 0;
	 * i<this.participantes.size();i++) { equipo =
	 * this.participantes.get(i).getEquipo(); equipos.add(equipo); } return equipos;
	 * }
	 */
	public void cambiarCapitan(int nuevoCapitan) {
		((Participante)this.usuarioActivo).cambiarCapitan(nuevoCapitan);
	}
	public int encontrarPosicion() {
		return this.temporadaActual.getRankingEquiposFantasia().indexOf(((Participante)usuarioActivo).getEquipo());
		
	}
	public int crearEquipoV2(ArrayList<Jugador> equipo, String nombre) {
		boolean modificar = permitirModificar();
		int resp = 12;
		if(modificar) {
			resp = 10;
			if (!(nombre.equals(""))&& nombre!=null) {
				resp = 9;
				if (equipo != null && equipo.size() == 15) {
					resp = ((Participante)this.usuarioActivo).crearEquipo(equipo, nombre, this.temporadaActual.getJornadas().size());
					if (resp == 0) {
						this.loader.guardarParticipantes(participantes);
						EquipoFantasia equipoCreado = ((Participante)this.usuarioActivo).getEquipo();
						this.temporadaActual.getRankingEquiposFantasia().add(equipoCreado);
					}
				}
			}
		}
		return resp;
	}
	public int cambiarAlineacionV2(ArrayList<String> jugadoresCambiar) {
		int resp = 4;
		boolean modificar = permitirModificar();
		if(modificar) {
			resp = ((Participante)this.getUsuarioActivo()).modificarAlineacionV2(jugadoresCambiar);
		}
		if (resp == 0&&((Participante)this.getUsuarioActivo()).getEquipo().getJugadores().size()==15) {
			this.loader.guardarParticipantes(participantes);
		}
		return resp;
	}
	public int cambiarCapitanV2(ArrayList<String> seleccion) {
		int resp =3;
		boolean modificar = permitirModificar();
		if(modificar) {
			resp = ((Participante)this.getUsuarioActivo()).cambiarCapitanV2(seleccion);
		}
		if (resp == 0&&((Participante)this.getUsuarioActivo()).getEquipo().getJugadores().size()==15) {
			this.loader.guardarParticipantes(participantes);
		}
		return resp;
	}
	public int venderJugadorV2(ArrayList<String>seleccion) {
		int resp = 4;
		boolean modificar = permitirModificar();
		if(modificar) {
			resp = ((Participante)this.usuarioActivo).venderJugadorV2(seleccion);
		}
		return resp;
	}
	public int comprarJugadorV2(ArrayList<Jugador> jugadoresComprar) {
		int resp = 9;
		if(jugadoresComprar.size()==1) {
			resp = 8;
			boolean modificar = permitirModificar();
			if (modificar) {
				resp = ((Participante)this.getUsuarioActivo()).comprarJugador(jugadoresComprar.get(0));	
				if(resp == 0) {
					((Participante)this.getUsuarioActivo()).getEquipo().getSuplentes().add(jugadoresComprar.get(0));
					loader.guardarParticipantes(participantes);
				}
			}
		}
		return resp;
	}
	public void organizarJugadoresEquipo() {
		((Participante)this.usuarioActivo).organizarJugadores();
		
	}
	
}
