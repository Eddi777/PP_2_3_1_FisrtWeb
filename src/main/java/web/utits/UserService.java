package web.utits;

import web.dao.UserDAOImpl;
import web.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserDAOImpl userDAO;

    @Transactional
    public void addAnyUser() {
        User eddi = new User("Eduard", "Sharipov", (byte) 45);
        System.out.println("New Eddi save" + eddi);
        userDAO.add(eddi);
    }

    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    public void removeById(Long id) {
        userDAO.remove(id);
    }
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.listUsers();
    }
}