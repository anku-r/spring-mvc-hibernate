package com.ankur.superhero.dataaccess.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ankur.superhero.dataaccess.repository.AbstractDaoService;

public abstract class AbstractDao<T> implements AbstractDaoService<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session session;
	
	public void fetchSession() {
		session = sessionFactory.getCurrentSession();
	}
	
	@Override
	public T create(T entity) {

		fetchSession();
		session.save(entity);
		return entity;
	}
	
	@Override
	public T update(T entity) {

		fetchSession();
		session.update(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {

		fetchSession();
		session.delete(entity);
	}

	@Override
	public T find(int id) {

		fetchSession();
		T entity = session.get(getEntityClass(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {

		fetchSession();
		String query = "from " + getEntityClass().getSimpleName();
		List<T> entities = session.createQuery(query).getResultList();
		return entities;
	}

	protected abstract Class<T> getEntityClass();
}
