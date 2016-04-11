
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
public class MatrizXML implements MatrizTDA {
    
    
    private double[][]  matriz;
    
    private int renglones;
    private int columnas;
    
    
  
    MatrizXML(String xmlName){
        

        try{
            
            useJDOM(xmlName);
            
        }catch(JDOMException | IOException e){
            

        }   
          
    }
/**
 * Metodo que va iniciar Jdom para lectura y escritura de archivos XML
 * @param xmlOtroNombre elNombre original del archivo.
 * @throws JDOMException Excepcion de JDOM
 * @throws IOException Excepcion del sistema.
 */
    
    private  void useJDOM(String xmlOtroNombre) throws JDOMException,IOException {

        
        
        SAXBuilder jdomBuilder = new SAXBuilder();
        File inputFile = new File(xmlOtroNombre);
        Document jdomDocument = jdomBuilder.build(inputFile);
        Element firstElement = jdomDocument.getRootElement();
        
        renglones = firstElement.getChildren().size();
        int c = 0;
        for (Element secondElement: firstElement.getChildren())
        {
            if(secondElement.getChildren().size()>c)
                c = secondElement.getChildren().size();
            
        }
        columnas = c;
        
        matriz = new double[renglones][columnas];
        recursionJDOM(firstElement, 0);

        
    }
     /**
     * Metodo recursivo para iterar los elementos del Jdom.
     *
     * @param currentElement Elemento current
     * @param cont Contador para saber la profundidad de la iteracion
     */
    
    private void recursionJDOM(Element currentElement, int cont)
    {
       
        List<Element> currentChildren = currentElement.getChildren();
        
        int count = 0;
        for (Element innerChild : currentChildren) {
            
            int innerCount = 0;
            for (Element small : innerChild.getChildren()) {
             
                matriz[count][innerCount] =  Double.parseDouble(small.getTextNormalize()); 
                innerCount ++;
            }
            count++;
        
        }
        
    }
    /**
     * Metodo implementado de MatrizTDA
     * Que regresa numero de Columnas.
     * @return columnas
     */
    
    @Override
    public int numberOfColumns() {
       
        return columnas;
        
    }
    /**
     * Metodo implementado del MatrizTDA
    * Que regresa numero de Renglones.
    * @return renglones
    */
    @Override
    public int numberOfRows() {
        
        return renglones ;
    }
    /**
    * Metodo implementado del MatrizTDA
    * Que regresa numero de Renglones.
    * @return el elemento que se encunetra en la ubicaccion x, y.
    */
    @Override
    public double getElement(int x, int y) {
        return matriz [y][x];
    }
    /**
    * Metodo implementado del MatrizTDA
    * Que cambia el valor de un punto en la matriz.
    * @param x son los renglones de la matriz.
    * @param y son las calumnas de la matriz.
    * @param newValue es el valor modificado a entrar en la Matriz.
    * @return exito saber que se pudo cambiar el valor.
    */
    @Override
    public boolean setElement(int x, int y, double newValue) {
        boolean exito = false;
        if (x<0 || y<0 || x>=renglones || y>= columnas ){
          System.out.println ("Out of bounds.");
        }
          else {
            
        matriz [y] [x] = newValue; 
        exito=true;
                  
                  }
        
        return exito;
        
        
    }
    /**
    * Metodo implementado del MatrizTDA
    * Que multiplica la Matriz por un escalar arbitrario.
    * @param scalar numero arbitrario.
    */
    @Override
    public void multipyByScalar(double scalar) {
        

    for(int i=0 ; i<columnas ; i++)
            for (int j=0 ;j<renglones ; j++)
            {
                
                matriz[j][i]*= scalar;
            }
    
    }
    /**
    * Metodo implementado del MatrizTDA
    * Que hace la transpuesta a nuestra Matriz.
    */
    @Override
    public void transposed() {
        double[][]  finalMatriz =  new double[columnas][renglones];
        
//        
        System.out.println("Cols: "+columnas + " Rows: "+ renglones+"\n");
        
        
         for(int i=0 ; i<renglones ; i++)
            for (int j=0 ;j<columnas ; j++)
            {
            

                    finalMatriz[j][i] = matriz[i][j];
                
                
            }
       
        int fixRenglones = renglones;
        
        renglones = columnas;
        columnas = fixRenglones;
         matriz=finalMatriz;
        
    }

    /**
    * Metodo implementado del MatrizTDA
    * Que suma nuestras Matrices.
    * @param m recibe una Matriz.
    * @throws ExcepcionIndiceInvalido Si nuestro indice esta equivocado.
    */
    @Override
    public void plusMatriz(MatrizTDA m) throws ExcepcionMemoria {
        
        
        if (m == null)
            return;
        if(m.numberOfColumns()!=this.numberOfColumns() ||
           m.numberOfRows()!=this.numberOfRows())
            
            throw new ExcepcionMemoria("No se pueden sumar matrices de diferentes tamanos");
        
        
        for(int i=0 ; i< m.numberOfColumns() ; i++)
            for (int j=0 ;j<m.numberOfRows() ; j++)
                this.matriz[j][i]+=m.getElement(i,j);
    }
    /**
    * Metodo implementado del MatrizTDA
    * Que compara dos matrices para saber si son iguales.
    * @param m Recibe una matriz
    * @return m2 
    */
     @Override
    public boolean isEqual(MatrizTDA m) {
           
        if (m == null)
            return false;
        if (getClass() != m.getClass())
            return false;
        MatrizXML m2 = (MatrizXML)m;
        
        return isEqual(m2);
    }
    /**
    * Metodo implementado del MatrizTDA
    * Que compara dos matrices para saber si son iguales.
    * @param georgina Recibe una Matriz.
    * @return true si resulta igual.
    */
    private boolean isEqual(MatrizXML georgina) {
        
        if(georgina.numberOfColumns()!=this.numberOfColumns() ||
           georgina.numberOfRows()!=this.numberOfRows())
            return false;
        for(int i=0 ; i< georgina.columnas ; i++)
            for (int j=0 ;j<georgina.renglones ; j++) 
               if (matriz[j][i]!=georgina.matriz[j][i])
                   return false;
                  
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
        String s = "";
        for(int i = 0 ; i<renglones;i++)
        {
            
            for(int c = 0 ; c<columnas;c++)
            {
                s+="["+matriz[i][c] +"] ";
            }
            s+="\n";
        }
               
        return s;
    }
    
    
}
