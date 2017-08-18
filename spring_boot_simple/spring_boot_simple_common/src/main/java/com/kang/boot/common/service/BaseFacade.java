package com.kang.boot.common.service;

import com.kang.boot.common.CommonRequest;
import com.kang.boot.common.CommonResponse;
import com.kang.boot.common.context.BaseContext;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */
public abstract class BaseFacade<T extends CommonRequest,R extends CommonResponse> {

    public  final R superExecute(T request){
        BaseContext baseContext = getContext();
        baseContext.setCommonRequest(request);
        baseContext.setBaseFacade(this);
        return initExecute(baseContext);
    }

    protected abstract R initExecute(BaseContext baseContext);

    protected abstract R doExecute(T baseContext);

    protected  abstract BaseContext<T>  getContext();
}
