package com.example.myre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DemoActivity extends AppCompatActivity {
        TextView textViewShowtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        textViewShowtext = findViewById(R.id.textView2);

        textViewShowtext.setText("HELLO USER!!!!");
    }
}
