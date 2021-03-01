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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	ImageView imageView;
	Button camera, setWall;
	Bitmap bitmap;
	private static final int PERMISSION_REQUEST_CODE = 100;
	private static final int CAMERA_REQUEST_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getSupportActionBar().hide();
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		imageView = findViewById(R.id.imageView);
		camera = findViewById(R.id.buttonCamera);
		setWall = findViewById(R.id.buttonSetWallpaper);

		camera.setOnClickListener(this);
		setWall.setOnClickListener(this);


	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.buttonCamera:
				if(checkPermission()) {
					openCameraMethod();
				}
				else
				{
					requestPermission();
				}
				break ;

			case R.id.buttonSetWallpaper:
				try {
					getApplicationContext().setWallpaper(bitmap);
					Toast.makeText(getApplicationContext(), "Wallpaper Set", Toast.LENGTH_LONG).show();
					finish();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
		}
		
	}

	private void requestPermission() {
		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
				PERMISSION_REQUEST_CODE);
	}
	private boolean checkPermission() {
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
				!= PackageManager.PERMISSION_GRANTED) {
			// Permission is not granted
			return false;
		}
		return true;
	}
	private void openCameraMethod()
	{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, CAMERA_REQUEST_CODE);
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
		switch (requestCode) {
			case PERMISSION_REQUEST_CODE:
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
				Toast.makeText(getApplicationContext(), "Camera Permission Granted", Toast.LENGTH_SHORT).show();
				openCameraMethod();
				// main logic
				}else {
				Toast.makeText(getApplicationContext(), "Camera Permission Denied", Toast.LENGTH_SHORT).show();
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
						showMessageOKCancel("You need to allow access permissions for Camera",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog, int which) {
										if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
											requestPermission();
										}
									}
								});
					}
				}
			}
			break;

	}

}

	private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
		new AlertDialog.Builder(MainActivity.this)
				.setMessage(message)
				.setPositiveButton("OK", okListener)
				.setNegativeButton("Cancel", null)
				.create()
				.show();
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle b = data.getExtras();
			bitmap = (Bitmap) b.get("data");
			imageView.setImageBitmap(bitmap);
		}
	}
}