package com.example.connectthepoints;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	public void music(boolean play) {
		play=true;
		MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.raw.sound1);
		if (play) {
			mp.start();
		} else {
			mp.stop();
		}
	}

	public void reset(View view) {
		music(true);
	}
	
	public void main(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
}
