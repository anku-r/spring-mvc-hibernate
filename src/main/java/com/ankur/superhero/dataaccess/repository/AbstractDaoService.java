package com.ankur.superhero.dataaccess.repository;

import java.util.List;

public interface AbstractDaoService<T> {

	public T create(T entity);
	
	public T update(T entity);

	public void delete(T entity);
	
	public T find(int id);

	public List<T> findAll();

}
