/**
 * 
 */
package com.ups.oms.oms_schpu_custumer_preference_service.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ups.oms.oms_schpu_custumer_preference_service.annotation.impl.DataFormatImpl;

/**
 * @author rahul
   @since  27-Jul-2024 2024 8:05:24 pm
 */
@Documented
@Constraint(validatedBy = DataFormatImpl.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataFormat {

    String message() default "Invalid date format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String pattern();
}
