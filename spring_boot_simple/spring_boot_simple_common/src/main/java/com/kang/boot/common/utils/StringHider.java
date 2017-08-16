package com.kang.boot.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/15.
 * @Author Healthy
 * @Version
 */


public class StringHider {
    public static final Character DEFAULT_CHARACTER = Character.valueOf('*');

    public StringHider() {
    }

    public static String hide(String str, int endOffset) {
        return hide(str, 0, endOffset, DEFAULT_CHARACTER);
    }

    public static String hide(String str, int beginOffset, int endOffset) {
        return hide(str, beginOffset, endOffset, DEFAULT_CHARACTER);
    }

    public static String hide(String str, int endOffset, Character character) {
        return hide(str, 0, endOffset, character);
    }

    public static String hide(String str, int beginOffset, int endOffset, Character character) {
        if(StringUtils.isEmpty(str)) {
            return str;
        } else {
            int endIndex = str.length() - endOffset;
            String leftPlainTextPart = str.substring(0, beginOffset);
            String rightPlainTextPart = str.substring(endIndex);
            String toReplaceString = str.substring(beginOffset, endIndex);
            String replaceResult = StringUtils.repeat(character.charValue(), toReplaceString.length());
            return leftPlainTextPart + replaceResult + rightPlainTextPart;
        }
    }
}

