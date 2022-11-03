package Interfaz;

import java.awt.Dimension;

import javax.swing.JFrame;


public class VentanaInicio extends JFrame{
	private PanelInicio panelInicio;
	private InterfazPrincipal padre;

	public VentanaInicio(InterfazPrincipal papa) {
		padre = papa;
		//app = new Aplicacion();
		panelInicio = new PanelInicio(this);
		
		add(panelInicio);
		
		//Configuracion de la ventana
		setTitle("Fantasy Football");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(300, 150));
		setResizable(false);
		setVisible(true);
	}

	public void iniciarSesion(String usuario, String contrasena) {
		int resp = padre.iniciarSesion(usuario, contrasena);
		if (resp == 0) {
			this.dispose();
		}
	}
	public void crearCuenta(String usuario, String contrasena) {
		int resp = padre.crearUsuario(usuario, contrasena);
		if (resp == 0) {
			this.dispose();
		}
	}


}
