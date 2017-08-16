package com.kang.springmybatis.service.impl;

import com.kang.springmybatis.api.AddUserRoleService;
import com.kang.springmybatis.biz.api.UserRoleBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/2.
 * @Author Healthy
 * @Version
 */
@Service
public class AddUserRoleServiceImpl  implements AddUserRoleService {

    @Autowired
    private UserRoleBiz userRoleBiz;

    @Override
    public void doAdd() {

    }
}
