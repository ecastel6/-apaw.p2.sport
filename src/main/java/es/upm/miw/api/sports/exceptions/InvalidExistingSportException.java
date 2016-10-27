package es.upm.miw.api.sports.exceptions;

public class InvalidExistingSportException extends Exception {
    private static final long serialVersionUID = 332090711324216421L;

    public static final String DESCRIPTION = "Deporte ya existente";

    public InvalidExistingSportException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidExistingSportException() {
        this("");
    }
}
