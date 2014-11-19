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
public class SpeakersActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.speakers_layout);
		Typeface tf = Typeface.createFromAsset(getAssets(), "RobotoSlab-Light.ttf");
	     getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
	     getActionBar().setCustomView(R.layout.action_bar);
	     TextView title = (TextView)findViewById(R.id.activity_title);
	     title.setText("Speakers");
		 title.setTypeface(tf);
		
		
		
		TextView tv1 = (TextView)findViewById(R.id.maulana_shakir);
		TextView tv2 = (TextView)findViewById(R.id.allama);
		TextView tv3 = (TextView)findViewById(R.id.aminul_qadri);
		TextView tv4 = (TextView)findViewById(R.id.qari_rizwan);
		TextView tv5 = (TextView)findViewById(R.id.khalid_razvi);
		TextView tv6 = (TextView)findViewById(R.id.sadiq_razvi);
		TextView tv7 = (TextView)findViewById(R.id.mufti_zubair);
		
		tv1.setTypeface(tf);
		tv2.setTypeface(tf);
		tv3.setTypeface(tf);
		tv4.setTypeface(tf);
		tv5.setTypeface(tf);
		tv6.setTypeface(tf);
		tv7.setTypeface(tf);
		
	}
	
	public void maulanaShakir(View v)
	{
		Intent in = new Intent(getApplicationContext(),PlaylistVideos.class);
		in.putExtra("playlist_id","PLNngVRDXb8awh_DpvmbjbkWHKE7JPYJzM");
		in.putExtra("name", "Maulana Shakir Noorie");
		startActivity(in);
	}
	
	public void allama(View v)
	{
		Intent in = new Intent(getApplicationContext(),PlaylistVideos.class);
		in.putExtra("playlist_id","PLNngVRDXb8ay-phPzRuHtN0fEN9TFdBp_");
		in.putExtra("name", "Allama Azmi");
		startActivity(in);
	}
	
	public void aminulQadri(View v)
	{
		Intent in = new Intent(getApplicationContext(),PlaylistVideos.class);
		in.putExtra("playlist_id","PLNngVRDXb8awuBerEfbYST4dGxuFYuPG8");
		in.putExtra("name", "Sayyed Aminul Qadri");
		startActivity(in);
	}
	
	public void qariRizwan(View v)
	{
		Intent in = new Intent(getApplicationContext(),PlaylistVideos.class);
		in.putExtra("playlist_id","PLNngVRDXb8azCHLVZL7vzo9KT673Z1TTW");
		in.putExtra("name", "Qari Rizwan");
		startActivity(in);
	}
	
	public void muftiZubair(View v)
	{
		Intent in = new Intent(getApplicationContext(),PlaylistVideos.class);
		in.putExtra("playlist_id","PLNngVRDXb8azlzOsC2RCHh89XSZtGSm0O");
		in.putExtra("name", "Mufti Zubair");
		startActivity(in);
	}
	
	public void sadiqRazvi(View v)
	{
		Intent in = new Intent(getApplicationContext(),PlaylistVideos.class);
		in.putExtra("playlist_id","PLNngVRDXb8ayy1NaH-OdH2UohD5Fsl2ca");
		in.putExtra("name", "Sadiq Razvi");
		startActivity(in);
	}
	
	public void khalidRazvi(View v)
	{
		Intent in = new Intent(getApplicationContext(),PlaylistVideos.class);
		in.putExtra("playlist_id","PLNngVRDXb8axoFRvnl81rYq6DEjaWcKj3");
		in.putExtra("name", "Khalid Razvi");
		startActivity(in);
	}
	
	
}
