package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {

        void addUser(User user);
        void removeUser(long id);
        void updateUser(User user);
        User readUserById(long id);
        List<User> getAllUsers();


}
