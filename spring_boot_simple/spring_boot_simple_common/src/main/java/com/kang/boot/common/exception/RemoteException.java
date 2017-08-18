package com.kang.boot.common.exception;

import com.kang.boot.common.context.BaseContext;
import com.kang.boot.common.enums.TransResCode;
import lombok.Getter;

/**
 */
public abstract class RemoteException extends BaseException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4434075193480285710L;
    @Getter
    private final BaseContext baseContext;
    /**
     * 错误描述
     */
    @Getter
    private final String errorMsg;

    public RemoteException(BaseContext baseContext, TransResCode transResCode) {
        super(transResCode.getResCode());
        this.baseContext = baseContext;
        this.errorMsg = transResCode.getResDes();
    }

    public RemoteException(BaseContext baseContext, String resCode, String resMsg) {
        super(resCode, resMsg);
        this.baseContext = baseContext;
        this.errorMsg = resMsg;
    }

    @Override
    public String getMessage() {
        return String.format("[%s]%s.[%s]", super.getCode(), this.getErrorMsg(), baseContext.getCommonRequest().getInitiationID());
    }

}
