package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class LoginActivity extends AppCompatActivity {
	EditText email , pass;
	Button btn_login ;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		email = findViewById(R.id.email);
		pass = findViewById(R.id.password);
		btn_login = findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FirebaseAuth firebaseAuth = null;
				String Email = email.getText().toString().trim();
				String Password=pass.getText().toString().trim();
				if(Email.isEmpty())
				{
					email.setError("Please enter email");
					email.requestFocus();
					return;
				}
				if(Password.isEmpty())
				{
					pass.setError("Please enter password");
					pass.requestFocus();
					return;
				}
				firebaseAuth=FirebaseAuth.getInstance();
				firebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						Toast.makeText(LoginActivity.this , "login successfully",Toast.LENGTH_LONG).show();
					}
				}).addOnFailureListener(new OnFailureListener() {
					@Override
					public void onFailure(@NonNull Exception e) {
						Toast.makeText(LoginActivity.this , e.getMessage(),Toast.LENGTH_LONG).show();
					}
				});
			}
		});
	}
	}

