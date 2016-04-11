
package fciencias.edatos.practica04;

import java.io.File;
import java.io.IOException;
import java.util.List;
  
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


/**
 * Esta clase implmenta nuestro TDA MatrizProtocol
 * @author Adrian Ibarra Fragoso, 311261871
 */
public class Catalogo <T extends Profesor>  implements CatalogoTDA< T>{
    
    private Lista<T> listaProfesores;
    
    
    
    Catalogo(String baseDeDatos){
        
    
        listaProfesores = new Lista<T>();

        try{
            
            useJDOM(baseDeDatos);
            
        }catch(JDOMException | IOException e){
            

        }   
          
    }
/**
 * Metodo que va iniciar Jdom para lectura y escritura de archivos XML
 * @param xmlOtroNombre elNombre original del archivo.
 * @throws JDOMException Excepcion de JDOM
 * @throws IOException Excepcion del sistema.
 */
    
    private  void useJDOM(String baseDeDatos) throws JDOMException,IOException {

        
        
        SAXBuilder jdomBuilder = new SAXBuilder();
        File inputFile = new File(baseDeDatos);
        Document jdomDocument = jdomBuilder.build(inputFile);
        Element firstElement = jdomDocument.getRootElement();
        
        
        
        //Estos son los profesores
       for( Element elementProfesor: firstElement.getChildren())
       {
           int[] salario = new int[12];
           int c = 0;
           for (Element elementSalario: elementProfesor.getChildren())
           {
               String salarioRealEnString = elementSalario.getValue();
               int salarioRealMes = Integer.parseInt(salarioRealEnString);
               
               
               
               salario[c] = salarioRealMes;
               c++;
               
           }
           
           
//           System.out.println(Arrays.toString(salario));
           
           
           String id = elementProfesor.getAttributeValue("id");
           int id_int = Integer.parseInt(id);
           String nombre = elementProfesor.getAttributeValue("nombre");
           String carreraString = elementProfesor.getAttributeValue("carrera");
           Carrera carrera = Carrera.NO_CARRERA;
           
           if (carreraString.equals("MATEMATICAS"))
           {
               carrera = Carrera.MATEMATICAS;
           }
           else if (carreraString.equals("ACTUARIA"))
           {
                          carrera = Carrera.ACTUARIA;}
           else if (carreraString.equals("FISICA"))
           {
                          carrera = Carrera.FISICA;}
           else if (carreraString.equals("BIOLOGIA"))
           {
                          carrera = Carrera.BIOLOGIA;}
           else if (carreraString.equals("CIENCIAS_DE_LA_COMPUTACION"))
           {
                          carrera = Carrera.CIENCIAS_DE_LA_COMPUTACION;}
           else if (carreraString.equals("FISICA_BIOMEDICA"))
           {
                          carrera = Carrera.FISICA_BIOMEDICA;}
           else if (carreraString.equals("CIENCIAS_DE_LA_TIERRA"))
           {
                          carrera = Carrera.CIENCIAS_DE_LA_TIERRA;
           }
           
           
           String gradoString = elementProfesor.getAttributeValue("grado");
           
           Grado grado = Grado.NO_GRADO;
           
           if (gradoString.equals("LICENCIADO"))
           {
               grado = Grado.LICENCIADO;
           }
           else if (gradoString.equals("MAESTRO"))
           {
               grado = Grado.MAESTRO;
           }
           else if (gradoString.equals("DOCTOR"))
           {
               grado = Grado.DOCTOR;
           }
           
           else if (gradoString.equals("ESPECIALISTA"))
           {
               grado = Grado.ESPECIALISTA;
           }
           
           
           
           
           Profesor profestorEnMemoria= null;


           profestorEnMemoria = new Profesor(id_int, nombre, carrera, grado, salario);
           
           
           
          @SuppressWarnings("unchecked") T prof = (T)profestorEnMemoria;

           
           listaProfesores.agregaFinal(prof);
           
       }
        
    }
    @Override
    public void agregaProfesor(T prof){
        
        listaProfesores.agregaFinal(prof);
        
    }
    
    
    /*
     * Metodo para saber numero de Renglones
     * @return el numero de renglones de la matriz
     */
    @Override
    public void eliminaProfesor(int id){
        
        
        
        @SuppressWarnings("unchecked") T prof = (T)new Profesor(id);

        listaProfesores.elimina(prof);
        
    }
    
    
    
//    /**
//    * Metodo implementado del MatrizTDA
//    * Que compara dos matrices para saber si son iguales.
//    * @param m Recibe una matriz
//    * @return m2 
//    */
//     @Override
//    public boolean isEqual(MatrizTDA m) {
//           
//        if (m == null)
//            return false;
//        if (getClass() != m.getClass())
//            return false;
//        MatrizXML m2 = (MatrizXML)m;
//        
//        return isEqual(m2);
//    }
    /**
    * Metodo implementado del MatrizTDA
    * Que compara dos matrices para saber si son iguales.
    * @param georgina Recibe una Matriz.
    * @return true si resulta igual.
    */
    private boolean isEqual(Object  hey) {
        
        return true;
    }
    /**
    * Metodo implementado de la clase Object
    * Que sirve para representar el objecto en texto legible.
    * @return el elemento que se encunetra en la ubicaccion x, y.
    */      
    @Override
    public String toString()
    {
        
        
        return listaProfesores.toString();
    }
    
    public String convertirXML(){
        String archivoXML_Final = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n"
       +" <!-- To change this license header, choose License Headers in Project Properties."
        + "\n"
        +"To change this template file, choose Tools | Templates"+ "\n"
        +"and open the template in the editor."+ "\n"
       +" -->"+ "\n"
        +"<!DOCTYPE cache SYSTEM " +" \"catalogo.dtd\" >"+ "\n"
        
        +"<catalogo>" + "\n";
        
        
        //Nuestro codigo miedrda;
        
        for(T prof: listaProfesores)
        {
            archivoXML_Final+=prof.tag();
        }
//
        
        
        archivoXML_Final+="</catalogo>" + "\n";
        
        return archivoXML_Final;
    }
    
    
}
