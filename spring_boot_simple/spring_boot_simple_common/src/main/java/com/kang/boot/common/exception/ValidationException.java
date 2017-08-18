package com.kang.boot.common.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/17.
 * @Author Healthy
 * @Version
 */


public class ValidationException extends Exception {
    private List<String> errors = null;

    public ValidationException(String msg) {
        super(msg);
        this.errors = new ArrayList();
        this.errors.add(msg);
    }

    public ValidationException(List<String> msgList) {
        this.errors = msgList;
    }

    public String getMessage() {
        return this.listToString(this.errors);
    }

    public List<String> getMessageList() {
        return this.errors;
    }

    private String listToString(List<String> list) {
        StringBuffer sb = new StringBuffer();
        Iterator i$ = list.iterator();

        while(i$.hasNext()) {
            String str = (String)i$.next();
            sb.append(str);
            sb.append("\r\n");
        }

        return sb.toString().trim();
    }
}

