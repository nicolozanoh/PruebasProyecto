package Interfaz;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Participante;

public class PanelCrearEquipo extends JPanel{
	
	private VentanaCrearEquipo padre;
	
	private JLabel presupuesto;
	private JLabel instrucciones;
	
	public PanelCrearEquipo(VentanaCrearEquipo papa) {
		padre = papa;
		setLayout(new GridLayout(2,1));
		setBorder(new TitledBorder("Crear Equipo"));
		
		presupuesto = new JLabel("Usted cuenta con un presupuesto de $"+Double.toString(((Participante)padre.getInterfaz().getAplicacion().getUsuarioActivo()).getPresupuesto()));
		instrucciones = new JLabel("Por favor seleccione 15 jugadores, 5 defensas, 5 mediocampistas, 2 arqueros y tres delanteros");
		add(instrucciones);
		add(presupuesto);
	}
}
