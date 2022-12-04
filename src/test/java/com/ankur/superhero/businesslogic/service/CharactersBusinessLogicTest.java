package com.ankur.superhero.businesslogic.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ankur.superhero.app.util.Category;
import com.ankur.superhero.app.util.Publisher;
import com.ankur.superhero.businesslogic.model.CharactersModel;
import com.ankur.superhero.businesslogic.service.impl.CharactersBusinessLogicImpl;
import com.ankur.superhero.businesslogic.service.mapper.CharactersMapper;
import com.ankur.superhero.dataaccess.entity.Characters;
import com.ankur.superhero.dataaccess.repository.CharacterDAO;

@RunWith(MockitoJUnitRunner.class)
public class CharactersBusinessLogicTest {

    @InjectMocks
    private CharactersBusinessLogicService service;

    @Mock
    private CharacterDAO repository;

    @Mock
    private CharactersMapper mapper;

    private static final String NAME = "Batman";

    public CharactersBusinessLogicTest() {
	service = new CharactersBusinessLogicImpl();
    }

    @Test
    public void testGetCharacterByName() {

	Characters character = getMockCharacter();

	Mockito.when(repository.findByName(NAME)).thenReturn(Optional.of(character));
	Mockito.when(mapper.mapEntityToModelToDisplay(character)).thenCallRealMethod();

	CharactersModel model = service.getCharacterByName(NAME);

	assertNotNull(model);
	assertEquals(model.getRealName(), character.getRealName());
	assertEquals(model.getPublisher(), character.getPublisher());
    }

    private static Characters getMockCharacter() {

	Characters character = new Characters();
	character.setName(NAME);
	character.setRealName("Bruce Wayne");
	character.setCategory(Category.Superhero);
	character.setPublisher(Publisher.DC);
	character.setDob(new Date());
	return character;
    }

}
