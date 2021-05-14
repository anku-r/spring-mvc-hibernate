package com.ankur.superhero.businesslogic.controller.mvc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ankur.superhero.app.util.AppConstants;
import com.ankur.superhero.businesslogic.exception.CharacterNameAlreadyPresentException;
import com.ankur.superhero.businesslogic.exception.UnauthorizedAccessException;
import com.ankur.superhero.businesslogic.model.CharactersModel;
import com.ankur.superhero.businesslogic.service.CharactersBusinessLogicService;

@Controller
@RequestMapping("/manage")
public class CharactersCrudController {

	@InitBinder
	public void preProcess(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimEditor);
	}

	@Autowired
	private CharactersBusinessLogicService service;

	@GetMapping(path = "/prepareupdateform", params = "id")
	public String prepareUpdateForm(@RequestParam("id") Integer id, Model model) {

		CharactersModel character = service.getCharacterById(id);
		model.addAttribute("character", character);
		return AppConstants.UPDATE_FORM;
	}

	@PostMapping("/update")
	public String updateCharacter(@Valid @ModelAttribute("character") CharactersModel character,
			BindingResult bindingResult, Model model) {

		try {
			if (!bindingResult.hasErrors()) {
				service.save(character);
				return AppConstants.REDIRECT_TO_HOME;
			}
		} catch (CharacterNameAlreadyPresentException e) {
			bindingResult.rejectValue("name", "1062", e.getMessage());
		}
		return AppConstants.UPDATE_FORM;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCharacter(@PathVariable("id") Integer id, Model model) {
		
		try {
			service.deleteCharacter(id);
		} catch(AccessDeniedException e) {
			throw new UnauthorizedAccessException(AppConstants.DELETE_DENIED_MSG);
		}
		return AppConstants.REDIRECT_TO_HOME;
	}
	
	@GetMapping("/prepareaddform")
	public String prepareAddForm(Model model) {

		model.addAttribute("character", new CharactersModel());
		return AppConstants.ADD_FORM;
	}

	@PostMapping("/add")
	public String addCharacter(@Valid @ModelAttribute("character") CharactersModel character,
			BindingResult bindingResult, Model model) {

		try {
			if (!bindingResult.hasErrors()) {
				service.save(character);
				return AppConstants.REDIRECT_TO_HOME;
			}
		} catch(CharacterNameAlreadyPresentException e) {
			bindingResult.rejectValue("name", "1062", e.getMessage());
		}
		return AppConstants.ADD_FORM;
	}
	
	@RequestMapping("/delete-batch")
	public String deleteBatch(@RequestParam("ids") List<Integer> ids, Model model) {
		
		try {
			service.deleteBatch(ids);
		} catch(AccessDeniedException e) {
			throw new UnauthorizedAccessException(AppConstants.DELETE_DENIED_MSG);
		}
		return AppConstants.REDIRECT_TO_HOME;
	}
}
