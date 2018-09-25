package com.example.andreii.firstaplication.HW3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.andreii.firstaplication.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        final ProgressBar progressBar = findViewById(R.id.progressBar3A);
        progressBar.setVisibility(View.GONE);

        Button button3A = findViewById(R.id.button3A);
        Button autoLinkButton = findViewById(R.id.addlink3A);
        final ImageView imageView3A = findViewById(R.id.imageView3A);
        final EditText editText3A = findViewById(R.id.editText3A);


        final String texttwo =
                "https://media.socastsrm.com/uploads/contest/19291/IronMaiden_Instagram_1080x1080_Static_1200_400_width.jpg";
        autoLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText3A.setText(texttwo);
            }
        });

        button3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText3A.getText().toString().isEmpty()) {
                    editText3A.setText("Enter your uri");
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    Picasso.get().load(String.valueOf(editText3A.getText()))
                            .transform(new TransformerCIrcle())
                            .placeholder(R.drawable.ic_launcher_background)
                            .error(R.drawable.ic_launcher_background)
                            .into(imageView3A, new Callback() {
                                @Override
                                public void onSuccess() {
                                    progressBar.setVisibility(View.GONE);
                                }

                                @Override
                                public void onError(Exception e) {

                                }
                            });
                }
            }
        });
    }
}