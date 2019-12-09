package hu.lmsystems.homeadmin.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import hu.lmsystems.homeadmin.annotations.PasswordMatches;
import hu.lmsystems.homeadmin.dto.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDto user = (UserDto) obj;
		return user.getPassword().equals(user.getMatchingPassword());
	}
}
