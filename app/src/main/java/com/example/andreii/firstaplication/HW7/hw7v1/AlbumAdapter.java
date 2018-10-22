package com.example.andreii.firstaplication.HW7.hw7v1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.andreii.firstaplication.HW7.comon.Album;
import com.example.andreii.firstaplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumHolder> {

    private List<Album> mAlbum;
    private static OnItemClickListener mListner;

    public AlbumAdapter(List<Album> albums) {
        mAlbum = albums;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener listener) {
        mListner = listener;
    }


    public static class AlbumHolder extends RecyclerView.ViewHolder {
        TextView albumName;
        TextView albumYear;
        ImageView albumImage;

        public AlbumHolder(@NonNull View itemView) {
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

    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_seven_item,parent,false);
        AlbumHolder holder = new AlbumHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.AlbumHolder albumHolder, int i) {
        albumHolder.albumName.setText(mAlbum.get(i).getName());
        albumHolder.albumYear.setText(mAlbum.get(i).getYear());
        Picasso.get().load(mAlbum.get(i).getImage()).into(albumHolder.albumImage);
    }

    @Override
    public int getItemCount() {
        return mAlbum.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
