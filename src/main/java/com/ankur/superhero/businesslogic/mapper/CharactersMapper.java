package com.ankur.superhero.businesslogic.mapper;

import org.springframework.stereotype.Component;

import com.ankur.superhero.app.util.DateUtil;
import com.ankur.superhero.businesslogic.model.CharactersModel;
import com.ankur.superhero.dataaccess.entity.Characters;

@Component
public class CharactersMapper {
	
	public Characters mapModelToEntity(CharactersModel model) {
		
		if (model == null) {
			return null;
		}
		Characters entity = new Characters();
		entity.setId(model.getId());
		entity.setName(model.getName());
		entity.setRealName(model.getRealName());
		entity.setCategory(model.getCategory());
		entity.setPublisher(model.getPublisher());
		entity.setDob(DateUtil.convertToDate(model.getDob()));
		return entity;
	}
	
	public CharactersModel mapEntityToModel(Characters entity) {
		
		if (entity == null) {
			return null;
		}
		CharactersModel model = new CharactersModel();
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setRealName(entity.getRealName());
		model.setCategory(entity.getCategory());
		model.setPublisher(entity.getPublisher());
		model.setDob(DateUtil.convertToString(entity.getDob()));
		return model;
	}

	public Characters mapModelToEntity(CharactersModel model, Characters entity) {
		
		if (model == null) {
			return null;
		}
		entity.setId(model.getId());
		entity.setName(model.getName());
		entity.setRealName(model.getRealName());
		entity.setCategory(model.getCategory());
		entity.setPublisher(model.getPublisher());
		entity.setDob(DateUtil.convertToDate(model.getDob()));
		return entity;
	}
	
	public CharactersModel mapEntityToModelToDisplay(Characters entity) {
		
		if (entity == null) {
			return null;
		}
		CharactersModel model = new CharactersModel();
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setRealName(entity.getRealName());
		model.setCategory(entity.getCategory());
		model.setPublisher(entity.getPublisher());
		model.setDob(DateUtil.convertToString(entity.getDob(), "dd-MM-yyyy"));
		return model;
	}
}
