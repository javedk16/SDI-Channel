package com.javed.sdi.activities;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.javed.sdi.R;

@SuppressLint("NewApi")
public class SpecialActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.special_layout);
		Typeface tf = Typeface.createFromAsset(getAssets(), "RobotoSlab-Light.ttf");
	     getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
	     getActionBar().setCustomView(R.layout.action_bar);
	     TextView title = (TextView)findViewById(R.id.activity_title);
	     title.setText("Special");
		 title.setTypeface(tf);
		
		
		
		TextView tv1 = (TextView)findViewById(R.id.maulana_shakir);
		TextView tv2 = (TextView)findViewById(R.id.allama);
		
		
		tv1.setTypeface(tf);
		tv2.setTypeface(tf);
		
		
	}
	
	public void maheRamzan(View v)
	{
		Intent in = new Intent(getApplicationContext(),PlaylistVideos.class);
		in.putExtra("playlist_id","PLNngVRDXb8azpBWzAWMXDB10iwkw9XPZ3");
		in.putExtra("name", "Mahe Ramzan");
		startActivity(in);
	}
	
	public void womenSpecial(View v)
	{
		Intent in = new Intent(getApplicationContext(),PlaylistVideos.class);
		in.putExtra("playlist_id","PLNngVRDXb8azNSeWTOnATZG3QWdYbbByX");
		in.putExtra("name", "For Sisters");
		startActivity(in);
	}

	
}
