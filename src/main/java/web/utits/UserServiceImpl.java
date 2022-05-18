package web.utits;

import org.springframework.stereotype.Component;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.models.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void removeUser(long id) {
        userDAO.removeUser(id);
    }

    @Override
    public void updateUser(User user, long id) {
        user.setId(id);
        userDAO.updateUser(user);
    }
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}