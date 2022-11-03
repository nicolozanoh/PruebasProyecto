package Interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Jugador;
import modelo.Participante;

public class PanelInferiorCrearEquipo extends JPanel implements ActionListener{
	VentanaCrearEquipo padre;
	
	private static final String CREAR = "CREAR";
	private static final String SELECCION = "SELECCION";
	private ArrayList<Jugador> arrayDefensas;
	private ArrayList<Jugador> arrayMediocampistas;
	private ArrayList<Jugador> arrayArqueros;
	private ArrayList<Jugador> arrayDelanteros;
	private JLabel arqueros;
	private JLabel defensas;
	private JLabel mediocampistas;
	private JLabel delanteros;
	private double presupuestoInicial;
	
	private JButton btnCrear;
	
	private JLabel nombre;
	private JTextField nombreEquipo;
	private JLabel saldo;
	private JComboBox<?>  arquero1;
	private JComboBox<?>  arquero2;
	private JComboBox<?>  defensa1;
	private JComboBox<?>  defensa2;
	private JComboBox<?>  defensa3;
	private JComboBox<?>  defensa4;
	private JComboBox<?>  defensa5;
	private JComboBox<?>  mediocampista1;
	private JComboBox<?>  mediocampista2;
	private JComboBox<?>  mediocampista3;
	private JComboBox<?>  mediocampista4;
	private JComboBox<?>  mediocampista5;
	private JComboBox<?>  delantero1;
	private JComboBox<?>  delantero2;
	private JComboBox<?>  delantero3;
	public PanelInferiorCrearEquipo(VentanaCrearEquipo papa) {
		padre = papa;
		setLayout(new GridLayout(23,1));
		arqueros = new JLabel("Arqueros:");
		defensas = new JLabel("Defensas:");
		mediocampistas = new JLabel("Mediocampistas:");
		delanteros = new JLabel("Delanteros:");
		presupuestoInicial = ((Participante)this.padre.getInterfaz().getAplicacion().getUsuarioActivo()).getPresupuesto();
		armarListas();
		
		saldo = new JLabel("Saldo: " + Double.toString(presupuestoInicial));
		
		nombre = new JLabel("Nombre Equipo:");
		nombreEquipo = new JTextField("");
		
		arquero1 = new JComboBox<>();
		arquero1.setModel(new DefaultComboBoxModel(arrayArqueros.toArray()));
		arquero1.setSelectedIndex(-1);
		arquero1.setActionCommand(SELECCION);
		arquero1.addActionListener(this);
		
		//arquero1.setPreferredSize(new Dimension (170, 50));
		arquero2 = new JComboBox<>();
		arquero2.setModel(new DefaultComboBoxModel(arrayArqueros.toArray()));
		arquero2.setSelectedIndex(-1);
		arquero2.setActionCommand(SELECCION);
		arquero2.addActionListener(this);
		
		//arquero2.setPreferredSize(new Dimension (170, 50));
		defensa1 = new JComboBox<>();
		defensa1.setModel(new DefaultComboBoxModel(arrayDefensas.toArray()));
		defensa1.setSelectedIndex(-1);
		defensa1.setActionCommand(SELECCION);
		defensa1.addActionListener(this);
		
		//defensa1.setPreferredSize(new Dimension (170, 50));
		defensa2 = new JComboBox<>();
		defensa2.setModel(new DefaultComboBoxModel(arrayDefensas.toArray()));
		defensa2.setSelectedIndex(-1);
		defensa2.setActionCommand(SELECCION);
		defensa2.addActionListener(this);
		
		//defensa2.setPreferredSize(new Dimension (170, 50));
		defensa3 = new JComboBox<>();
		defensa3.setModel(new DefaultComboBoxModel(arrayDefensas.toArray()));
		defensa3.setSelectedIndex(-1);
		defensa3.setActionCommand(SELECCION);
		defensa3.addActionListener(this);
		
		//defensa3.setPreferredSize(new Dimension (170, 50));
		defensa4 = new JComboBox<>();
		defensa4.setModel(new DefaultComboBoxModel(arrayDefensas.toArray()));
		defensa4.setSelectedIndex(-1);
		defensa4.setActionCommand(SELECCION);
		defensa4.addActionListener(this);
		
		//defensa4.setPreferredSize(new Dimension (170, 50));
		defensa5 = new JComboBox<>();
		defensa5.setModel(new DefaultComboBoxModel(arrayDefensas.toArray()));
		defensa5.setSelectedIndex(-1);
		defensa5.setActionCommand(SELECCION);
		defensa5.addActionListener(this);
		
		//defensa5.setPreferredSize(new Dimension (170, 50));
		mediocampista1 = new JComboBox<>();
		mediocampista1.setModel(new DefaultComboBoxModel(arrayMediocampistas.toArray()));
		mediocampista1.setSelectedIndex(-1);
		mediocampista1.setActionCommand(SELECCION);
		mediocampista1.addActionListener(this);
		
		//mediocampista1.setPreferredSize(new Dimension (170, 50));
		mediocampista2 = new JComboBox<>();
		mediocampista2.setModel(new DefaultComboBoxModel(arrayMediocampistas.toArray()));
		mediocampista2.setSelectedIndex(-1);
		mediocampista2.setActionCommand(SELECCION);
		mediocampista2.addActionListener(this);
		
		//mediocampista2.setPreferredSize(new Dimension (170, 50));
		mediocampista3 = new JComboBox<>();
		mediocampista3.setModel(new DefaultComboBoxModel(arrayMediocampistas.toArray()));
		mediocampista3.setSelectedIndex(-1);
		mediocampista3.setActionCommand(SELECCION);
		mediocampista3.addActionListener(this);
		
		//mediocampista3.setPreferredSize(new Dimension (170, 50));
		mediocampista4 = new JComboBox<>();
		mediocampista4.setModel(new DefaultComboBoxModel(arrayMediocampistas.toArray()));
		mediocampista4.setSelectedIndex(-1);
		mediocampista4.setActionCommand(SELECCION);
		mediocampista4.addActionListener(this);
		
		//mediocampista4.setPreferredSize(new Dimension (170, 50));
		mediocampista5 = new JComboBox<>();
		mediocampista5.setModel(new DefaultComboBoxModel(arrayMediocampistas.toArray()));
		mediocampista5.setSelectedIndex(-1);
		mediocampista5.setActionCommand(SELECCION);
		mediocampista5.addActionListener(this);
		
		//mediocampista5.setPreferredSize(new Dimension (170, 50));
		delantero1 = new JComboBox<>();
		delantero1.setModel(new DefaultComboBoxModel(arrayDelanteros.toArray()));
		delantero1.setSelectedIndex(-1);
		delantero1.setActionCommand(SELECCION);
		delantero1.addActionListener(this);
		
		//delantero1.setPreferredSize(new Dimension (170, 50));
		delantero2 = new JComboBox<>();
		delantero2.setModel(new DefaultComboBoxModel(arrayDelanteros.toArray()));
		delantero2.setSelectedIndex(-1);
		delantero2.setActionCommand(SELECCION);
		delantero2.addActionListener(this);
		
		//delantero2.setPreferredSize(new Dimension (170, 50));
		delantero3 = new JComboBox<>();
		delantero3.setModel(new DefaultComboBoxModel(arrayDelanteros.toArray()));
		delantero3.setSelectedIndex(-1);
		delantero3.setActionCommand(SELECCION);
		delantero3.addActionListener(this);
		
		//delantero3.setPreferredSize(new Dimension (170, 50));
		
		btnCrear = new JButton("Crear");
		btnCrear.setActionCommand(CREAR);
		btnCrear.addActionListener(this);
		
		add(nombre);
		add(nombreEquipo);
		add(arqueros);
		add(arquero1);
		add(arquero2);
		
		add(defensas);
		add(defensa1);
		add(defensa2);
		add(defensa3);
		add(defensa4);
		add(defensa5);
		
		add(mediocampistas);
		add(mediocampista1);
		add(mediocampista2);
		add(mediocampista3);
		add(mediocampista4);
		add(mediocampista5);
		
		add(delanteros);
		add(delantero1);
		add(delantero2);
		add(delantero3);
		add(saldo);
		add(btnCrear);
	}
	private void armarListas() {
		ArrayList<Jugador> jugadores = this.padre.getInterfaz().getAplicacion().getTemporada().getJugadores();
		this.arrayArqueros = new ArrayList<Jugador>();
		this.arrayDefensas = new ArrayList<Jugador>();
		this.arrayMediocampistas = new ArrayList<Jugador>();
		this.arrayDelanteros = new ArrayList<Jugador>();
		for (int i = 0; i<jugadores.size();i++) {
			if(jugadores.get(i).getPosicion().equals("defensa")) {
				this.arrayDefensas.add(jugadores.get(i));
			}
			if(jugadores.get(i).getPosicion().equals("arquero")) {
				this.arrayArqueros.add(jugadores.get(i));
			}
			if(jugadores.get(i).getPosicion().equals("mediocampista")) {
				this.arrayMediocampistas.add(jugadores.get(i));
			}
			if(jugadores.get(i).getPosicion().equals("delantero")) {
				this.arrayDelanteros.add(jugadores.get(i));
			}
		}
	}
	private double recalcularSaldoRestante() {
		double saldo = presupuestoInicial;
		if (arquero1.getSelectedItem()!= null) {
			
			saldo -=((Jugador)arquero1.getSelectedItem()).getPrecio();
		}
		if (arquero2.getSelectedItem()!= null) {
			
			saldo -=((Jugador)arquero2.getSelectedItem()).getPrecio();
		}
		if (defensa1.getSelectedItem()!= null) {
			
			saldo -=((Jugador)defensa1.getSelectedItem()).getPrecio();
		}
		if (defensa2.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)defensa2.getSelectedItem()).getPrecio();
		}
		if (defensa3.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)defensa3.getSelectedItem()).getPrecio();
		}
		if (defensa4.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)defensa4.getSelectedItem()).getPrecio();
		}
		if (defensa5.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)defensa5.getSelectedItem()).getPrecio();
		}
		if (mediocampista1.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)mediocampista1.getSelectedItem()).getPrecio();
		}
		if (mediocampista2.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)mediocampista2.getSelectedItem()).getPrecio();
		}
		if (mediocampista3.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)mediocampista3.getSelectedItem()).getPrecio();
		}
		if (mediocampista4.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)mediocampista4.getSelectedItem()).getPrecio();
		}
		if (mediocampista5.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)mediocampista5.getSelectedItem()).getPrecio();
		}
		if (delantero1.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)delantero1.getSelectedItem()).getPrecio();
		}
		if (delantero2.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)delantero2.getSelectedItem()).getPrecio();
		}
		if (delantero3.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)delantero3.getSelectedItem()).getPrecio();
		}
		return saldo;
	}
	private ArrayList<Jugador> listaEquipo(){
		ArrayList<Jugador>equipo = null;
		equipo = new ArrayList<Jugador>();
		equipo.add((Jugador)arquero1.getSelectedItem());
		equipo.add((Jugador)arquero2.getSelectedItem());
		equipo.add((Jugador)defensa1.getSelectedItem());
		equipo.add((Jugador)defensa2.getSelectedItem());
		equipo.add((Jugador)defensa3.getSelectedItem());
		equipo.add((Jugador)defensa4.getSelectedItem());
		equipo.add((Jugador)defensa5.getSelectedItem());
		equipo.add((Jugador)mediocampista1.getSelectedItem());
		equipo.add((Jugador)mediocampista2.getSelectedItem());
		equipo.add((Jugador)mediocampista3.getSelectedItem());
		equipo.add((Jugador)mediocampista4.getSelectedItem());
		equipo.add((Jugador)mediocampista5.getSelectedItem());
		equipo.add((Jugador)delantero1.getSelectedItem());
		equipo.add((Jugador)delantero2.getSelectedItem());
		equipo.add((Jugador)delantero3.getSelectedItem());
		equipo.removeAll(Collections.singleton(null));
		return equipo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if (evento.equals(SELECCION)) {
			double saldo = recalcularSaldoRestante();
			this.saldo.setText("Saldo: "+ Double.toString(saldo));
		}
		if (evento.equals(CREAR)) {
			ArrayList<Jugador> equipo = listaEquipo();
			this.padre.crearEquipo(equipo, nombreEquipo.getText());
				
		}
	}
}
