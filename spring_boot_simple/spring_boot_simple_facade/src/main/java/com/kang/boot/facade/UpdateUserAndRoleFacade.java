package com.kang.boot.facade;

import com.kang.boot.request.UpdateUserAndRoleRequest;
import com.kang.boot.response.SimpleReponse;
import com.kang.boot.response.UpdateUserAndRoleResponse;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/16.
 * @Author Healthy
 * @Version
 */
public interface UpdateUserAndRoleFacade {

    public SimpleReponse<UpdateUserAndRoleResponse> execute(UpdateUserAndRoleRequest updateUserAndRoleRequest);

}
