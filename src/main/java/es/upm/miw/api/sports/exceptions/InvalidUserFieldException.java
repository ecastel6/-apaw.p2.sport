package es.upm.miw.api.sports.exceptions;

public class InvalidUserFieldException extends Exception {

    private static final long serialVersionUID = -5079110259752969910L;

    public static final String DESCRIPTION = "Datos paa crear usuario incompletos o inválidos ";

    public InvalidUserFieldException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidUserFieldException() {
        this("");
    }
}
