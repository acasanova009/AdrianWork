package fciencias.edatos.practica02;



/**
 * <p>Interfaz TDA MatrizProtocol</p>
 *
 *<p>Abstract class for Matrices. Contiene una estructura basica para realizar operaciones.
* Este TDA, puede ser implementada por otra clase que se guarda en la memoria y se manifiesta como una matriz.</p> 
 
 *
 * @author Adrian Ibarra Fragoso, 311261871.
 */
public interface MatrizTDA {
    
    /*
    * Metodo para saber numero de Columnas
    
    * @return el numero de columnas de la matriz
    */
    int numberOfColumns();
    /*
    * Metodo para saber numero de Renglones
    * @return el numero de renglones de la matriz
    */
    int numberOfRows();
    
   
    /*
    *Metodo para obtener un elemento de la Matriz
     @param x define la columna.
     @param y define el renglon.
    * @return el elemento que se encunetra en la ubicaccion x, y.
    */
    double getElement(int x, int y);
    
    
    
    
     
    /*
    * Metodo para colocar un nuevo valor en un ubicacion especifica.
    *
     *@param x define la columna.
     *@param y define el renglon.
     * @param newValue el nuevo valor a colocar
    *  @return nos dice si el logro colocar al elemento.
     
    */
    boolean setElement(int x, int y, double newValue );
    
     
    /*
    * Permite multiplicar a la matriz por un escalar.
    * @param scalar Valor por el cual se va multiplicar la matriz.
    */
    void multipyByScalar(double scalar);
    
     
    /*
    * Permite realizar una transpoicion de la matriz.
    *  
    */
    void transposed(); 
    
    
    
    /*
    * Permite sumar a la matriz otra matrizTDA
    *@throws ExcepcionIndiceInvalido en caso que las matrices no sean del mismo tamañoç
    *@param m es la matriz que se la va a sumar a la original.
    *  
    */
    void plusMatriz(MatrizTDA m) throws ExcepcionIndiceInvalido;
    
     
   
    /**
     * Metodo para comparar dos matrices y sber si son iguales.
     * @param m the object to comapre
     * @return true if it has the same elements.
     */
    
    boolean isEqual(MatrizTDA m);
    
}
