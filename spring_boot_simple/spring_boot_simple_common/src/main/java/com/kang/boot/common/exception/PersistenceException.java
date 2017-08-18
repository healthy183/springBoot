package com.kang.boot.common.exception;


import com.kang.boot.common.context.BaseContext;
import com.kang.boot.common.enums.TransResCode;

/**
 * @Title 类名
 * @Description 持久化异常
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */
public class PersistenceException extends RemoteException {

    private static final long serialVersionUID = -1609049612624373627L;

    public PersistenceException(BaseContext baseContext, TransResCode transResCode) {
        super(baseContext, transResCode);
    }

    public PersistenceException(BaseContext baseContext, String resCode, String resMsg) {
        super(baseContext, resCode, resMsg);
    }
}
