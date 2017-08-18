package com.kang.boot.common;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/15.
 * @Author Healthy
 * @Version
 */
public class CommonResponse<T extends java.io.Serializable> implements Serializable {
    private static final long serialVersionUID = -3214885479484534221L;
    private String initiationID;
    private T result;
    private String errorCode;
    private String errorMsg;

    public CommonResponse() {
    }

    public CommonResponse(T result) {
        this.result = result;
    }

    public CommonResponse(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            CommonResponse response = (CommonResponse)o;
            return !this.errorCode.equals(response.errorCode)?false:(!this.errorMsg.equals(response.errorMsg)?false:this.result.equals(response.result));
        } else {
            return false;
        }
    }

    public int hashCode() {
        byte result1 = 1;
        int result11 = 31 * result1 + this.result.hashCode();
        result11 = 31 * result11 + this.errorCode.hashCode();
        result11 = 31 * result11 + this.errorMsg.hashCode();
        return result11;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("result", this.result).add("errorCode", this.errorCode).add("errorMsg", this.errorMsg).omitNullValues().toString();
    }

    public String getInitiationID() {
        return initiationID;
    }

    public void setInitiationID(String initiationID) {
        this.initiationID = initiationID;
    }
}

