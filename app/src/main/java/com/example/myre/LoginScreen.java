package com.example.myre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    EditText email,password;
    Button login;
    String str1 = "admin";
    String str2 = "admin";
    TextView newuser1,signupuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        email=(EditText)findViewById(R.id.login_email);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        newuser1=(TextView)findViewById(R.id.newuser);
        signupuser=(TextView)findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals(str1)){
                    if(password.getText().toString().equals(str2)){
                        Toast.makeText(LoginScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(LoginScreen.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(LoginScreen.this, "Wrong EmailID", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this,SignupScreen.class);
                startActivity(intent);
            }
        });
    }
}
