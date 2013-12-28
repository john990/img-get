package com.get;

import com.get.info.DownloadInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kai.wang on 12/27/13.
 */
public class HttpGet {

	private ExecutorService pool;

	private String outputFloder;

	private Downloader.DownloadListener listener;

	public HttpGet(Builder builder){
		pool = Executors.newFixedThreadPool(builder.threadPoolSize);
		outputFloder = builder.outputFloder;
	}

	public void addTask(DownloadInfo downloadInfo){
		downloadInfo.setOutputFloder(outputFloder);
		HttpDownloader downloader = new HttpDownloader(downloadInfo);
		downloader.setDownloadListener(listener);
		pool.execute(downloader);
	}

	/**
	 * 任务是否全部完成
	 * @return
	 */
	public boolean isShutdown(){
		return pool.isShutdown();
	}

	public void setDownloadListener(Downloader.DownloadListener listener) {
		this.listener = listener;
	}

	public static class Builder{
		private int threadPoolSize;

		private String outputFloder = "/";

		/**
		 * 设置线程池大小
		 * @param threadPoolSize
		 * @return
		 */
		public Builder setThreadPoolSize(int threadPoolSize) {
			this.threadPoolSize = threadPoolSize;
			return this;
		}

		/**
		 * 设置下载文件存放的文件夹
		 * @param outputFloder
		 * @return
		 */
		public Builder setOutputFloder(String outputFloder) {
			this.outputFloder = outputFloder;
			return this;
		}

		public HttpGet build(){
			return new HttpGet(this);
		}
	}
}

