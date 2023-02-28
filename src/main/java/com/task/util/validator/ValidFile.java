package com.task.util.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy= {FileValidator.class})

public @interface ValidFile {

    String message() default "Invalid File Type";
    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};

}
