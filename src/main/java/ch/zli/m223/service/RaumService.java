package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Raum;

@ApplicationScoped
public class RaumService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Raum createRaum(Raum raum) {
        return entityManager.merge(raum);
    }

    @Transactional
    public Raum updateUser(Long id, Raum raum) {
        raum.setId(id);
        return entityManager.merge(raum);
    }

    @Transactional
    public void deleteRaum(Long id) {
        var entity = entityManager.find(Raum.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Raum findRaum(Long id) {
        var entity = entityManager.find(Raum.class, id);
        return entity;

    }

    public List<Raum> findAll() {
        var query = entityManager.createQuery("FROM Raum", Raum.class);
        return query.getResultList();
    }

    public Optional<Raum> findByEmail(String email) {
        return entityManager
                .createNamedQuery("Raum.findByEmail", Raum.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }

}