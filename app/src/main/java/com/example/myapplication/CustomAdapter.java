package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	Context context;
	LayoutInflater inflater;
	int images[] ;
	String title[] , title1[];
	TextView textView,textView1;
	ImageView imageView;

	public CustomAdapter(Context context, int[] images, String[] title,String[] title1) {
		this.context = context;
		this.images = images;
		this.title = title;
		this.title1=title1;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return title.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = inflater.inflate(R.layout.activity_row,null);
		textView = view.findViewById(R.id.text_view);
		textView1 = view.findViewById(R.id.text1_view);
		imageView = view.findViewById(R.id.txt_img);
		textView.setText(title[position]);
		imageView.setImageResource(images[position]);
		textView1.setText(title1[position]);
		return view;
	}
}
