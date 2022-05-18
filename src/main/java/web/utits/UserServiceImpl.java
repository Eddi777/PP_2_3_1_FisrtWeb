package web.utits;

import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.models.User;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


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
        System.out.println("service start - all users");
        return userDAO.getAllUsers();
    }
}