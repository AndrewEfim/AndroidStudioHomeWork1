package com.example.andreii.firstaplication.HW7.hw7v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.andreii.firstaplication.HW7.comon.Album;
import com.example.andreii.firstaplication.HW7.comon.MyBase;
import com.example.andreii.firstaplication.R;

import java.util.List;

public class SevenActivityMain extends Activity implements AlbumAdapter.OnItemClickListener {

    public static final String EXRTA_URL = "imageURL";
    public static final String EXRTA_albumName = "albumName";
    public static final String EXRTA_albumYear = "albumYear";
    private static final String TAG = "myLog";

    private RecyclerView myRecycle;
    private AlbumAdapter myAlbumAdapter;
    List<Album> albums;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_main);
        MyBase myBase = MyBase.get(this);
        albums = myBase.getAlbums();
        myRecycle = findViewById(R.id.rv);
        myAlbumAdapter = new AlbumAdapter(albums);
        myAlbumAdapter.setItemClickListener(SevenActivityMain.this);
        myRecycle.setAdapter(myAlbumAdapter);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        Bundle arguments = getIntent().getExtras();

        Album album = null;
        if (arguments != null) {
            album = (Album) arguments.getSerializable(Album.class.getSimpleName());
        }

        Intent intentdelete = getIntent();
        String urlNameFromDelete = intentdelete.getStringExtra("urlName");
        int deleteposition = intentdelete.getIntExtra("deleteposition", 0);
        int deleteButton = intentdelete.getIntExtra("deleteButton", -1);
        Log.d(TAG, "deleteposition" + deleteposition);

        Intent intensave = getIntent();
        int idsave = intensave.getIntExtra("IDSave", 0);
        String newAlbumName = intensave.getStringExtra("savaAlbumNeme");
        String newAlbumYear = intensave.getStringExtra("savaAlbumYear");
        String newAlbumImageURL = intensave.getStringExtra("savaImageURL");
        int saveButton = intensave.getIntExtra("saveButton", -1);
        Log.d(TAG, "id from full" + idsave);

        Button buttonNewAdd = findViewById(R.id.newalbumbutton);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        if (album != null) {
            albums.add(album);
            Log.d(TAG, "add method");
            myAlbumAdapter.notifyDataSetChanged();
        }

        if (saveButton == 1) {
            Log.d(TAG, "save button on method");
            albums.get(idsave).setNameA(newAlbumName);
            albums.get(idsave).setYear(newAlbumYear);
            albums.get(idsave).setImageURL(newAlbumImageURL);

            //albums.add(new Album(newAlbumName, newAlbumYear, newAlbumImageURL));
            myAlbumAdapter.notifyItemChanged(idsave);
        }

        Log.d(TAG, "String fromdelete" + urlNameFromDelete);

        if (deleteButton == 2) {
            for (int i = 0; i < albums.size(); i++) {
                if (urlNameFromDelete.equals(albums.get(i).getImage())) {
                    albums.remove(i);
                    myAlbumAdapter.notifyItemChanged(deleteposition);
                    Log.d(TAG, "delte method");      //  albums.remove(deleteposition);
                    Toast.makeText(getApplicationContext(), "delete elenment", Toast.LENGTH_SHORT).show();
                    break;
                }

            }
        }
        //            Log.d(TAG, "delete button on method");
//            albums.remove(deleteposition);
//            myAlbumAdapter.notifyItemChanged(deleteposition);//?
//            Log.d(TAG, "delete button" + albums.size());
//            Log.d(TAG, "delete button" + deleteButton);


        buttonNewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SevenActivityMain.this, SevenActivityAdd.class));
                myAlbumAdapter.notifyDataSetChanged();
            }
        });
    }
//on create close body
//    private void deleteposition(int deleteposition) {
//        albums.remove(deleteposition);
//    }


    @Override
    public void onItemClick(int position) {

        Intent intentfull = new Intent(this, SevenActivityFull.class);
        Album clicked = albums.get(position);
        for (int i = 0; i < albums.size(); i++) {
            if (clicked.getImage().equals(albums.get(i).getImage())) {
                int id = i;
                intentfull.putExtra("ID", id);
                Log.d(TAG,"id to Full"+id);
            }
        }
        intentfull.putExtra(EXRTA_URL, clicked.getImage());
        intentfull.putExtra(EXRTA_albumName, clicked.getName());
        intentfull.putExtra(EXRTA_albumYear, clicked.getYear());
        intentfull.putExtra("position", albums.get(position));
        startActivity(intentfull);
        Log.d(TAG, "onItemClick");
    }
}

