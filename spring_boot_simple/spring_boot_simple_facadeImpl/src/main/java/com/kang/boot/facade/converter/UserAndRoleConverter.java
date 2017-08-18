package com.kang.boot.facade.converter;

import com.kang.boot.bo.request.UserAndRoleBO;
import com.kang.boot.bo.response.UserAndRoleRBO;
import com.kang.boot.request.UpdateUserAndRoleRequest;
import com.kang.boot.response.UpdateUserAndRoleResponse;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/18.
 * @Author Healthy
 * @Version
 */
public class UserAndRoleConverter {

    public  static UserAndRoleBO  toBO(UpdateUserAndRoleRequest updateUserAndRoleRequest){
        UserAndRoleBO userAndRoleBO = new UserAndRoleBO();
        userAndRoleBO.setUsrid(updateUserAndRoleRequest.getUsrid());
        userAndRoleBO.setUsrname(updateUserAndRoleRequest.getUsrname());
        return userAndRoleBO;
    }

    public  static UpdateUserAndRoleResponse toResponse(UserAndRoleRBO userAndRoleRBO){
        UpdateUserAndRoleResponse updateUserAndRoleResponse = new UpdateUserAndRoleResponse();
        updateUserAndRoleResponse.setUpdateCount(userAndRoleRBO.getUpdateCount());
        return updateUserAndRoleResponse;
    }



}
