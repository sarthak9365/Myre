package com.example.myre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

public class SignupScreen extends AppCompatActivity {
    DatabaseHelper db;
    EditText editTextSignupFirstName,editTextSignupLastName,editTextSignupMobileNo,editTextSignupPassWord,editTextSignupConfirmPassWord;
    String strfn,strln,stremail,strpwd,strcpwd;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        db= new DatabaseHelper(this);
        editTextSignupFirstName= (EditText) findViewById(R.id.editTextSignupFirstName1);
        editTextSignupLastName=(EditText) findViewById(R.id.editTextSignupLastName1);
        editTextSignupMobileNo=(EditText) findViewById(R.id.editTextSignupMobileNumber);
        editTextSignupPassWord=(EditText) findViewById(R.id.editTextSignupPassword1);
       editTextSignupConfirmPassWord =(EditText) findViewById(R.id.editTextSignupConfirmPassword1);
        signup=(Button)findViewById(R.id.buttonSignup1);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //int number = Integer.parseInt(editTextSignupMobileNo.getText().toString());
                long result = db.insert(editTextSignupFirstName.getText().toString(),
                        editTextSignupLastName.getText().toString(),
                        editTextSignupPassWord.getText().toString(),editTextSignupMobileNo.getText().toString());


                if (editTextSignupFirstName.getText().toString().equals("") || editTextSignupLastName.getText().toString().equals("") || editTextSignupMobileNo.getText().toString().equals("") ||
                        editTextSignupPassWord.getText().toString().equals("") || editTextSignupConfirmPassWord.getText().toString().equals("")) {
                    Toast.makeText(SignupScreen.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }

                else {
                        if (editTextSignupPassWord.getText().toString().equals(editTextSignupConfirmPassWord.getText().toString())) {
                            if (result > -1) {
                                Toast.makeText(SignupScreen.this, "Insertion Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else {
                            Toast.makeText(SignupScreen.this, "Wrong insertion", Toast.LENGTH_SHORT).show();
                            }
                     }
                        else {
                        Toast.makeText(SignupScreen.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });


    }


}
