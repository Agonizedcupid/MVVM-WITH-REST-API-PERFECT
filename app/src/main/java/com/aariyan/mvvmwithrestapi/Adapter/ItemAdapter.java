package com.aariyan.mvvmwithrestapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aariyan.mvvmwithrestapi.Model.Picsum;
import com.aariyan.mvvmwithrestapi.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context context;
    private List<Picsum> listOfData;

    public ItemAdapter (Context context, List<Picsum> listOfData) {
        this.context = context;
        this.listOfData = listOfData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picsum model = listOfData.get(position);
        holder.authorName.setText(model.getAuthorName());
        Glide.with(context).load(model.getImageUrl()).error(R.mipmap.ic_launcher).into(holder.singleImage);
    }

    @Override
    public int getItemCount() {
        return listOfData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView singleImage;
        private TextView authorName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            singleImage = itemView.findViewById(R.id.singleImage);
            authorName = itemView.findViewById(R.id.authorName);
        }
    }
}
