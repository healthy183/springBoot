package com.kang.boot.dal.mapper.test;

import com.kang.boot.dal.mapper.SysRolesMapper;
import com.kang.boot.dal.model.SysRoles;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/16.
 * @Author Healthy
 * @Version
 */
public class SysRolesMapperTest extends  BaseTest {

    @Autowired
    private SysRolesMapper sysRolesMapper;

    @Test
    public void run(){
        SysRoles sysRoles = new SysRoles();
        sysRoles.setRolename("梁健康");
        sysRoles.setRoleurl("abc");
        sysRolesMapper.insert(sysRoles);
    }
}
