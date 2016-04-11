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
        
        

        MatrizXML mt1 = new MatrizXML("matriz1.xml");
        MatrizXML mt2 = new MatrizXML("matriz2.xml");
        MatrizXML mt3 = new MatrizXML("matriz3.xml");
        
        System.out.println("Matriz1: \n"+ mt1.toString());
        System.out.println("Matriz2: \n"+ mt2.toString());
        System.out.println("Matriz3: \n"+ mt3.toString());
        long tiempoInicial;
        long tiempoFinal;
        long totalTime;
        
        System.out.println(".............METHOD _ COLUMNS...........\n");
        tiempoInicial=System.currentTimeMillis();
        
        System.out.println("Matriz1: \n"+ "Number of columns:" + mt1.numberOfColumns());
        
        tiempoFinal= System.currentTimeMillis();
        totalTime = tiempoFinal-tiempoInicial;
        System.out.println(".............END OF METHOD _ COLUMNS...........[BENCHMARK:: "+totalTime+"]\n\n\n");
        
        System.out.println(".............METHOD _ ROWS..................\n");
                tiempoInicial=System.currentTimeMillis();
        System.out.println("Matriz1: \n"+ "Number of rows:" + mt1.numberOfRows() + "\n");
        
        tiempoFinal= System.currentTimeMillis();
        totalTime = tiempoFinal-tiempoInicial;
        
        System.out.println(".............END OF METHOD _ ROWS...........[BENCHMARK:: "+totalTime+"]\n\n\n");
        
        System.out.println(".............METHOD _ GET ELEMENT...........\n");
                tiempoInicial=System.currentTimeMillis();
        System.out.println("Matriz1: \n"+ "Get element:[1][0]: " + mt1.getElement(1,0)+ ": \n");
        
        
        tiempoFinal= System.currentTimeMillis();
        totalTime = tiempoFinal-tiempoInicial;
        
        System.out.println(".............END OF METHOD _ GET ELEMENT...........[BENCHMARK:: "+totalTime+"]\n\n\n");
        
        System.out.println(".............METHOD _ SET ELEMENT...........\n");
                tiempoInicial=System.currentTimeMillis();
        System.out.println("MATRIZ_1: Set 10, on [1][0]  \n"+ mt1.toString() + " ");
        mt1.setElement(1,0,10);
        System.out.println("MATRIZ_1: \n"+ mt1.toString());
        
        
        tiempoFinal= System.currentTimeMillis();
        totalTime = tiempoFinal-tiempoInicial;
//
        
        System.out.println("\n.............METHOD _ MULTIPLY.............\n");
                tiempoInicial=System.currentTimeMillis();
        mt1.multipyByScalar(3);
        System.out.println("MATRIZ_1: \n"+ mt1.toString());
        
        
        tiempoFinal= System.currentTimeMillis();
        totalTime = tiempoFinal-tiempoInicial;
        
        System.out.println(".............END OF METHOD _ MULTIPLY...........[BENCHMARK:: "+totalTime+"]\n\n\n");
       
        System.out.println("\n.............METHOD _ TRANSPOSED...........\n");
                tiempoInicial=System.currentTimeMillis();
        
        System.out.println("MATRIZ_3: Before \n"+ mt3.toString());

        mt3.transposed();
        System.out.println("MATRIZ_3: After \n"+ mt3.toString());
        
        
        tiempoFinal= System.currentTimeMillis();
        totalTime = tiempoFinal-tiempoInicial;
        
        
        System.out.println(".............END OF METHOD _ TRANSPOSED...........[BENCHMARK:: "+totalTime+"]\n\n\n");
        System.out.println("\n.............METHOD _ PLUS MATRIZ..........\n");
                tiempoInicial=System.currentTimeMillis();
        
        

        try
        {
        mt3.plusMatriz(mt2);
        }catch(ExcepcionIndiceInvalido e)
        {
            System.out.println("Intento de sumar mt3 and mt2 pero no se pueden sumar matrices de diferentes tamaños");
        }
        
        
        
        try
        {
            mt1.plusMatriz(mt2);
        }catch(ExcepcionIndiceInvalido e)
        {
            System.out.println(e);
        }
        

        System.out.println("MATRIZ1 + Matriz2: \n"+ mt1.toString());
        
        
        
        tiempoFinal= System.currentTimeMillis();
        totalTime = tiempoFinal-tiempoInicial;
        
        
        System.out.println(".............END OF METHOD _ PLUS...........[BENCHMARK:: "+totalTime+"]\n\n\n");
        
        System.out.println("\n.............METHOD _ IS EQUAL.............\n");
                tiempoInicial=System.currentTimeMillis();
        if(!mt1.isEqual(mt2))
        {
            System.out.println("Matriz 1 and 2 arent equal");
            
        }
    
         mt1  = new MatrizXML("matriz1.xml");
         mt2  = new MatrizXML("matriz1.xml");
        if(mt2.isEqual(mt1))
        {
            
            System.out.println("Matriz 1# is equal to mt ##1");
        
        }
        
        tiempoFinal= System.currentTimeMillis();
        totalTime = tiempoFinal-tiempoInicial;
        
        
        System.out.println(".............END OF METHOD _ EquALS...........[BENCHMARK:: "+totalTime+"]\n\n\n");

        
    }
    
}
