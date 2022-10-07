package consola;
import procesamiento.Aplicacion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;


public class consolaAplicacion {
    private Aplicacion aplicacion;

    public void ejecutarAplicacion(){

    }

    private void cargarDataActual(){
        File archivoParticipantes = new File("data/participantes.json");
        File archivoTemporada = new File("data/configuracionTemporada.json");
        File archivoAdministrador = new File("data/administrador.json");


    }

    public static void main(String[] args)
	{
		consolaAplicacion consola = new consolaAplicacion();
        consola.ejecutarAplicacion();
	}
}
