package Interfaz;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import procesamiento.Aplicacion;
import modelo.Jugador;
import modelo.Participante;

public class InterfazPrincipal extends JFrame{
	
	private Aplicacion app;
	private VentanaAdmin vAdministrador;
	private VentanaUsuario vUsuario;
	private VentanaComprar vComprar;
	private VentanaInicio vInicio;
	private VentanaCrearEquipo vCrear;
	private VentanaEstadisticas vEstadisticas;
	private VentanaEstadisticaEquipo vEstEquipo;
	private VentanaEstadisticaJornada vEstJornada;
	private VentanaEstadisticaTemporada vEstTemporada;
	
	boolean temporadaConfigurada;

	public InterfazPrincipal() {
		app = new Aplicacion();
	}

	public static void main(String[] args) {
		InterfazPrincipal ip = new InterfazPrincipal();
		ip.iniciarAplicacion();
	}
	private void iniciarAplicacion(){
		app.cargarParticipantes();
        app.cargarAdministrador();
        int resp = app.cargarTemporadaActual();
        if (resp == 0) {
        	app.actualizarReferencias();
        	app.actualizarRankingEquipos();
        	app.actualizarRankingJugadores();
        	temporadaConfigurada = true;
        }
        else {
        	temporadaConfigurada = false;
        }
        vInicio = new VentanaInicio(this);
	}

