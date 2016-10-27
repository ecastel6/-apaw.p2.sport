package es.upm.miw.api.sports.controllers;

import es.upm.miw.api.sports.daos.DaoFactory;
import es.upm.miw.api.sports.entities.Sport;
import es.upm.miw.api.sports.exceptions.InvalidExistingSportException;

public class SportController {

    public void createSport(String sportName) throws InvalidExistingSportException {
        Sport sport = DaoFactory.getFactory().getSportDao().findSportbyName(sportName);
        if (sport == null) {
            DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
        } else 
            throw new InvalidExistingSportException();
    }

}
