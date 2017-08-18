package com.kang.boot.service.impl;

import com.kang.boot.bo.request.UserAndRoleBO;
import com.kang.boot.bo.response.UserAndRoleRBO;
import com.kang.boot.service.UserAndRoleService;
import org.springframework.stereotype.Service;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/18.
 * @Author Healthy
 * @Version
 */
@Service
public class UserAndRoleServiceImpl implements UserAndRoleService {
    @Override
    public UserAndRoleRBO updateUserAndRole(UserAndRoleBO userAndRoleBO) {
        UserAndRoleRBO userAndRoleRBO = new UserAndRoleRBO();
        userAndRoleRBO.setUpdateCount(1);
        return userAndRoleRBO;
    }
}
