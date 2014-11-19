package com.javed.sdi.model;

import android.R;

public class Speaker 
{
	private String name,playlist_id;
	private R.drawable photo;
	
	Speaker(String name, String playlist_id, R.drawable photo)
	{
		this.name=name;
		this.photo=photo;
		this.playlist_id=playlist_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public R.drawable getPhoto() {
		return photo;
	}

	public void setPhoto(R.drawable photo) {
		this.photo = photo;
	}

	public String getPlaylist_id() {
		return playlist_id;
	}

	public void setPlaylist_id(String playlist_id) {
		this.playlist_id = playlist_id;
	}

	
}
