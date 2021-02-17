package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

	Context context ;
	List<Model> list;

	public MyAdapter(Context context, List<Model> list) {
		this.context = context;
		this.list = list;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflaterLayout;
		View view ;
		inflaterLayout = LayoutInflater.from(context);
		view = inflaterLayout.inflate(R.layout.cardview_layout , parent , false);
		return new MyViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.imageView.setImageResource(list.get(position).getImage());
    holder.textView.setText(list.get(position).getTitle());
    holder.cardView.setOnClickListener(new View.OnClickListener() {
	    @Override
	    public void onClick(View v) {
		   // Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
		    Intent intent = new Intent(context,DataActivity.class);
		    intent.putExtra("key_image",list.get(position).getImage());
		    intent.putExtra("key_title",list.get(position).getTitle());
		    context.startActivity(intent);
	    }
    });

	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	public static class MyViewHolder extends RecyclerView.ViewHolder
	{
         ImageView imageView ;
         TextView textView;
         CardView cardView;
		public MyViewHolder(@NonNull View itemView) {
			super(itemView);
			imageView = itemView.findViewById(R.id.txt_img);
			textView = itemView.findViewById(R.id.txt);
			cardView = itemView.findViewById(R.id.cardview);
		}
	}
}
