package es.upm.miw.api.sports.controllers;

import java.util.List;

import es.upm.miw.api.sports.daos.DaoFactory;
import es.upm.miw.api.sports.entities.Theme;
import es.upm.miw.api.sports.entities.User;
import es.upm.miw.api.sports.wrappers.ThemeListWrapper;
import es.upm.miw.api.sports.wrappers.ThemeWrapper;
import es.upm.miw.api.sports.wrappers.UserListWrapper;

public class UserController {

    public UserListWrapper userList() {
        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        UserListWrapper userListWrapper = new UserListWrapper();
        for (User user : userList) {
            userListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getName(),user.getSports()));
        }
        return userListWrapper;
    }

    public void createUser(String userName) {
        DaoFactory.getFactory().getUserDao().create(new User(userName));
    }
}