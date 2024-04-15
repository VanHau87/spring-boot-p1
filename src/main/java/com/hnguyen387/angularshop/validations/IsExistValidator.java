package com.hnguyen387.angularshop.validations;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsExistValidator implements ConstraintValidator<IsExist, Object>{
	private String fieldName;
	@Override
	public void initialize(final IsExist constraintAnnotation) {
		fieldName = constraintAnnotation.field();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(value);
		final var val = beanWrapper.getPropertyValue(fieldName);
		boolean valid = false;
		String string = String.valueOf(val);
		if (string.startsWith("aa")) {
			valid = true;
		} else {
			valid = false;
		}
		if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                   .addConstraintViolation();
        }
		return valid;
	}
	
}
