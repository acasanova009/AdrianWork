package fciencias.edatos.practica02;

/**
 * <p>Aqui creamos 3 diferentes matrices
 * Y obtenemos elementos de ellas
 * Cambiamos elementos, comparamos si son iguales
 * Medimos el tiempo de ejecucion de cada operacion
 * Aplicamos la transpuesta.</p>
 * @author Adrian Ibarra Fragoso, 311261871.
 */
public class Practica02 {

    /**
     * Metodo Main
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hola");
        
        recrusiveExample('c',5);
//        rec('c',5);
    }
    static public void rec(char c, int i)
    {
        recursive(c,i);
    }
    
    static public void recursive(char c, int i )
    {
        if(i>0)
            
        {
            System.out.print (c);
            recursive(c,i-1);
        }
            

        
        
    }
    
    
    static public void whileExample(char c, int i )
    {
        
        while(i !=0)
        {
            //imprimir c
            //y despues?
            //
                        System.out.print (5);
            
            i--;
        }
    }
    static public void recrusiveExample(char c, int i  )
    {
        if(i!=0)
        {
         
            recrusiveExample(c, --i);

            System.out.print (c);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
