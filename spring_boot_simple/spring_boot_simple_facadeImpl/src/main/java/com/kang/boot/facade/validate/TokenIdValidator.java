package com.kang.boot.facade.validate;

import com.kang.boot.common.context.BaseContext;
import com.kang.boot.common.enums.TransResCode;
import com.kang.boot.common.validate.ValidationParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Title 类名
 * @Description 保证服务幂等性
 * 1,initiationID请求流水作为分布式锁，防止网络抖动等重复请求;
 * 2,tokenId(调用方提供的唯一标识,一般是外部流水),
 * 访问key(tokenId),不存在,查数据库，也不存在则存入commonResponse标记resultCode处理中到redis,有效期1分钟
 *存在则直接返回commonResponse
 * 服务返回处理结果为成功则保存1小时，否则有效期1分钟
 * java客户端可以使用spring RedisTemple或者redisson(他提供例如分布式锁,阻塞队列，缓存等功能,值得学习)
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */
@Service
@Slf4j
public class TokenIdValidator  extends ValidatorTemplate {
    @Override
    protected void validateInner(BaseContext baseContext) {
        String tokenId = baseContext.getCommonRequest().getTokenId();
        if(false){
            throw new ValidationParamException(baseContext,TransResCode.RES_CODE_SIM02880008);
        }
    }
}
