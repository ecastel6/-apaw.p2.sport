package es.upm.miw.api.sports.api;

import es.upm.miw.api.sports.controllers.UserController;
import es.upm.miw.api.sports.exceptions.InvalidSportFieldException;
import es.upm.miw.api.sports.exceptions.InvalidUserFieldException;
import es.upm.miw.api.sports.wrappers.UserListWrapper;

public class UsersResource {

    // GET **/users
    public UserListWrapper userList() {
        return new UserController().userList();
    }
    

    public String userPlaySportList(String string) {
        // TODO Auto-generated method stub
        return null;
    }

    public void createUser(String userNick, String userEmail) throws InvalidUserFieldException {
        // TODO Auto-generated method stub
        
    }

    public void addSport(String userNick, String sportName) throws InvalidSportFieldException {
        // TODO Auto-generated method stub
        
    }

}
