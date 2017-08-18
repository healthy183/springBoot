package com.kang.boot.facade.impl;

import com.kang.boot.bo.request.UserAndRoleBO;
import com.kang.boot.bo.response.UserAndRoleRBO;
import com.kang.boot.common.CommonRequest;
import com.kang.boot.common.CommonResponse;
import com.kang.boot.common.enums.TransResCode;
import com.kang.boot.common.validate.ValidatorChain;
import com.kang.boot.facade.UpdateUserAndRoleFacade;
import com.kang.boot.facade.base.SimpleBaseFacade;
import com.kang.boot.facade.converter.UserAndRoleConverter;
import com.kang.boot.facade.validate.TokenIdValidator;
import com.kang.boot.request.UpdateUserAndRoleRequest;
import com.kang.boot.response.SimpleReponse;
import com.kang.boot.response.UpdateUserAndRoleResponse;
import com.kang.boot.service.UserAndRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */
@Service
@ValidatorChain(TokenIdValidator.class)
public class UpdateUserAndRoleFacadeImpl  extends SimpleBaseFacade<UpdateUserAndRoleRequest,SimpleReponse> implements UpdateUserAndRoleFacade {

    @Autowired
    private UserAndRoleService userAndRoleService;


    @Override
    public SimpleReponse<UpdateUserAndRoleResponse> execute(UpdateUserAndRoleRequest updateUserAndRoleRequest) {
        return (SimpleReponse<UpdateUserAndRoleResponse>) superExecute(updateUserAndRoleRequest);
    }

    @Override
    protected CommonResponse doExecute(CommonRequest commonRequest) {
        UpdateUserAndRoleRequest updateUserAndRoleRequest = (UpdateUserAndRoleRequest)commonRequest;
        UserAndRoleBO userAndRoleBO = UserAndRoleConverter.toBO(updateUserAndRoleRequest);
        UserAndRoleRBO userAndRoleRBO = userAndRoleService.updateUserAndRole(userAndRoleBO);
        SimpleReponse<UpdateUserAndRoleResponse> simpleReponse  = new  SimpleReponse<UpdateUserAndRoleResponse>();
        simpleReponse.setResult(UserAndRoleConverter.toResponse(userAndRoleRBO));
        simpleReponse.setErrorCode(TransResCode.PGW_SUCCESS.getResCode());
        simpleReponse.setErrorMsg(TransResCode.PGW_SUCCESS.getResDes());
        return simpleReponse;
    }
}
