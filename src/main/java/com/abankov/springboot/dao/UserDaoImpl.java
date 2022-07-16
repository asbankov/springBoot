package com.abankov.springboot.dao;

import org.springframework.stereotype.Repository;
import com.abankov.springboot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;
    //private  LocalContainerEntityManagerFactoryBean em;

    /*
    @Autowired
    public void setEm(LocalContainerEntityManagerFactoryBean em) {
        this.em = em;
    }

     */

    /*private PlatformTransactionManager platformTransactionManager;

    @Autowired
    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }*/

    @Override
    public void add(User user) {
        //EntityManagerFactory entityManagerFactory = em.getObject();
        //EntityManager entityManager = entityManagerFactory.createEntityManager();

        //EntityTransaction transaction = entityManager.getTransaction();
        //transaction.begin();
        entityManager.persist(user);
        //entityManager.flush();
        //transaction.commit();
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = /*em.getObject().createEntityManager()*/entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getByID(long id) {
        //EntityManagerFactory entityManagerFactory = em.getObject();
        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        //EntityTransaction transaction = entityManager.getTransaction();
        //transaction.begin();
        User user = entityManager.find(User.class, id);
        //entityManager.flush();
        //transaction.commit();
        //entityManager.close();
        return user;
    }

    @Override
    public void edit(User user) {
        //EntityManagerFactory entityManagerFactory = em.getObject();
        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        //EntityTransaction transaction = entityManager.getTransaction();
        //transaction.begin();
        entityManager.merge(user);
        //entityManager.flush();
        //transaction.commit();
        //entityManager.close();
    }

    @Override
    public void delete(User user) {
        //EntityManagerFactory entityManagerFactory = em.getObject();
        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        //EntityTransaction transaction = entityManager.getTransaction();
        //transaction.begin();
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
        //entityManager.flush();
        //transaction.commit();
        //entityManager.close();
    }
}
