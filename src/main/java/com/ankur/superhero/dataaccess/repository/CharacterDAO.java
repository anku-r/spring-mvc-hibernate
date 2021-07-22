package com.ankur.superhero.dataaccess.repository;

import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.ankur.superhero.dataaccess.entity.Characters;

@Repository
public class CharacterDAO extends AbstractDAO<Characters> {

	public CharacterDAO() {
		super(Characters.class);
	}

	public Optional<Characters> findByName(String name) {

		fetchSession();
		try {
			Characters singleCharacter =  session
					.createQuery("from Characters where name = ?1", Characters.class)
					.setParameter(1, name)
					.getSingleResult();
			
			return Optional.of(singleCharacter);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

}
