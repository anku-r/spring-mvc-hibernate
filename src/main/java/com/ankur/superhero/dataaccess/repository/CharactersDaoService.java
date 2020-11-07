package com.ankur.superhero.dataaccess.repository;

import java.util.Optional;

import com.ankur.superhero.dataaccess.entity.Characters;

public interface CharactersDaoService extends AbstractDaoService<Characters> {

	public Optional<Characters> findByName(String name);

}
