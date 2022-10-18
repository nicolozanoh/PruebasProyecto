package modelo;

import java.util.ArrayList;

public class EquipoFantasia {

	private String nombre;
	private double puntosTotales;
	private double precio;
	private double numeroJugadores;
	private Jugador capitan;
	private ArrayList<Double> puntosJornada;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Jugador> titulares;
	private ArrayList<Jugador> suplentes;
	public EquipoFantasia(){
		this.jugadores = new ArrayList<Jugador>();
		this.titulares = new ArrayList<Jugador>();
		this.suplentes = new ArrayList<Jugador>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPuntosTotales() {
		return puntosTotales;
	}
	public double getNumeroJugadores() {
		return numeroJugadores;
	}
	public void setPuntosTotales(double puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Jugador getCapitan() {
		return capitan;
	}
	public void setCapitan(Jugador capitan) {
		this.capitan = capitan;
	}
	public ArrayList<Double> getPuntosJornada() {
		return puntosJornada;
	}
	public void actualizarPuntosJornada() {
		double puntos=0;
		for (Jugador j: titulares) {
			if (j==capitan) {
				puntos= puntos + (j.getPuntosJornada().get(-1))*2;
			}	
			else {
				puntos+=j.getPuntosJornada().get(-1);
			}
		}
		
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public ArrayList<Jugador> getTitulares() {
		return titulares;
	}
	public void setTitulares(ArrayList<Jugador> titulares) {
		this.titulares = titulares;
	}
	public ArrayList<Jugador> getSuplentes() {
		return suplentes;
	}
	public void setSuplentes(ArrayList<Jugador> suplentes) {
		this.suplentes = suplentes;
	}
	public void quitarJugador (Jugador jugador) {
		jugadores.remove(jugador);
	}
	public int agregarJugador (Jugador jugador) {
		int respuesta=1;
		if (jugadores.size()<15) {
			String posicion = jugador.getPosicion();
			int contador = 0;
			int maximo =0;
			for (int i=0; i<jugadores.size(); i++) {
				String posicionComparar = jugadores.get(i).getPosicion();
				if (posicionComparar==posicion) { 
					contador++;
				}
			}
			if (posicion=="arquero") {
				maximo=2;
				respuesta = 2;
				}
			else if (posicion=="defensa") {
				maximo=5;
				respuesta = 3;
			}
			else if (posicion=="mediocampista") {
				maximo=5;
				respuesta = 4;
			}
			else if (posicion=="delantero") {
				maximo=3;
				respuesta = 5;
			}	
			if (maximo>=contador) {
				jugadores.add(jugador);
				respuesta=0;
			}	
			else
				respuesta=2;
		}
		return respuesta;
	}

	public String cambiarAlineacion(Jugador nuevoTitular, Jugador nuevoSuplente) {
		String respuesta = "No se puede hacerel cambio porque los jugadores no tienen la misma posicion.";
		if (nuevoTitular.getPosicion()== nuevoSuplente.getPosicion()) {
			titulares.add(nuevoTitular);
			titulares.remove(nuevoSuplente);
			suplentes.add(nuevoTitular);
			suplentes.remove(nuevoSuplente);
			respuesta="El cambio se realozo exitosamente.";
		}
		return respuesta;
	}
	
	public void seleccionarAlineacionDefault() {
		ArrayList<Jugador> copiaJugadores = new ArrayList<Jugador>(this.jugadores);
		int defensas = 0;
		int arqueros= 0;
		int mediocampistas = 0;
		int delanteros = 0;
		
		for (int i = 0; i<copiaJugadores.size();i++) {
			if(copiaJugadores.get(i).getPosicion() == "defensa" && defensas <4) {
				this.titulares.add(copiaJugadores.get(i));
				defensas++;
				copiaJugadores.remove(i);
			}
			if(copiaJugadores.get(i).getPosicion() == "arquero" && arqueros <1) {
				this.titulares.add(copiaJugadores.get(i));
				arqueros++;
				copiaJugadores.remove(i);
			}
			if(copiaJugadores.get(i).getPosicion() == "arquero" && mediocampistas <4) {
				this.titulares.add(copiaJugadores.get(i));
				mediocampistas++;
				copiaJugadores.remove(i);
			}
			if(copiaJugadores.get(i).getPosicion() == "delantero" && delanteros <1) {
				this.titulares.add(copiaJugadores.get(i));
				delanteros++;
				copiaJugadores.remove(i);
			}
		}
		
		this.suplentes = copiaJugadores;
	}
	
}
