package modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Delantero extends Jugador{

	public double calcularPuntaje(int numJornada) {
		this.puntosJornada.add(numJornada-1, (double) 0);


		this.puntosJornada.add(numJornada-1, 5 * (double) this.golesAnotadosJornada.get(numJornada-1));
		this.puntosJornada.add(numJornada-1, 3 * (double) this.asistenciasJornada.get(numJornada-1));
		this.puntosJornada.add(numJornada-1, -2 * (double) this.penaltisErradosJornada.get(numJornada-1));
		this.puntosJornada.add(numJornada-1, -1 * (double) this.amarillasJornada.get(numJornada-1));
		this.puntosJornada.add(numJornada-1, -3 * (double) this.rojasJornada.get(numJornada-1));
		this.puntosJornada.add(numJornada-1, -2 * (double) this.autogolesJornada.get(numJornada-1));

		if(this.minutosJugadosJornada.get(numJornada-1) > 1 && this.minutosJugadosJornada.get(numJornada-1) <= 60) {
			this.puntosJornada.add(numJornada-1, (double) 1);
		}
		if(this.minutosJugadosJornada.get(numJornada-1) > 60) {
			this.puntosJornada.add(numJornada-1, (double) 2);
		}
		
		this.actualizarPuntosTotales();
		return this.puntosTotales;
	}
	
}
