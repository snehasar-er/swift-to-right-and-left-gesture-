package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;

import android.telephony.SmsManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

	private GestureDetectorCompat gestureDetectorCompat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gestureDetectorCompat = new GestureDetectorCompat(this, new GestureClass());
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.gestureDetectorCompat.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	class GestureClass extends GestureDetector.SimpleOnGestureListener {
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

			if (e2.getX() < e1.getX()) {
				Intent intent = new Intent(MainActivity.this, HomeActivity.class);
				startActivity(intent);
				finish();
			}
			return true;
		}
	}
}