package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Platz;

@ApplicationScoped
public class PlatzService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Platz createPlatz(Platz platz) {
        return entityManager.merge(platz);
    }

    @Transactional
    public Platz updatePlatz(Long id, Platz platz) {
        platz.setId(id);
        return entityManager.merge(platz);
    }

    @Transactional
    public void deletePlatz(Long id) {
        var entity = entityManager.find(Platz.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Platz findPlatz(Long id) {
        var entity = entityManager.find(Platz.class, id);
        return entity;

    }

    public List<Platz> findAll() {
        var query = entityManager.createQuery("FROM Platz", Platz.class);
        return query.getResultList();
    }

    public Optional<Platz> findByEmail(String email) {
        return entityManager
                .createNamedQuery("Platz.findByEmail", Platz.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }

}