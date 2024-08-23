package com.example.mvvmpractice.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmpractice.databinding.ProductrvdesignBinding;
import com.example.mvvmpractice.model.Product;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    List<Product> productList;
    Context context;

    public ImageAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    public void updateAdapter(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductrvdesignBinding productrvdesignBinding = ProductrvdesignBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(productrvdesignBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.productrvdesignBinding.tvPname.setText(productList.get(position).title);
        Glide.with(holder.productrvdesignBinding.ivThumbnail)
                .load(productList.get(position).thumbnailUrl)
                .into(holder.productrvdesignBinding.ivThumbnail);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ProductrvdesignBinding productrvdesignBinding;

        public ViewHolder(@NonNull ProductrvdesignBinding productrvdesignBinding) {
            super(productrvdesignBinding.getRoot());

            this.productrvdesignBinding = productrvdesignBinding;

        }
    }
}
