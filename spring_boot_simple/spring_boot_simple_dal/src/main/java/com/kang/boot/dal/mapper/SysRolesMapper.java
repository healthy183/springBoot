package com.kang.boot.dal.mapper;

import com.kang.boot.dal.model.SysRoles;

public interface SysRolesMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(SysRoles record);

    int insertSelective(SysRoles record);

    SysRoles selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(SysRoles record);

    int updateByPrimaryKey(SysRoles record);
}