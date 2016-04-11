package fciencias.edatos.practica04;

/**
 * Clase para excepciones de índices de lista inválidos.
 * @author Adrian Ibarra Fragoso, 311261871.
 */
public class ExcepcionMemoria extends IndexOutOfBoundsException {

    /**
     * Constructor vacio.
     */
    public ExcepcionMemoria() {
        super();
    }

    /**
     * Constructor que recibe un mensaje para el usuario.
     * @param mensaje un mensaje que verá el usuario cuando ocurra
     *                la excepción.
     */
    public ExcepcionMemoria(String mensaje) {
        super(mensaje);
    }
}
