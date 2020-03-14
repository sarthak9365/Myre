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
    EditText editTextLoginEmail,editTextLoginPassword;
    DatabaseHelper db;
    Button buttonLogin;
    String stringEmail,stringPassword;
    TextView textViewLoginNewUser,textViewLoginSignUpUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        db = new DatabaseHelper(this);
        editTextLoginEmail=(EditText)findViewById(R.id.editTextLoginEmail1);
        editTextLoginPassword=(EditText)findViewById(R.id.editTextLoginPassword);
        buttonLogin=(Button)findViewById(R.id.buttonLogin);
        textViewLoginNewUser=(TextView)findViewById(R.id.textViewLoginNewUser);
        textViewLoginSignUpUser=(TextView)findViewById(R.id.textViewLoginSignUp);

       buttonLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               stringEmail = editTextLoginEmail.getText().toString();
               stringPassword=editTextLoginPassword.getText().toString();
               if(stringEmail.equals(" ")||stringPassword.equals(" ")){
                   Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_SHORT).show();
               }
               else{
                   //Toast.makeText(LoginScreen.this, stringEmail, Toast.LENGTH_LONG).show();
                   //Toast.makeText(LoginScreen.this, stringPassword, Toast.LENGTH_SHORT).show();
                   boolean validate = db.validate(stringEmail,stringPassword);
                    if(validate==true){
                        Toast.makeText(LoginScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(LoginScreen.this, "Wrong EmailID and Password", Toast.LENGTH_SHORT).show();
                    }
               }

           }
       });

        textViewLoginSignUpUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this,SignupScreen.class);
                startActivity(intent);
            }
        });
    }
}
