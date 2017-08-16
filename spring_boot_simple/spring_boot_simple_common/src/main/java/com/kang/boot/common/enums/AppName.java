package com.kang.boot.common.enums;

import com.kang.boot.common.utils.EnumUtil;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/15.
 * @Author Healthy
 * @Version
 */

public enum AppName {
    PE("PE", "支付引擎", "05");

    private String code;
    private String desc;
    private String number;

    private AppName(String code, String desc, String number) {
        this.code = code;
        this.desc = desc;
        this.number = number;
    }

    public static AppName resolve(String code) {
        return (AppName) EnumUtil.resolveFromCode(code, AppName.class);
    }

    public String toString() {
        return "AppName(code=" + this.getCode() + ", desc=" + this.getDesc() + ", number=" + this.getNumber() + ")";
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getNumber() {
        return this.number;
    }
}

