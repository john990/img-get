package com.wget;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kai.wang on 12/27/13.
 */
public class WGet {

	private ExecutorService pool;

	private String outputFloder;

	private Downloader.DownloadListener listener;

	public WGet(Builder builder){
		pool = Executors.newFixedThreadPool(builder.threadPoolSize);
		outputFloder = builder.outputFloder;
		this.listener = builder.listener;
	}

	public void addTask(String url,String outputFileName){
		HttpDownloader downloader = new HttpDownloader(url,outputFloder,outputFileName);
		downloader.setDownloadListener(listener);
		pool.execute(downloader);
	}

	public static class Builder{
		private int threadPoolSize;

		private String outputFloder = "/";

		private Downloader.DownloadListener listener;

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

		public Builder setDownloadListener(Downloader.DownloadListener listener) {
			this.listener = listener;
			return this;
		}

		public WGet build(){
			return new WGet(this);
		}
	}
}

