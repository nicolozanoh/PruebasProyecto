package Interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Jugador;
import modelo.Participante;

public class PanelInferiorComprar extends JPanel implements ActionListener{
	private static final String SELECCION = "SELECCION";
	private static final String COMPRAR = "COMPRAR";
	private ArrayList<Jugador> arrayDefensas;
	private ArrayList<Jugador> arrayMediocampistas;
	private ArrayList<Jugador> arrayArqueros;
	private ArrayList<Jugador> arrayDelanteros;
	private JLabel arqueros;
	private JLabel defensas;
	private JLabel mediocampistas;
	private JLabel delanteros;
	private double presupuestoInicial;
	
	private JButton btnComprar;
	
	private JLabel nombre;
	private JTextField nombreEquipo;
	private JLabel saldo;
	private JComboBox<?>  comboArqueros;
	private JComboBox<?>  comboDefensas;
	private JComboBox<?>  comboMediocampistas;
	private JComboBox<?>  comboDelanteros;
	private VentanaComprar padre;
	public PanelInferiorComprar(VentanaComprar papa) {
		padre = papa;
		setLayout(new GridLayout(23,1));
		arqueros = new JLabel("Arqueros:");
		defensas = new JLabel("Defensas:");
		mediocampistas = new JLabel("Mediocampistas:");
		delanteros = new JLabel("Delanteros:");
		presupuestoInicial = ((Participante)this.padre.getInterfaz().getAplicacion().getUsuarioActivo()).getPresupuesto();
		saldo = new JLabel("Saldo: " + Double.toString(presupuestoInicial));
		
		armarListas();
		
		comboArqueros = new JComboBox<>();
		comboArqueros.setModel(new DefaultComboBoxModel(arrayArqueros.toArray()));
		comboArqueros.setSelectedIndex(-1);
		comboArqueros.setActionCommand(SELECCION);
		comboArqueros.addActionListener(this);
		
		comboDefensas = new JComboBox<>();
		comboDefensas.setModel(new DefaultComboBoxModel(arrayDefensas.toArray()));
		comboDefensas.setSelectedIndex(-1);
		comboDefensas.setActionCommand(SELECCION);
		comboDefensas.addActionListener(this);
		
		comboMediocampistas = new JComboBox<>();
		comboMediocampistas.setModel(new DefaultComboBoxModel(arrayMediocampistas.toArray()));
		comboMediocampistas.setSelectedIndex(-1);
		comboMediocampistas.setActionCommand(SELECCION);
		comboMediocampistas.addActionListener(this);
		
		comboDelanteros = new JComboBox<>();
		comboDelanteros.setModel(new DefaultComboBoxModel(arrayDelanteros.toArray()));
		comboDelanteros.setSelectedIndex(-1);
		comboDelanteros.setActionCommand(SELECCION);
		comboDelanteros.addActionListener(this);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setActionCommand(COMPRAR);
		btnComprar.addActionListener(this);
		
		add(arqueros);
		add(comboArqueros);
		add(defensas);
		add(comboDefensas);
		add(mediocampistas);
		add(comboMediocampistas);
		add(delanteros);
		add(comboDelanteros);
		add(saldo);
		add(btnComprar);
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
		this.arrayArqueros.add(0, null);
		this.arrayDefensas.add(0, null);
		this.arrayMediocampistas.add(0, null);;
		this.arrayDelanteros.add(0, null);;
	}
	private double recalcularSaldoRestante() {
		double saldo = presupuestoInicial;
		if (comboArqueros.getSelectedItem()!= null) {
			
			saldo -=((Jugador)comboArqueros.getSelectedItem()).getPrecio();
		}
		if (comboDefensas.getSelectedItem()!= null) {
			
			saldo -=((Jugador)comboDefensas.getSelectedItem()).getPrecio();
		}
		if (comboMediocampistas.getSelectedItem()!= null) {
			
			saldo -=((Jugador)comboMediocampistas.getSelectedItem()).getPrecio();
		}
		if (comboDelanteros.getSelectedItem()!= null) {
			
			saldo -= ((Jugador)comboDelanteros.getSelectedItem()).getPrecio();
		}
		return saldo;
	}
	private ArrayList<Jugador> listaSeleccion(){
		ArrayList<Jugador>jugadoresComprar = null;
		jugadoresComprar = new ArrayList<Jugador>();
		jugadoresComprar.add((Jugador)comboArqueros.getSelectedItem());
		jugadoresComprar.add((Jugador)comboDefensas.getSelectedItem());
		jugadoresComprar.add((Jugador)comboMediocampistas.getSelectedItem());
		jugadoresComprar.add((Jugador)comboDelanteros.getSelectedItem());
		jugadoresComprar.removeAll(Collections.singleton(null));
		return jugadoresComprar;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if (evento.equals(SELECCION)) {
			double saldo = recalcularSaldoRestante();
			this.saldo.setText("Saldo: "+ Double.toString(saldo));
		}
		if (evento.equals(COMPRAR)) {
			ArrayList<Jugador> jugadoresComprar = listaSeleccion();
			this.padre.comprarJugador(jugadoresComprar);
				
		}
	}
}
