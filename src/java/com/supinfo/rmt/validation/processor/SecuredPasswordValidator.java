/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.validation.processor;

import com.supinfo.rmt.validation.SecuredPassword;
import java.lang.annotation.Annotation;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author lukas
 */
public class SecuredPasswordValidator implements ConstraintValidator<SecuredPassword, String> {

    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*)";

    private SecuredPassword securedPassword;
    private Pattern pattern;

    @Override
    public void initialize(SecuredPassword securedPassword) {
        this.securedPassword = securedPassword;
        pattern = pattern.compile(PASSWORD_PATTERN);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return pattern.matcher(password).matches();
    }
}