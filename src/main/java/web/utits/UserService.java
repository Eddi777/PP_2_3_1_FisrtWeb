package web.utits;

import web.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user, long id);
    List<User> getAllUsers();
}
