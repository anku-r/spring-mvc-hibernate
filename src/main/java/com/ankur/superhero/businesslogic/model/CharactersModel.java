package com.ankur.superhero.businesslogic.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ankur.superhero.app.util.AppConstants;
import com.ankur.superhero.app.util.Category;
import com.ankur.superhero.app.util.Publisher;
import com.ankur.superhero.businesslogic.model.validation.ValidDateFormat;

import lombok.Data;

@Data
public class CharactersModel implements AppConstants {

	private Integer id;
	
	@Pattern(regexp = "[a-zA-Z\\s]*", message = INVALID_NAME)
	@NotNull(message = REQUIRED)
	@Size(min = 1, message = REQUIRED)
	private String name;
	
	@Pattern(regexp = "[a-zA-Z\\s]*", message = INVALID_NAME)
	@NotEmpty(message = REQUIRED)
	private String realName;
	
	@NotNull(message = REQUIRED)
	private Category category;
	
	@NotNull(message = REQUIRED)
	private Publisher publisher;

	@NotNull(message = REQUIRED)
	@ValidDateFormat
	private String dob;
	
}
