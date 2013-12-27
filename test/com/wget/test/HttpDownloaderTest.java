package com.wget.test;

import com.wget.info.DownloadInfo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by kai.wang on 12/27/13.
 */
public class HttpDownloaderTest {
	public boolean httpDownload(DownloadInfo downloadInfo) {
		int downloaded = 0;
		int size = 0;
		int readed = 0;

		URL url = null;
		try {
			url = new URL(downloadInfo.getUrl());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			return false;
		}

		try {
			URLConnection conn = url.openConnection();
			InputStream inStream = conn.getInputStream();
			FileOutputStream fs = new FileOutputStream(downloadInfo.getOutputName());
			size = conn.getContentLength();
			downloadInfo.setSize(size);

			byte[] buffer = new byte[1204];
			while ((readed = inStream.read(buffer)) != -1) {
				downloaded += readed;
				fs.write(buffer, 0, readed);

			}
			fs.flush();

			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
