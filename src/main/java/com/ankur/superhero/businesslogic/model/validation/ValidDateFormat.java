package com.ankur.superhero.businesslogic.model.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.ankur.superhero.app.util.DateUtil;

@Constraint(validatedBy = DateFormatValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateFormat {
	
	public String message() default "Incorrect Date Format. Should be 'YYYY-MM-DD'";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
	
}

class DateFormatValidator implements ConstraintValidator<ValidDateFormat, String>{
	
	@Override
	public boolean isValid(String date, ConstraintValidatorContext context) {
		return DateUtil.convertToDate(date) != null;
	}

}
