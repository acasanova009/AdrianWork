package fciencias.edatos.practica04;

/**
 * <p>Aqui creamos 3 diferentes matrices
 * Y obtenemos elementos de ellas
 * Cambiamos elementos, comparamos si son iguales
 * Medimos el tiempo de ejecucion de cada operacion
 * Aplicamos la transpuesta.</p>
 * @author Adrian Ibarra Fragoso, 311261871.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
public class Practica04 {

    /**
     * Metodo Main
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Leer XML.
        
        Catalogo<Profesor> catalogo = new Catalogo("catalogo.xml");
    
        
        catalogo.agregaProfesor(new Profesor(123456));
        
        catalogo.eliminaProfesor(123456);
        
        
        writeStringToFile(catalogo.convertirXML(),new File("catalogo.xml"));
        
        
        
    }
    private static void writeStringToFile(String stringToWrite, File file)
    {
        
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            OutputStreamWriter osOut = new OutputStreamWriter(fileOut);
            BufferedWriter out = new BufferedWriter(osOut);
            out.write(stringToWrite);
            out.close();
            
        } catch (IOException ioe) {
            System.exit(1);
        }
    }
}