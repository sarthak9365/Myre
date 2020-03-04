package com.example.myre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    TextView myre_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        myre_title = (TextView)findViewById(R.id.myre_title);
    }
}
