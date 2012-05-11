/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.validation;

import com.supinfo.rmt.validation.processor.SecuredPasswordValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author lukas
 */
@NotEmpty
@Size(min = 6, max = 20)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE } )
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { SecuredPasswordValidator.class })
@Documented
public @interface SecuredPassword {

    String message() default "Invalid password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

