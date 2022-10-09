package modelo;

import java.sql.Time;
import java.util.ArrayList;

public abstract class Jugador {

	protected String nombre;
	protected String posicion;
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
	public void setPuntosTotales() {
		this.puntosTotales=0;
		for (Double d: puntosJornada) {
			this.puntosTotales+=d;
		}
	}
	public int getMinutosJugados() {
		return minutosJugados;
	}
	public void setMinutosJugados(int minutosJugados) {
		this.minutosJugados = minutosJugados;
	}
	public int getMinutoInicio() {
		return minutoInicio;
	}
	public void setMinutoInicio(int minutoInicio) {
		this.minutoInicio = minutoInicio;
	}
	public int getMinutoSustitucion() {
		return minutoSustitucion;
	}
	public void setMinutoSustitucion(int minutoSustitucion) {
		this.minutoSustitucion = minutoSustitucion;
	}
	public int getGolesAnotados() {
		return golesAnotados;
	}
	public void setGolesAnotados(int golesAnotados) {
		this.golesAnotados = golesAnotados;
	}
	public int getAutogoles() {
		return autogoles;
	}
	public void setAutogoles(int autogoles) {
		this.autogoles = autogoles;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	public int getPenaltisErrados() {
		return penaltisErrados;
	}
	public void setPenaltisErrados(int penaltisErrados) {
		this.penaltisErrados = penaltisErrados;
	}
	public int getAmarillas() {
		return amarillas;
	}
	public void setAmarillas(int amarillas) {
		this.amarillas = amarillas;
	}
	public int getRojas() {
		return rojas;
	}
	public void setRojas(int rojas) {
		this.rojas = rojas;
	}
	public ArrayList<Double> getPuntosJornada() {
		return puntosJornada;
	}
	public void setPuntosJornada(ArrayList<Double> puntosJornada) {
		this.puntosJornada = puntosJornada;
	}
	
	
	abstract public double calcularPuntaje();
	
}
