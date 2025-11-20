package tp8_excepcion4_personalizada;

// 4. Crear EdadInvalidaException 
// Extiende de 'Exception' (checked exception)
public class EdadInvalidaException extends Exception {

    public EdadInvalidaException(String message) {
        super(message);
    }
}