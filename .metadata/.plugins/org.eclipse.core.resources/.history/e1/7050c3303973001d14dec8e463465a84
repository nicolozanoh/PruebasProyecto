package modelo;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "posicion",
	    visible = true)
	@JsonSubTypes({
	    @Type(value = Arquero.class, name = "arquero"),
	    @Type(value = Defensa.class, name = "defensa"),
	    @Type(value = Mediocampista.class, name = "mediocampista"),
	    @Type(value = Delantero.class, name = "delantero")})
public abstract class Jugador {
	protected String nombre;
	protected String posicion;
	protected String nombreEquipo;
	protected double precio;
	protected double puntosTotales;
	protected ArrayList<Double> puntosJornada;
	protected int minutosJugados;
	protected int minutoInicio;
	protected int minutoSustitucion;
	protected int golesAnotados;
	protected int autogoles;
	protected int asistencias;
	protected int penaltisErrados;
	protected int amarillas;
	protected int rojas;
	protected ArrayList<Integer> minutosJugadosJornada;
	protected ArrayList<Integer> minutoInicioJornada;
	protected ArrayList<Integer> minutoSustitucionJornada;
	protected ArrayList<Integer> golesAnotadosJornada;
	protected ArrayList<Integer> autogolesJornada;
	protected ArrayList<Integer> asistenciasJornada;
	protected ArrayList<Integer> penaltisErradosJornada;
	protected ArrayList<Integer> amarillasJornada;
	protected ArrayList<Integer> rojasJornada;
	public Jugador() {
		minutosJugadosJornada = new ArrayList<Integer>();
		minutoInicioJornada= new ArrayList<Integer>();
		minutoSustitucionJornada= new ArrayList<Integer>();
		golesAnotadosJornada= new ArrayList<Integer>();
		autogolesJornada= new ArrayList<Integer>();
		asistenciasJornada= new ArrayList<Integer>();
		penaltisErradosJornada= new ArrayList<Integer>();
		amarillasJornada= new ArrayList<Integer>();
		rojasJornada= new ArrayList<Integer>();
		puntosJornada = new ArrayList<Double>();
	}
	public Jugador(String nombre, String posicion) {
		this.nombre = nombre;
		this.posicion = posicion;
	}
	public ArrayList<Integer> getMinutosJugadosJornada() {
		return minutosJugadosJornada;
	}
	public void setMinutosJugadosJornada(ArrayList<Integer> minutosJugadosJornada) {
		this.minutosJugadosJornada = minutosJugadosJornada;
	}
	public ArrayList<Integer> getMinutoInicioJornada() {
		return minutoInicioJornada;
	}
	public void setMinutoInicioJornada(ArrayList<Integer> minutoInicioJornada) {
		this.minutoInicioJornada = minutoInicioJornada;
	}
	public ArrayList<Integer> getMinutoSustitucionJornada() {
		return minutoSustitucionJornada;
	}
	public void setMinutoSustitucionJornada(ArrayList<Integer> minutoSustitucionJornada) {
		this.minutoSustitucionJornada = minutoSustitucionJornada;
	}
	public ArrayList<Integer> getGolesAnotadosJornada() {
		return golesAnotadosJornada;
	}
	public void setGolesAnotadosJornada(ArrayList<Integer> golesAnotadosJornada) {
		this.golesAnotadosJornada = golesAnotadosJornada;
	}
	public ArrayList<Integer> getAutogolesJornada() {
		return autogolesJornada;
	}
	public void setAutogolesJornada(ArrayList<Integer> autogolesJornada) {
		this.autogolesJornada = autogolesJornada;
	}
	public ArrayList<Integer> getAsistenciasJornada() {
		return asistenciasJornada;
	}
	public void setAsistenciasJornada(ArrayList<Integer> asistenciasJornada) {
		this.asistenciasJornada = asistenciasJornada;
	}
	public ArrayList<Integer> getPenaltisErradosJornada() {
		return penaltisErradosJornada;
	}
	public void setPenaltisErradosJornada(ArrayList<Integer> penaltisErradosJornada) {
		this.penaltisErradosJornada = penaltisErradosJornada;
	}
	public ArrayList<Integer> getAmarillasJornada() {
		return amarillasJornada;
	}
	public void setAmarillasJornada(ArrayList<Integer> amarillasJornada) {
		this.amarillasJornada = amarillasJornada;
	}
	public ArrayList<Integer> getRojasJornada() {
		return rojasJornada;
	}
	public void setRojasJornada(ArrayList<Integer> rojasJornada) {
		this.rojasJornada = rojasJornada;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPuntosTotales() {
		return puntosTotales;
	}
	public void actualizarPuntosTotales() {
		this.puntosTotales=0;
		for (Double d: puntosJornada) {
			this.puntosTotales+=d;
		}
	}
	public int getMinutosJugados() {
		return minutosJugados;
	}
	public void setMinutosJugados() {
		this.minutosJugados = 0;
		for (int d: minutosJugadosJornada) {
			this.minutosJugados+=d;
		}
	}
	public int getMinutoInicio() {
		return minutoInicio;
	}
	public void setMinutoInicio() {
		this.minutoInicio = 0;
		for (int d: minutoInicioJornada) {
			this.minutoInicio+=d;
		}
	}
	public int getMinutoSustitucion() {
		return minutoSustitucion;
	}
	public void setMinutoSustitucion() {
		this.minutoSustitucion = 0;
		for (int d: minutoSustitucionJornada) {
			this.minutoSustitucion+=d;
		}
	}
	public int getGolesAnotados() {
		return golesAnotados;
	}
	public void setGolesAnotados() {
		this.golesAnotados = 0;
		for (int d: golesAnotadosJornada) {
			this.golesAnotados+=d;
		}
	}
	public int getAutogoles() {
		return autogoles;
	}
	public void setAutogoles() {
		this.autogoles = 0;
		for (int d: autogolesJornada) {
			this.autogoles+=d;
		}
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias() {
		this.asistencias = 0;
		for (int d: asistenciasJornada) {
			this.asistencias+=d;
		}
	}
	public int getPenaltisErrados() {
		return penaltisErrados;
	}
	public void setPenaltisErrados() {
		this.penaltisErrados = 0;
		for (int d: penaltisErradosJornada) {
			this.penaltisErrados+=d;
		}
	}
	public int getAmarillas() {
		return amarillas;
	}
	public void setAmarillas() {
		this.amarillas = 0;
		for (int d: amarillasJornada) {
			this.amarillas+=d;
		}
	}
	public int getRojas() {
		return rojas;
	}
	public void setRojas() {
		this.rojas = 0;
		for (int d: rojasJornada) {
			this.rojas+=d;
		}
	}
	public ArrayList<Double> getPuntosJornada() {
		return puntosJornada;
	}
	public void setPuntosJornada(ArrayList<Double> puntosJornada) {
		this.puntosJornada = puntosJornada;
	}
	public void actualizarPuntosJornada(int numJornada, double puntos) {
		if(minutosJugadosJornada==null) {
			minutosJugadosJornada = new ArrayList<Integer>();
		}
		if(minutoInicioJornada==null) {
			minutoInicioJornada= new ArrayList<Integer>();
		}
		if(minutoSustitucionJornada==null) {
			minutoSustitucionJornada= new ArrayList<Integer>();
		}
		if(golesAnotadosJornada==null) {
			golesAnotadosJornada= new ArrayList<Integer>();
		}
		if(autogolesJornada==null) {
			autogolesJornada= new ArrayList<Integer>();
		}
		if(asistenciasJornada==null) {
			asistenciasJornada= new ArrayList<Integer>();
		}
		if(penaltisErradosJornada==null) {
			penaltisErradosJornada= new ArrayList<Integer>();
		}
		if(amarillasJornada==null) {
			amarillasJornada= new ArrayList<Integer>();
		}
		if(rojasJornada==null) {
			rojasJornada= new ArrayList<Integer>();
		}
		calcularPuntaje(numJornada);
		
	}
	public String getNombreEquipo() {
		return this.nombreEquipo;
	}
	public void iniciarPuntosJornada(int numJornadas) {
		for (int i = 0; i<numJornadas;i++) {
			this.puntosJornada.add(0.00);
		}
	}
	public String toString() {
		return this.nombre + ", "+this.posicion +", " + Double.toString(this.precio);
	}
	public String puntosJornadaToString() {
		String puntosJornada = Double.toString(this.puntosJornada.get(0));
		for(int i = 1; i<this.puntosJornada.size();i++) {
			puntosJornada += ", " +Double.toString(this.puntosJornada.get(i));
		}
		return puntosJornada;
	}
	abstract public double calcularPuntaje(int numJornada);
}
