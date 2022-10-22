package modelo;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

//import modelo.EquipoReal;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;

public class ManejoPersistencia {
	public ArrayList<Participante> cargarParticipantes(File archivoParticipantes){
		ArrayList<Participante> participantes = new ArrayList<Participante>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			participantes =  new ArrayList<>(Arrays.asList(mapper.readValue(archivoParticipantes, Participante[].class)));
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return participantes;
	}
	public Administrador cargarAdministrador(File archivoAdministrador) {
		Administrador administrador = new Administrador();
		try {
			ObjectMapper mapper = new ObjectMapper();
			administrador = mapper.readValue(archivoAdministrador, Administrador.class);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return administrador;
	}
	public ArrayList<Jugador> cargarJugadores(File archivoJugadores) {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			jugadores =  new ArrayList<>(Arrays.asList(mapper.readValue(archivoJugadores, Jugador[].class)));
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return jugadores;
	}
	public void guardarParticipantes(ArrayList<Participante> participantes){
		List<Participante> lParticipantes = participantes;
		try {
			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(Paths.get("data\\usuarios\\participantes.json").toFile(), lParticipantes);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/*
	 * public void guardarEquipo(EquipoFantasia equipo, String nombreUsuario) { try
	 * { ObjectMapper mapper = new ObjectMapper(); ObjectWriter writer =
	 * mapper.writer(new DefaultPrettyPrinter());
	 * writer.writeValue(Paths.get("data\\equipos\\"+nombreUsuario+".json").toFile()
	 * , equipo); } catch(Exception ex) { System.out.println(ex.getMessage()); } }
	 */
	public void borrarEquipo(String nombreUsuario) {
		File archivoEquipo = new File("data\\equipos\\" + nombreUsuario+".json");
		if(archivoEquipo.exists()) {
			archivoEquipo.delete();
		}
	}/*
		 * public EquipoFantasia cargarEquipoParticipanteActivo(File archivoEquipo) {
		 * EquipoFantasia equipoUsuario = new EquipoFantasia(); try { ObjectMapper
		 * mapper = new ObjectMapper(); equipoUsuario = mapper.readValue(archivoEquipo,
		 * EquipoFantasia.class); } catch(Exception ex) {
		 * System.out.println(ex.getMessage()); }
		 * 
		 * return equipoUsuario; }
		 */
	public ArrayList<Partido> cargarPartidos(File archivoPartidos) {
		ArrayList<Partido> partidos = new ArrayList<Partido>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			partidos =  new ArrayList<>(Arrays.asList(mapper.readValue(archivoPartidos, Partido[].class)));
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return partidos;
	}
	public ArrayList<EquipoReal> llenarEquiposReales(ArrayList<Jugador> jugadores) {
		ArrayList<EquipoReal> equipos = new ArrayList<EquipoReal>();
		for (int i = 0; i<jugadores.size();i++) {
			int coincidio = 0;
			for (int j = 0; j< equipos.size();j++) {
				if (jugadores.get(i).getNombreEquipo().equals(equipos.get(j).getNombre())) {
					coincidio ++;
					equipos.get(j).getJugadores().add(jugadores.get(i));
				}
			}
			if(coincidio == 0) {
				EquipoReal nuevoEquipo = new EquipoReal();
				nuevoEquipo.getJugadores().add(jugadores.get(i));
				nuevoEquipo.setNombre(jugadores.get(i).getNombreEquipo());
				equipos.add(nuevoEquipo);
			}
		}
		return equipos;
	}
	public ArrayList<Partido> llenarJugadoresPartidos(ArrayList<Partido> partidos, ArrayList<EquipoReal> equipos){
		for (int i = 0; i< equipos.size(); i++) {
			for (int j = 0; j<partidos.size(); j++) {
				if (partidos.get(j).getEquipoLocal().getNombre().equals(equipos.get(i).getNombre())) {
					partidos.get(j).setEquipoLocal(equipos.get(i));
				}
				if (partidos.get(j).getEquipoVisitante().getNombre().equals(equipos.get(i).getNombre())) {
					partidos.get(j).setEquipoVisitante(equipos.get(i));
				}
			}
		}
		return partidos;
	}
	public ArrayList<Jornada> llenarJornadas(ArrayList<Partido> partidos){
		ArrayList<Jornada> jornadas = new ArrayList<Jornada>();
		LocalDateTime fechaPartido;
		for (int i = 0; i < partidos.size(); i++) {
			int coincidio = 0;
			for (int j = 0; j < jornadas.size(); j++) {
				if(partidos.get(i).getNumeroJornada() == jornadas.get(j).getNumeroJornada()) {
					fechaPartido = LocalDateTime.parse(partidos.get(i).getFecha());
					if (LocalDateTime.parse(jornadas.get(j).getFechaPrimerPartido()).isAfter(fechaPartido)) {
						jornadas.get(j).setFechaPrimerPartido(fechaPartido.toString());
					}
					if (LocalDateTime.parse(jornadas.get(j).getFechaUltimoPartido()).isBefore(fechaPartido)) {
						jornadas.get(j).setFechaUltimoPartido(fechaPartido.toString());
					}
					jornadas.get(j).getPartidos().add(partidos.get(i));
					coincidio++;
				}
			}
			if(coincidio == 0) {
				Jornada nuevaJornada = new Jornada();
				nuevaJornada.setNumeroJornada(partidos.get(i).getNumeroJornada());
				nuevaJornada.getPartidos().add(partidos.get(i));
				nuevaJornada.setFechaPrimerPartido(partidos.get(i).getFecha());
				nuevaJornada.setFechaUltimoPartido(partidos.get(i).getFecha());
				jornadas.add(nuevaJornada);
			}
		}
		return jornadas;
	}
	public void guardarJornadas(ArrayList<Jornada> jornadas) {
		List<Jornada> ljornada = jornadas;
		try {
			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(Paths.get("data\\temporada\\jornadas.json").toFile(), ljornada);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void guardarJugadores(ArrayList<Jugador> jugadores) {
		List<Jugador> ljugadores = jugadores;
		try {
			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(Paths.get("data\\temporada\\jugadores.json").toFile(), ljugadores);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public ArrayList<Jornada> cargarJornadas(File archivoJornadas) {
		ArrayList<Jornada> jornadas = new ArrayList<Jornada>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			jornadas =  new ArrayList<>(Arrays.asList(mapper.readValue(archivoJornadas, Jornada[].class)));
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return jornadas;
	}
	public void borrarArchivosTemporada() {
		File archivoJugadores = new File("data\\temporada\\jugadores.json");
		File archivoJornadas = new File("data\\temporada\\jornadas.json");
		if(archivoJugadores.exists()) {
			archivoJugadores.delete();
		}
		if(archivoJornadas.exists()) {
			archivoJornadas.delete();
		}
	}
	public Partido cargarResultadoPartido(File resultadoPartido) {
		Partido partido = new Partido();
		try {
			ObjectMapper mapper = new ObjectMapper();
			partido = mapper.readValue(resultadoPartido, Partido.class);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return partido;
	}
	
}
