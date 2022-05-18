package web.utits;

import web.dao.UserDAOImpl;
import web.models.User;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
public class UserService {

    private final UserDAOImpl userDAO;
    public UserService(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void addAnyUser() {
        User eddi = new User("Eduard", "Sharipov", (byte) 45);
        System.out.println("New Eddi save" + eddi);
        userDAO.addUser(eddi);
    }

    @Transactional
    public void add(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public void removeById(Long id) {
        userDAO.removeUser(id);
    }
    @Transactional
    public void update(User user) {
        userDAO.updateUser(user);
    }
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}