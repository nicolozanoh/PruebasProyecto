package mundo;

import java.sql.Time;

public abstract class Jugador {

	private String nombre;
	private String posicion;
	private double precio;
	protected double puntos;
	protected Time minutosJugados;
	private Time minutoInicio;
	private Time minutoSustitucion;
	protected int golesAnotados;
	protected int autogoles;
	protected int asistencias;
	protected int penaltisErrados;
	protected int amarillas;
	protected int rojas;

	abstract public double calcularPuntaje();
	
}
