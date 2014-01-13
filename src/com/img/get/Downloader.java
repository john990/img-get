package com.img.get;

import com.img.get.info.DownloadInfo;

/**
 * Created by kai.wang on 12/27/13.
 */
public abstract class Downloader implements Runnable {



	public interface DownloadListener{
		void onStart(DownloadInfo downloadInfo);

		void onFinish(DownloadInfo downloadInfo);

		void onProgressChange(DownloadInfo downloadInfo);

		void onFail(DownloadInfo downloadInfo);
	}
}
