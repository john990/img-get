package com.wget;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kai.wang on 12/27/13.
 */
public class WGet {

	private ExecutorService pool;
	public WGet(Builder builder){
		pool = Executors.newFixedThreadPool(builder.threadPoolSize);
	}

	public void download(){

	}

	public static class Builder{
		private int threadPoolSize;

		/**
		 * 设置线程池大小
		 * @param threadPoolSize
		 * @return
		 */
		public Builder setThreadPoolSize(int threadPoolSize) {
			this.threadPoolSize = threadPoolSize;
			return this;
		}
	}
}

