package es.upm.miw.api.sports.exceptions;

public class InvalidSportFieldException extends Exception {
    private static final long serialVersionUID = 1347539724683165884L;

    public static final String DESCRIPTION = "Invalid Sport Name";

    public InvalidSportFieldException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidSportFieldException() {
        this("");
    }

}
