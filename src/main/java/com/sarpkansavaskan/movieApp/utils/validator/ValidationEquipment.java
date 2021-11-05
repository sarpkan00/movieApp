package com.sarpkansavaskan.movieApp.utils.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class ValidationEquipment implements ConstraintValidator<FieldMatchUp, Object>{

	private String firstField;
    private String secondField;

    @Override
    public void initialize(final FieldMatchUp constraintAnnotation) {
    	firstField = constraintAnnotation.first();
    	secondField = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            final Object firstObject = BeanUtils.getProperty(value, firstField);
            final Object secondObject = BeanUtils.getProperty(value, secondField);
            return firstObject == null && secondObject == null 
            		|| firstObject != null && firstObject.equals(secondObject);
        } catch (final Exception ignore) {}
        return true;
    }
	 

}
