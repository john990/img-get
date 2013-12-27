package com.wget;

import com.wget.info.DownloadInfo;
import com.wget.util.UrlUtil;

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
public class HttpDownloader extends Downloader{

	private DownloadInfo downloadInfo;

	public HttpDownloader(String url){
		this(url, UrlUtil.getFileNameFromUrl(url));
	}

	public HttpDownloader(String url,String outputFileName){
		downloadInfo.setUrl(url);
		downloadInfo.setOutputName(outputFileName);
	}

	@Override
	public void run() {
		httpDownload(downloadInfo);
	}

	/**http下载*/
	public static boolean httpDownload(DownloadInfo downloadInfo){
		// 下载网络文件
		int bytesum = 0;
		int byteread = 0;

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
//			conn.getContentLength();
			byte[] buffer = new byte[1204];
			while ((byteread = inStream.read(buffer)) != -1) {
				bytesum += byteread;
				System.out.println(bytesum);
				fs.write(buffer, 0, byteread);
			}
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
