package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
	Context context;
	List<Model> list;

	public MyAdapter(Context context, List<Model> list) {
		this.context = context;
		this.list = list;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view;
		LayoutInflater layoutInflater =LayoutInflater.from(context) ;
		view =layoutInflater.inflate(R.layout.cardview_layout ,parent ,false );
		return new MyViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.imageView.setImageResource(list.get(position).getImage());
      holder.textView.setText(list.get(position).getTitle());
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	public static class MyViewHolder extends RecyclerView.ViewHolder
	{
		ImageView imageView;
		TextView textView;
		public MyViewHolder(@NonNull View itemView) {
			super(itemView);
			imageView = itemView.findViewById(R.id.txt_img);
			textView = itemView.findViewById(R.id.txt);
		}
	}
}
