package org.dhbw.mosbach.ai.keepyourday.objects;

// NewsInfo Objekt mit title und url
public class NewsInfo {

	private String title;
	private String url;

	public NewsInfo(String title, String url) {
		super();
		this.title = title;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
