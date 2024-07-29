/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.annotation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ups.oms.oms_schpu_custumer_preference_service.annotation.DataFormat;

/**
 * @author rahul
   @since  27-Jul-2024 2024 8:05:49 pm
 */
public class DataFormatImpl implements  ConstraintValidator<DataFormat, String> {
	
    private String pattern;

    @Override
    public void initialize(DataFormat constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
            return true;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);

        try {
            sdf.parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }
	}
	
	

}
