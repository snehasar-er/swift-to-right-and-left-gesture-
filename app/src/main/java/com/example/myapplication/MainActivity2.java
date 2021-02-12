package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
ImageView imageView;
TextView textView, textView1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		imageView = findViewById(R.id.images);
		textView = findViewById(R.id.title_major);
		textView1 = findViewById(R.id.title_minor);
		display();
	}

	private void display() {
		Intent intent = getIntent();
		int image= intent.getIntExtra("key_images",R.drawable.ic_launcher_background);
		imageView.setImageResource(image);

		String title = intent.getStringExtra("key_title");
		textView.setText(title);

		String title1 = intent.getStringExtra("key_title1");
		textView1.setText(title1);

	}
}