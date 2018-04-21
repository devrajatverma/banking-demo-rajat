package com.example.demo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> entity;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
	this.entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
		.getActualTypeArguments()[1];
    }

    @PersistenceContext
    private EntityManager entityManager;

    public Class<T> getEntity() {
	return entity;
    }

    protected EntityManager getEntityManager() {
	return this.entityManager;
    }

    protected Criteria getCriteria() {
	Session session = getEntityManager().unwrap(Session.class);
	return session.createCriteria(getEntity());
    }

    protected Session getSession() {
	return getEntityManager().unwrap(Session.class);
    }

    // ---------------------------------------------------------

    public T getByKey(PK key) {
	return getEntityManager().find(entity, key);
    }

    public void persist(T entity) {
	getEntityManager().persist(entity);

    }

    public T merge(T entity) {
	return getEntityManager().merge(entity);
    }

    public T save(T entity) {
	Session session = entityManager.unwrap(Session.class);
	session.save(entity);
	session.flush();
	return entity;
    }

    public void saveOrUpdate(T entity) {
	Session session = entityManager.unwrap(Session.class);
	session.saveOrUpdate(entity);
	session.flush();
    }

    public Query createHqlQuery(String hql) {
	Session session = entityManager.unwrap(Session.class);
	return session.createQuery(hql);
    }

    public SQLQuery createSQLQuery(String sql) {
	Session session = entityManager.unwrap(Session.class);
	return session.createSQLQuery(sql);
    }

    public void remove(T entity) {
	getEntityManager().remove(entity);
    }

}
