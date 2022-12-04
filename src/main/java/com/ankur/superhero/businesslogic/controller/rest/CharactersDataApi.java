package com.ankur.superhero.businesslogic.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.superhero.app.util.AppConstants;
import com.ankur.superhero.businesslogic.exception.UnauthorizedAccessException;
import com.ankur.superhero.businesslogic.model.CharactersModel;
import com.ankur.superhero.businesslogic.service.CharactersBusinessLogicService;

@RestController
@RequestMapping("api/characters")
public class CharactersDataApi {

    @Autowired
    private CharactersBusinessLogicService service;

    @GetMapping
    public List<CharactersModel> getAllCharacters() {

	return service.listAllCharacters();
    }

    @GetMapping(params = "name")
    public CharactersModel getCharacterByName(@RequestParam String name) {

	return service.getCharacterByName(name);
    }

    @GetMapping("{id}")
    public CharactersModel getCharacter(@PathVariable("id") Integer id) {

	return service.getCharacterById(id);
    }

    @DeleteMapping("{id}")
    public void deleteCharacter(@PathVariable("id") Integer id) {

	try {
	    service.deleteCharacter(id);
	} catch (AccessDeniedException e) {
	    throw new UnauthorizedAccessException(AppConstants.DELETE_DENIED_MSG);
	}
    }

    @PostMapping
    public CharactersModel addCharacter(@Valid @RequestBody CharactersModel model) {

	return service.save(model);
    }

    @PutMapping
    public CharactersModel updateCharacter(@Valid @RequestBody CharactersModel model) {

	return service.save(model);
    }
}
