package com.ankur.superhero.dataaccess.repository;

import java.util.Optional;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ankur.superhero.dataaccess.entity.UserAccess;

@Repository
@Transactional
public class UserAccessDAO extends AbstractDAO<UserAccess> {

	public Optional<UserAccess> findByUsername(String userName) {
		
		String query = "from UserAccess where user = ?1";
		fetchSession();	
		try {
			UserAccess singleUser =  session
					.createQuery(query, UserAccess.class)
					.setParameter(1, userName)
					.getSingleResult();
			
			return Optional.of(singleUser);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}
	
	@Override
	protected Class<UserAccess> getEntityClass() {
		return UserAccess.class;
	}
}
