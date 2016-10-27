package es.upm.miw.api.sports.api;

import es.upm.miw.api.sports.controllers.UserController;
import es.upm.miw.api.sports.daos.DaoFactory;
import es.upm.miw.api.sports.entities.User;
import es.upm.miw.api.sports.exceptions.InvalidExistingUserException;
import es.upm.miw.api.sports.exceptions.InvalidSportFieldException;
import es.upm.miw.api.sports.exceptions.InvalidUserFieldException;
import es.upm.miw.api.sports.wrappers.ListNickWrapper;
import es.upm.miw.api.sports.wrappers.SportListWrapper;
import es.upm.miw.api.sports.wrappers.UserListWrapper;

public class UsersResource {

    // GET **/users
    public UserListWrapper userList() {
        return new UserController().userList();
    }

    public void createUser(String nick, String email) throws InvalidUserFieldException, InvalidExistingUserException {
        if (nick==null || nick.isEmpty()) {
            throw new InvalidUserFieldException("Invalid User");
        } else 
        if (email==null || email.isEmpty()) {
            throw new InvalidUserFieldException("Invalid email");
        } else 
            if (!new UserController().createUser(nick, email)) {
                throw new InvalidExistingUserException ();
            }
        
    }
    
    // GET / users/search?sport=*
    public ListNickWrapper nickSportList(String sport) throws InvalidSportFieldException {
        if (sport==null || sport.isEmpty()) {
            throw new InvalidSportFieldException("Invalid Param sport");
        } else { 
            return new UserController().nickSportList(sport);
        }
    }
    
    public void addSport(String userNick, String sportName) throws InvalidSportFieldException {
        User user = DaoFactory.getFactory().getUserDao().findbyNick(userNick);
//          sport = DaoFactory.getFactory().getSportDao().
        
    }


    

}
