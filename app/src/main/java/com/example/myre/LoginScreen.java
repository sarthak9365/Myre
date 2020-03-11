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
    DatabaseHelper db;
    Button login;
    String str1,str2;
    TextView newuser1,signupuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        db = new DatabaseHelper(this);
        email=(EditText)findViewById(R.id.login_email);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        newuser1=(TextView)findViewById(R.id.newuser);
        signupuser=(TextView)findViewById(R.id.signup);

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               str1=email.getText().toString();
               str2=password.getText().toString();
               if(str1.equals(" ")||str2.equals(" ")){
                   Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_SHORT).show();
               }
               else{
                    Boolean validate = db.validate(str1,str2);
                    if(validate == true){
                        Toast.makeText(LoginScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(LoginScreen.this, "Wrong EmailID and Password", Toast.LENGTH_SHORT).show();
                    }
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
