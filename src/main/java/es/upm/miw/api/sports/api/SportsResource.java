package es.upm.miw.api.sports.api;

import es.upm.miw.api.sports.controllers.SportController;
import es.upm.miw.api.sports.exceptions.InvalidExistingSportException;
import es.upm.miw.api.sports.exceptions.InvalidSportFieldException;

public class SportsResource {

    public void createSport(String sport) throws InvalidExistingSportException, InvalidSportFieldException {
        if (sport == null || sport.isEmpty()) {
            throw new InvalidSportFieldException("Nombre de deporte nulo o vacío");
        } else if (!new SportController().createSport(sport)) {
            throw new InvalidExistingSportException();
        }
    }
}
