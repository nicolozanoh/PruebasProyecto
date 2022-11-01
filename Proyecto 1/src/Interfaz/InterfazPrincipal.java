package Interfaz;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import procesamiento.Aplicacion;
import modelo.Participante;

public class InterfazPrincipal extends JFrame{
	
	private Aplicacion app;
	

	public InterfazPrincipal() {
		app = new Aplicacion();
	}

	public static void main(String[] args) {
		InterfazPrincipal ip = new InterfazPrincipal();
		ip.iniciarAplicacion();
	}
	private void iniciarAplicacion(){
		app.cargarParticipantes();
        app.cargarAdministrador();
        int resp = app.cargarTemporadaActual();
        if (resp == 0) {
        	app.actualizarReferencias();
        	app.actualizarRankingEquipos();
        	app.actualizarRankingJugadores();
        	VentanaInicio vInicio = new VentanaInicio(this);
        }
	}

	public int iniciarSesion(String usuario, String contrasena) {
		
		int resp = app.iniciarSesion(usuario, contrasena);
		
		if (resp == 1) {
			JOptionPane.showMessageDialog(this,"La contraseña no es correcta", "Error", JOptionPane.WARNING_MESSAGE);
		}
		
		if (resp == 2) {
			JOptionPane.showMessageDialog(this, "El nombre de usuario no existe","Error",JOptionPane.WARNING_MESSAGE);
		}
		
		if(resp == 0) {
			if (this.app.getUsuarioActivo().getClass().getName().equals("modelo.Participante")) {
				if(((Participante)this.app.getUsuarioActivo()).getEquipo()!=null) {
					VentanaUsuario vUsuario = new VentanaUsuario(this);
				}
				else {
					VentanaCrearEquipo vCrear = new VentanaCrearEquipo(this);
				}
			}
			if (this.app.getUsuarioActivo().getClass().getName().equals("modelo.Administrador")) {
				VentanaAdmin vUsuario = new VentanaAdmin(this);
			}
		}
		
		return resp;
	}

	public int crearUsuario(String usuario, String contrasena) {
		int resp = app.crearCuenta(usuario, contrasena);
		if (resp == 1){
			JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe, seleccione otro","Error",JOptionPane.WARNING_MESSAGE);
		}
		if (resp == 0){
			iniciarSesion(usuario, contrasena);
		}
		return resp;
	}
	public Aplicacion getAplicacion() {
		return this.app;
	}

}
