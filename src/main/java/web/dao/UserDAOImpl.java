package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.TransactionManager;
import web.models.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import java.util.List;


@Repository
@EnableTransactionManagement(proxyTargetClass = true)
@Transactional(value="entityManager")
@javax.transaction.Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    @Qualifier("entityManager")
    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRED)
    public void addUser(User user) {
        entityManager.getTransaction();
        entityManager.persist(user);
        entityManager.flush();

//        getSession().save(user);
//        getSession().flush();
    }

    @Override
    public void removeUser(long id) {
        User user = readUserById(id);
        if (user!=null) {
            entityManager.remove(user);
            entityManager.flush();
        }
    }

    @Override
    public void updateUser(User user) {
        System.out.println("DAO Update user " + user);
        User userUpdate = readUserById(user.getId());
        userUpdate.setName(user.getName());
        userUpdate.setLastname(user.getLastname());
        userUpdate.setAge(user.getAge());
        System.out.println("DAO Update user/2 " + userUpdate);
        entityManager.merge(userUpdate);
        entityManager.flush();
    }

    public User readUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRED)
    public List<User> getAllUsers() {
        System.out.println("Request List from DAO");
        return entityManager.createQuery("FROM User").getResultList();
    }
}


