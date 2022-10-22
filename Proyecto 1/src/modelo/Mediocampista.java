package modelo;

public class Mediocampista extends Jugador{
	@Override
	public double calcularPuntaje(int numJornada) {
		double puntos = 0;
		puntos += 5 * (double) this.golesAnotadosJornada.get(numJornada-1);
		puntos += 3 * (double) this.asistenciasJornada.get(numJornada-1);
		puntos += -2 * (double) this.penaltisErradosJornada.get(numJornada-1);
		puntos += -1 * (double) this.amarillasJornada.get(numJornada-1);
		puntos += -3 * (double) this.rojasJornada.get(numJornada-1);
		puntos += -2 * (double) this.autogolesJornada.get(numJornada-1);
		if(this.minutosJugadosJornada.get(numJornada-1) > 1 && this.minutosJugadosJornada.get(numJornada-1) <= 60) {
			puntos+=1;
		}
		if(this.minutosJugadosJornada.get(numJornada-1) > 60) {
			puntos+= 2;
		}
		this.puntosJornada.add(numJornada-1, puntos);
		this.actualizarPuntosTotales();
		return this.puntosTotales;
	}
}
