package com.example.andreii.firstaplication.HW7.hw7v2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.andreii.firstaplication.HW7.comon.Album;
import com.example.andreii.firstaplication.R;
import com.squareup.picasso.Picasso;

import static android.content.ContentValues.TAG;


//fragment contain choice item only view right on screen
public class DetailFragment extends Fragment {


    private static ListFragment.onSomeEventListner someEventListner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        someEventListner = (ListFragment.onSomeEventListner) context;
    }

    EditText albumName, albumYear, albumImage;
    ImageView imageAlbum;
    Button saveButton, deleteButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewTWO = inflater.inflate(R.layout.fragment_two_detail, container, false);
        Log.d(TAG, "view TWO run");
        Bundle bundle = getArguments();
        assert bundle != null;
        String albumNameFromBundle = bundle.getString("NAME");
        String albumYearFromBundle = bundle.getString("YEAR");
        final String albumImageFromBundle = bundle.getString("IMAGE");
        Integer position =bundle.getInt("POSITION");
        Log.d(TAG,"positionDETAILFRAGMENT "+" "+position);
        final int idPOSITION = position;
        Log.d(TAG,"idPOSITION"+ idPOSITION);
        albumName = viewTWO.findViewById(R.id.editTextalbumNameActivitySevenFullFragment);
        albumYear = viewTWO.findViewById(R.id.editTextalbumYearActivitySevenFullFragment);
        albumImage = viewTWO.findViewById(R.id.editTextimageURLActivitySevenFullFragment);
        imageAlbum = viewTWO.findViewById(R.id.imageviewActivitySevenFullFragment);
        albumName.setText(albumNameFromBundle);
        albumYear.setText(albumYearFromBundle);
        albumImage.setText(albumImageFromBundle);
        Picasso.get().load(albumImageFromBundle).into(imageAlbum);
        //
        saveButton = viewTWO.findViewById(R.id.saveButtonActivitySevenFullFragment);
        deleteButton = viewTWO.findViewById(R.id.deleteButtonActivitySevenFullFragment);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), MainFragmentActivity.class);

                intent.putExtra("EDIT_NAME",albumName.getText().toString());
                intent.putExtra("EDIT_YEAR",albumYear.getText().toString());
                intent.putExtra("EDIT_IMAGE",albumImage.getText().toString());
                intent.putExtra("SAVE_COMAND",2);
                intent.putExtra("ID_SAVE",idPOSITION);
                Log.d(TAG,"save "+idPOSITION);
                getActivity().startActivity(intent);


            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), MainFragmentActivity.class);
                intent.putExtra("DELETE_POSITION", idPOSITION);
                intent.putExtra("DELETE_COMAND",3);
                intent.putExtra("URL_DELETE",albumImageFromBundle);
                getActivity().startActivity(intent);

            }
        });


        return viewTWO;


    }

}

