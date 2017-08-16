package com.kang.boot.dal.mapper;

import com.kang.boot.dal.model.UsrRoleLink;

public interface UsrRoleLinkMapper {
    int deleteByPrimaryKey(Integer linkid);

    int insert(UsrRoleLink record);

    int insertSelective(UsrRoleLink record);

    UsrRoleLink selectByPrimaryKey(Integer linkid);

    int updateByPrimaryKeySelective(UsrRoleLink record);

    int updateByPrimaryKey(UsrRoleLink record);
}