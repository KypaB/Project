package com.example.connectthepoints;

import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.PaintDrawable;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends Activity implements View.OnClickListener {
	Button button7, button9, button13, button18, button20, button21, button22,
			button23, button, button1, button2, button3, button4, button5,
			button6, button8, button10, button11, button12, button14, button15,
			button16, button17, button19, button24, button25;
	PaintDrawable buttonColor = new PaintDrawable(Color.WHITE);
	int move = 0;
	Chronometer c = new Chronometer();
	long start;

	public void main(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	public void restart(View view) {
		Intent intent = new Intent(this, PlayActivity.class);
		startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);

		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
		button7 = (Button) findViewById(R.id.button7);
		button8 = (Button) findViewById(R.id.button8);
		button9 = (Button) findViewById(R.id.button9);
		button10 = (Button) findViewById(R.id.button10);
		button11 = (Button) findViewById(R.id.button11);
		button13 = (Button) findViewById(R.id.button13);
		button12 = (Button) findViewById(R.id.button12);
		button14 = (Button) findViewById(R.id.button14);
		button15 = (Button) findViewById(R.id.button15);
		button16 = (Button) findViewById(R.id.button16);
		button17 = (Button) findViewById(R.id.button17);
		button18 = (Button) findViewById(R.id.button18);
		button19 = (Button) findViewById(R.id.button19);
		button20 = (Button) findViewById(R.id.button20);
		button21 = (Button) findViewById(R.id.button21);
		button22 = (Button) findViewById(R.id.button22);
		button23 = (Button) findViewById(R.id.button23);
		button24 = (Button) findViewById(R.id.button24);
		button25 = (Button) findViewById(R.id.button25);

		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
		button7.setOnClickListener(this);
		button8.setOnClickListener(this);
		button9.setOnClickListener(this);
		button10.setOnClickListener(this);
		button11.setOnClickListener(this);
		button12.setOnClickListener(this);
		button13.setOnClickListener(this);
		button14.setOnClickListener(this);
		button15.setOnClickListener(this);
		button16.setOnClickListener(this);
		button17.setOnClickListener(this);
		button18.setOnClickListener(this);
		button19.setOnClickListener(this);
		button20.setOnClickListener(this);
		button21.setOnClickListener(this);
		button22.setOnClickListener(this);
		button23.setOnClickListener(this);
		button24.setOnClickListener(this);
		button25.setOnClickListener(this);

		start = c.startTime();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.button7:
			buttonColor = new PaintDrawable(Color.YELLOW);
			break;
		case R.id.button22:
			buttonColor = new PaintDrawable(Color.YELLOW);
			break;
		case R.id.button9:
			buttonColor = new PaintDrawable(Color.BLUE);
			break;
		case R.id.button13:
			buttonColor = new PaintDrawable(Color.BLUE);
			break;
		case R.id.button21:
			buttonColor = new PaintDrawable(Color.RED);
			break;
		case R.id.button18:
			buttonColor = new PaintDrawable(Color.RED);
			break;
		case R.id.button23:
			buttonColor = new PaintDrawable(Color.GREEN);
			break;
		case R.id.button20:
			buttonColor = new PaintDrawable(Color.GREEN);
			break;
		default:
			button = (Button) findViewById(v.getId());
			button.setBackgroundDrawable(buttonColor);
			--move;
			break;
		}

		++move;
		TextView text = (TextView) findViewById(R.id.moves);
		text.setText("Moves: " + move);
		//mHandler.postDelayed(mUpdateUITimerTask, 1000);
		TextView time = (TextView) findViewById(R.id.time);
		time.setText("Time: " + c.getTillNow(start));

	}
	
	

	private final Runnable mUpdateUITimerTask = new Runnable() {
		public void run() {
			TextView time = (TextView) findViewById(R.id.time);
			time.setText("Time: " + c.getTillNow(start));
		}
	};
	private final Handler mHandler = new Handler();
	

	public class Chronometer {
		private long startTime;
		private long endTime;

		public long startTime() {
			startTime = System.currentTimeMillis();
			return startTime;
		}

		public void endTime() {
			endTime = System.currentTimeMillis();
		}

		public String getTillNow(long theBeginTime) {
			long timeNow = System.currentTimeMillis();
			long untilnow = timeNow - theBeginTime;

			if ((untilnow > 1000)) {
				untilnow = untilnow / 1000;
			}

			String s = "0:00";
			if (untilnow < 10) {
				s = "0:0" + untilnow;
			} else if (untilnow < 60) {
				s = "0:" + untilnow;
			} else if (untilnow > 60) {
				s = untilnow / 60 + ":" + untilnow % 60;
			}

			return s;
		}

	}
	
	
}
