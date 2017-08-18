package com.kang.boot.facade.base;

import com.google.common.base.Throwables;
import com.kang.boot.common.CommonRequest;
import com.kang.boot.common.CommonResponse;
import com.kang.boot.common.context.BaseContext;
import com.kang.boot.common.service.BaseFacade;
import com.kang.boot.common.validate.ValidationParamException;
import com.kang.boot.facade.context.SimpleContext;
import com.kang.boot.facade.validate.ValidateFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */
@Slf4j
public abstract class SimpleBaseFacade<T extends CommonRequest,R extends CommonResponse>  extends BaseFacade {
    @Autowired
    private ValidateFacade validateFacade;

    @Override
    protected CommonResponse initExecute(BaseContext baseContext) {
        R commonResponse = getInstance(1);
        try{
            validateFacade.validate(baseContext);
            commonResponse = (R) doExecute(baseContext.getCommonRequest());
        }catch (ValidationParamException e){
            commonResponse.setErrorCode(e.getCode());
            commonResponse.setErrorMsg(e.getErrorMsg());
            log.error("Param  illegal cause:[{}] \n", Throwables.getStackTraceAsString(e));
        }catch (Exception e){
            log.info(Throwables.getStackTraceAsString(e));
        }finally {
            commonResponse.setInitiationID(baseContext.getCommonRequest().getInitiationID());
        }
        return commonResponse;
    }

    @Override
    public BaseContext getContext() {
        return new SimpleContext<T>();
    }

    private  <T> T getInstance(int i) {
        try {
            Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[i];
            return entityClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
