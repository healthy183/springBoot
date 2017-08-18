package com.kang.boot.request;

import com.kang.boot.common.CommonRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */
@Data
public class UpdateUserAndRoleRequest extends CommonRequest {

    @NotNull(message="用户id不能为空")
    private Integer usrid;
    @NotNull(message="用户名称不能为空")
    private String usrname;
}
