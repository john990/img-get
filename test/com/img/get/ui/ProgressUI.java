package com.img.get.ui;

import com.img.get.ImgGet;
import com.img.get.info.DownloadInfo;
import com.img.get.test.util.DownloadProgress;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Created by kai on 12/28/13.<br/>
 * Function :
 */
public class ProgressUI implements WindowListener{
	JFrame frame;
	JPanel panel;
	JTextArea textArea;


	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		ProgressUI ui = new ProgressUI();
		ui.frame = new JFrame("http-get");
		ui.panel = new JPanel();
		ui.textArea = new JTextArea();
		ui.textArea.setText("download");
		ui.textArea.setRows(15);
		ui.textArea.setColumns(80);
		ui.panel.setSize(900, 400);
		ui.panel.add(ui.textArea);
		ui.frame.add(ui.panel);
		ui.frame.setSize(900, 400);
		ui.frame.setLocation(400, 200);
		ui.frame.setVisible(true);
		ui.frame.addWindowListener(new ProgressUI());
		ImgGet wget = new ImgGet.Builder().setThreadPoolSize(4).setOutputFloder("/http-get/").build();
		DownloadProgress progress = new DownloadProgress(wget,ui.textArea);
		wget.setDownloadListener(progress);
		for (int i = 0; i < urls.length; i++) {
			DownloadInfo downloadInfo = new DownloadInfo();
			downloadInfo.setUrl(urls[i]);
			downloadInfo.setOutputName(i+"");
			downloadInfo.setFlag(i);
			wget.addTask(downloadInfo);
		}
		wget.finish();
	}

	public static String[] urls = {
			"http://personal-demo.u.qiniudn.com/Fvo0dUF8kAWNUAjm8Xjv3FWgudj3",
			"http://cdn1.evernote.com/win5/public/Evernote_5.1.0.2217.exe",
			"http://img.hb.aicdn.com/89f4b6c0226221e6401d2a4d44b160b1185229298374-8wspgi_fw236",
			"http://img.hb.aicdn.com/ca51eedf51f337ea3a5d73a01fd5d0bce5e3cca16f2fe-g436qJ_fw236",
			"http://img.hb.aicdn.com/e9bb779534da1c43d6ca6e49cfb5e972517c720013f87-36OAhB_fw236",
			"http://img.hb.aicdn.com/c0d918954f26a7d8b9b4ed42d964b581a21983a67c99e-trVNoz_fw236",
			"http://img.hb.aicdn.com/7e615f1ef19dd6ee342be2dd917b2b38759cc83c10931-y0T1M8_fw236",
			"http://img.hb.aicdn.com/89f4b6c0226221e6401d2a4d44b160b1185229298374-8wspgi_fw236",
			"http://img.hb.aicdn.com/ca51eedf51f337ea3a5d73a01fd5d0bce5e3cca16f2fe-g436qJ_fw236",
			"http://img.hb.aicdn.com/e9bb779534da1c43d6ca6e49cfb5e972517c720013f87-36OAhB_fw236",
			"http://img.hb.aicdn.com/c0d918954f26a7d8b9b4ed42d964b581a21983a67c99e-trVNoz_fw236",
			"http://img.hb.aicdn.com/7e615f1ef19dd6ee342be2dd917b2b38759cc83c10931-y0T1M8_fw236",
			"http://img.hb.aicdn.com/89f4b6c0226221e6401d2a4d44b160b1185229298374-8wspgi_fw236",
			"http://img.hb.aicdn.com/ca51eedf51f337ea3a5d73a01fd5d0bce5e3cca16f2fe-g436qJ_fw236",
			"http://img.hb.aicdn.com/e9bb779534da1c43d6ca6e49cfb5e972517c720013f87-36OAhB_fw236",
			"http://img.hb.aicdn.com/c0d918954f26a7d8b9b4ed42d964b581a21983a67c99e-trVNoz_fw236",
			"http://img.hb.aicdn.com/7e615f1ef19dd6ee342be2dd917b2b38759cc83c10931-y0T1M8_fw236",
			"http://img.hb.aicdn.com/89f4b6c0226221e6401d2a4d44b160b1185229298374-8wspgi_fw236",
			"http://img.hb.aicdn.com/ca51eedf51f337ea3a5d73a01fd5d0bce5e3cca16f2fe-g436qJ_fw236",
			"http://img.hb.aicdn.com/e9bb779534da1c43d6ca6e49cfb5e972517c720013f87-36OAhB_fw236",
			"http://img.hb.aicdn.com/c0d918954f26a7d8b9b4ed42d964b581a21983a67c99e-trVNoz_fw236",
			"http://img.hb.aicdn.com/7e615f1ef19dd6ee342be2dd917b2b38759cc83c10931-y0T1M8_fw236",
			"http://img.hb.aicdn.com/89f4b6c0226221e6401d2a4d44b160b1185229298374-8wspgi_fw236",
			"http://img.hb.aicdn.com/ca51eedf51f337ea3a5d73a01fd5d0bce5e3cca16f2fe-g436qJ_fw236",
			"http://img.hb.aicdn.com/e9bb779534da1c43d6ca6e49cfb5e972517c720013f87-36OAhB_fw236",
			"http://img.hb.aicdn.com/c0d918954f26a7d8b9b4ed42d964b581a21983a67c99e-trVNoz_fw236",
			"http://img.hb.aicdn.com/7e615f1ef19dd6ee342be2dd917b2b38759cc83c10931-y0T1M8_fw236",
			"http://img.hb.aicdn.com/89f4b6c0226221e6401d2a4d44b160b1185229298374-8wspgi_fw236",
			"http://img.hb.aicdn.com/ca51eedf51f337ea3a5d73a01fd5d0bce5e3cca16f2fe-g436qJ_fw236",
			"http://img.hb.aicdn.com/e9bb779534da1c43d6ca6e49cfb5e972517c720013f87-36OAhB_fw236",
			"http://img.hb.aicdn.com/c0d918954f26a7d8b9b4ed42d964b581a21983a67c99e-trVNoz_fw236",
			"http://img.hb.aicdn.com/7e615f1ef19dd6ee342be2dd917b2b38759cc83c10931-y0T1M8_fw236",
			"http://img.hb.aicdn.com/89f4b6c0226221e6401d2a4d44b160b1185229298374-8wspgi_fw236",
			"http://img.hb.aicdn.com/ca51eedf51f337ea3a5d73a01fd5d0bce5e3cca16f2fe-g436qJ_fw236",
			"http://img.hb.aicdn.com/e9bb779534da1c43d6ca6e49cfb5e972517c720013f87-36OAhB_fw236",
			"http://img.hb.aicdn.com/c0d918954f26a7d8b9b4ed42d964b581a21983a67c99e-trVNoz_fw236",
			"http://img.hb.aicdn.com/7e615f1ef19dd6ee342be2dd917b2b38759cc83c10931-y0T1M8_fw236",
			"http://img.hb.aicdn.com/89f4b6c0226221e6401d2a4d44b160b1185229298374-8wspgi_fw236",
			"http://img.hb.aicdn.com/ca51eedf51f337ea3a5d73a01fd5d0bce5e3cca16f2fe-g436qJ_fw236",
			"http://img.hb.aicdn.com/e9bb779534da1c43d6ca6e49cfb5e972517c720013f87-36OAhB_fw236",
			"http://img.hb.aicdn.com/c0d918954f26a7d8b9b4ed42d964b581a21983a67c99e-trVNoz_fw236"
	};

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
