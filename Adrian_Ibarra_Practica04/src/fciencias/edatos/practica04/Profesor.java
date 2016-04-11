
package fciencias.edatos.practica04;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//  
//import org.jdom2.Document;
//import org.jdom2.Element;
//import org.jdom2.JDOMException;
//import org.jdom2.input.SAXBuilder;


/**
 * Esta clase implmenta nuestro TDA MatrizProtocol
 * @author Adrian Ibarra Fragoso, 311261871
 */



public class Profesor implements PersonaTDA{
    
    
    private int id;
    private String nombre;
    private Carrera carrera;
    private Grado grado;
    private int[] salarios;
    
    Profesor(int id)
    {
        this.id=id;
        nombre="";
        carrera = Carrera.NO_CARRERA;
        grado= Grado.NO_GRADO;
        salarios =null;
    }
    
  
    Profesor(int numeroDeEmeplado, String nombre, Carrera laCarrera, Grado elGrado, int[] salarios){
        this.id = numeroDeEmeplado;
        this.nombre = nombre;
        this.carrera = laCarrera;
        this.grado = elGrado;
        this.salarios = salarios;
    
        //
        
    }
    
    @Override
    public String getNombre(){
        
        return nombre;
        
    }
    
    
    /**
    * Metodo implementado de la clase Object
    * Que sirve para representar el objecto en texto legible.
    * @return el elemento que se encunetra en la ubicaccion x, y.
    */      
    @Override
    public String toString()
    {
//               System.out.println(Arrays.toString(array));
  
                    String misSalarios = "";
        if(salarios!=null)
        {
            misSalarios = "[";

            for(int i= 0 ;i<12;i++)
            {
                misSalarios+=salarios[i]+", ";
            }
            misSalarios +="]";
        }
        
        return "id: "+id+" "+nombre+" "+ this.grado+" "+this.carrera+"\n";
    }
    
    public String tag()
    {
        String profStringXML = "<profesor  id=\""+id+"\" nombre=\""+nombre+"\" carrera=\""+carrera+"\" grado=\""+grado+"\""+">\n";
        
        
        String misSalarios = "";
        if(salarios!=null)
        {

            

            for(int i= 0 ;i<12;i++)
            {
                misSalarios+= "    <salarios>" + salarios[i]+ "</salarios>"+"\n";
            }

        }
        profStringXML+=misSalarios;
        profStringXML+="</profesor>\n";
        
        return profStringXML;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Profesor prof = (Profesor)o;
        
        if(prof.id == this.id)
            
            return true;
        else
            return false;
    }
    
    
}
