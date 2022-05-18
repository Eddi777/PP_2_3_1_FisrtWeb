package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceUnit
    private final EntityManagerFactory entityManagerFactory;
    public UserDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    private EntityManager entityManager;

    private EntityManager getEntityManager(){
        if (entityManager == null) {
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }


    @Override
//    @Transactional //(propagation = Propagation.REQUIRED)
    public void addUser(User user) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(user);
        getEntityManager().flush();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void removeUser(long id) {
        User user = readUserById(id);
        if (user!=null) {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(user);
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
        }
    }

    @Override
    public void updateUser(User user) {
        User userUpdate = readUserById(user.getId());
        userUpdate.setName(user.getName());
        userUpdate.setLastname(user.getLastname());
        userUpdate.setAge(user.getAge());
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(userUpdate);
        getEntityManager().flush();
        getEntityManager().getTransaction().commit();
    }

    public User readUserById(long id) {
        return getEntityManager().find(User.class, id);
    }

    @Override
//    @Transactional (propagation = Propagation.REQUIRED)
    public List<User> getAllUsers() {
        return getEntityManager().createQuery("FROM User").getResultList();
    }
}


