package com.ankur.superhero.dataaccess.repository.impl;

import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.ankur.superhero.dataaccess.entity.Characters;
import com.ankur.superhero.dataaccess.repository.CharactersDaoService;

@Repository
public class CharacterDao extends AbstractDao<Characters>
						  			implements CharactersDaoService {

	public Optional<Characters> findByName(String name) {

		fetchSession();
		try {
			Characters singleCharacter =  session
					.createQuery("from Characters where name = ?1", Characters.class)
					.setParameter(1, name)
					.getSingleResult();
			
			return  Optional.of(singleCharacter);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}
	
	@Override
	protected Class<Characters> getEntityClass() {
		return Characters.class;
	}
}
