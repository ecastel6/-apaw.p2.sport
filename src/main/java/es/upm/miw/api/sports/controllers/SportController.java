package es.upm.miw.api.sports.controllers;

import es.upm.miw.api.sports.daos.DaoFactory;
import es.upm.miw.api.sports.entities.Sport;

public class SportController {

    public boolean createSport(String sportName) {
        Sport sport = DaoFactory.getFactory().getSportDao().findSportbyName(sportName);
        if (sport == null) {
            DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
            return true;
        } else 
            return false;
//            throw new InvalidExistingSportException();
    }

}
