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
public class DownloadErrorActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.downloaderror);
		Typeface tf = Typeface.createFromAsset(getAssets(), "RobotoSlab-Light.ttf");
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getActionBar().setCustomView(R.layout.action_bar);
		//getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0064A8")));
		
		TextView title = (TextView)findViewById(R.id.activity_title);
		TextView smiley = (TextView)findViewById(R.id.smiley);
		title.setText("Oops!");
		title.setTypeface(tf);
		smiley.setTypeface(tf);
		
	}
	
	
}
