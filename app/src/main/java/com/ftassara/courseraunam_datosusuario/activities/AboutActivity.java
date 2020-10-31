package com.ftassara.courseraunam_datosusuario.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ftassara.courseraunam_datosusuario.R;

public class AboutActivity extends AppCompatActivity {

    TextView mBio1;
    TextView mBio2;
    TextView mBio3;
    TextView mBio4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inicializo mis variables relacionadolas con el objeto del layout correspondiente
        mBio1 = (TextView) findViewById(R.id.tvBio1);
        mBio2 = (TextView) findViewById(R.id.tvBio2);
        mBio3 = (TextView) findViewById(R.id.tvBio3);
        mBio4 = (TextView) findViewById(R.id.tvBio4);
    }


}
