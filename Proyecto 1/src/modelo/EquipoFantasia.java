package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class EquipoFantasia {
	private String nombre;
	private double puntosTotales;
	private Jugador capitan;
	private ArrayList<Double> puntosJornada;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Jugador> titulares;
	private ArrayList<Jugador> suplentes;
	public EquipoFantasia(){
		this.jugadores = new ArrayList<Jugador>();
		this.titulares = new ArrayList<Jugador>();
		this.suplentes = new ArrayList<Jugador>();
		this.puntosJornada = new ArrayList<>();
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
	public void setPuntosTotales(double puntosTotales) {
		this.puntosTotales = puntosTotales;
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
	public void actualizarPuntosJornada(int numJornada) {
		double puntos=0;
		for (Jugador j: titulares) {
			if (j==capitan) {
				puntos= puntos + (j.getPuntosJornada().get(numJornada-1))*2;
			}	
			else {
				puntos+=j.getPuntosJornada().get(numJornada-1);
			}
		}
		this.puntosTotales += puntos;
		this.puntosJornada.set(numJornada-1, puntos);
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
	public int quitarJugador (int numJugador) {
		int resp = 2;
		if (this.jugadores.size()== 15) {
			Jugador jugador = this.jugadores.get(numJugador-1);
			if (titulares.contains(jugador)) {
				titulares.remove(jugador);
				for (int i =0; i<suplentes.size();i++) {
					if (jugador.getPosicion().equals((suplentes.get(i).getPosicion()))) {
						titulares.add(suplentes.get(i));
						suplentes.remove(i);
						break;
					}
				}
			}
			else if (suplentes.contains(jugador))
			{
				suplentes.remove(jugador);
			}
			jugadores.remove(jugador);
			resp = 0;
		}
		return resp;
	}
	public int agregarJugador (Jugador jugador) {
		int respuesta=0;
		if (jugadores.size()<15) {
			String posicion = jugador.getPosicion();
			int contador = 0;
			int maximo =0;
			for (int i=0; i<jugadores.size(); i++) {
				String posicionComparar = jugadores.get(i).getPosicion();
				if (posicionComparar.equals(posicion)) { 
					if(jugador.getNombre().equals(jugadores.get(i).getNombre())) {
						respuesta = 11;
					}
					contador++;
				}
			}
			if (respuesta != 11) {
				if (posicion.equals("arquero")) {
					maximo=2;
					respuesta = 2;
					}
				else if (posicion.equals("defensa")) {
					maximo=5;
					respuesta = 3;
				}
				else if (posicion.equals("mediocampista")) {
					maximo=5;
					respuesta = 4;
				}
				else if (posicion.equals("delantero")) {
					maximo=3;
					respuesta = 5;
				}	
				if (maximo>contador) {
					jugadores.add(jugador);
					respuesta = 0;
				}
			}
		}
		return respuesta;
	}
	public int cambiarAlineacion(int nuevoTitular, int nuevoSuplente) {
		int resp = 1;
		try {
			Jugador jugadorTitular = this.suplentes.get(nuevoTitular - 1);
			Jugador jugadorSuplente = this.titulares.get(nuevoSuplente -1);
			if (jugadorTitular.getPosicion().equals(jugadorSuplente.getPosicion())) {
				titulares.add(jugadorTitular);
				titulares.remove(jugadorSuplente);
				suplentes.add(jugadorSuplente);
				suplentes.remove(jugadorTitular);
				resp = 0;
			}
		}catch(Exception ex) {
			resp = 2;
		}
		return resp;
	}
	public void seleccionarAlineacionDefault() {
		ArrayList<Jugador> copiaJugadores = new ArrayList<Jugador>(this.jugadores);
		int defensas = 0;
		int arqueros= 0;
		int mediocampistas = 0;
		int delanteros = 0;
		
		for (int i = 0; i<copiaJugadores.size();i++) {
			if(copiaJugadores.get(i).getPosicion().equals("defensa") && defensas <4) {
				this.titulares.add(copiaJugadores.get(i));
				defensas++;
				copiaJugadores.set(i, null);
			}
			else if(copiaJugadores.get(i).getPosicion().equals("arquero") && arqueros <1) {
				this.titulares.add(copiaJugadores.get(i));
				arqueros++;
				copiaJugadores.set(i, null);
			}
			else if(copiaJugadores.get(i).getPosicion().equals("mediocampista") && mediocampistas <4) {
				this.titulares.add(copiaJugadores.get(i));
				mediocampistas++;
				copiaJugadores.set(i, null);
			}
			else if(copiaJugadores.get(i).getPosicion().equals("delantero") && delanteros <2) {
				this.titulares.add(copiaJugadores.get(i));
				delanteros++;
				copiaJugadores.set(i, null);
			}
		}
		for (int i = 0; i<copiaJugadores.size();i++) {
			if (copiaJugadores.get(i)!= null) {
				this.suplentes.add(copiaJugadores.get(i));
			}
		}
		this.capitan = this.titulares.get(0);
	}
	public void iniciarPuntosJornada(int numJornada) {
		for (int i = 0; i<numJornada;i++) {
			this.puntosJornada.add(0.00);
		}
	}
	public void cambiarEquipo(int nuevoCapitan) {
		this.capitan = this.titulares.get(nuevoCapitan-1);
		
	}
	public int cambiarAlineacionV2(ArrayList<String> jugadoresCambiar) {
		int resp = 1;
		Jugador nuevoSuplente = this.titulares.get(0);
		Jugador nuevoTitular=this.titulares.get(0);
		
		if(jugadoresCambiar.size()==2) {
			String nombre1=((jugadoresCambiar.get(0).split(","))[0]).trim();
			String posicion1=((jugadoresCambiar.get(0).split(","))[1]).trim();
			String nombre2=((jugadoresCambiar.get(1).split(","))[0]).trim();
			String posicion2=((jugadoresCambiar.get(1).split(","))[1]).trim();
			resp = 2;
			if (posicion1.equals(posicion2)) {
				resp =3;
				int coincidenciasTitular = 0;
				int coincidenciasSuplentes = 0;
				for (int i = 0 ; i < this.titulares.size(); i++) {
					if (this.titulares.get(i).getNombre().equals(nombre1)) {
						coincidenciasTitular +=1;
						nuevoSuplente = this.titulares.get(i);
					}
					if (this.titulares.get(i).getNombre().equals(nombre2)) {
						coincidenciasTitular +=1;
						nuevoSuplente = this.titulares.get(i);
					}
				}
				for (int i = 0 ; i < this.suplentes.size(); i++) {
					if (this.suplentes.get(i).getNombre().equals(nombre1)) {
						coincidenciasSuplentes +=1;
						nuevoTitular = this.suplentes.get(i);
					}
					if (this.suplentes.get(i).getNombre().equals(nombre2)) {
						coincidenciasSuplentes +=1;
						nuevoTitular = this.suplentes.get(i);
					}
				}
				if (coincidenciasTitular == 1&&coincidenciasSuplentes == 1) {
					resp = 0;
					titulares.add(nuevoTitular);
					titulares.remove(nuevoSuplente);
					
					suplentes.add(nuevoSuplente);
					suplentes.remove(nuevoTitular);
				}
			}
		}
		return resp;
	}
	public int cambiarCapitanV2(ArrayList<String> nuevoCapitan) {
		int resp = 1;
		if(nuevoCapitan.size() == 1) {
			resp = 2;
			String nombre=((nuevoCapitan.get(0).split(","))[0]).trim();
			//String posicion=((nuevoCapitan.get(0).split(","))[1]).trim();
			int coincidencias = 0;
			for(int i = 0; i<this.titulares.size();i++) {
				if (nombre.equals(this.titulares.get(i).getNombre())) {
					this.capitan = this.titulares.get(i);
					coincidencias +=1;
				}
			}
			if(coincidencias == 1) {
				resp = 0;
			}
		}
		return resp;
	}
	public int quitarJugadorV2(ArrayList<String> seleccion) {
		int resp = 1;
		Jugador jugadorVender = null;
		if (this.jugadores.size()== 15) {
			if(seleccion.size() == 1) {
				resp = 2;
				String nombre=((seleccion.get(0).split(","))[0]).trim();
				String posicion=((seleccion.get(0).split(","))[1]).trim();
				int coincidencias = 0;
				for (int i = 0; i<jugadores.size(); i ++) {
					if(jugadores.get(i).getNombre().equals(nombre)&&jugadores.get(i).getPosicion().equals(posicion)) {
						coincidencias += 1;
						jugadorVender = jugadores.get(i);
					}
				}
				if (coincidencias == 1) {
					resp = 3;
					if (titulares.contains(jugadorVender)) {
						titulares.remove(jugadorVender);
						for (int i =0; i<suplentes.size();i++) {
							if (jugadorVender.getPosicion().equals((suplentes.get(i).getPosicion()))) {
								titulares.add(suplentes.get(i));
								suplentes.remove(i);
								break;
							}
						}
					}
					else if (suplentes.contains(jugadorVender))
					{
						suplentes.remove(jugadorVender);
					}
					jugadores.remove(jugadorVender);
					resp = 0;
				}
			}
		}
		return resp;
	}
	public String puntosJornadaToString() {
		String puntosJornada = Double.toString(this.puntosJornada.get(0));
		for(int i = 1; i<this.puntosJornada.size();i++) {
			puntosJornada += ", " +Double.toString(this.puntosJornada.get(i));
		}
		return puntosJornada;
	}
	public void organizarJugadores() {
		ArrayList<Jugador>cJugadores = new ArrayList<Jugador>(this.jugadores);
		cJugadores.removeAll(Collections.singleton(null));
		if(cJugadores.size() == 15) {
			this.jugadores.sort((Jugador a , Jugador b) -> -(Double.compare(a.getPuntosTotales(), b.getPuntosTotales())));
		}
	}
}
