package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.services.exceptions;

public class FlorNoCreada extends RuntimeException {

    public FlorNoCreada() {
        super("No se ha podido crear la flor");
    }
}
