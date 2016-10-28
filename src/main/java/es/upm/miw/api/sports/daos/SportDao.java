package es.upm.miw.api.sports.daos;

import es.upm.miw.api.sports.entities.Sport;

public interface SportDao extends GenericDao<Sport, Integer> {
    Sport findSportbyName(String sportName);
}
