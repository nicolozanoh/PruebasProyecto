package Interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Jugador;
import modelo.Participante;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelUsuario extends JPanel{
	private static final String CAMBIOSELECCION = "CAMBIOSELECCION";
	private VentanaUsuario padre;
	
	private JLabel titulares;
	private JLabel suplentes;
	private ArrayList<String> seleccion = new ArrayList<String>();
	private JCheckBox  titular1;
	private JCheckBox  titular2;
	private JCheckBox  titular3;
	private JCheckBox  titular4;
	private JCheckBox  titular5;
	private JCheckBox  titular6;
	private JCheckBox  titular7;
	private JCheckBox  titular8;
	private JCheckBox  titular9;
	private JCheckBox  titular10;
	private JCheckBox  titular11;
	private JCheckBox  suplente1;
	private JCheckBox  suplente2;
	private JCheckBox  suplente3;
	private JCheckBox  suplente4;
	
	public PanelUsuario(VentanaUsuario papa) {
		padre = papa;
		
		if (((Participante)padre.getInterfaz().getAplicacion().getUsuarioActivo()).getEquipo()!=null) {
			setBorder(new TitledBorder(((Participante)padre.getInterfaz().getAplicacion().getUsuarioActivo()).getEquipo().getNombre()));
		}
		
		titulares = new JLabel("Titulares:");
		suplentes = new JLabel("Suplentes:");
		
		titular1 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(0).toString());
		titular2 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(1).toString());
		titular3 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(2).toString());
		titular4 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(3).toString());
		titular5 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(4).toString());
		titular6 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(5).toString());
		titular7 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(6).toString());
		titular8 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(7).toString());
		titular9 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(8).toString());
		titular10 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(9).toString());
		titular11 = new JCheckBox (padre.getUsuario().getEquipo().getTitulares().get(10).toString());
		suplente1 = new JCheckBox (padre.getUsuario().getEquipo().getSuplentes().get(0).toString());
		suplente2 = new JCheckBox (padre.getUsuario().getEquipo().getSuplentes().get(1).toString());
		suplente3 = new JCheckBox (padre.getUsuario().getEquipo().getSuplentes().get(2).toString());
		if (padre.getUsuario().getEquipo().getSuplentes().size()==4) {
			suplente4 = new JCheckBox (padre.getUsuario().getEquipo().getSuplentes().get(3).toString());
		}
		else {
			suplente4 = new JCheckBox();
		}
		setLayout(new GridLayout(15,1));
		
		add(titulares);
		add(titular1);
		add(titular2);
		add(titular3);
		add(titular4);
		add(titular5);
		add(titular6);
		add(titular7);
		add(titular8);
		add(titular9);
		add(titular10);
		add(titular11);
		add(suplentes);
		add(new JLabel());
		add(suplente1);
		add(suplente2);
		add(suplente3);
		add(suplente4);
		
	}
	public ArrayList<String> getElementosSeleccionados() {
		ArrayList<String> seleccionados = new ArrayList<String>();
		if (titular1.isSelected()) {
			seleccionados.add(titular1.getText());
		}
		if (titular2.isSelected()) {
			seleccionados.add(titular2.getText());
		}
		if (titular3.isSelected()) {
			seleccionados.add(titular3.getText());
		}
		if (titular4.isSelected()) {
			seleccionados.add(titular4.getText());
		}
		if (titular5.isSelected()) {
			seleccionados.add(titular5.getText());
		}
		if (titular6.isSelected()) {
			seleccionados.add(titular6.getText());
		}
		if (titular7.isSelected()) {
			seleccionados.add(titular7.getText());
		}
		if (titular8.isSelected()) {
			seleccionados.add(titular8.getText());
		}
		if (titular9.isSelected()) {
			seleccionados.add(titular9.getText());
		}
		if (titular10.isSelected()) {
			seleccionados.add(titular10.getText());
		}
		if (titular11.isSelected()) {
			seleccionados.add(titular11.getText());
		}
		if (suplente1.isSelected()) {
			seleccionados.add(suplente1.getText());
		}
		if (suplente2.isSelected()) {
			seleccionados.add(suplente2.getText());
		}
		if (suplente3.isSelected()) {
			seleccionados.add(suplente3.getText());
		}
		if (suplente4.isSelected()) {
			if(!(suplente4.getText().equals(""))) {
				seleccionados.add(suplente4.getText());
			}
		}
		return seleccionados;
	}
	
	public ArrayList<String> getSeleccion() {
		return seleccion;
	}


	public void actualizarAlineacion() {
		titular1.setText(padre.getUsuario().getEquipo().getTitulares().get(0).toString());
		titular2.setText(padre.getUsuario().getEquipo().getTitulares().get(1).toString());
		titular3.setText(padre.getUsuario().getEquipo().getTitulares().get(2).toString());
		titular4.setText(padre.getUsuario().getEquipo().getTitulares().get(3).toString());
		titular5.setText(padre.getUsuario().getEquipo().getTitulares().get(4).toString());
		titular6.setText(padre.getUsuario().getEquipo().getTitulares().get(5).toString());
		titular7.setText(padre.getUsuario().getEquipo().getTitulares().get(6).toString());
		titular8.setText(padre.getUsuario().getEquipo().getTitulares().get(7).toString());
		titular9.setText(padre.getUsuario().getEquipo().getTitulares().get(8).toString());
		titular10.setText(padre.getUsuario().getEquipo().getTitulares().get(9).toString());
		titular11.setText(padre.getUsuario().getEquipo().getTitulares().get(10).toString());
		suplente1.setText(padre.getUsuario().getEquipo().getSuplentes().get(0).toString());
		suplente2.setText(padre.getUsuario().getEquipo().getSuplentes().get(1).toString());
		suplente3.setText(padre.getUsuario().getEquipo().getSuplentes().get(2).toString());
		suplente4.setText("");
		if (padre.getUsuario().getEquipo().getSuplentes().size()==4) {
			suplente4.setText(padre.getUsuario().getEquipo().getSuplentes().get(3).toString());	
		}
			
	}
	public void borrarSelecciones() {
		titular1.setSelected(false);
		titular2.setSelected(false);
		titular3.setSelected(false);
		titular4.setSelected(false);
		titular5.setSelected(false);
		titular6.setSelected(false);
		titular7.setSelected(false);
		titular8.setSelected(false);
		titular9.setSelected(false);
		titular10.setSelected(false);
		titular11.setSelected(false);
		suplente1.setSelected(false);
		suplente2.setSelected(false);
		suplente3.setSelected(false);
		suplente4.setSelected(false);
	}
	
}
