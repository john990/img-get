package com.img.get.util;

/**
 * Created by kai.wang on 12/27/13.
 */
public class UrlUtil {

	public static String getFileNameFromUrl(String url) {
		if (url == null) {
			return "";
		}
		return url.substring(url.lastIndexOf("/") + 1, url.length());
	}
}
