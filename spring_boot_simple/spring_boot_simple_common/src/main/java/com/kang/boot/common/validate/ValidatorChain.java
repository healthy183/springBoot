package com.kang.boot.common.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatorChain {
    /**
     * 校验器链, 检验器间用","分隔, 如"abc,def"
     * 自动忽略重复定义的校验器.
     * 特别的, 当enableBasicChain为true时, 自动忽略与basicChain重复的校验器
     * @return 校验器链
     */
    Class[] value();

    /**
     * 启动预设的校验器
     * @return 默认为true
     */
    boolean enableBasicChain() default true;

    /**
     * 当请求为二阶段请求时, 校验原交易流水与本交易请求参数是否一致
     * @return 默认为true
     */
    boolean enableValidateOriginTrans() default true;
}
