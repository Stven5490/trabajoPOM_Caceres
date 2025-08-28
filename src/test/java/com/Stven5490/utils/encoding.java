package com.Stven5490.utils;

import java.nio.charset.StandardCharsets;

public class encoding {
    public static String fixEncoding(String failedText){
        byte[] bytes = failedText.getBytes(StandardCharsets.ISO_8859_1);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
