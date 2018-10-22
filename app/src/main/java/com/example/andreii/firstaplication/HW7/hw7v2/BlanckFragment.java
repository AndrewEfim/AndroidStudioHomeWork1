package com.example.andreii.firstaplication.HW7.hw7v2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.andreii.firstaplication.R;

public class BlanckFragment extends Fragment {

    Button addButton;
    EditText nameAdd;
    EditText yearAdd;
    EditText imageAdd;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewBlank = inflater.inflate(R.layout.fragment_two_detail_blanck, container, false);

        nameAdd = viewBlank.findViewById(R.id.editTextalbumNameActivitySevenFullBlank);
        yearAdd = viewBlank.findViewById(R.id.editTextalbumYearActivitySevenFullBlank);
        imageAdd = viewBlank.findViewById(R.id.editTextimageURLActivitySevenFullBlank);
        addButton = viewBlank.findViewById(R.id.saveButtonActivitySevenFullBlank);

        addButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), MainFragmentActivity.class);
                intent.putExtra("NAME_ADD", nameAdd.getText().toString());
                intent.putExtra("YEAR_ADD", yearAdd.getText().toString());
                intent.putExtra("IMAGE_ADD", imageAdd.getText().toString());

                intent.putExtra("ADD", 1);
                getActivity().startActivity(intent);
            }
        });
        return viewBlank;
    }

}