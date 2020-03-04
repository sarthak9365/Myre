package com.example.myre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity {
    EditText email,password;
    Button login;
    TextView newuser1,signupuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        email=(EditText)findViewById(R.id.emailid);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        newuser1=(TextView)findViewById(R.id.newuser);
        signupuser=(TextView)findViewById(R.id.signup);

        signupuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this,SignupScreen.class);
                startActivity(intent);
            }
        });
    }
}
