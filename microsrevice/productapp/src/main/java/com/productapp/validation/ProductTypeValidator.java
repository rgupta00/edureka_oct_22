package com.productapp.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
@Component
public class ProductTypeValidator implements ConstraintValidator<ValidateProductType, String> {
    @Override
    public boolean isValid(String productType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> productTypes = Arrays.asList("Electronic", "Books");
        return productTypes.contains(productType);
    }
}