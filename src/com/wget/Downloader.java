package com.wget;

import com.wget.info.DownloadInfo;

/**
 * Created by kai.wang on 12/27/13.
 */
public abstract class Downloader implements Runnable {



	public interface DownloadListener{
		void onStart(DownloadInfo downloadInfo);

		void onFinish(DownloadInfo downloadInfo);

		void onProgressChange(int progress);

		void onFail(DownloadInfo downloadInfo);
	}
}
