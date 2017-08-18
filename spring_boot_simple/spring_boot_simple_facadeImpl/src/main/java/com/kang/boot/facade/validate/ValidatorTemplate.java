package com.kang.boot.facade.validate;

import com.kang.boot.common.context.BaseContext;
import com.kang.boot.common.validate.ValidationParamException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author healthy
 *         created at 17-8-9.
 */
@Slf4j
public abstract class ValidatorTemplate {
    public BaseContext validate(BaseContext baseContext) throws ValidationParamException {
        String clazzName = this.getClass().getSimpleName();   //获得类名
        try {
            validateInner(baseContext);
            log.debug("{} validate success[{}]", clazzName, baseContext.getCommonRequest().getInitiationID());
        } catch (RuntimeException ex) {
            log.debug("{} validate fail[{}]", clazzName, baseContext.getCommonRequest().getInitiationID());
            throw ex;
        }
        return baseContext;
    }

    protected abstract void validateInner(BaseContext baseContext);
}
