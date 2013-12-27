package com.wget.info;

/**
 * Created by kai.wang on 12/27/13.
 * 下载文件信息
 */
public class DownloadInfo {
	private long size = 0;
	private String name;
	private String mime;
	private String url;
	private int percent;
	private String outputName;
	private String outputFloder;

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public String getOutputName() {
		return outputName;
	}

	public void setOutputName(String outputName) {
		this.outputName = outputName;
	}

	public String getOutputFloder() {
		return outputFloder;
	}

	public void setOutputFloder(String outputFloder) {
		this.outputFloder = outputFloder;
	}
}
