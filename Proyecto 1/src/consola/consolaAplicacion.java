package consola;
import procesamiento.Aplicacion;
import java.io.BufferedReader;          
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import modelo.EquipoFantasia;
import modelo.Jugador;
import modelo.Participante;

public class consolaAplicacion {
    private Aplicacion aplicacion;
    public void ejecutarAplicacion(){
    	int respInicioSesion;
    	int respCrearCuenta;
    	int opcionSeleccionada;
    	aplicacion = new Aplicacion();
    	int respCargarData = cargarDataActual();
    	boolean iniciarAplicacion = true;
    	boolean sesionIniciada = false;
    	while(iniciarAplicacion) {
    		menuInicio();
    		opcionSeleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
    		if (opcionSeleccionada == 1) {
    			respInicioSesion = ejecutarIniciarSesion();
    			if(respInicioSesion == 0) {
    				sesionIniciada = true;
    			}
    		}
    		else if (opcionSeleccionada == 2) {
    			respCrearCuenta = ejecutarCrearCuenta();
    			if (respCrearCuenta == 0) {
    				sesionIniciada =true;
    			}
    		}
    		else if (opcionSeleccionada == 0) {
    			
    		}
    		else {
    			System.out.println("\nPor favor seleccione una opcion valida");
    		}
    		while(sesionIniciada) {
    			if (aplicacion.getUsuarioActivo().getClass().getName() == "modelo.Administrador") {
    				menuAdmin();
    				opcionSeleccionada =Integer.parseInt(input("\nPor favor seleccione una opción"));
    				if(opcionSeleccionada == 1){
    					ejecutarCargarConfiguracionTemporada();
    				}
    				else if(opcionSeleccionada == 2){
    					ejecutarCargarResultadosPartido();
    				}
    				else if(opcionSeleccionada == 3){
    					
    				}
    				else if(opcionSeleccionada == 4){
    					ejecutarBorrarInformacionTemporada();
    				}
    				else if(opcionSeleccionada == 0){
    					ejecutarCerrarSesion();
    					sesionIniciada = false;
    				}
    				else {
    					System.out.println("\nPor favor seleccione una opción valida.");
    				}
    			}
    			
    			else if (aplicacion.getUsuarioActivo().getClass().getName() ==  "modelo.Participante") {
    				if (respCargarData == 0) {
    					menuParticipante();
    					opcionSeleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
    				}
    				else {
    					System.out.println("Aún no se ha cargado la configuración de la temporada. Por favor vuelva más tarde.");
    					opcionSeleccionada = 0;
    				}
    				if(opcionSeleccionada == 1){
    					ejecutarCrearEquipo();
    				}
    				else if(opcionSeleccionada == 2){
    					ejecutarBorrarEquipo();
    				}
    				else if(opcionSeleccionada == 3){
    					verAlineacionEquipo();
    				}
    				else if(opcionSeleccionada == 5){
    					ejecutarCambiarCapitan();
    				}
    				else if(opcionSeleccionada == 4){
    					ejecutarCambiarAlineacion();
    				}
    				else if(opcionSeleccionada == 6){
    					ejecutarComprarJugador();
    				}
    				else if(opcionSeleccionada == 7){
    					ejecutarVenderJugador();
    				}
    				else if(opcionSeleccionada == 8){
    					verEstadisticasEquipo();
    				}
    				else if(opcionSeleccionada == 9){
    					verEstadisticasJornada();
    				}
    				else if(opcionSeleccionada == 10){
    					verEstadisticasTemporada();
    				}
    				else if(opcionSeleccionada == 11){
    					ejecutarGuardarCambiosParticipante();
    				}
    				else if(opcionSeleccionada == 0){
    					ejecutarCerrarSesion();
    					sesionIniciada = false;
    				}
    				else {
    					System.out.println("\nPor favor seleccione una opcion valida");
    				}
    			}
    		}
    	}
    }
    private void verEstadisticasTemporada() {
    	Jugador mejorJugador = this.aplicacion.mejorJugadorActual();
    	EquipoFantasia mejorEquipo = this.aplicacion.mejorEquipoActual();
    	String sPuntos = Double.toString(mejorEquipo.getPuntosJornada().get(0));
    	for (int i = 1; i<mejorEquipo.getPuntosJornada().size();i++) {
			sPuntos += ", " + Double.toString(mejorEquipo.getPuntosJornada().get(i));
		}
    	System.out.println("El mejor equipo de la temporada es: ");
		System.out.println("Nombre: "+mejorEquipo.getNombre());
		System.out.println("Puntos totales: "+ Double.toString(mejorEquipo.getPuntosTotales()));
		System.out.println("Puntos jornada: "+ sPuntos);
		
		sPuntos = Double.toString(mejorJugador.getPuntosJornada().get(0));
		for (int i = 1; i<mejorJugador.getPuntosJornada().size();i++) {
			sPuntos += ", " + Double.toString(mejorJugador.getPuntosJornada().get(i));
		}
		System.out.println("\nEl mejor jugador de la temporada es: ");
		System.out.println("Nombre: "+mejorJugador.getNombre());
		System.out.println("Puntos totales: "+ Double.toString(mejorJugador.getPuntosTotales()));
		System.out.println("Equipo: "+ mejorJugador.getNombreEquipo());
		System.out.println("Puntos jornada: "+ sPuntos);
		
	}
	private void verEstadisticasJornada() {
		int numJornada = Integer.parseInt(input("Ingrese el numero de la jornada de la que quiere consultar la información"));
		Jugador mejorJugador = this.aplicacion.mejorJugadorFecha(numJornada);
		EquipoFantasia mejorEquipo = this.aplicacion.mejorEquipoFecha(numJornada);
		
		System.out.println("El mejor equipo de la jornada "+ Integer.toString(numJornada) + " fue: ");
		System.out.println("Nombre: "+mejorEquipo.getNombre());
		System.out.println("Puntos totales hasta la jornada: "+ Double.toString(mejorEquipo.getPuntosTotales()));
		System.out.println("Puntos jornada: "+ Double.toString(mejorEquipo.getPuntosJornada().get(numJornada-1)));
		
		System.out.println("\nEl mejor jugador de la jornada "+ Integer.toString(numJornada) + " fue: ");
		System.out.println("Nombre: "+mejorJugador.getNombre());
		System.out.println("Puntos totales hasta la jornada: "+ Double.toString(mejorJugador.getPuntosTotales()));
		System.out.println("Puntos jornada: "+ Double.toString(mejorJugador.getPuntosJornada().get(numJornada-1)));
		System.out.println("Equipo: "+ mejorJugador.getNombreEquipo());
		
	}
	private void verEstadisticasEquipo() {
    	ArrayList<Double> puntosJornada = ((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getPuntosJornada();
    	String sPuntos = Double.toString(puntosJornada.get(0));
    	int posicionActual = this.aplicacion.encontrarPosicion();
		System.out.println("Nombre: " + ((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getNombre());
		System.out.println("Posicion Actual: " + Integer.toString(posicionActual+1));
		System.out.println("Puntos totales: "+Double.toString(((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getPuntosTotales()));
		
		for (int i = 1; i<puntosJornada.size();i++) {
			sPuntos += ", " + Double.toString(puntosJornada.get(i));
		}
		System.out.println("Puntos por jornada: " + sPuntos);
	}
	private void ejecutarCambiarCapitan() {
    	mostrarJugadores(((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getTitulares());
    	int nuevoCapitan = Integer.parseInt(input("\nSeleccione el jugador titular que quiere que sea el capitan."));
    	this.aplicacion.cambiarCapitan(nuevoCapitan);
	}
	private void ejecutarCargarResultadosPartido() {
    	String rutaResultadoPartido = input("Por favor ingrese la ruta del archivo con el resultado del partido que desea cargar");
    	int resp = this.aplicacion.cargarResultadoPartido(rutaResultadoPartido);
		System.out.println(Integer.toString(resp));
	}
	public void ejecutarBorrarInformacionTemporada() {
    	System.out.println("¿Está seguro que desea eliminar la configuración de la temporada?");
    	menuConfirmarBorrar();
    	int respuesta = Integer.parseInt(input("Por favor seleccione una opción"));
    	if(respuesta == 1) {
    		this.aplicacion.borrarArchivosTemporada();
    	}
    }
    public void verAlineacionEquipo() {
    	System.out.println("Capitan: " + ((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getCapitan().getNombre());
    	System.out.println("Titulares:\n");
    	mostrarJugadores(((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getTitulares());
    	System.out.println("Suplentes:\n");
    	mostrarJugadores(((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getSuplentes());
    }
    public void ejecutarCambiarAlineacion() {
    	verAlineacionEquipo();
    	System.out.println("\nRecuerse que para poder hacer el cambio, los jugadores deben jugar en la misma posicion.");
    	int nuevoTitular = Integer.parseInt(input("\nSeleccione el suplente que desea agregar a la formación titular"));
    	int nuevoSuplente = Integer.parseInt(input("\nSeleccione el titular que quiere poner de suplente"));
    	int resp = this.aplicacion.cambiarAlineacion(nuevoTitular, nuevoSuplente);
    	if (resp== 0) {
			System.out.println("\nSu equipo ha sido modificado exitosamente.");
		}
    	else if (resp== 1) {
			System.out.println("\nError: Los jugadores seleccionados no juegan en la misma posición.");
		}
    	else if (resp== 2) {
			System.out.println("\nError: Los números seleccionados no son validos.");
		}
    	else if (resp== 3) {
			System.out.println("\nError: No sé puede modificar el equipo mientras en esta fecha, intente de nuevo el día siguiente al último partido de la jornada.");
		}
    }
    public int cargarDataActual(){
        aplicacion.cargarParticipantes();
        aplicacion.cargarAdministrador();
        int resp = aplicacion.cargarTemporadaActual();
        if (resp == 0) {
        	aplicacion.actualizarReferencias();
        	aplicacion.actualizarRankingEquipos();
        	aplicacion.actualizarRankingJugadores();
        }
        return resp;
    }
    public void ejecutarCargarConfiguracionTemporada() {
    	String rutaJugadores = input("Por favor ingrese la ruta del arcchivo con la información de los jugadores");
    	String rutaPartidos = input("Por favor ingrese la ruta del archivo con la información de los partidos");
    	int resp = this.aplicacion.cargarConfiguracionTemporada(rutaJugadores, rutaPartidos);
    	if (resp == 3) {
    		System.out.println("Error: Ya existe la informacion de una temporada, para configurar otra, por favor elimine temporada actual");
    	}
    	else if(resp == 2|| resp == 1) {
    		System.out.println("Error: Los archivos seleccionados no existen, por favor revise que las rutas sean correctas");
    	}
    	else if (resp == 0) {
    		System.out.println("La información se ha cargado exitosamente!");
    	}
    }
    public int ejecutarIniciarSesion() {
    	String nombreUsuario = input("\nIngrese su nombre de usuario");
    	String contraseña = input("\nIngrese su contraseña");
    	int resp = aplicacion.iniciarSesion(nombreUsuario, contraseña);
    	
    	if (resp == 0) {
    		System.out.println("\nInicio de sesión exitoso!\n" + "\nBienvenido " + aplicacion.getUsuarioActivo().getNombreUsuario() + "!");	
    	}
    	if (resp == 2) {
    		System.out.println("\nError al iniciar sesión: El nombre de usuario no existe.");
    	}
    	if (resp == 1) {
    		System.out.println("\nError al iniciar sesión: La contraseña no es correcta.");
    	}
    	return resp;
    }
    public int ejecutarCrearCuenta() {
    	String nombreUsuario = input("\nIngrese un nombre de usuario");
    	String contraseña = input("\nIngrese una contraseña");
    	int resp = aplicacion.crearCuenta(nombreUsuario, contraseña);
    	if(resp == 0) {
    		System.out.println("\nSu usuario se ha creado exitosamente!");
    		aplicacion.iniciarSesion(nombreUsuario, contraseña);
    	}
    	if(resp == 1) {
    		System.out.println("\nEl nombre de usuario seleccionado ya esta en uso, seleccione otro y vuelva a intentarlo");
    	}
    	return resp;
    }
    public void ejecutarCerrarSesion() {
    	this.aplicacion.cerrarSesion();	
    }
    public void ejecutarComprarJugador() {
    	mostrarJugadores(this.aplicacion.getTemporada().getJugadores());
    	int numJugador = Integer.parseInt(input("\nDigite el número del jugador que desea comprar"));
    	int resp = this.aplicacion.comprarJugador(numJugador);
    	if (resp == 0) {
    		System.out.println("\nCompra exitosa, su nuevo saldo es: " + Double.toString(((Participante)this.aplicacion.getUsuarioActivo()).getPresupuesto()));
    	}
    	else if(resp==1) {
    		System.out.println("\nError: El número digitado no corresponde a ningun jugadorr");
    	}
    	else if(resp==2) {
    		System.out.println("\nError: Numero de arqueros. Recuerde: No pueden haber más de 2 arqueros");
    	}
    	else if(resp==3) {
    		System.out.println("\nError: Numero de defensas. Recuerde: No pueden haber más de 5 defensores.");
    	}
    	else if(resp==4) {
    		System.out.println("\nError: Numero de mediocampistas. Recuerde: No pueden haber más de 5 mediocampistas.");
    	}
    	else if(resp==5) {
    		System.out.println("\nError: Numero de delanteros. Recuerde: No pueden haber más de 3 delanteros.");
    	}
    	else if(resp==6) {
    		System.out.println("\nError: Saldo induficiente.");
    	}
    	else if(resp==7) {
    		System.out.println("\nError: Su equipo está lleno, para comprar un nuevo jugador, primero venda otro.");
    	}
    	else if (resp== 8) {
			System.out.println("\nError: No sé puede modificar el equipo mientras en esta fecha, intente de nuevo el día siguiente al último partido de la jornada.");
		}
    }
    public void ejecutarVenderJugador() {
    	mostrarJugadores(((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getJugadores());
    	int numJugador = Integer.parseInt(input("\nDigite el número del jugador"));
    	int resp = this.aplicacion.venderJugador(numJugador);
    	if (resp == 0) {
    		System.out.println("\nVenta exitosa, su nuevo saldo es: " + Double.toString(((Participante)this.aplicacion.getUsuarioActivo()).getPresupuesto()));
    	}
    	else if(resp==1) {
    		System.out.println("\nError: El número digitado no corresponde a ningun jugador.");
    	}
    	else if(resp==2) {
    		System.out.println("\nError: Su equipo ya tiene menos de 15 jugadores, para poder vender más su equipo debe estar completo.");
    	}
    	if (resp== 3) {
			System.out.println("\nError: No sé puede modificar el equipo mientras en esta fecha, intente de nuevo el día siguiente al último partido de la jornada.");
		}
    }   
    public void menuInicio(){
    	System.out.println("\n1) Iniciar Sesión");
    	System.out.println("2) Crear Usuario");
    	System.out.println("0) Cerrar Aplicación");
    }
    public void ejecutarCrearEquipo() {
    	double presupuestoInicial = ((Participante)(this.aplicacion.getUsuarioActivo())).getPresupuesto();
    	mostrarJugadores(this.aplicacion.getTemporada().getJugadores());
    	System.out.println("\nSeleccione los jugadores que quiere que hagan parte de su equipo./n Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)");
    	System.out.println("\nRecuerde, usted tiene un presupuesto de: " + presupuestoInicial);
    	String[] jugadoresSeleccionados = input("\nSeleccione el número de todos los jugadores que quiere agregar, separados por comas (',').").trim().split(",");
    	String nombreEquipo = input("\nEscriba un nombre para su equipo");
    	int resp = aplicacion.crearEquipo(jugadoresSeleccionados, nombreEquipo);
    	if(resp==0) {
    		System.out.println("\nSu equipo ha sido creado con los siguientes jugadores: ");
    		int cont = 1;
        	for (int i = 0; i < ((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getJugadores().size(); i++) {
        		System.out.println(Integer.toString(cont) + ". Nombre: " + ((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getJugadores().get(i).getNombre() + ", Posición: " + ((Participante)this.aplicacion.getUsuarioActivo()).getEquipo().getJugadores().get(i).getPosicion());
        		cont++;
        	}
        	System.out.println("\nSu nuevo saldo es de $"+((Participante)(this.aplicacion.getUsuarioActivo())).getPresupuesto());
        	System.out.println("\n¿Desea guardar su equipo?");
        	System.out.println("1) Si");
        	System.out.println("2) No");
        	int opcionSeleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
        	if (opcionSeleccionada == 1) {
        		aplicacion.guardarEquipo();
        	}
        	if(opcionSeleccionada == 2) {
        		System.out.println("\nEstá acción no se puede deshacer, ¿Está seguro de que desea continuar?");
        		menuConfirmarBorrar();
        		opcionSeleccionada = Integer.parseInt(input("\nPor favor seleccione una opción"));
        		if(opcionSeleccionada == 1) {
	        		int respBorrar = aplicacion.borrarEquipo();
	        		if (respBorrar== 0) {
	        			System.out.println("\nSu equipo ha sido eliminado");
	        		}else {
	        			System.out.println("\nHubo un error al eliminar su equipo, por favor vuelva a intentarlo.");
	        		}
        		}
        	}
    	}
    	else if(resp==1) {
    		System.out.println("\nError: Ya existe un equipo, para crear un nuevo equipo, elimine el equipo anterior. También puede modificar el equipo existente.");
    	}
    	else if(resp==2) {
    		System.out.println("\nError: Numero de arqueros. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)");
    	}
    	else if(resp==3) {
    		System.out.println("\nError: Numero de defensas. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)");
    	}
    	else if(resp==4) {
    		System.out.println("\nError: Numero de mediocampistas. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)");
    	}
    	else if(resp==5) {
    		System.out.println("\nError: Numero de delanteros. Recuerde: Debe seleccionar 15 jugadores (2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros)");
    	}
    	else if(resp==6) {
    		System.out.println("\nError: Ya existe un equipo, para crear un nuevo equipo, elimine el equipo anterior. También puede modificar el equipo existente.");
    	}
    	else if(resp==7) {
    		System.out.println("\nError: Debe seleccionar 15 jugadores para crear el equipo.");
    	}
    }
    public void ejecutarBorrarEquipo() {
    	System.out.println("\n¿Está seguro de que quiere eliminar su equipo?");
    	menuConfirmarBorrar();
    	int opcion = Integer.parseInt(input(("\nPor favor seleccione una opción")));
    	if (opcion == 1) {
    		int resp = this.aplicacion.borrarEquipo();
	    	if (resp == 0) {
	    		System.out.println("\nEl equipo ha sido eliminado");
	    	}
	    	if (resp == 1) {
	    		System.out.println("\nUsted aun no ha creado ningún equipo, por favor cree uno.");
	    	}
    	}
    }
    public void menuAdmin(){
    	System.out.println("\n1) Cargar información temporada");
    	System.out.println("2) Cargar resultados partido");
    	//System.out.println("3) Ver configuración temporada");
    	System.out.println("4) Borrar información temporada");
    	System.out.println("0) Cerrar sesión");
    }
    public void menuParticipante() {
    	System.out.println("\n1) Crear equipo");
    	System.out.println("2) Borrar equipo");
    	System.out.println("3) Consultar alineación del equipo");
    	System.out.println("4) Cambiar Alineación");
    	System.out.println("5) Cambiar Capitan");
    	System.out.println("6) Comprar Jugador");
    	System.out.println("7) Vender Jugador");
    	System.out.println("8) Ver estadísticas del equipo");
    	System.out.println("9) Ver estadísticas de la temporada");
    	System.out.println("10) Ver estadísticas por jornada temporada");
    	System.out.println("11) Guardar Cambios");
    	System.out.println("0) Cerrar sesión");
    }
    public void menuConfirmarBorrar() {
    	System.out.println("\n1) Si");
    	System.out.println("2) No");
    }
    public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("\nError leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
    public void mostrarJugadores(ArrayList<Jugador> jugadores) {
    	int cont = 1;
    	for (int i = 0; i < jugadores.size(); i++) {
    		System.out.println(Integer.toString(cont) + ". Nombre: " + jugadores.get(i).getNombre() + ", Posición: " + jugadores.get(i).getPosicion() + ", Precio: " + Double.toString(jugadores.get(i).getPrecio()));
    		cont++;
    	}
    }
    public void ejecutarGuardarCambiosParticipante() {
    	int resp =this.aplicacion.guardarCambiosParticipante();
    	if (resp == 1) {
    		System.out.println("\nPara poder guardar el equipo debe tener 15 participantes. Por favor compre un nuevo jugador, de lo contrario los cambios no serán guardados.");
    	}
    	if (resp == 0) {
    		System.out.println("\nSe ha guardado la información!");
    	}
    }
    public static void main(String[] args)
	{
		consolaAplicacion consola = new consolaAplicacion();
        consola.ejecutarAplicacion();
	}
}