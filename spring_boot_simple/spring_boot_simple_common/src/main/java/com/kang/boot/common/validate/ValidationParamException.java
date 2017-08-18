package com.kang.boot.common.validate;

import com.kang.boot.common.exception.RemoteException;
import com.kang.boot.common.context.BaseContext;
import com.kang.boot.common.enums.TransResCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ValidationParamException extends RemoteException {
    private static final long serialVersionUID = -7168688399206854036L;

    public ValidationParamException(BaseContext baseContext, TransResCode transResCode) {
        super(baseContext, transResCode);
    }

    public ValidationParamException(BaseContext baseContext, String resCode, String resMsg) {
        super(baseContext, resCode, resMsg);
    }

    public ValidationParamException(BaseContext baseContext, TransResCode transResCode, Object res) {
        super(baseContext, transResCode);
        baseContext.setResult(res);
    }

}
