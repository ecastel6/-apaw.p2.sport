package es.upm.miw.api.sports.exceptions;

public class InvalidExistingUserException extends Exception {
    private static final long serialVersionUID = 5637609024182516424L;

    public static final String DESCRIPTION = "Usuario ya existente";

    public InvalidExistingUserException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidExistingUserException() {
        this("");
    }
}
