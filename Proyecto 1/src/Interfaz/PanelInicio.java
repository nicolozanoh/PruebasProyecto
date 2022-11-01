package Interfaz;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PanelInicio extends JPanel implements ActionListener{
	private static final String INICIAR = "INICIAR";
	private static final String CREAR = "CREAR";
	private JLabel usuario;
	private JLabel contrasena;
	
	private JTextField campoUsuario;
	private JPasswordField campoContrasena;
	
	private JButton btnIniciarSesion;
	private JButton btnCrearEquipo;
	
	private VentanaInicio padre;
	
	public PanelInicio(VentanaInicio ventanaInicio) {
	
		padre = ventanaInicio;
		
		usuario = new JLabel("Usuario");
		usuario.setPreferredSize(new Dimension(70,30));
		contrasena = new JLabel("Contraseña");
		contrasena.setPreferredSize(new Dimension(70,30));
		
		campoUsuario = new JTextField();
		campoUsuario.setPreferredSize(new Dimension(170,30));
		campoContrasena= new JPasswordField();
		campoContrasena.setPreferredSize(new Dimension(170,30));
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setActionCommand(INICIAR);
		btnIniciarSesion.addActionListener(this);
		
		btnCrearEquipo = new JButton("Crear Usuario");
		btnCrearEquipo.setActionCommand(CREAR);
		btnCrearEquipo.addActionListener(this);
		
		add(usuario);
		add(campoUsuario);
		add(contrasena);
		add(campoContrasena);
		add(btnIniciarSesion);
		add(btnCrearEquipo);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		String usuario = campoUsuario.getText();
		String contrasena = campoContrasena.getText();
		if(evento.equals(INICIAR)) {
			padre.iniciarSesion(usuario,contrasena);
		}
		if(evento.equals(CREAR)) {
			padre.crearCuenta(usuario,contrasena);
		}
		
	}

}
