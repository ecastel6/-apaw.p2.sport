package es.upm.miw.api.sports.api;

import es.upm.miw.api.sports.controllers.UserController;
import es.upm.miw.api.sports.exceptions.InvalidExistingUserException;
import es.upm.miw.api.sports.exceptions.InvalidSportFieldException;
import es.upm.miw.api.sports.exceptions.InvalidUserFieldException;
import es.upm.miw.api.sports.wrappers.UserListWrapper;

public class UsersResource {

    // GET **/users
    public UserListWrapper userList() {
        return new UserController().userList();
    }

    public void createUser(String nick, String email) throws InvalidUserFieldException, InvalidExistingUserException {
        if (nick == null || nick.isEmpty()) {
            throw new InvalidUserFieldException("Invalid User");
        } else if (email == null || email.isEmpty()) {
            throw new InvalidUserFieldException("Invalid email");
        } else
            new UserController().createUser(nick, email);
    }

    // GET / users/search?sport=*
    public UserListWrapper nickSportList(String sport) throws InvalidSportFieldException {
        if (sport == null || sport.isEmpty()) {
            throw new InvalidSportFieldException("No indicó el deporte");
        } else {
            return new UserController().nickSportList(sport);
        }
    }

    // PUT /users/{nick}/sport body=sportName
    public void addSport(String nick, String sportName) throws InvalidSportFieldException, InvalidUserFieldException {
        new UserController().addSport(nick, sportName);

    }
}
