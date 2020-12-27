package com.ankur.superhero.businesslogic.controller.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ankur.superhero.businesslogic.model.CharactersModel;
import com.ankur.superhero.businesslogic.service.CharactersBusinessLogicService;

@Controller
public class CharactersHomeController {
	
	@Autowired
	private CharactersBusinessLogicService service;

	@GetMapping("/")
    public String home(Model model) {
        
		List<CharactersModel> characters = service.listAllCharacters();
		model.addAttribute("characters", characters);
		return "home";
    }
}
