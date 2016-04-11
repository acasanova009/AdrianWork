package fciencias.edatos.practica02;

/**
 * Clase para excepciones de índices de lista inválidos.
 * @author Adrian Ibarra Fragoso, 311261871.
 */
public class ExcepcionIndiceInvalido extends IndexOutOfBoundsException {

    /**
     * Constructor vacio.
     */
    public ExcepcionIndiceInvalido() {
        super();
    }

    /**
     * Constructor que recibe un mensaje para el usuario.
     * @param mensaje un mensaje que verá el usuario cuando ocurra
     *                la excepción.
     */
    public ExcepcionIndiceInvalido(String mensaje) {
        super(mensaje);
    }
}
