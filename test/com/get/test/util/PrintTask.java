package com.get.test.util;

import com.get.info.DownloadInfo;
import com.get.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

/**
 * Created by kai on 12/28/13.<br/>
 * Function :
 */
public class PrintTask {
	ArrayList<DownloadInfo> printQueue = new ArrayList<DownloadInfo>();

	private static final int PROGRESS_SIZE = 50;
	private static int prePieceSize = 0;
	private JTextArea console;

	static {
		prePieceSize = 100 / PROGRESS_SIZE;
	}

	public PrintTask(JTextArea console) {
		this.console = console;
	}

	public void printStart(DownloadInfo info) {
		synchronized (printQueue) {
			info.setState(DownloadInfo.STATE_START);
			if (printQueue.indexOf(info) == -1) {
				printQueue.add(info);
			}
			print();
		}
	}

	public void printProgress(DownloadInfo info) {
		synchronized (printQueue) {
			info.setState(DownloadInfo.STATE_PROGRESS);
			if (printQueue.indexOf(info) == -1) {
				printQueue.add(info);
			}
			print();
		}
	}

	public void printFinish(DownloadInfo info) {
		synchronized (printQueue) {
			info.setState(DownloadInfo.STATE_FINISH);
			if (printQueue.indexOf(info) == -1) {
				printQueue.add(info);
			}
			print();
		}
	}

	public void printFail(DownloadInfo info) {
		synchronized (printQueue) {
			info.setState(DownloadInfo.STATE_FAIL);
			if (printQueue.indexOf(info) == -1) {
				printQueue.add(info);
			}
			print();
		}
	}

	private synchronized void print() {
		synchronized (printQueue) {
			StringBuffer print = new StringBuffer();
			List<DownloadInfo> queue = (List<DownloadInfo>) printQueue.clone();
			List<Integer> finished = new ArrayList<Integer>();
			for (int i = 0; i < queue.size(); i++) {
				DownloadInfo progress = queue.get(i);
				if (progress.getState() == DownloadInfo.STATE_START) {
					print.append("| " + progress.getUrl() + "\n| " + getProgress(0) + " 0%  " + Util.byteToKb(progress.getSize()));
				} else if (progress.getState() == DownloadInfo.STATE_PROGRESS) {
					print.append("| " + progress.getUrl() + "\n| " + getProgress(progress.getPercent()) + " " + progress.getPercent() + "%  " + Util.byteToKb(progress.getSize()));
				} else if (progress.getState() == DownloadInfo.STATE_FINISH) {
					print.append("| " + progress.getUrl() + "\n| " + getProgress(100) + " 100%");
					finished.add(i);
				} else if (progress.getState() == DownloadInfo.STATE_FAIL) {
					print.append("| " + progress.getUrl() + "\n| " + "[ download fail ]");
					finished.add(i);
				}
				print.append("\n\n");
			}
			console.setText(print.toString());
			for (int index : finished) {
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
