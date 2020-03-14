package com.example.myre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class LoginScreen extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    private static final int SIGN_IN=1;
    //database object
    DatabaseHelper db;
    //TextView refrence
    TextView textViewLoginForgotPassword;
    EditText editTextLoginMobileNo,editTextloginPassword;
    Button buttonLoginuser,buttonNothavingAccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        // Build A COnfiguration if you require more Information for Sign in
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        //to access the GoogleAPI provided in the Google Play Service Library(Google sign in,games,drives)
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions).build();
        signInButton = (SignInButton)findViewById(R.id.googlesignin);

        db = new DatabaseHelper(this);
        //textview Casting
        textViewLoginForgotPassword = (TextView)findViewById(R.id.textViewLoginForgotPassword);
        // EditText  Refrence Casting
        editTextLoginMobileNo = (EditText)findViewById(R.id.editTextLoginMobileNumber);
        editTextloginPassword = (EditText)findViewById(R.id.editTextLoginPassword);
        //Button  Refrence Casting
        buttonLoginuser = (Button)findViewById(R.id.buttonLogin);
        buttonNothavingAccount=(Button)findViewById(R.id.buttonNotHavingAccount);

        buttonLoginuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mobilenumber1;
                String password,mobile;
               mobile = editTextLoginMobileNo.getText().toString();
              // mobilenumber1=Integer.parseInt(mobile);
                password  = editTextloginPassword.getText().toString();

                if(mobile.equals("")||password.equals("")) {
                    Toast.makeText(LoginScreen.this, "Field is empty", Toast.LENGTH_SHORT).show();
                }
                else{

                    boolean validate = db.validate(mobile,password);
                    if(validate==true){
                        Toast.makeText(LoginScreen.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginScreen.this, "wrong number and password!", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

        buttonNothavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignupScreen.class));

            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,SIGN_IN);
            }
        });





    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==SIGN_IN){
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()){
                startActivity(new Intent(getApplicationContext(),DemoActivity.class));
                finish();
            }
            else{
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
