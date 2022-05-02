package web.dao;

import web.models.User;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@EnableTransactionManagement(proxyTargetClass = true)
public class UserDAOImpl implements UserDAO {

    @Autowired
    private HibernateTransactionManager transactionManager;

    private Session getSession() {
        if (transactionManager.getSessionFactory().getCurrentSession().getTransaction().isActive()) {
            return transactionManager.getSessionFactory().getCurrentSession();
        } else {
            transactionManager.getSessionFactory().getCurrentSession().beginTransaction();
            return transactionManager.getSessionFactory().getCurrentSession();
        }
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRED)
    public void add(User user) {
        getSession().save(user);
        getSession().flush();
    }

    @Override
    public void remove(long id) {
        User user = read(id);
        if (user!=null) {
            getSession().delete(user);
        }
    }

    @Override
    public void update(User user) {
        User userUpdate = read(user.getId());
        userUpdate.setName(user.getName());
        userUpdate.setLastname(user.getLastname());
        userUpdate.setAge(user.getAge());
        getSession().update(userUpdate);
    }

    @Override
    public User read(long id) {
        return getSession().get(User.class, id);
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRED)
    public List<User> listUsers() {
        return getSession().createQuery("FROM User").getResultList();
    }
}


