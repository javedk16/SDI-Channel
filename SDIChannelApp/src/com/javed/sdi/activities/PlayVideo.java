package com.javed.sdi.activities;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.javed.sdi.R;

public class PlayVideo extends YouTubeBaseActivity implements
YouTubePlayer.OnInitializedListener{
 
 public static final String API_KEY = "AIzaSyCOMLqATGL5jS_UAp79mBkpzf-lN58y0R0";
 public static String video_id="";

    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_video);
        Typeface tf = Typeface.createFromAsset(getAssets(), "RobotoSlab-Light.ttf");
        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
        getActionBar().setCustomView(R.layout.action_bar);
        TextView actionbar_title = (TextView)findViewById(R.id.activity_title);
        TextView title = (TextView)findViewById(R.id.title);
	    
		actionbar_title.setTypeface(tf);
		title.setTypeface(tf);
        Intent in = getIntent();
        actionbar_title.setText(in.getStringExtra("speaker_name"));
        title.setText(in.getStringExtra("video_title"));
        
        video_id = in.getStringExtra("video_id");
        
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtubeplayerview);
        youTubePlayerView.initialize(API_KEY, this);
    }
    
public void showError(View v)
{
	Intent in=new Intent(getApplicationContext(),DownloadErrorActivity.class);
	startActivity(in);
}
	

 @Override
 public void onInitializationFailure(Provider provider,
   YouTubeInitializationResult result) {
  Toast.makeText(getApplicationContext(), 
    "onInitializationFailure()", 
    Toast.LENGTH_LONG).show();
 }

 @Override
 public void onInitializationSuccess(Provider provider, YouTubePlayer player,
   boolean wasRestored) {
  if (!wasRestored) {
        player.cueVideo(video_id);
      }
 }

}