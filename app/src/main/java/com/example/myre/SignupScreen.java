package com.example.myre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignupScreen extends AppCompatActivity {
    EditText fname,lname,email,pwd,cpwd;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        fname= (EditText) findViewById(R.id.firstname);
        lname=(EditText) findViewById(R.id.lastname);
        email=(EditText) findViewById(R.id.emailId_1);
        pwd=(EditText) findViewById(R.id.password);
        cpwd=(EditText) findViewById(R.id.cpassword);
        signup=(Button)findViewById(R.id.signup1);

    }
}
