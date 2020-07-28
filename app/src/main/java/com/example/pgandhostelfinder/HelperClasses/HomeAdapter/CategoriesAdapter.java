package com.example.pgandhostelfinder.HelperClasses.HomeAdapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pgandhostelfinder.R;

import java.util.ArrayList;
import java.util.Random;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    ArrayList<CategoriesHelperClass> categoriesArrayList;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categoriesArrayList) {
        this.categoriesArrayList = categoriesArrayList;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        CategoriesHelperClass helperClass = categoriesArrayList.get(position);
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.categoriesBackground.setBackgroundColor(currentColor);
        holder.cimage.setImageResource(helperClass.getCimage());
        holder.ctitle.setText(helperClass.getCtitle());
    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder{

        ImageView cimage;
        TextView ctitle;
        RelativeLayout categoriesBackground;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
             cimage = itemView.findViewById(R.id.c_image);
             ctitle = itemView.findViewById(R.id.c_title);
             categoriesBackground = itemView.findViewById(R.id.categories_background);
        }
    }
}
