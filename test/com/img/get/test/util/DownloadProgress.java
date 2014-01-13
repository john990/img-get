package com.img.get.test.util;

import com.img.get.Downloader;
import com.img.get.ImgGet;
import com.img.get.info.DownloadInfo;

import javax.swing.JTextArea;

/**
 * Created by kai on 12/28/13.<br/>
 * Function :
 */
public class DownloadProgress implements Downloader.DownloadListener {

	PrintTask print;

	private ImgGet imgGet;
	private JTextArea console;
	public DownloadProgress(ImgGet imgGet,JTextArea console) {
		this.imgGet = imgGet;
		this.console = console;
		print = new PrintTask(console);
	}

	@Override
	public void onStart(DownloadInfo downloadInfo) {
		print.printStart(downloadInfo);
	}

	@Override
	public void onFinish(DownloadInfo downloadInfo) {
		print.printFinish(downloadInfo);
		if (imgGet.hasTask()) {
			System.out.println("all download finish!");
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
		if (imgGet.hasTask()) {
			System.exit(1);
		}
	}
}
