package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<Model> list;
MyAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		recyclerView = findViewById(R.id.recycleview);
		list = new ArrayList<>();
		list.add(new Model(R.drawable.apple,getResources().getString(R.string.apple)));
		list.add(new Model(R.drawable.banana,getResources().getString(R.string.banana)));
		list.add(new Model(R.drawable.dragon,getResources().getString(R.string.dragon)));
		list.add(new Model(R.drawable.grapes,getResources().getString(R.string.grapes)));
		list.add(new Model(R.drawable.guava,getResources().getString(R.string.guava)));
		list.add(new Model(R.drawable.kiwi,getResources().getString(R.string.kiwi)));
		list.add(new Model(R.drawable.oranges,getResources().getString(R.string.oranges)));
		list.add(new Model(R.drawable.papaya,getResources().getString(R.string.papaya)));
		list.add(new Model(R.drawable.pineapple,getResources().getString(R.string.pineapple)));
		list.add(new Model(R.drawable.strawberry,getResources().getString(R.string.strawberry)));
		list.add(new Model(R.drawable.apples,getResources().getString(R.string.mango)));
		list.add(new Model(R.drawable.apple,getResources().getString(R.string.apple)));
		list.add(new Model(R.drawable.banana,getResources().getString(R.string.banana)));
		list.add(new Model(R.drawable.dragon,getResources().getString(R.string.dragon)));
		list.add(new Model(R.drawable.grapes,getResources().getString(R.string.grapes)));
		list.add(new Model(R.drawable.guava,getResources().getString(R.string.guava)));
		list.add(new Model(R.drawable.kiwi,getResources().getString(R.string.kiwi)));
		list.add(new Model(R.drawable.oranges,getResources().getString(R.string.oranges)));
		list.add(new Model(R.drawable.papaya,getResources().getString(R.string.papaya)));
		list.add(new Model(R.drawable.pineapple,getResources().getString(R.string.pineapple)));
		list.add(new Model(R.drawable.strawberry,getResources().getString(R.string.strawberry)));
		list.add(new Model(R.drawable.apples,getResources().getString(R.string.mango)));

		adapter = new MyAdapter(MainActivity.this,list);
		recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
		recyclerView.setAdapter(adapter);
	}


}