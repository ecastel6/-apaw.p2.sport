package es.upm.miw.api.sports.daos;

import java.util.List;

import es.upm.miw.api.sports.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
    List<User> findNickbySport(String sport);
//    User userList(String nick);
    User findbyNick(String userNick);
}
