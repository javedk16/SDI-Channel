package com.javed.sdi.adater;



import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.javed.sdi.R;
import com.javed.sdi.app.AppController;
import com.javed.sdi.model.Video;

public class CustomListAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<Video> videoItems;
	private int lastPosition = -1;
	
	
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public CustomListAdapter(Activity activity, List<Video> videoItems) {
		this.activity = activity;
		this.videoItems = videoItems;
	}

	
	
	@Override
	public int getCount() {
		return videoItems.size();
	}

	
	
	@Override
	public Object getItem(int location) {
		return videoItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		
		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.list_row, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();
		NetworkImageView thumbNail = (NetworkImageView) convertView
				.findViewById(R.id.thumbnail);
		TextView title = (TextView) convertView.findViewById(R.id.title);
		
		Video m = videoItems.get(position);

		// thumbnail image
		thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);
		
		// title
		title.setText(m.getTitle());
		Typeface tf = Typeface.createFromAsset(title.getContext().getAssets(), "RobotoSlab-Light.ttf");
		title.setTypeface(tf);
		
		Animation animation = AnimationUtils.loadAnimation(activity, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
	    convertView.startAnimation(animation);
	    lastPosition = position;

		return convertView;
	}

	

}