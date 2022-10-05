package mundo;

import java.util.ArrayList;

public class EquipoFantasia {

	private String nombre;
	private double puntosTotales;
	private double precio;
	private Jugador capitan;
	private double puntosJornada;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Jugador> titulares;
	private ArrayList<Jugador> suplentes;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPuntosTotales() {
		return puntosTotales;
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
	public double getPuntosJornada() {
		return puntosJornada;
	}
	public void setPuntosJornada(double puntosJornada) {
		this.puntosJornada = puntosJornada;
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
	
	
	
}
