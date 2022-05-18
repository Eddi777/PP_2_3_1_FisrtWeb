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

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public void removeUser(long id) {
        userDAO.removeUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user, long id) {
        user.setId(id);
        userDAO.updateUser(user);
    }
    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}