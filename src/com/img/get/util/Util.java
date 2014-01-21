package com.img.get.util;

/**
 * Created by kai on 12/28/13.<br/>
 * Function :
 */
public class Util {

    public static String byteToKb(long bytes) {
        return ((float) bytes) / 1024 + "KB";
    }

    public static String mimeToCommmonType(String mime) {
        return "." + mime.substring(mime.lastIndexOf("/") + 1, mime.length());
    }
}
