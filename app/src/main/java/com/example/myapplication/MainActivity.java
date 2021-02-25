package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText password , email;
Button btn_send;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		email =findViewById(R.id.email);
        password=findViewById(R.id.password);
        btn_send = findViewById(R.id.btn_Send);
        btn_send.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
		        FirebaseAuth firebaseauth = null;
		        String Email = email.getText().toString().trim();
		        String Password=password.getText().toString().trim();
		        if(Email.isEmpty())
		        {
			        email.setError("Please enter email");
			        email.requestFocus();
			        return;
		        }
		        if(Password.isEmpty())
		        {
			        password.setError("Please enter password");
			        password.requestFocus();
			        return;
		        }
		        firebaseauth=FirebaseAuth.getInstance();
		        firebaseauth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
			        @Override
			        public void onComplete(@NonNull Task<AuthResult> task) {
				        if (task.isSuccessful())
				        {
				        	Toast.makeText(MainActivity.this,"User is added successfully ",Toast.LENGTH_LONG).show();
				        	Intent intent = new Intent(MainActivity.this,LoginActivity.class);
				        	startActivity(intent);
				        }
			        }
		        }).addOnFailureListener(new OnFailureListener() {
			        @Override
			        public void onFailure(@NonNull Exception e) {
				        Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
			        }
		        });
	        }
        });
	}

}