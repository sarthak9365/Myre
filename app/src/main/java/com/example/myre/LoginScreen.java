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
    String str1,str2;
    Button login;
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
        signupuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this,SignupScreen.class);
                startActivity(intent);
            }
        });

        //str1=email.getText().toString();
        //str2=password.getText().toString();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString()=="admin"){
                    if(str2=="12345678"){
                        Toast.makeText(LoginScreen.this,"Login Successfully",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(LoginScreen.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(LoginScreen.this, ""+email.getText().toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(LoginScreen.this, "Wrong EmailID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
