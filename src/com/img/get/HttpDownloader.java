package com.img.get;

import com.img.get.info.DownloadInfo;
import com.img.get.util.Util;

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
public class HttpDownloader extends Downloader {

	private DownloadInfo downloadInfo;
	private DownloadListener listener;

	public HttpDownloader(DownloadInfo downloadInfo) {
		this.downloadInfo = downloadInfo;
	}

	@Override
	public void run() {
		httpDownload(downloadInfo);
	}


	public void setDownloadListener(DownloadListener listener) {
		this.listener = listener;
	}

	public boolean httpDownload(DownloadInfo downloadInfo) {
		float downloaded = 0;
		float size = 0;
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
			FileOutputStream fs = new FileOutputStream(downloadInfo.getOutputFloder() + downloadInfo.getOutputName() + Util.mimeToCommmonType(conn.getContentType()));
			size = conn.getContentLength();
			downloadInfo.setSize((int) size);

			if (listener != null) listener.onStart(downloadInfo);

			byte[] buffer = new byte[10240];
			while ((readed = inStream.read(buffer)) != -1) {
				downloaded += readed;
				fs.write(buffer, 0, readed);
				downloadInfo.setPercent((int) ((downloaded / size) * 100));
				if (listener != null) listener.onProgressChange(downloadInfo);
			}
			fs.flush();

			if (listener != null) listener.onFinish(downloadInfo);

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
