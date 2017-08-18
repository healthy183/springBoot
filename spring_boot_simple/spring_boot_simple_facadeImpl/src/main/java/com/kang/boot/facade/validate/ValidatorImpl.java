package com.kang.boot.facade.validate;

import com.kang.boot.common.exception.ValidationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */

@Service
public class ValidatorImpl implements IValidator {
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static Validator validator;

    public ValidatorImpl() {
    }

    public void validateMutil(Object obj) throws ValidationException {
        Set constraintViolations = validator.validate(obj, new Class[0]);
        ArrayList errList = new ArrayList();
        if(constraintViolations != null && constraintViolations.size() != 0) {
            Iterator i$ = constraintViolations.iterator();
            while(i$.hasNext()) {
                ConstraintViolation error = (ConstraintViolation)i$.next();
                String errorMsg = error.getPropertyPath() + ":" + error.getMessage();
                errList.add(errorMsg);
            }
            throw new ValidationException(errList);
        }
    }

    public void validate(Object obj) throws ValidationException {
        Set constraintViolations = validator.validate(obj, new Class[0]);
        String errorMsg = null;
        if(constraintViolations != null && constraintViolations.size() != 0) {
            ConstraintViolation error = (ConstraintViolation)constraintViolations.iterator().next();
            errorMsg = error.getPropertyPath() + ":" + error.getMessage();
            throw new ValidationException(errorMsg);
        }
    }

    static {
        validator = factory.getValidator();
    }
}

