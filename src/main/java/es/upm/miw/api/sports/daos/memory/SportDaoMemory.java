package es.upm.miw.api.sports.daos.memory;

import java.util.HashMap;
import java.util.List;

import es.upm.miw.api.sports.daos.SportDao;
import es.upm.miw.api.sports.entities.Sport;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

    public SportDaoMemory() {
        this.setMap(new HashMap<Integer, Sport>());
    }

    @Override
    public Sport findSportbyName(String sportName) {
        List<Sport> sports = this.findAll();
        for (Sport sport : sports) {
            if (sport.getSportName().equals(sportName)) {
                return sport;
            }
        }
        return null;
    }

    @Override
    protected Integer getId(Sport entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Sport entity, Integer id) {
        entity.setId(id);

    }
}
