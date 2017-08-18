package com.kang.boot.common.context;

import com.kang.boot.common.CommonRequest;
import com.kang.boot.common.service.BaseFacade;
import lombok.Data;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */
@Data
public class BaseContext<T extends CommonRequest> {
    /**
     * 通用请求类
     */
    private CommonRequest commonRequest;
    /**
     * 通用服务类
     */
    private BaseFacade baseFacade;
    /**
     * 响应描述
     */
    private String errorMsg;
    /**
     * 响应码
     */
    private String errorCode;
    /**
     * 交易结果
     */
    private Object result;
}
