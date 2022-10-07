package mundo;

import java.util.ArrayList;

public class Aplicacion {

	private ArrayList<Administrador> administrador;
	private ArrayList<Participante> participantes;
	private ArrayList<Temporada> temporadas;
	private String tipoUsuarioActivo;
	
	public String getTipoUsuarioActivo() {
		return tipoUsuarioActivo;
	}
	public void setTipoUsuarioActivo(String tipoUsuarioActivo) {
		this.tipoUsuarioActivo = tipoUsuarioActivo;
	}
	public ArrayList<Administrador> getAdministrador() {
		return administrador;
	}
	public void setAdministrador(ArrayList<Administrador> administrador) {
		this.administrador = administrador;
	}
	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(ArrayList<Temporada> temporadas) {
		this.temporadas = temporadas;
	}
	
	
}
