package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelUsuario extends JPanel{
	
	private VentanaUsuario padre;
	
	private JLabel titulares;
	private JLabel suplentes;
	
	private JTextField jugador1;
	private JTextField jugador2;
	private JTextField jugador3;
	private JTextField jugador4;
	private JTextField jugador5;
	private JTextField jugador6;
	private JTextField jugador7;
	private JTextField jugador8;
	private JTextField jugador9;
	private JTextField jugador10;
	private JTextField jugador11;
	private JTextField jugador12;
	private JTextField jugador13;
	private JTextField jugador14;
	private JTextField jugador15;
	
	
	public PanelUsuario(VentanaUsuario papa) {
		padre = papa;
		setBorder(new TitledBorder("Bienvenido "+ padre.getInterfaz().getAplicacion().getUsuarioActivo().getNombreUsuario()+"!"));
		
		titulares = new JLabel("Titulares:");
		suplentes = new JLabel("Suplentes:");
		
		jugador1 = new JTextField();
		jugador1.setPreferredSize(new Dimension(70,10));
		jugador1.setEditable(false);
		jugador2 = new JTextField();
		jugador2.setPreferredSize(new Dimension(70,10));
		jugador2.setEditable(false);
		jugador3 = new JTextField();
		jugador3.setPreferredSize(new Dimension(70,10));
		jugador3.setEditable(false);
		jugador4 = new JTextField();
		jugador4.setPreferredSize(new Dimension(70,10));
		jugador4.setEditable(false);
		jugador5 = new JTextField();
		jugador5.setPreferredSize(new Dimension(70,10));
		jugador5.setEditable(false);
		jugador6 = new JTextField();
		jugador6.setPreferredSize(new Dimension(70,10));
		jugador6.setEditable(false);
		jugador7 = new JTextField();
		jugador7.setPreferredSize(new Dimension(70,10));
		jugador7.setEditable(false);
		jugador8 = new JTextField();
		jugador8.setPreferredSize(new Dimension(70,10));
		jugador8.setEditable(false);
		jugador9 = new JTextField();
		jugador9.setPreferredSize(new Dimension(70,10));
		jugador9.setEditable(false);
		jugador10 = new JTextField();
		jugador10.setPreferredSize(new Dimension(70,10));
		jugador10.setEditable(false);
		jugador11 = new JTextField();
		jugador11.setPreferredSize(new Dimension(70,10));
		jugador11.setEditable(false);
		jugador12 = new JTextField();
		jugador12.setPreferredSize(new Dimension(70,10));
		jugador12.setEditable(false);
		jugador13 = new JTextField();
		jugador13.setPreferredSize(new Dimension(70,10));
		jugador13.setEditable(false);
		jugador14 = new JTextField();
		jugador14.setPreferredSize(new Dimension(70,10));
		jugador14.setEditable(false);
		jugador15 = new JTextField();
		jugador15.setPreferredSize(new Dimension(70,10));
		jugador15.setEditable(false);
	
		setLayout(new GridLayout(15,1));
		
		add(titulares);
		add(jugador1);
		add(jugador2);
		add(jugador3);
		add(jugador4);
		add(jugador5);
		add(jugador6);
		add(jugador7);
		add(jugador8);
		add(jugador9);
		add(jugador10);
		add(jugador11);
		add(suplentes);
		add(jugador12);
		add(jugador13);
		add(jugador14);
		add(jugador15);
		
	}
	
}
