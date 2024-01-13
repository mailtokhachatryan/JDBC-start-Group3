package repository.user.impl;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import repository.user.UserRepository;
import util.HibernateDataSource;
import util.constants.Parameter;

import javax.persistence.NoResultException;
import java.util.List;

public class UserRepositoryJPAImpl implements UserRepository {

    private SessionFactory sessionFactory = HibernateDataSource.getSessionFactory();

    @Override
    public void create(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.update(user);
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        User user = getById(id);
        session.delete(user);
        session.close();
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        NativeQuery<User> nativeQuery = session.createNativeQuery("SELECT  * FROM  users", User.class);
        List<User> resultList = nativeQuery.getResultList();
        session.close();
        return resultList;
    }

    @Override
    public User getById(int userId) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userId);
        session.close();
        return user;
    }

    @Override
    public User getByEmail(String email) {

        try (Session session = sessionFactory.openSession();) {
            NativeQuery<User> nativeQuery = session.createNativeQuery("SELECT * FROM users WHERE email=:email", User.class);
            return nativeQuery.setParameter(Parameter.EMAIL, email).getSingleResult();
        } catch (NoResultException e) {

            return null;
        }
    }
}
