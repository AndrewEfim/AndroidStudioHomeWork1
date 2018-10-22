package com.example.andreii.firstaplication.HW7.hw7v2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andreii.firstaplication.HW7.comon.Album;
import com.example.andreii.firstaplication.HW7.hw7v1.AlbumAdapter;
import com.example.andreii.firstaplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private  Context context;
    List<Album> mAlbums;

    private static OnItemClickListener mListner;

    public RecycleViewAdapter(Context context, List<Album> mAlbums) {
        this.context = context;
        this.mAlbums = mAlbums;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);//View view
    }

    public void setItemClickListener(OnItemClickListener listener) {
        mListner = listener;
    }

    OnItemClickListener onItemClickListener;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fragment_item_only, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.albumName.setText(mAlbums.get(position).getName());
        holder.albumYear.setText(mAlbums.get(position).getYear());
        Picasso.get().load(mAlbums.get(position).getImage()).into(holder.albumImage);

    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView albumName;
        TextView albumYear;
        ImageView albumImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            albumName = itemView.findViewById(R.id.albumName);
            albumYear = itemView.findViewById(R.id.albumYear);
            albumImage = itemView.findViewById(R.id.albumImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListner != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListner.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}

