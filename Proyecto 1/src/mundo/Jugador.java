package mundo;

import java.sql.Time;

public abstract class Jugador {

	private String nombre;
	private String posicion;
	private double precio;
	private double puntos;
	private Time minutosJugados;
	private Time minutoInicio;
	private Time minutoSustitucion;
	private int golesAnotados;
	private int autogoles;
	private int asistencias;
	private int penaltisErrados;
	private int amarillas;
	private int rojas;
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
	public double getPuntos() {
		return puntos;
	}
	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}
	public Time getMinutosJugados() {
		return minutosJugados;
	}
	public void setMinutosJugados(Time minutosJugados) {
		this.minutosJugados = minutosJugados;
	}
	public Time getMinutoInicio() {
		return minutoInicio;
	}
	public void setMinutoInicio(Time minutoInicio) {
		this.minutoInicio = minutoInicio;
	}
	public Time getMinutoSustitucion() {
		return minutoSustitucion;
	}
	public void setMinutoSustitucion(Time minutoSustitucion) {
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
	
	

}
