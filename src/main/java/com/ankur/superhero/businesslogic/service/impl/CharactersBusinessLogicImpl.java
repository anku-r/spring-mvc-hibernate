package com.ankur.superhero.businesslogic.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ankur.superhero.app.util.AppConstants;
import com.ankur.superhero.businesslogic.exception.CharacterNameAlreadyPresentException;
import com.ankur.superhero.businesslogic.exception.RequestNotFoundException;
import com.ankur.superhero.businesslogic.model.CharactersModel;
import com.ankur.superhero.businesslogic.service.CharactersBusinessLogicService;
import com.ankur.superhero.businesslogic.service.mapper.CharactersMapper;
import com.ankur.superhero.dataaccess.entity.Characters;
import com.ankur.superhero.dataaccess.repository.CharactersDaoService;

@Service
@Transactional
public class CharactersBusinessLogicImpl implements CharactersBusinessLogicService,
																		AppConstants {

	@Autowired
	private CharactersMapper mapper;
	
	@Autowired
	private CharactersDaoService repository;
	
	@Override
	public CharactersModel save(CharactersModel model) {
		
		try {
			Characters character;
			if (model.getId() != null) {
				character = repository.update(mapper
						.mapModelToEntity(model, repository.find(model.getId())));
			} else {
				character = repository.create(
						mapper.mapModelToEntity(model));
			}
			return mapper.mapEntityToModel(character);
		} catch (DataIntegrityViolationException | ConstraintViolationException e) {
			throw new CharacterNameAlreadyPresentException();
		}
	}

	@Override
	@PreAuthorize("hasAuthority('ADMIN')")
	public void deleteCharacter(int id) {
		
		Characters character = repository.find(id);
		if (character == null) {
			throw new RequestNotFoundException(CHARACTER_NOTFOUND_MSG);
		}
		repository.delete(character);
	}

	@Override
	public CharactersModel getCharacterById(int id) {
		
		Characters character = repository.find(id);
		if (character == null) {
			throw new RequestNotFoundException();
		}
		return mapper.mapEntityToModel(character);
	}

	@Override
	public List<CharactersModel> listAllCharacters() {
		
		List<Characters> characters = repository.findAll();
		return characters.stream().map(mapper::mapEntityToModelToDisplay)
				.collect(Collectors.toList());
	}

	@Override
	public CharactersModel getCharacterByName(String name) {
		
		Optional<Characters> character = repository.findByName(name);
		if (!character.isPresent()) {
			throw new RequestNotFoundException(CHARACTER_NOTFOUND_MSG);
		}
		return mapper.mapEntityToModelToDisplay(character.get());
	}

	@Override
	@PreAuthorize("hasAuthority('ADMIN')")
	public void deleteBatch(List<Integer> charIds) {
		
		charIds.forEach(this::deleteCharacter);
	}

}
