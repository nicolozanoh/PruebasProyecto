package mundo;

public class Mediocampista extends Jugador{

	@Override
	public double calcularPuntaje() {
		this.puntos = 0;
		golesAnotados = this.golesAnotados;
		minutosJugados = this.minutosJugados;
		asistencias= this.asistencias;
		amarillas = this.amarillas;
		rojas = this.rojas;
		penaltisErrados = this.penaltisErrados;
		autogoles = this.autogoles;
		// Debemos poner si el jugador es cápitan del equipo de fantasia o no
		// Debemos tener en cuenta si el equipo del jugador gano el partido o no
		this.puntos = this.puntos + 5 * golesAnotados;
		this.puntos = this.puntos + 3 * asistencias;
		this.puntos = this.puntos + -2 * penaltisErrados;
		this.puntos = this.puntos + -1 * amarillas;
		this.puntos = this.puntos + -3 * rojas;
		this.puntos = this.puntos + -2 * autogoles;
		if(minutosJugados > 1 && minutosJugados <= 60) {
			this.puntos = this.puntos + 1;
		}
		if(minutosJugados > 60) {
			this.puntos = this.puntos + 2;
		}
		
		return this.puntos;
	}
	
}
