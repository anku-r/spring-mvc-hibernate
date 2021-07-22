package com.ankur.superhero.dataaccess.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<T> {
	
	private final Class<T> entityClass;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AbstractDAO(Class entityClass) {
		this.entityClass = entityClass;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session session;
	
	public void fetchSession() {
		session = sessionFactory.getCurrentSession();
	}
	
	public T create(T entity) {

		fetchSession();
		session.save(entity);
		return entity;
	}
	
	public T update(T entity) {

		fetchSession();
		session.update(entity);
		return entity;
	}

	public void delete(T entity) {

		fetchSession();
		session.delete(entity);
	}

	public T find(int id) {

		fetchSession();
		T entity = session.get(entityClass, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		fetchSession();
		String query = "from " + entityClass.getSimpleName();
		List<T> entities = session.createQuery(query).getResultList();
		return entities;
	}
}
