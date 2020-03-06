package com.example.myre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupScreen extends AppCompatActivity {
    DatabaseHelper db;
    EditText fname,lname,email,pwd,cpwd;
    String strfn,strln,stremail,strpwd,strcpwd;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        db= new DatabaseHelper(this);
        fname= (EditText) findViewById(R.id.firstname);
        lname=(EditText) findViewById(R.id.lastname);
        email=(EditText) findViewById(R.id.emailId_1);
        pwd=(EditText) findViewById(R.id.password);
        cpwd=(EditText) findViewById(R.id.cpassword);
        signup=(Button)findViewById(R.id.signup1);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strfn=fname.getText().toString();
                strln=lname.getText().toString();
                stremail=email.getText().toString();
                strpwd=pwd.getText().toString();
                strcpwd=cpwd.getText().toString();
                if(strfn.equals("")||strln.equals("")||stremail.equals("")||strpwd.equals("")||strcpwd.equals("")){
                    Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


}
