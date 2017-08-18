package com.kang.boot.facade.validate;

import com.kang.boot.common.context.BaseContext;
import com.kang.boot.common.enums.TransResCode;
import com.kang.boot.common.exception.BaseException;
import com.kang.boot.common.validate.ValidationParamException;
import com.kang.boot.common.validate.ValidatorChain;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */
@Slf4j
@Component
public class ValidateFacade implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private final static Class[] BASIC_VALIDATORS = {TokenIdValidator.class};

    @Resource
    private ValidatorTemplate paramValidator;

    public void validate(BaseContext request) throws ValidationParamException {
        //先对参数进行验证
        paramValidator.validate(request);

        //获取ValidatorChain注解
        ValidatorChain annotation = request.getBaseFacade().getClass()
                .getAnnotation(ValidatorChain.class);
        List<Class> validatorList = initValidatorList(annotation);
        doValidate(request, validatorList);
    }

    private List<Class> initValidatorList(ValidatorChain annotation) {
        List<Class> validatorList = new ArrayList<Class>();
        if (annotation == null) { //如果标签为null, 则自动校验预设校验及原交易流水交易
            CollectionUtils.addAll(validatorList, BASIC_VALIDATORS);
            return validatorList;
        }
        if (annotation.enableBasicChain()) {
            CollectionUtils.addAll(validatorList, BASIC_VALIDATORS);
        }

        Class[] validatorBeanPrefix = annotation.value();
        for (Class beanPrefix : validatorBeanPrefix) {
            if (!validatorList.contains(beanPrefix)) {
                validatorList.add(beanPrefix);
            }
        }
        return validatorList;
    }

    private void doValidate(BaseContext request, List<Class> validatorList) {
        for (Class beanPrefix : validatorList) {
            //遍历获取验证器并执行验证
            getValidator(beanPrefix).validate(request);
        }
    }
    /**
     * 根据验证器前缀获取验证器
     *
     * @param beanClazz 验证器前缀
     * @return 验证器
     * @throws BaseException 当验证器的Bean不存在时抛出异常
     */
    private ValidatorTemplate getValidator(Class beanClazz) throws BaseException {
        ValidatorTemplate validator = null;
        String validatorBeanName = StringUtils.uncapitalize(beanClazz.getSimpleName());
        if (applicationContext.containsBeanDefinition(validatorBeanName)) {
            validator = (ValidatorTemplate) applicationContext.getBean(validatorBeanName);
        } else {
            log.error("Unabled to get validator bean {}", beanClazz.getSimpleName());
            throw new BaseException(TransResCode.RES_CODE_SIM02990001);
        }
        return validator;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