	public int iniciarSesion(String usuario, String contrasena) {
		
		int resp = app.iniciarSesion(usuario, contrasena);
		
		if (resp == 1) {
			JOptionPane.showMessageDialog(this,"La contraseña no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if (resp == 2) {
			JOptionPane.showMessageDialog(this, "El nombre de usuario no existe","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		if(resp == 0) {
			if (this.app.getUsuarioActivo().getClass().getName().equals("modelo.Participante")) {
				if(temporadaConfigurada) {
					if(((Participante)this.app.getUsuarioActivo()).getEquipo()!=null) {
						this.app.organizarJugadoresEquipo();
						vUsuario = new VentanaUsuario(this);
					}
					else {
						vCrear = new VentanaCrearEquipo(this);
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "La temporada aún no se ha configurado, por favor vuelva más tarde","Error",JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
			}
			if (this.app.getUsuarioActivo().getClass().getName().equals("modelo.Administrador")) {
				vAdministrador= new VentanaAdmin(this);
			}
		}
		
		return resp;
	}

	public int crearUsuario(String usuario, String contrasena) {
		int resp = app.crearCuenta(usuario, contrasena);
		if (resp == 1){
			JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña no validos, seleccione otro","Error",JOptionPane.WARNING_MESSAGE);
		}
		if (resp == 0){
			JOptionPane.showMessageDialog(this, "Su usuario se ha creado!","",JOptionPane.INFORMATION_MESSAGE);
			iniciarSesion(usuario, contrasena);
		}
		return resp;
	}
	public Aplicacion getAplicacion() {
		return this.app;
	}

	public void crearEquipo(ArrayList<Jugador>equipo, String nombreEquipo) {
		int resp = app.crearEquipoV2(equipo, nombreEquipo);
		if (resp == 0) {
			JOptionPane.showMessageDialog(this, "Su equipo se ha creado exitosamente, su nuevo saldo es de: $" + ((Participante)this.app.getUsuarioActivo()).getPresupuesto(),"",JOptionPane.INFORMATION_MESSAGE);
			vUsuario = new VentanaUsuario(this);
		}
		else if(resp==1) {
			JOptionPane.showMessageDialog(this, "Error: Ya existe un equipo, para crear un nuevo equipo, elimine el anterior","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==2) {
    		JOptionPane.showMessageDialog(this, "Error: Numero de arqueros. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==3) {
    		JOptionPane.showMessageDialog(this, "Error: Numero de defensas. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==4) {
    		JOptionPane.showMessageDialog(this, "Error: Numero de mediocampistas. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==5) {
    		JOptionPane.showMessageDialog(this, "Error: Numero de delanteros. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==6) {
    		JOptionPane.showMessageDialog(this, "Error: Saldo insuficiente","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==7||resp == 9) {
    		JOptionPane.showMessageDialog(this, "Error: Debe seleccionar 15 jugadores para crear el equipo.","Error",JOptionPane.ERROR_MESSAGE);	
    	}
    	else if(resp == 10) {
    		JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para su equipo","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp == 11) {
    		JOptionPane.showMessageDialog(this, "Debe seleccionar 15 jugadores diferentes","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if (resp== 4) {
    		JOptionPane.showMessageDialog(this, "No sé permite crear equipos en esta fecha, intente de nuevo el día siguiente al último partido de la jornada.","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public int CambiarAlineacion(ArrayList<String> seleccion) {
		int resp = this.app.cambiarAlineacionV2(seleccion);
		if(resp == 1||resp == 3) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un titular y un suplente para hacer el cambio","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(resp == 2) {
			JOptionPane.showMessageDialog(this, "Los jugadores deben jugar en la misma posición","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if (resp == 0) {
			JOptionPane.showMessageDialog(this, "Se ha realizado el cambio","",JOptionPane.INFORMATION_MESSAGE);
		}
		else if (resp== 4) {
    		JOptionPane.showMessageDialog(this, "No sé puede modificar el equipo en esta fecha, intente de nuevo el día siguiente al último partido de la jornada.","Error",JOptionPane.ERROR_MESSAGE);
		}
		return resp;
	}

	public int cambiarCapitan(ArrayList<String> seleccion) {
		int resp = this.app.cambiarCapitanV2(seleccion);
		if(resp == 1) {
			JOptionPane.showMessageDialog(this, "Seleccione solo 1 jugador","Error",JOptionPane.ERROR_MESSAGE);
		}
		if(resp == 2) {
			JOptionPane.showMessageDialog(this, "El jugador debe ser parte de la nomina titular.","Error",JOptionPane.ERROR_MESSAGE);
		}
		if (resp == 0) {
			JOptionPane.showMessageDialog(this, "Se ha realizado el cambio","",JOptionPane.INFORMATION_MESSAGE);
		}
		else if (resp== 3) {
    		JOptionPane.showMessageDialog(this, "No sé puede modificar el equipo en esta fecha, intente de nuevo el día siguiente al último partido de la jornada.","Error",JOptionPane.ERROR_MESSAGE);
		}
		return resp;
	}
	
	public int cargarConfiguracionTemp(String rutaJugadores, String rutaPartidos) {
		int resp = this.app.cargarConfiguracionTemporada(rutaJugadores, rutaPartidos);
		if (resp == 3) {
			JOptionPane.showMessageDialog(this, "Ya existe la informacion de una temporada, para configurar otra, por favor elimine temporada actual","Error",JOptionPane.ERROR_MESSAGE);
    		
    	}
    	else if(resp == 2|| resp == 1) {
    		
    		JOptionPane.showMessageDialog(this, "Los archivos seleccionados no existen, por favor revise que las rutas sean correctas","Error",JOptionPane.ERROR_MESSAGE);
    		
    	}
    	else if (resp == 0) {
    		JOptionPane.showMessageDialog(this, "La información se ha cargado exitosamente!","",JOptionPane.INFORMATION_MESSAGE);
    		this.temporadaConfigurada = true;
    	}
		return resp;
	}
	
	public int cargarResulPartido(String rutaPartido) {
		//falta verficar los casos de los enteros de la respuesta
		
		int resp = this.app.cargarResultadoPartido(rutaPartido);
		return resp;
	}

	public int venderJugador(ArrayList<String>seleccion) {
		int resp = this.app.venderJugadorV2(seleccion);
		if(resp == 1) {
			JOptionPane.showMessageDialog(this, "Su equipo tiene menos de 15 jugadores, para vender más jugadores, compre un jugador antes","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if(resp == 2||resp == 3) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar 1 jugador","Error",JOptionPane.ERROR_MESSAGE);
		}
		else if (resp == 0) {
			JOptionPane.showMessageDialog(this, "El jugador se ha vendido, recuerde que para poder guardar los cambios realizados, debe comprar un jugador.","",JOptionPane.INFORMATION_MESSAGE);
		}
		else if (resp== 4) {
    		JOptionPane.showMessageDialog(this, "No sé puede modificar el equipo en esta fecha, intente de nuevo el día siguiente al último partido de la jornada.","Error",JOptionPane.ERROR_MESSAGE);
		}
		return resp;
	}

	public void abrirComprarJugador() {
		vComprar = new VentanaComprar(this);
	}

	public void verEtadisticas() {
		vEstadisticas = new VentanaEstadisticas(this);
	}

	public void comprarJugador(ArrayList<Jugador> jugadoresComprar) {
		int resp = this.app.comprarJugadorV2(jugadoresComprar);
		if (resp == 0) {
			this.vUsuario.actualizarVentana();
			this.vComprar.dispatchEvent(new WindowEvent(vComprar, WindowEvent.WINDOW_CLOSING));
			JOptionPane.showMessageDialog(this, "Compra exitosa, su nuevo saldo es: " + Double.toString(((Participante)this.app.getUsuarioActivo()).getPresupuesto()),"",JOptionPane.INFORMATION_MESSAGE);
			
		}
    	else if(resp==1) {
    		System.out.println("\nError: El número digitado no corresponde a ningun jugadorr");
    	}
    	else if(resp==1) {
			JOptionPane.showMessageDialog(this, "Ya existe un equipo, para crear un nuevo equipo, elimine el anterior","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==2) {
    		JOptionPane.showMessageDialog(this, "Numero de arqueros. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==3) {
    		JOptionPane.showMessageDialog(this, "Numero de defensas. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==4) {
    		JOptionPane.showMessageDialog(this, "Numero de mediocampistas. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==5) {
    		JOptionPane.showMessageDialog(this, "Numero de delanteros. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==6) {
    		JOptionPane.showMessageDialog(this, "Saldo insuficiente","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if(resp==7) {
    		
    		JOptionPane.showMessageDialog(this, "Su equipo está lleno, para comprar un nuevo jugador, primero venda otro.","Error",JOptionPane.ERROR_MESSAGE);
    	}
    	else if (resp== 8) {
    		JOptionPane.showMessageDialog(this, "No sé puede modificar el equipo en esta fecha, intente de nuevo el día siguiente al último partido de la jornada.","Error",JOptionPane.ERROR_MESSAGE);
		}
    	else if (resp== 9) {
    		JOptionPane.showMessageDialog(this, "Seleccione solo un jugador.","Error",JOptionPane.ERROR_MESSAGE);
		}
    	else if (resp== 11) {
    		JOptionPane.showMessageDialog(this, "El Jugador seleccionado ya hace parte de su equipo, por favor seleccione otro","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void mostrarEstadisticasEquipo() {
		this.vEstEquipo = new VentanaEstadisticaEquipo(this);
		
	}

	public void mostrarEstadisticasJornada() {
		this.vEstJornada = new VentanaEstadisticaJornada(this);
		
	}

	public void mostrarEstadisticasTemporada() {
		this.vEstTemporada = new VentanaEstadisticaTemporada(this);
		
	}

	public void cerrarSesionAdmin() {
		this.app.cerrarSesion();
		this.vAdministrador.dispose();
		JOptionPane.showMessageDialog(this, "Su sesión se ha cerrado.","",JOptionPane.INFORMATION_MESSAGE);
		this.vInicio = new VentanaInicio(this);
	}

	public void borrarTemporada() {
		this.app.borrarArchivosTemporada();
		JOptionPane.showMessageDialog(this, "Se ha eliminado la información de la temporada.","",JOptionPane.INFORMATION_MESSAGE);
		this.temporadaConfigurada = false;
	}
	public void borrarEquipo() {
		this.app.borrarEquipo();
		JOptionPane.showMessageDialog(this, "Su equipo se ha eliminado.","",JOptionPane.INFORMATION_MESSAGE);
		this.vUsuario.dispose();
		this.vCrear = new VentanaCrearEquipo(this);
	}
	public void cerrarSesionUsuario() {
		this.app.cerrarSesion();
		this.vUsuario.dispose();
		JOptionPane.showMessageDialog(this, "Su sesión se ha cerrado.","",JOptionPane.INFORMATION_MESSAGE);
		this.vInicio = new VentanaInicio(this);
	}
}
