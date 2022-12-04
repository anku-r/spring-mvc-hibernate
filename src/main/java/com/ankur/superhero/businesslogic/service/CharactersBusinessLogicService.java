package com.ankur.superhero.businesslogic.service;

import java.util.List;

import com.ankur.superhero.businesslogic.model.CharactersModel;

public interface CharactersBusinessLogicService {

    public CharactersModel save(CharactersModel model);

    public void deleteCharacter(int id);

    public CharactersModel getCharacterById(int id);

    public List<CharactersModel> listAllCharacters();

    public CharactersModel getCharacterByName(String name);

    public void deleteBatch(List<Integer> charIds);
}
