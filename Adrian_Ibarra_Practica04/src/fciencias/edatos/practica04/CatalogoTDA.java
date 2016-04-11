package fciencias.edatos.practica04;



/**
 * <p>Interfaz TDA MatrizProtocol</p>
 *
 *<p>Abstract class for Matrices. Contiene una estructura basica para realizar operaciones.
* Este TDA, puede ser implementada por otra clase que se guarda en la memoria y se manifiesta como una matriz.</p> 
 
 *
 * @author Adrian Ibarra Fragoso, 311261871.
 */
public interface CatalogoTDA<T extends Profesor> {
    
    public void agregaProfesor(T prof);
    
    /*
     * Metodo para saber numero de Renglones
     * @return el numero de renglones de la matriz
     */
    
    public void eliminaProfesor(int id);
    
    
    
    
}
