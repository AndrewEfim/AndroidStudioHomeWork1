package com.example.andreii.firstaplication.HW7.hw7v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.andreii.firstaplication.R;
import com.squareup.picasso.Picasso;

import static com.example.andreii.firstaplication.HW7.hw7v1.SevenActivityMain.EXRTA_URL;
import static com.example.andreii.firstaplication.HW7.hw7v1.SevenActivityMain.EXRTA_albumName;
import static com.example.andreii.firstaplication.HW7.hw7v1.SevenActivityMain.EXRTA_albumYear;

public class SevenActivityFull extends Activity {
    private static final String TAG = "myLog";

    EditText albumNameF;
    EditText albumYearF;
    EditText imageURLF;
    ImageView imageAlbumF;
    Button saveButton;
    Button deleteButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_full);
        final Intent intent = getIntent();
        final String imageURL = intent.getStringExtra(EXRTA_URL);
        String albumName = intent.getStringExtra(EXRTA_albumName);
        String albumYear = intent.getStringExtra(EXRTA_albumYear);
        final int selectposition = intent.getIntExtra("position", 0);
        final int id = intent.getIntExtra("ID",0);
        Log.d(TAG,"id from main"+ id);

        imageAlbumF = findViewById(R.id.imageviewActivitySevenFull);
        albumNameF = findViewById(R.id.editTextalbumNameActivitySevenFull);
        albumYearF = findViewById(R.id.editTextalbumYearActivitySevenFull);
        imageURLF = findViewById(R.id.editTextimageURLActivitySevenFull);
        saveButton = findViewById(R.id.saveButtonActivitySevenFull);
        deleteButton = findViewById(R.id.deleteButtonActivitySevenFull);


        Picasso.get().load(imageURL).into(imageAlbumF);
        albumNameF.setText(albumName);
        albumYearF.setText(albumYear);
        imageURLF.setText(imageURL);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdelete = new Intent(SevenActivityFull.this, SevenActivityMain.class);
                intentdelete.putExtra("urlName", imageURLF.getText().toString());
                Log.d(TAG,"urname from full "+imageURLF+imageURLF.getText().toString());
                intentdelete.putExtra("deleteposition", selectposition);
                intentdelete.putExtra("deleteButton", 2);
                startActivity(intentdelete);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsave = new Intent(SevenActivityFull.this, SevenActivityMain.class);
                intentsave.putExtra("IDSave", id);
                Log.d(TAG,"id to main"+id);
                intentsave.putExtra("saveButton", 1);
                intentsave.putExtra("savaAlbumNeme", albumNameF.getText().toString());
                intentsave.putExtra("savaAlbumYear", albumYearF.getText().toString());
                intentsave.putExtra("savaImageURL", imageURLF.getText().toString());

                startActivity(intentsave);
            }
        });
    }
}
