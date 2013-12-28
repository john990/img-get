package com.get;

import com.get.info.DownloadInfo;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by kai.wang on 12/27/13.
 */
public class HttpGet {

	private ThreadPoolExecutor pool;

	private String outputFloder;

	private Downloader.DownloadListener listener;

	public HttpGet(Builder builder){
		pool = new ThreadPoolExecutor(builder.threadPoolSize,builder.threadPoolSize, 1,
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
//		pool = Executors.newFixedThreadPool(builder.threadPoolSize);
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
	public boolean hasTask(){
		return pool.getActiveCount() == 0;
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
			File file = new File(outputFloder);
			if(!file.exists()){
				file.mkdirs();
			}
			return this;
		}

		public HttpGet build(){
			return new HttpGet(this);
		}
	}
}

