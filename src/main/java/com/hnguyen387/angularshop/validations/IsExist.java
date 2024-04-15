package com.hnguyen387.angularshop.validations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({TYPE})
@Constraint(validatedBy = IsExistValidator.class)
public @interface IsExist {
	String message() default "The value already exists.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field();
    @Target({ TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
    	IsExist[] value();
    }
}
