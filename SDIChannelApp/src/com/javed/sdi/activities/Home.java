package com.javed.sdi.activities;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.javed.sdi.R;

@SuppressLint("NewApi")
public class Home extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Typeface tf = Typeface.createFromAsset(getAssets(), "RobotoSlab-Light.ttf");
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getActionBar().setCustomView(R.layout.action_bar);
		//getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0064A8")));
		
		TextView title = (TextView)findViewById(R.id.activity_title);
		title.setText("SDI Channel");
		title.setTypeface(tf);
		
	}
	
	public void speeches(View v)
	{
		Intent in=new Intent(getApplicationContext(),SpeakersActivity.class);
		startActivity(in);
	}
	
	public void naats(View v)
	{
		Intent in=new Intent(getApplicationContext(),NaatsActivity.class);
		startActivity(in);
	}
	
	public void special(View v)
	{
		Intent in=new Intent(getApplicationContext(),SpecialActivity.class);
		startActivity(in);
	}
	
	public void recent(View v)
	{
		Intent in=new Intent(getApplicationContext(),RecentActivity.class);
		startActivity(in);
	}
	
	public void shortClips(View v)
	{
		Intent in=new Intent(getApplicationContext(),ShortClipsActivity.class);
		startActivity(in);
	}
	
	public void about(View v)
	{
		Intent in=new Intent(getApplicationContext(),AboutActivity.class);
		startActivity(in);
	}
	

}
