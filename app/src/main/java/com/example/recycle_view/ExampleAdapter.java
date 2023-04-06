package com.example.recycle_view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

        private ArrayList<Item> list;

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.txt);
        }
    }
    public ExampleAdapter(ArrayList<Item> exampleList){
        list =exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_list,viewGroup,false);
       ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view);
       return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {

        Item currentItem = list.get(i);
        exampleViewHolder.imageView.setImageResource(currentItem.getsImgResource());
        exampleViewHolder.textView.setText(currentItem.getsText());
    }

    @Override
    public int getItemCount() {
      return list.size();
    }

}
