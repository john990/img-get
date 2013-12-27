package com.wget;

/**
 * Created by kai.wang on 12/27/13.
 */
public abstract class Downloader implements Runnable {



	public interface DownloadListener{
		void onFinish();

		void onProgressChange(int progress);
	}
}
