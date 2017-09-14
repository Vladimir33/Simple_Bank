package com.bank.repository;

import com.bank.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AbstractRepository<T extends BaseEntity> {

    @PersistenceContext
    @Autowired
    public EntityManager em;

    public T doSave(T entity) {
        if (entity.isNew()) {
            em.persist(entity);
            return entity;
        } else {
            em.merge(entity);
            return entity;
        }
    }

    public T doFind(Class<T> clazz, int id) {
        return em.find(clazz, id);
    }
}
