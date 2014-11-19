package com.javed.sdi.model;

import java.util.ArrayList;

public class Video {
	private String title, thumbnailUrl,videoId;
	
	public Video() {
	}

	public Video(String name, String thumbnailUrl, int year, double rating,
			ArrayList<String> genre) {
		this.title = name;
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	
	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

}
