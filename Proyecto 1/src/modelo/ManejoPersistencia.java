package modelo;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			writer.writeValue(Paths.get("data/participantes.json").toFile(), lParticipantes);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void guardarEquipo(EquipoFantasia equipo, String nombreUsuario) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(Paths.get("data/equipos/"+nombreUsuario+".json").toFile(), equipo);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void borrarEquipo(String nombreUsuario) {
		File archivoEquipo = new File("data/equipos/" + nombreUsuario+".json");
		if(archivoEquipo.exists()) {
			archivoEquipo.delete();
		}
	}
	public EquipoFantasia cargarEquipoParticipanteActivo(File archivoEquipo) {
		EquipoFantasia equipoUsuario = new EquipoFantasia();
		try {
			ObjectMapper mapper = new ObjectMapper();
			equipoUsuario = mapper.readValue(archivoEquipo, EquipoFantasia.class);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return equipoUsuario;
	}
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
}
