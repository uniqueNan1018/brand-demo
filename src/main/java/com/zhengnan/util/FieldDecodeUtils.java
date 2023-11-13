package com.zhengnan.util;

import java.nio.charset.StandardCharsets;

public class FieldDecodeUtils {
    public static String decode(String str) {
        if (str == null) return "";
        byte[] strBytes = str.getBytes(StandardCharsets.ISO_8859_1);
        return new String(strBytes, StandardCharsets.UTF_8).trim();
    }
}
