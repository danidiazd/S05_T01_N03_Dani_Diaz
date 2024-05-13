package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.services.exceptions;

public class FlorNula extends RuntimeException {

    public FlorNula() {
        super("Data cannot be empty");
    }

}


