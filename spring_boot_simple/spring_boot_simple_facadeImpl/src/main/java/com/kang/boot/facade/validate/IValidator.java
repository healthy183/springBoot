package com.kang.boot.facade.validate;

import com.kang.boot.common.exception.ValidationException;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */
public interface IValidator {
    void validateMutil(Object var1) throws ValidationException;

    void validate(Object var1) throws ValidationException;
}
