package com.ankur.superhero.dataaccess.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.ankur.superhero.app.util.Category;
import com.ankur.superhero.app.util.Publisher;

import lombok.Data;

@Data
@Entity
public class Characters {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String name;

	@Column(name = "real_name")
	private String realName;

	@Enumerated(EnumType.STRING)
	private Category category;

	@Enumerated(EnumType.STRING)
	private Publisher publisher;

	private Date dob;
	
	@Version
	private Integer version;
}
