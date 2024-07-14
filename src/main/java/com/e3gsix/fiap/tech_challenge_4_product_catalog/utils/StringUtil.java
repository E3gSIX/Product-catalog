package com.e3gsix.fiap.tech_challenge_4_product_catalog.utils;

public class StringUtil {
    public static  <T> String toStringWithNoClassName(T obj){
        return obj.toString().replace(obj.getClass().getSimpleName(), "");
    }
}
