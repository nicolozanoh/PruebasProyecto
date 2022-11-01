package Interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInferiorCrearEquipo extends JPanel{
	VentanaCrearEquipo padre;
	
	private JLabel arqueros;
	private JLabel defensas;
	private JLabel mediocampistas;
	private JLabel delanteros;
	
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
		setLayout(new GridLayout(19,1));
		arqueros = new JLabel("Arqueros:");
		defensas = new JLabel("Defensas:");
		mediocampistas = new JLabel("Mediocampistas:");
		delanteros = new JLabel("Delanteros:");
		
		arquero1 = new JComboBox<>();
		arquero1.setPreferredSize(new Dimension (170, 50));
		arquero2 = new JComboBox<>();
		arquero2.setPreferredSize(new Dimension (170, 50));
		defensa1 = new JComboBox<>();
		defensa1.setPreferredSize(new Dimension (170, 50));
		defensa2 = new JComboBox<>();
		defensa2.setPreferredSize(new Dimension (170, 50));
		defensa3 = new JComboBox<>();
		defensa3.setPreferredSize(new Dimension (170, 50));
		defensa4 = new JComboBox<>();
		defensa4.setPreferredSize(new Dimension (170, 50));
		defensa5 = new JComboBox<>();
		defensa5.setPreferredSize(new Dimension (170, 50));
		mediocampista1 = new JComboBox<>();
		mediocampista1.setPreferredSize(new Dimension (170, 50));
		mediocampista2 = new JComboBox<>();
		mediocampista2.setPreferredSize(new Dimension (170, 50));
		mediocampista3 = new JComboBox<>();
		mediocampista3.setPreferredSize(new Dimension (170, 50));
		mediocampista4 = new JComboBox<>();
		mediocampista4.setPreferredSize(new Dimension (170, 50));
		mediocampista5 = new JComboBox<>();
		mediocampista5.setPreferredSize(new Dimension (170, 50));
		delantero1 = new JComboBox<>();
		delantero1.setPreferredSize(new Dimension (170, 50));
		delantero2 = new JComboBox<>();
		delantero2.setPreferredSize(new Dimension (170, 50));
		delantero3 = new JComboBox<>();
		delantero3.setPreferredSize(new Dimension (170, 50));
		
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
	}
}
