package com.task.util.validator;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {

    public static final String[] SUPPORTED_CONTENT = {"text/xml"};

    @Override
    public void initialize(ValidFile constraintAnnotation) {

    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext ctx) {
        return Arrays.stream(SUPPORTED_CONTENT).anyMatch(multipartFile.getContentType()::equals);
    }

}
