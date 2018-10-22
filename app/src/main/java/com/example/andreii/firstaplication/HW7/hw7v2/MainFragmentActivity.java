package com.example.andreii.firstaplication.HW7.hw7v2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andreii.firstaplication.HW7.comon.Album;
import com.example.andreii.firstaplication.HW7.comon.MyBase;
import com.example.andreii.firstaplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import static android.content.ContentValues.TAG;


public class MainFragmentActivity extends AppCompatActivity implements ListFragment.onSomeEventListner {
    private static final String TAG = "myLog";

    Fragment fragmentList;
    Fragment fragmentDetail;
    Fragment fragmentDetailBlank;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        Intent intentFromBlank = getIntent();


        String TESST = intentFromBlank.getStringExtra("TEST");
        String nameAdd = intentFromBlank.getStringExtra("NAME_ADD");//rabotaet
        Log.d(TAG, "" + TESST + " " + nameAdd);
        String yearFromBlank = intentFromBlank.getStringExtra("YEAR_ADD");
        String imageFromBlank = intentFromBlank.getStringExtra("IMAGE_ADD");
        Integer ADD = intentFromBlank.getIntExtra("ADD", 0);
        Integer deletePosition = intentFromBlank.getIntExtra("DELETE_POSITION", -1);
        String url_DELETE = intentFromBlank.getStringExtra("URL_DELETE");
        Integer deleteComand = intentFromBlank.getIntExtra("DELETE_COMAND", -1);
        String editName = intentFromBlank.getStringExtra("EDIT_NAME");
        String editYear = intentFromBlank.getStringExtra("EDIT_YEAR");
        String editImage = intentFromBlank.getStringExtra("EDIT_IMAGE");
        Integer saveComand = intentFromBlank.getIntExtra("SAVE_COMAND", -1);
        Integer idSave = intentFromBlank.getIntExtra("ID_SAVE",-1);
        Log.d(TAG,"save "+idSave);
        Log.d(TAG, "" + " " + nameAdd + "_ " + yearFromBlank + "_ " + imageFromBlank);
        Bundle bundleTEST = new Bundle();
        bundleTEST.putString("NAME_test", nameAdd);
        bundleTEST.putString("YEAR_test", yearFromBlank);
        bundleTEST.putString("IMAGE_test", imageFromBlank);
        bundleTEST.putInt("ADD_test", ADD);
        bundleTEST.putInt("DELETE_test", deletePosition);
        bundleTEST.putInt("DELETE_COMAND_test", deleteComand);
        bundleTEST.putString("url_DELETE_test",url_DELETE);
        bundleTEST.putInt("SAVE_COMAND_test",saveComand);
        bundleTEST.putInt("ID_SAVE_test",idSave);
        bundleTEST.putString("EDIT_NAME_test",editName);
        bundleTEST.putString("EDIT_YEAR_test",editYear);
        bundleTEST.putString("EDIT_IMAGE_test",editImage);

        //

        fragmentList = new ListFragment();
        fragmentList.setArguments(bundleTEST);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragmentList);
        ft.commit();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addDetailFragment(int position, String name, String year, String image) {
        fragmentDetail = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("NAME", name);
        bundle.putString("YEAR", year);
        bundle.putString("IMAGE", image);
        bundle.putInt("POSITION", position);
        bundle.putString("URL", image);
        Log.d(TAG, "positionMAINFRAGMENT" + position+" ");

        fragmentDetail.setArguments(bundle);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Log.d(TAG, "itemSelect" + position);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d(TAG, "ORIENTATION_LANDSCAPE");
            ft.replace(R.id.fragment_frame_Two, fragmentDetail);
        } else {
            ft.replace(R.id.fragment_frame, fragmentDetail);
            Log.d(TAG, "ORIENTATION_PORTREIT");
        }
        ft.addToBackStack(null);
        ft.commit();

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void someEvent(int position, String name, String year, String image) {

        addDetailFragment(position, name, year, image);
        Log.d(TAG, "id" + position);

    }

    @Override
    public void someEventTwo(Album album) {


    }

    @Override
    public void someEvent(int idADD) {
        Log.d(TAG, "MainActivity add" + idADD);

        addEmptyBlank(idADD);


    }

    public void addEmptyBlank(int id) {
        if (id == 1) {
            fragmentDetailBlank = new BlanckFragment();

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                Log.d(TAG, "ORIENTATION_LANDSCAPE");
                ft.replace(R.id.fragment_frame_Two, fragmentDetailBlank);
                Log.d(TAG, "down load");
            } else {
                ft.replace(R.id.fragment_frame, fragmentDetailBlank);
                Log.d(TAG, "ORIENTATION_PORTREIT");
            }
            ft.addToBackStack(null);
            ft.commit();
        }
    }


}
