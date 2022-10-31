package Interfaz;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelInicio extends JPanel{
	
	private JLabel usuario;
	private JLabel contrasena;
	
	private JTextField campoUsuario;
	private JTextField campoContrasena;
	
	private JButton btnIniciarSesion;
	private JButton btnCrearEquipo;
	
	private InterfazPrincipal padre;
	
	public PanelInicio(InterfazPrincipal papa) {
	
		padre = papa;
		
		usuario = new JLabel("Usuario");
		usuario.setPreferredSize(new Dimension(70,30));
		contrasena = new JLabel("Contraseña");
		contrasena.setPreferredSize(new Dimension(70,30));
		
		campoUsuario = new JTextField();
		campoUsuario.setPreferredSize(new Dimension(170,30));
		campoContrasena= new JTextField();
		campoContrasena.setPreferredSize(new Dimension(170,30));
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnCrearEquipo = new JButton("Crear Equipo");
		
		
		add(usuario);
		add(campoUsuario);
		add(contrasena);
		add(campoContrasena);
		add(btnIniciarSesion);
		add(btnCrearEquipo);
		
	}

}
