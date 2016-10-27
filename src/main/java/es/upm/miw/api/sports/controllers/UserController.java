package es.upm.miw.api.sports.controllers;

import java.util.List;

import es.upm.miw.api.sports.daos.DaoFactory;
import es.upm.miw.api.sports.entities.Sport;
import es.upm.miw.api.sports.entities.User;
import es.upm.miw.api.sports.exceptions.InvalidExistingUserException;
import es.upm.miw.api.sports.exceptions.InvalidSportFieldException;
import es.upm.miw.api.sports.exceptions.InvalidUserFieldException;
import es.upm.miw.api.sports.wrappers.ListNickWrapper;
import es.upm.miw.api.sports.wrappers.UserListWrapper;
import es.upm.miw.api.sports.wrappers.UserWrapper;

public class UserController {

    public UserListWrapper userList() {
        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        UserListWrapper userListWrapper = new UserListWrapper();
        for (User user : userList) {
            userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
        }
        return userListWrapper;
    }

    public void createUser(String nick, String email) throws InvalidExistingUserException {
        if (DaoFactory.getFactory().getUserDao().findbyNick(nick) == null) {
            DaoFactory.getFactory().getUserDao().create(new User(nick, email));
        } else {
            throw new InvalidExistingUserException();
        }
    }

    public UserListWrapper nickSportList(String sport) {
        UserListWrapper listNickWrapper = new UserListWrapper();
        List<User> listNick = DaoFactory.getFactory().getUserDao().findNickbySport(sport);
        for (User user : listNick) {
            listNickWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
        }
        return listNickWrapper;
    }

    public void addSport(String nick, String sportName) throws InvalidSportFieldException, InvalidUserFieldException {
        Sport sport = DaoFactory.getFactory().getSportDao().findSportbyName(sportName);
        if (sport == null) {
            throw new InvalidSportFieldException("Deporte no existente");
        }

        User user = DaoFactory.getFactory().getUserDao().findbyNick(nick);
        if (user == null) {
            throw new InvalidUserFieldException("No existe el usuario");
        }
        user.addSport(sport);
        DaoFactory.getFactory().getUserDao().update(user);

    }
}
