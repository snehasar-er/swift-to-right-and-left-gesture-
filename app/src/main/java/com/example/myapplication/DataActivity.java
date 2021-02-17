package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
	ImageView imageView;
	TextView textView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		imageView = findViewById(R.id.image);
		textView = findViewById(R.id.text);
		Intent intent = getIntent();
		int img = intent.getIntExtra("key_image",R.drawable.ic_launcher_background);
		String Title =intent.getStringExtra("key_title");
		imageView.setImageResource(img);
		textView.setText(Title);
	}
}
