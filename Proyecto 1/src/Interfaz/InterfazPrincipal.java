package Interfaz;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import procesamiento.Aplicacion;
import modelo.Jugador;
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

	public void crearEquipo(ArrayList<Jugador>equipo, String nombreEquipo) {
		int resp = app.crearEquipoV2(equipo, nombreEquipo);
		if (resp == 0) {
			JOptionPane.showMessageDialog(this, "Su equipo se ha creado exitosamente, su nuevo saldo es de: $" + ((Participante)this.app.getUsuarioActivo()).getPresupuesto(),"",JOptionPane.INFORMATION_MESSAGE);
			VentanaUsuario vUsuario = new VentanaUsuario(this);
		}
		else if(resp==1) {
			JOptionPane.showMessageDialog(this, "Error: Ya existe un equipo, para crear un nuevo equipo, elimine el anterior","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==2) {
    		JOptionPane.showMessageDialog(this, "Error: Numero de arqueros. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==3) {
    		JOptionPane.showMessageDialog(this, "Error: Numero de defensas. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==4) {
    		JOptionPane.showMessageDialog(this, "Error: Numero de mediocampistas. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==5) {
    		JOptionPane.showMessageDialog(this, "Error: Numero de delanteros. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==6) {
    		JOptionPane.showMessageDialog(this, "Error: Saldo insuficiente","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==7||resp == 9) {
    		JOptionPane.showMessageDialog(this, "Error: Debe seleccionar 15 jugadores para crear el equipo.","Error",JOptionPane.ERROR_MESSAGE);	
    	}
    	else if(resp == 10) {
    		JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para su equipo","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp == 11) {
    		JOptionPane.showMessageDialog(this, "Debe seleccionar 15 jugadores diferentes","Error",JOptionPane.ERROR_MESSAGE);
    	}
	}

}
