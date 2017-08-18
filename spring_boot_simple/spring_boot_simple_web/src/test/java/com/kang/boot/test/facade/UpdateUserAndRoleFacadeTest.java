package com.kang.boot.test.facade;

import com.kang.boot.facade.UpdateUserAndRoleFacade;
import com.kang.boot.request.UpdateUserAndRoleRequest;
import com.kang.boot.response.SimpleReponse;
import com.kang.boot.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */
@Slf4j
public class UpdateUserAndRoleFacadeTest  extends BaseTest {
    @Autowired
    private UpdateUserAndRoleFacade updateUserAndRoleFacade;
    @Test
    public void firstNull(){
        log.info("updateUserAndRoleFacade is null?{}",updateUserAndRoleFacade == null);
    }

    @Test
    public void paramNull(){
        UpdateUserAndRoleRequest updateUserAndRoleRequest = new  UpdateUserAndRoleRequest();
        SimpleReponse commonResponse = updateUserAndRoleFacade.execute(updateUserAndRoleRequest);
        log.info(commonResponse.toString());
    }

    @Test
    public void TokenIdNull(){
        UpdateUserAndRoleRequest updateUserAndRoleRequest = new  UpdateUserAndRoleRequest();
        updateUserAndRoleRequest.setInitiationID("abc");
        updateUserAndRoleRequest.setUsrid(1);
        updateUserAndRoleRequest.setUsrname("ljk");
        SimpleReponse commonResponse = updateUserAndRoleFacade.execute(updateUserAndRoleRequest);
        log.info(commonResponse.toString());
    }
}
