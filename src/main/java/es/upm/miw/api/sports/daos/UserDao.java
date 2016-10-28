package es.upm.miw.api.sports.daos;

import java.util.List;

import es.upm.miw.api.sports.entities.Sport;
import es.upm.miw.api.sports.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
    List<User> findNickbySport(Sport sport);

    User findbyNick(String userNick);
}
