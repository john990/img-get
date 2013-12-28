package com.get.test.util;

import com.get.Downloader;
import com.get.HttpGet;
import com.get.info.DownloadInfo;

/**
 * Created by kai on 12/28/13.<br/>
 * Function :
 */
public class DownloadProgress implements Downloader.DownloadListener {

	PrintTask print = new PrintTask();

	private HttpGet httpGet;

	public DownloadProgress(HttpGet httpGet) {
		this.httpGet = httpGet;
	}

	@Override
	public void onStart(DownloadInfo downloadInfo) {
		print.printStart(downloadInfo);
	}

	@Override
	public void onFinish(DownloadInfo downloadInfo) {
		print.printFinish(downloadInfo);
		if (httpGet.isShutdown()) {
			System.exit(1);
		}
	}

	@Override
	public void onProgressChange(DownloadInfo downloadInfo) {
		print.printProgress(downloadInfo);
	}

	@Override
	public void onFail(DownloadInfo downloadInfo) {
		print.printFail(downloadInfo);
		if (httpGet.isShutdown()) {
			System.exit(1);
		}
	}
}
