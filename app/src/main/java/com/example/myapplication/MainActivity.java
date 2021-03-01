package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
	ImageView image1,image2,image3,image4;
	String url, url1, url2, url3;
	Glide glide, glide1, glide2, glide3;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		image1 = findViewById(R.id.image);
		image2 = findViewById(R.id.image1);
		image3 = findViewById(R.id.image2);
		image4 = findViewById(R.id.image3);

		url = "https://firebasestorage.googleapis.com/v0/b/fir-574b6.appspot.com/o/kiwi.jpg?alt=media&token=cdd8301f-437b-4ce3-b8ac-b05178a65cbd";
		glide.with(getApplicationContext()).load(url).into(image1);

		url1 = "https://firebasestorage.googleapis.com/v0/b/fir-574b6.appspot.com/o/apples.jpg?alt=media&token=cca83591-1c37-48e3-9be1-13af0e1aec94";
		glide1.with(getApplicationContext()).load(url1).into(image2);

		url2 = "https://firebasestorage.googleapis.com/v0/b/fir-574b6.appspot.com/o/banana.jpg?alt=media&token=33e90898-273b-4b4e-8cb8-283ca3cc8b43";
		glide2.with(getApplicationContext()).load(url2).into(image3);

		url3 = "https://firebasestorage.googleapis.com/v0/b/fir-574b6.appspot.com/o/dragon.jpg?alt=media&token=eed581fc-f343-4b49-bd03-44f13acda4b4";
		glide3.with(getApplicationContext()).load(url3).into(image4);

	}






}