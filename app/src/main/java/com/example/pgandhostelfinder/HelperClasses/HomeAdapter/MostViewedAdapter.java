package com.example.pgandhostelfinder.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pgandhostelfinder.R;

import java.util.ArrayList;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedHolder> {

    ArrayList<MostViewedHelperClass> mostViewedHelperClasses;

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewedHelperClasses) {
        this.mostViewedHelperClasses = mostViewedHelperClasses;
    }

    @NonNull
    @Override
    public MostViewedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
        MostViewedHolder mostViewedHolder = new MostViewedHolder(view);
        return mostViewedHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedHolder holder, int position) {
        MostViewedHelperClass mostViewedClass = mostViewedHelperClasses.get(position);
        holder.mvimage.setImageResource(mostViewedClass.getMvimage());
        holder.mvtitle.setText(mostViewedClass.getMvtitle());
        holder.mvdesc.setText(mostViewedClass.getMvdesc());
    }

    @Override
    public int getItemCount() {
        return mostViewedHelperClasses.size();
    }

    public static class MostViewedHolder extends RecyclerView.ViewHolder{

        ImageView mvimage;
        TextView mvtitle, mvdesc;

        public MostViewedHolder(@NonNull View itemView) {
            super(itemView);
            mvimage = itemView.findViewById(R.id.mv_image);
            mvtitle = itemView.findViewById(R.id.mv_title);
            mvdesc = itemView.findViewById(R.id.mv_desc);
        }
    }
}
