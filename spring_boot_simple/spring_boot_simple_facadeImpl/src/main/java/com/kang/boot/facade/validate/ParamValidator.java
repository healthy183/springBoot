package com.kang.boot.facade.validate;

import com.kang.boot.common.CommonRequest;
import com.kang.boot.common.context.BaseContext;
import com.kang.boot.common.enums.TransResCode;
import com.kang.boot.common.validate.ValidationParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author healthy
 *         created at
 *         17-8-10.
 */
@Service
@Slf4j
public class ParamValidator extends ValidatorTemplate {
    @Autowired
    public ValidatorImpl validator;

    @Override
    public void validateInner(BaseContext baseContext) throws ValidationParamException {
        CommonRequest commonRequest = baseContext.getCommonRequest();
        try {
            validator.validateMutil(commonRequest);
        } catch (Exception e) {
            //log.error("ParamValidator.validateInner is error:[{}] \n", Throwables.getStackTraceAsString(e));
            throw new ValidationParamException(baseContext, TransResCode.RES_CODE_SIM02880001.getResCode(),
            String.format(TransResCode.RES_CODE_SIM02880001.getResDes(),e.getMessage()));
        }
    }
}
