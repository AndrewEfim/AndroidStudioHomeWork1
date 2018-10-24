package com.example.andreii.firstaplication.HW7.hw7v2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v4.app.FragmentTransaction;

import com.example.andreii.firstaplication.HW7.comon.Album;
import com.example.andreii.firstaplication.HW7.comon.MyBase;
import com.example.andreii.firstaplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//fragment contain recycle view left on screen
public class ListFragment extends Fragment implements RecycleViewAdapter.OnItemClickListener {


//    F ft ;

    public interface onSomeEventListner {
        void someEvent(int id, String name, String year, String image);

        void someEventTwo(Album album);

        void someEvent(int idADD);

    }

    private static final String TAG = "myLog";

    List<Album> albums;
    private Context context;
    EditText imageURl;
    EditText name;
    EditText year;
    ImageView imageView;

    RecycleViewAdapter recycleViewAdapter;
    private static onSomeEventListner someEventListner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        someEventListner = (onSomeEventListner) context;

    }

    public ListFragment() {
    }

    int srartAdd = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewONE = inflater.inflate(R.layout.fragment_one_list, container, false);
        RecyclerView myRecycle = viewONE.findViewById(R.id.rvFragment);
        MyBase myBase = MyBase.get(getActivity());
        albums = myBase.getAlbums();
        recycleViewAdapter = new RecycleViewAdapter(getContext(), albums);//
        myRecycle.setAdapter(recycleViewAdapter);
        recycleViewAdapter.setItemClickListener(ListFragment.this);
        myRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));

        Bundle bundlefromActivity = getArguments();
        String albumNameADD = bundlefromActivity.getString("NAME_test");
        String albumYearADD = bundlefromActivity.getString("YEAR_test");
        String albumImageADD = bundlefromActivity.getString("IMAGE_test");
        Integer ADD = bundlefromActivity.getInt("ADD_test",0);
        Integer deletePosition = bundlefromActivity.getInt("DELETE_test",-1);
        Integer deleteComand = bundlefromActivity.getInt("DELETE_COMAND_test",-1);
        String urlNameFromDelete = bundlefromActivity.getString("url_DELETE_test");
        Integer savaComand = bundlefromActivity.getInt("SAVE_COMAND_test",-1);
        Integer saveID = bundlefromActivity.getInt("ID_SAVE_test",-1);
        Log.d(TAG,"save "+saveID);

        String editName = bundlefromActivity.getString("EDIT_NAME_test");
        String editYear = bundlefromActivity.getString("EDIT_YEAR_test");
        String editImage = bundlefromActivity.getString("EDIT_IMAGE_test");



        Log.d(TAG, "NAME_test" + deleteComand+" "+deletePosition);
        if (ADD == 1) {
            Album album = new Album(albumNameADD, albumYearADD, albumImageADD);
            albums.add(album);
        }
        if(savaComand==2){
            albums.get(saveID).setNameA(editName);
            albums.get(saveID).setYear(editYear);
            albums.get(saveID).setImageURL(editImage);
            Log.d(TAG,"save id from save Comand ListFragment"+" "+ saveID );
        }
        if(deleteComand==3){
            for (int i = 0; i < albums.size(); i++){
                if (urlNameFromDelete.equals(albums.get(i).getImage())){
            albums.remove(i);
            Log.d(TAG,""+albums.size());
            recycleViewAdapter.notifyDataSetChanged();
        }}
        }
        EditText search = viewONE.findViewById(R.id.edittext7AFragment);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                        filter(s.toString());
            }

        });

        Button buttonAdd = viewONE.findViewById(R.id.newalbumbuttonFragment);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = 1;
                someEventListner.someEvent(id);
                Log.d(TAG, "someEvent" + id);

            }

        });

        return viewONE;
    }

    public void filter(String text){
        ArrayList<Album> filtredList = new ArrayList<>();
        for(Album album:albums){
            if(album.getName().toLowerCase().contains(text.toLowerCase())){
                filtredList.add(album);
            }
            if (album.getYear().toLowerCase().contains(text.toLowerCase())){
                filtredList.add(album);
            }
        }
        recycleViewAdapter.filterlist(filtredList);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "on Create ER.1 run");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "on Create ER.1 1 run");

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onItemClick(int position) {
        String albumName = albums.get(position).getName();
        String albumYear = albums.get(position).getYear();
        String albumImage = albums.get(position).getImage();
        Log.d(TAG, "LIST FRAGMENT CLICK   " + " " + position);
        someEventListner.someEvent(position, albumName, albumYear, albumImage);

    }

}
