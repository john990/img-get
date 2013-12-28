package com.get.test.util;

import com.get.info.DownloadInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kai on 12/28/13.<br/>
 * Function :
 */
public class PrintTask {
	ArrayList<DownloadInfo> printQueue = new ArrayList<DownloadInfo>();

	private static final int PROGRESS_SIZE = 50;
	private static int prePieceSize = 0;

	static {
		prePieceSize = 100 / PROGRESS_SIZE;
	}

	public void printStart(DownloadInfo info) {
		synchronized (printQueue) {
			info.setState(DownloadInfo.STATE_START);
			printQueue.add(info);
			print();
		}
	}
	public void printProgress(DownloadInfo info) {
		synchronized (printQueue) {
			info.setState(DownloadInfo.STATE_PROGRESS);
			printQueue.add(info);
			print();
		}
	}
	public void printFinish(DownloadInfo info) {
		synchronized (printQueue) {
			info.setState(DownloadInfo.STATE_FINISH);
			printQueue.add(info);
			print();
		}
	}

	public void printFail(DownloadInfo info) {
		synchronized (printQueue) {
			info.setState(DownloadInfo.STATE_FAIL);
			printQueue.add(info);
			print();
		}
	}

	private synchronized void print() {
		StringBuffer print = new StringBuffer();
		synchronized (printQueue) {
			List<DownloadInfo> queue = (List<DownloadInfo>) printQueue.clone();
			List<Integer> finished = new ArrayList<Integer>();
			System.out.print("\\b\\b\\b\\b\\b");
			for (int i=0;i<queue.size();i++) {
				DownloadInfo progress = queue.get(i);
				if (progress.getState() == DownloadInfo.STATE_START) {
					print.append("| " + progress.getUrl() + "\n| " + getProgress(0) + " 0%");
				} else if (progress.getState() == DownloadInfo.STATE_PROGRESS) {
					print.append("| " + progress.getUrl() + "\n| " + getProgress(progress.getPercent()) + " " + progress.getPercent() + "%");
				} else if (progress.getState() == DownloadInfo.STATE_FINISH) {
					print.append("| " + progress.getUrl() + "\n| " + getProgress(100) + " 100%");
					finished.add(i);
				} else if (progress.getState() == DownloadInfo.STATE_FAIL) {
					print.append("| " + progress.getUrl() + "\n| " + "[ download fail ]");
					finished.add(i);
				}
				print.append("\n\n");
			}
			System.out.println(print);

			for(int index : finished){
				printQueue.remove(index);
			}
		}
	}

	private String getProgress(int progress) {
		StringBuffer sb = new StringBuffer();
		int done = progress / prePieceSize;
		sb.append("[");
		for (int i = 0; i < PROGRESS_SIZE; i++) {
			if (i < done) {
				sb.append("=");
			} else {
				sb.append("-");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
