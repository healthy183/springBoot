package com.kang.boot.common.utils;

import java.io.Serializable;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/15.
 * @Author Healthy
 * @Version
 */


public class SensitiveDataWrapper implements Serializable {
    private static final long serialVersionUID = 2606620321171763649L;
    private String value;
    private int beginOffset;
    private int endOffset;
    private boolean returnOrigValue;

    public SensitiveDataWrapper(String value) {
        this(value, 0, 1);
    }

    public SensitiveDataWrapper(String value, int endOffset) {
        this(value, 0, endOffset);
    }

    public SensitiveDataWrapper(String value, int beginOffset, int endOffset) {
        this.value = value;
        this.beginOffset = beginOffset;
        this.endOffset = endOffset;
    }

    public String toString() {
        return this.returnOrigValue?this.value:StringHider.hide(this.value, this.beginOffset, this.endOffset);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setReturnOrigValue(boolean returnOrigValue) {
        this.returnOrigValue = returnOrigValue;
    }

    public boolean isReturnOrigValue() {
        return this.returnOrigValue;
    }
}

