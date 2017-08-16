package com.kang.boot.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/15.
 * @Author Healthy
 * @Version
 */

public class EnumUtil {
    public EnumUtil() {
    }

    public static <T extends Enum<T>> T fromEnumValue(Class<T> enumClass, String property, String propValue) {
        Enum[] enumConstants = (Enum[])enumClass.getEnumConstants();
        String methodName = "get" + StringUtils.capitalize(property);
        Enum[] arr$ = enumConstants;
        int len$ = enumConstants.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Enum t = arr$[i$];

            try {
                Object constantPropValue = t.getDeclaringClass().getDeclaredMethod(methodName, new Class[0]).invoke(t, new Object[0]);
                if(constantPropValue.equals(propValue)) {
                    return (T)t;
                }
            } catch (Exception var11) {
                throw new RuntimeException(var11);
            }
        }

        throw new EnumConstantNotPresentException(enumClass, propValue);
    }

    public static String getEnumProperty(Enum enumObject, String property) {
        String methodName = "get" + StringUtils.capitalize(property);

        Object constantPropValue;
        try {
            constantPropValue = enumObject.getDeclaringClass().getDeclaredMethod(methodName, new Class[0]).invoke(enumObject, new Object[0]);
        } catch (Exception var5) {
            throw new RuntimeException(String.format("could not found settable filed [%s] in [%s]", new Object[]{property, enumObject.getDeclaringClass()}), var5);
        }

        return constantPropValue.toString();
    }

    public static String getEnumDesc(Enum enumObject) {
        return getEnumProperty(enumObject, "desc");
    }

    public static <T extends Enum<T>> String getEnumDescByCode(String code, Class<T> clazz) {
        Enum enumObject = null;

        try {
            enumObject = fromEnumValue(clazz, "code", code.trim());
        } catch (EnumConstantNotPresentException var4) {
            return code;
        }

        return getEnumDesc(enumObject);
    }

    public static <T extends Enum<T>> T resolveFromCode(String code, Class<T> clazz) {
        return fromEnumValue(clazz, "code", code.trim());
    }
}

