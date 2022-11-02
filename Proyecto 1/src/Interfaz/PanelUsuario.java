package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import modelo.Participante;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelUsuario extends JPanel{
	
	private VentanaUsuario padre;
	private Participante usuario;
	private JLabel titulares;
	private JLabel suplentes;
	
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
		usuario = (Participante)padre.getInterfaz().getAplicacion().getUsuarioActivo();
		if (((Participante)padre.getInterfaz().getAplicacion().getUsuarioActivo()).getEquipo()!=null) {
			setBorder(new TitledBorder(((Participante)padre.getInterfaz().getAplicacion().getUsuarioActivo()).getEquipo().getNombre()));
		}
		
		titulares = new JLabel("Titulares:");
		suplentes = new JLabel("Suplentes:");
		
		titular1 = new JCheckBox (usuario.getEquipo().getTitulares().get(0).toString());
		//jugador1.setPreferredSize(new Dimension(70,10));
		//jugador1.setEditable(false);
		titular2 = new JCheckBox (usuario.getEquipo().getTitulares().get(1).toString());
		//jugador2.setPreferredSize(new Dimension(70,10));
		//jugador2.setEditable(false);
		titular3 = new JCheckBox (usuario.getEquipo().getTitulares().get(2).toString());
		//jugador3.setPreferredSize(new Dimension(70,10));
		//jugador3.setEditable(false);
		titular4 = new JCheckBox (usuario.getEquipo().getTitulares().get(3).toString());
		//jugador4.setPreferredSize(new Dimension(70,10));
		//jugador4.setEditable(false);
		titular5 = new JCheckBox (usuario.getEquipo().getTitulares().get(4).toString());
		//jugador5.setPreferredSize(new Dimension(70,10));
		//jugador5.JCheckBox (false);
		titular6 = new JCheckBox (usuario.getEquipo().getTitulares().get(5).toString());
		//jugador6.setPreferredSize(new Dimension(70,10));
		//jugador6.setEditable(false);
		titular7 = new JCheckBox (usuario.getEquipo().getTitulares().get(6).toString());
		//jugador7.setPreferredSize(new Dimension(70,10));
		//jugador7.setEditable(false);
		titular8 = new JCheckBox (usuario.getEquipo().getTitulares().get(7).toString());
		//jugador8.setPreferredSize(new Dimension(70,10));
		//jugador8.setEditable(false);
		titular9 = new JCheckBox (usuario.getEquipo().getTitulares().get(8).toString());
		//jugador9.setPreferredSize(new Dimension(70,10));
		//jugador9.setEditable(false);
		titular10 = new JCheckBox (usuario.getEquipo().getTitulares().get(9).toString());
		//jugador10.setPreferredSize(new Dimension(70,10));
		//jugador10.setEditable(false);
		titular11 = new JCheckBox (usuario.getEquipo().getTitulares().get(10).toString());
		//jugador11.setPreferredSize(new Dimension(70,10));
		//jugador11.setEditable(false);
		suplente1 = new JCheckBox (usuario.getEquipo().getSuplentes().get(0).toString());
		//jugador12.setPreferredSize(new Dimension(70,10));
		//jugador12.setEditable(false);
		suplente2 = new JCheckBox (usuario.getEquipo().getSuplentes().get(1).toString());
		//jugador13.setPreferredSize(new Dimension(70,10));
		//jugador13.setEditable(false);
		suplente3 = new JCheckBox (usuario.getEquipo().getSuplentes().get(2).toString());
		//jugador14.setPreferredSize(new Dimension(70,10));
		//jugador14.setEditable(false);
		suplente4 = new JCheckBox (usuario.getEquipo().getSuplentes().get(3).toString());
		//jugador15.setPreferredSize(new Dimension(70,10));
		//jugador15.setEditable(false);
		
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
		add(suplente1);
		add(suplente2);
		add(suplente3);
		add(suplente4);
		
	}
	
}
