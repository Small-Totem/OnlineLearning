package com.cqu.online_learning.utils;

import org.springframework.util.DigestUtils;
import java.nio.charset.StandardCharsets;

public class StaticUtils {
    public static String getMD5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
    }
}
