package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {

        void addUser(User user);
        void removeUser(long id);
        void updateUser(User user);
        List<User> getAllUsers();


}
