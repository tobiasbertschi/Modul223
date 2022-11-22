package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.User;

@ApplicationScoped
public class UserService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public User createUser(User user) {
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        var entity = entityManager.find(User.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public User updateUser(Long id, User user) {
        user.setId(id);
        return entityManager.merge(user);
    }

    @Transactional
    public User findUser(Long id) {
        /*
         * var entity = entityManager.createQuery("FROM User u WHERE u.id = :id",
         * User.class).setParameter("id", id);
         * return entity.getSingleResult();
         */
        var entity = entityManager.find(User.class, id);
        return entity;

    }

    public List<User> findAll() {
        var query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Transactional
    public Optional<User> findByEmail(String email) {
        return entityManager
                .createNamedQuery("User.findByEmail", User.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }

    /*
     * public Optional<User> findByEmail(String email){
     * return entityManager
     * .createQuery("SELECT p FROM User p WHERE p.email = :email", User.class)
     * .setParameter("email", email)
     * .getResultStream()
     * .findFirst();
     * }
     */

}