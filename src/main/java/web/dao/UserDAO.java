package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {

        void add(User user);
        void remove(long id);
        void update(User user);
        User read (long id);
        List<User> listUsers();


}
