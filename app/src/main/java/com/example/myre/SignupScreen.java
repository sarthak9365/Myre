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
        pwd=(EditText) findViewById(R.id.password_signup);
        cpwd=(EditText) findViewById(R.id.cpassword);
        signup=(Button)findViewById(R.id.signup1);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long result = db.insert(fname.getText().toString(),
                        lname.getText().toString(),
                        email.getText().toString(),
                        pwd.getText().toString(),
                        cpwd.getText().toString());

                if(result>-1)
                {
                    Toast.makeText(SignupScreen.this, "Insertion Successful", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SignupScreen.this, " Error in Insertion"+result, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
