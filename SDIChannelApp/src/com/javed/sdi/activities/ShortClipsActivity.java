package com.javed.sdi.activities;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.javed.sdi.R;
import com.javed.sdi.adater.CustomListAdapter;
import com.javed.sdi.app.AppController;
import com.javed.sdi.model.Video;


@SuppressLint("NewApi")
public class ShortClipsActivity extends Activity {
	// Log tag
	private static final String TAG = PlaylistVideos.class.getSimpleName();

	// Videos json url
	private static String url ="";
	private ProgressDialog pDialog;
	private List<Video> videoList = new ArrayList<Video>();
	private ListView listView;
	private CustomListAdapter adapter;
	private String speakername="Short Clips";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		listView = (ListView) findViewById(R.id.list);
		adapter = new CustomListAdapter(this, videoList);
		
		 
		 url = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+"PLNngVRDXb8ayAB5146YkgY_mR7WC4io1h"+"&key=AIzaSyCOMLqATGL5jS_UAp79mBkpzf-lN58y0R0&maxResults=50";
	     
		 setTitle(speakername);
	     
	     Typeface tf = Typeface.createFromAsset(getAssets(), "RobotoSlab-Light.ttf");
	     getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
	     getActionBar().setCustomView(R.layout.action_bar);
	     TextView title = (TextView)findViewById(R.id.activity_title);
	     title.setTypeface(tf);
	     title.setText("Short Clips");
	   
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				Video v = (Video) adapter.getItem(position);
				String video_title = v.getTitle();
				String video_id = v.getVideoId();

				// Starting single contact activity
				Intent in = new Intent(getApplicationContext(),PlayVideo.class);
				in.putExtra("video_id", video_id);
				in.putExtra("video_title", video_title);
				in.putExtra("speaker_name", speakername);
				startActivity(in);
				
				//Toast.makeText(getApplicationContext(), "Video id is "+video_id+" video title is: "+video_title, 5000).show();

			}
		});

		pDialog = new ProgressDialog(this);
		// Showing progress dialog before making http request
		pDialog.setMessage("Loading...");
		pDialog.show();

		// Creating volley request obj
		JsonObjectRequest movieReq = new JsonObjectRequest(url,
				null, new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						Log.d(TAG, response.toString());
						hidePDialog();

						JSONArray videos = null;
						try {
							videos = response.getJSONArray("items");
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// Parsing json
						for (int i = 0; i < videos.length(); i++) {
							try {

								JSONObject c = videos.getJSONObject(i);
								JSONObject snippet = c.getJSONObject("snippet");
								Video video = new Video();
								video.setTitle(snippet.getString("title"));
								video.setVideoId(snippet.getJSONObject("resourceId").getString("videoId"));
								video.setThumbnailUrl(snippet.getJSONObject("thumbnails").getJSONObject("default").getString("url"));
								videoList.add(video);

							} catch (JSONException e) {
								e.printStackTrace();
							}

						}

						// notifying list adapter about data changes
						// so that it renders the list view with updated data
						adapter.notifyDataSetChanged();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						VolleyLog.d(TAG, "Error: " + error.getMessage());
						hidePDialog();

					}
				});

		// Adding request to request queue
		AppController.getInstance().addToRequestQueue(movieReq);
	}
	
	
	

	@Override
	public void onDestroy() {
		super.onDestroy();
		hidePDialog();
	}

	private void hidePDialog() {
		if (pDialog != null) {
			pDialog.dismiss();
			pDialog = null;
		}
	}
}
