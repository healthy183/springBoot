package com.kang.boot.common.utils;


import org.hibernate.validator.constraints.Length;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/15.
 * @Author Healthy
 * @Version
 */

public class LengthValidatorForSensitiveData implements ConstraintValidator<Length, SensitiveDataWrapper> {
    private int min;
    private int max;

    public LengthValidatorForSensitiveData() {
    }

    public void initialize(Length constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
        this.validateParameters();
    }

    private void validateParameters() {
        if(this.min < 0) {
            throw new IllegalArgumentException("The min parameter cannot be negative.");
        } else if(this.max < 0) {
            throw new IllegalArgumentException("The max parameter cannot be negative.");
        } else if(this.max < this.min) {
            throw new IllegalArgumentException("The length cannot be negative.");
        }
    }

    public boolean isValid(SensitiveDataWrapper value, ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        } else {
            int length = value.getValue().length();
            return length >= this.min && length <= this.max;
        }
    }
}

