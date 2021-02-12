package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
ListView listView;
CustomAdapter adapter;
int images[] ={R.drawable.apple ,R.drawable.banana,R.drawable.dragon,R.drawable.grapes,R.drawable.guava,R.drawable.kiwi,R.drawable.oranges,
		R.drawable.strawberry,R.drawable.pineapple,R.drawable.papaya};
String title[] ={"APPLE","BANANA","DRAGON","GRAPES","GUAVA","KIWI","ORANGES","STRAWBERRY","PINEAPPLE","PAPAYA"};
String title1[] ={"apple","banana","dragon","grapes","guava","kiwi","oranges","strawberry","pineapple","papaya"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = findViewById(R.id.lists);
		adapter = new CustomAdapter(MainActivity.this,images,title,title1);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(MainActivity.this,MainActivity2.class);
				intent.putExtra("key_images",images[position]);
				intent.putExtra("key_title", title[position]);
				intent.putExtra("key_title1",title1[position]);
				startActivity(intent);
			}
		});
	}


}