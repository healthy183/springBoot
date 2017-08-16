package com.kang.boot.dal.mapper;

import com.kang.boot.dal.model.SysUsers;

public interface SysUsersMapper {
    int deleteByPrimaryKey(Integer usrid);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    SysUsers selectByPrimaryKey(Integer usrid);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);
}