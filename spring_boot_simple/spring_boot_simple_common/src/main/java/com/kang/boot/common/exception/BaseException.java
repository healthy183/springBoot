package com.kang.boot.common.exception;


import com.kang.boot.common.enums.TransResCode;
import lombok.Getter;

/**
 * 创建异常类
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1165876351848409310L;
    @Getter
    private final String code;

    public BaseException(String code) {
        this.code = code;
    }

    public BaseException(String code, Throwable throwable) {
        super(throwable);
        this.code = code;
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }
  public BaseException(TransResCode transResCode) {
        super(transResCode.getResDes());
        this.code = transResCode.getResCode();
    }

    public BaseException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }
}
