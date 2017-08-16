package com.kang.boot.common.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Size;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/15.
 * @Author Healthy
 * @Version
 */

public class SizeValidatorForSensitiveData implements ConstraintValidator<Size, SensitiveDataWrapper> {
    public SizeValidatorForSensitiveData() {
    }

    public void initialize(Size constraintAnnotation) {
    }

    public boolean isValid(SensitiveDataWrapper value, ConstraintValidatorContext context) {
        return value != null && value.getValue() != null?value.getValue().trim().length() > 0:false;
    }
}

