package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.EquipoFantasia;
import modelo.Participante;

public class PanelUsuarioSuperior extends JPanel implements ActionListener{
	private static final String COMPRAR = "COMPRAR";
	private static final String VENDER = "VENDER";
	private static final String ESTADISTICAS = "ESTADISTICAS";
	private static final String CERRAR = "CERRAR";
	private static final String BORRAR= "BORRAR";
	private static final String SELECCION= "SELECCION";
	private static final String CREAR= "CREAR";
	private VentanaUsuario padre;
	private VentanaComprar vComprar;
	private JButton verEstadisticas;
	private JButton comprarJugador;
	private JButton venderJugador;
	private JButton cerrarSesion;
	private JButton borrarEquipo;
	private JButton crearEquipo;
	private JComboBox<EquipoFantasia> comboEquipo;
	private JPanel centro;
	private JPanel derecha;
	private JLabel lCombo;
	
	
	public PanelUsuarioSuperior(VentanaUsuario papa) {
		padre = papa;
		
		crearEquipo = new JButton("Crear Equipo");
		crearEquipo.setActionCommand(CREAR);
		crearEquipo.addActionListener(this);
		
		verEstadisticas = new JButton("Ver Estadísticas");
		verEstadisticas.setActionCommand(ESTADISTICAS);
		verEstadisticas.addActionListener(this);
		
		comprarJugador = new JButton("Comprar Jugador");
		comprarJugador.setActionCommand(COMPRAR);
		comprarJugador.addActionListener(this);
		
		venderJugador = new JButton("Vender Jugador");
		venderJugador.setActionCommand(VENDER);
		venderJugador.addActionListener(this);
		
		cerrarSesion = new JButton("Cerrar Sesión");
		cerrarSesion.setActionCommand(CERRAR);
		cerrarSesion.addActionListener(this);
		
		borrarEquipo = new JButton("Borrar Equipo");
		borrarEquipo.setActionCommand(BORRAR);
		borrarEquipo.addActionListener(this);
		
		comboEquipo = new JComboBox();
		comboEquipo.setModel(new DefaultComboBoxModel((((Participante)this.padre.getInterfaz().getAplicacion().getUsuarioActivo()).getEquipos()).toArray()));
		comboEquipo.setSelectedIndex(-1);
		comboEquipo.setActionCommand(SELECCION);
		comboEquipo.addActionListener(this);
		
		lCombo = new JLabel("Seleccione un equipo:  ");
		
		setBorder(new TitledBorder("Bienvenido "+ padre.getInterfaz().getAplicacion().getUsuarioActivo().getNombreUsuario()+"!"));
		setLayout(new BorderLayout());
		
		derecha = new JPanel();
		derecha.setLayout(new GridLayout(1,1));
		derecha.add(lCombo);
		derecha.add(comboEquipo);
		
		centro = new JPanel();
		
		centro.setLayout(new FlowLayout());
		centro.add(verEstadisticas);
		centro.add(comprarJugador);
		centro.add(venderJugador);
		centro.add(venderJugador);
		centro.add(crearEquipo);
		centro.add(cerrarSesion);
		
		add(centro, BorderLayout.CENTER);
		add(derecha, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if (evento.equals(COMPRAR)) {
				this.padre.comprarJugador();
		}
		else if (evento.equals(VENDER)) {
			this.padre.venderJugador();
		}
		else if (evento.equals(ESTADISTICAS)) {
			this.padre.verEstadisticas();;
		}
		else if (evento.equals(CERRAR)) {
			this.padre.cerrarSesion();
		}
		else if (evento.equals(BORRAR)) {
			this.padre.borrarEquipo();
		}
		else if (evento.equals(SELECCION)) {
			this.padre.setEquipoSeleccionado((EquipoFantasia)comboEquipo.getSelectedItem());
		}
		else if (evento.equals(CREAR)) {
			this.padre.crearNuevoEquipo();
		}
	}

	public void actualizarListaEquipos() {
		comboEquipo.setModel(new DefaultComboBoxModel((((Participante)this.padre.getInterfaz().getAplicacion().getUsuarioActivo()).getEquipos()).toArray()));
	}

}
