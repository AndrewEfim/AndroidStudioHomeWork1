package com.example.andreii.firstaplication.HW7.hw7v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.andreii.firstaplication.HW7.comon.Album;
import com.example.andreii.firstaplication.HW7.comon.MyBase;
import com.example.andreii.firstaplication.R;

import java.util.List;

public class SevenActivityAdd extends Activity {
 //   List<Album> discography = new ArrayList<>();

    EditText editnameAlbum;
    EditText editYearAlbum;
    EditText editimageURL;
    Button addButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_add);
        MyBase myBase = MyBase.get(this);
    final List<Album> albums = myBase.getAlbums();//
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        editnameAlbum = findViewById(R.id.enterName);
        editYearAlbum = findViewById(R.id.enterYear);
        editimageURL = findViewById(R.id.entarimageUrl);

        addButton = findViewById(R.id.addbutton7A);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Album album = new Album(editnameAlbum.getText().toString()
                        , editYearAlbum.getText().toString()
                        , editimageURL.getText().toString());
                albums.add(album);//
               // new MyBase().discographyMB.add(album);//addInBase(album);
                Intent intent = new Intent(SevenActivityAdd.this, SevenActivityMain.class);
                //intent.putExtra(Album.class.getSimpleName(),album);
                startActivity(intent);
            }
        });
    }
}
