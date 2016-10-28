package es.upm.miw.api.sports.daos.memory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import es.upm.miw.api.sports.daos.UserDao;
import es.upm.miw.api.sports.entities.Sport;
import es.upm.miw.api.sports.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

    public UserDaoMemory() {
        this.setMap(new HashMap<Integer, User>());
    }

    @Override
    protected Integer getId(User entity) {
        return entity.getId();
    }

    @Override
    protected void setId(User entity, Integer id) {
        entity.setId(id);

    }

    @Override
    public List<User> findNickbySport(Sport sport) {
        List<User> users = this.findAll();
        List<User> selectedUsers = new LinkedList<>();
        for (User user : users) {
            if (user.getSports().contains(sport)) {
                selectedUsers.add(user);
            }
        }
        return selectedUsers;
    }

    @Override
    public User findbyNick(String userNick) {
        List<User> nickList = this.findAll();
        for (User nick : nickList) {
            if (nick.getNick().equals(userNick)) {
                return nick;
            }
        }
        return null;
    }
}
