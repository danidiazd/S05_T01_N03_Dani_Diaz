package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.services.exceptions;

public class FlorNoID extends RuntimeException {

    public FlorNoID(Integer id) {
        super("No se ha encontrado la flor con ID " + id);
    }
}
